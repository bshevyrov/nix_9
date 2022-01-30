package ua.com.alevel.facade.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;
import ua.com.alevel.facade.ShowSeatFacade;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.Show;
import ua.com.alevel.persistence.entity.ShowSeat;
import ua.com.alevel.service.ShowSeatService;
import ua.com.alevel.util.ClassConverterUtil;
import ua.com.alevel.util.FacadeUtil;
import ua.com.alevel.util.WebRequestUtil;
import ua.com.alevel.view.dto.request.PageAndSizeData;
import ua.com.alevel.view.dto.request.ShowSeatRequestDto;
import ua.com.alevel.view.dto.request.SortData;
import ua.com.alevel.view.dto.response.PageDataResponse;
import ua.com.alevel.view.dto.response.ShowResponseDto;
import ua.com.alevel.view.dto.response.ShowSeatResponseDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShowSeatFacadeImpl implements ShowSeatFacade {

    private final ShowSeatService showSeatService;

    public ShowSeatFacadeImpl(ShowSeatService showSeatService) {
        this.showSeatService = showSeatService;
    }


    @Override
    public void create(ShowSeatRequestDto showSeatRequestDto) {
        showSeatService.create(ClassConverterUtil.showSeatRequestDtoToEntity(showSeatRequestDto));
    }

    @Override
    public void update(ShowSeatRequestDto showSeatRequestDto) {
        showSeatService.update(ClassConverterUtil.showSeatRequestDtoToEntity(showSeatRequestDto));

    }

    @Override
    public void delete(long id) {
        showSeatService.delete(id);

    }

    @Override
    public ShowSeatResponseDto findById(long id) {
        return ClassConverterUtil.showSeatToShowSeatResponseDto(showSeatService.findById(id).get());
    }

    @Override
    public List<ShowSeatResponseDto> findAll() {
        return showSeatService.findAll().stream().map(ClassConverterUtil::showSeatToShowSeatResponseDto).collect(Collectors.toList());
    }

    @Override
    public PageDataResponse<ShowSeatResponseDto> findAll(WebRequest request) {
        PageAndSizeData pageAndSizeData = WebRequestUtil.generatePageAndSizeData(request);
        SortData sortData = WebRequestUtil.generateSortData(request);
        DataTableRequest dataTableRequest = FacadeUtil.getDTReqFromPageAndSortData(pageAndSizeData, sortData);
        DataTableResponse<ShowSeat> all = showSeatService.findAll(dataTableRequest);
        return getPageDataResponseFromDataTable(pageAndSizeData, sortData, all);
    }

    private PageDataResponse<ShowSeatResponseDto> getPageDataResponseFromDataTable(PageAndSizeData pageAndSizeData, SortData sortData, DataTableResponse<ShowSeat> all) {
        List<ShowSeatResponseDto> list = all.getItems()
                .stream()
                .map(ClassConverterUtil::showSeatToShowSeatResponseDto)
                .collect(Collectors.toList());
        PageDataResponse<ShowSeatResponseDto> pageDataResponse = FacadeUtil.getPageDataResponseFromDTResp(list, pageAndSizeData, sortData);
        pageDataResponse.setItemsSize(all.getItemsSize());
        pageDataResponse.initPaginationState(pageDataResponse.getCurrentPage());
        return pageDataResponse;
    }

    @Override
    public List<ShowSeatResponseDto> findAllByShowId(long id) {
        return showSeatService.findAllByShowId(id).stream().map(ClassConverterUtil::showSeatToShowSeatResponseDto)
                .collect(Collectors.toList());
    }
}
