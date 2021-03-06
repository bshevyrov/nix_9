package ua.com.alevel.facade.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;
import ua.com.alevel.facade.ShowFacade;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.Show;
import ua.com.alevel.persistence.type.CinemaHallType;
import ua.com.alevel.service.ShowService;
import ua.com.alevel.util.ClassConverterUtil;
import ua.com.alevel.util.FacadeUtil;
import ua.com.alevel.util.WebUtil;
import ua.com.alevel.view.dto.request.PageAndSizeData;
import ua.com.alevel.view.dto.request.ShowRequestDto;
import ua.com.alevel.view.dto.request.SortData;
import ua.com.alevel.view.dto.response.PageDataResponse;
import ua.com.alevel.view.dto.response.ShowResponseDto;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ShowFacadeImpl implements ShowFacade {

    private final ShowService showService;

    public ShowFacadeImpl(ShowService showService) {
        this.showService = showService;
    }

    @Override
    public void create(ShowRequestDto showRequestDto) {
        showService.create(ClassConverterUtil.ShowRequestDtoToEntity(showRequestDto));
    }

    @Override
    public void update(ShowRequestDto showRequestDto) {
        showService.update(ClassConverterUtil.ShowRequestDtoToEntity(showRequestDto));
    }

    @Override
    public void delete(long id) {
        showService.delete(id);
    }

    @Override
    public ShowResponseDto findById(long id) {
        return ClassConverterUtil
                .showToShowResponseDto(
                        showService
                                .findById(id)
                                .get());
    }

    @Override
    public List<ShowResponseDto> findAll() {
        return showService.findAll().stream()
                .map(ClassConverterUtil::showToShowResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public PageDataResponse<ShowResponseDto> findAll(WebRequest request) {
        PageAndSizeData pageAndSizeData = WebUtil.generatePageAndSizeData(request);
        SortData sortData = WebUtil.generateSortData(request);
        DataTableRequest dataTableRequest = FacadeUtil.getDTReqFromPageAndSortData(pageAndSizeData, sortData);
        DataTableResponse<Show> all = showService.findAll(dataTableRequest);
        return getPageDataResponseFromDataTable(pageAndSizeData, sortData, all);
    }

    @Override
    public ShowResponseDto findByMovieId(long id) {
        return ClassConverterUtil.showToShowResponseDto(showService.findByMovieId(id).get());
    }

    @Override
    public List<ShowResponseDto> findAllByMovieId(long id) {
        return showService.findAllByMovieId(id).stream()
                .map(ClassConverterUtil::showToShowResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public PageDataResponse<ShowResponseDto> findAllByMovieId(long id, WebRequest request) {
        PageAndSizeData pageAndSizeData = WebUtil.generatePageAndSizeData(request);
        SortData sortData = WebUtil.generateSortData(request);
        DataTableRequest dataTableRequest = FacadeUtil.getDTReqFromPageAndSortData(pageAndSizeData, sortData);
        DataTableResponse<Show> all = showService.findAllByMovieId(id, dataTableRequest);
        return getPageDataResponseFromDataTable(pageAndSizeData, sortData, all);
    }

    @Override
    public Map<String, List<ShowResponseDto>> getShowsByMovieIdSortedByCinemaHallType(long id) {

        Map<String, List<ShowResponseDto>> shows = new HashMap<>();
        CinemaHallType[] types = CinemaHallType.values();
        for (CinemaHallType type : types) {
            shows.put(type.name(), new ArrayList<>());
        }
        List<ShowResponseDto> showResponseDtos = showService.findAllByMovieId(id).stream()
                .map(ClassConverterUtil::showToShowResponseDto)
                .sorted(Comparator.comparing(ShowResponseDto::getDate ).thenComparing(ShowResponseDto::getStartTime))
                .collect(Collectors.toList());

        for (ShowResponseDto showResponseDto : showResponseDtos) {
            shows.get(showResponseDto.getCinemaHall().getCinemaHallType().name()).add(showResponseDto);
        }
        return shows;
    }


    private PageDataResponse<ShowResponseDto> getPageDataResponseFromDataTable(PageAndSizeData pageAndSizeData, SortData sortData, DataTableResponse<Show> all) {
        List<ShowResponseDto> list = all.getItems()
                .stream()
                .map(ClassConverterUtil::showToShowResponseDto)
                .collect(Collectors.toList());
        PageDataResponse<ShowResponseDto> pageDataResponse = FacadeUtil.getPageDataResponseFromDTResp(list, pageAndSizeData, sortData);
        pageDataResponse.setItemsSize(all.getItemsSize());
        pageDataResponse.initPaginationState(pageDataResponse.getCurrentPage());
        return pageDataResponse;
    }
}
