package ua.com.alevel.facade.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;
import ua.com.alevel.facade.CinemaHallSeatFacade;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.CinemaHallSeat;
import ua.com.alevel.service.CinemaHallSeatService;
import ua.com.alevel.util.ClassConverterUtil;
import ua.com.alevel.util.FacadeUtil;
import ua.com.alevel.util.WebRequestUtil;
import ua.com.alevel.view.dto.request.CinemaHallSeatRequestDto;
import ua.com.alevel.view.dto.request.PageAndSizeData;
import ua.com.alevel.view.dto.request.SortData;
import ua.com.alevel.view.dto.response.CinemaHallSeatResponseDto;
import ua.com.alevel.view.dto.response.PageDataResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CinemaHallSeatFacadeImpl implements CinemaHallSeatFacade {

    private final CinemaHallSeatService cinemaHallSeatService;

    public CinemaHallSeatFacadeImpl(CinemaHallSeatService cinemaHallSeatService) {
        this.cinemaHallSeatService = cinemaHallSeatService;
    }


    @Override
    public void create(CinemaHallSeatRequestDto cinemaHallSeatRequestDto) {
        cinemaHallSeatService.create(ClassConverterUtil
                .cinemaHallSeatResponseDtoToCinemaHallSeat(cinemaHallSeatRequestDto));
    }

    @Override
    public void update(CinemaHallSeatRequestDto cinemaHallSeatRequestDto) {
        cinemaHallSeatService.update(ClassConverterUtil
                .cinemaHallSeatResponseDtoToCinemaHallSeat(cinemaHallSeatRequestDto));

    }

    @Override
    public void delete(long id) {
        cinemaHallSeatService.delete(id);

    }

    @Override
    public CinemaHallSeatResponseDto findById(long id) {
        return ClassConverterUtil.cinemaHallSeatToCinemaHallSeatResponseDto(cinemaHallSeatService.findById(id).get());
    }

    @Override
    public List<CinemaHallSeatResponseDto> findAll() {
        return cinemaHallSeatService.findAll()
                .stream()
                .map(ClassConverterUtil::cinemaHallSeatToCinemaHallSeatResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public PageDataResponse<CinemaHallSeatResponseDto> findAll(WebRequest request) {
        PageAndSizeData pageAndSizeData = WebRequestUtil.generatePageAndSizeData(request);
        SortData sortData = WebRequestUtil.generateSortData(request);
        DataTableRequest dataTableRequest = FacadeUtil.getDTReqFromPageAndSortData(pageAndSizeData, sortData);
        DataTableResponse<CinemaHallSeat> all = cinemaHallSeatService.findAll(dataTableRequest);
        return getPageDataResponseFromDataTable(pageAndSizeData, sortData, all);
    }

    @Override
    public List<CinemaHallSeatResponseDto> findAllByCinemaHallId(long id) {
        return cinemaHallSeatService.findAllByCinemaHallId(id).stream()
                .map(ClassConverterUtil::cinemaHallSeatToCinemaHallSeatResponseDto).collect(Collectors.toList());
    }


    private PageDataResponse<CinemaHallSeatResponseDto> getPageDataResponseFromDataTable(PageAndSizeData pageAndSizeData
            , SortData sortData
            , DataTableResponse<CinemaHallSeat> all) {
        List<CinemaHallSeatResponseDto> list = all.getItems()
                .stream()
                .map(ClassConverterUtil::cinemaHallSeatToCinemaHallSeatResponseDto)
                .collect(Collectors.toList());
        PageDataResponse<CinemaHallSeatResponseDto> pageDataResponse = FacadeUtil.getPageDataResponseFromDTResp(list, pageAndSizeData, sortData);
        pageDataResponse.setItemsSize(all.getItemsSize());
        pageDataResponse.initPaginationState(pageDataResponse.getCurrentPage());
        return pageDataResponse;
    }

}
