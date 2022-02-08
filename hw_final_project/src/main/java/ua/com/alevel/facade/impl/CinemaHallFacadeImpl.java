package ua.com.alevel.facade.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;
import ua.com.alevel.facade.CinemaHallFacade;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.CinemaHall;
import ua.com.alevel.service.CinemaHallService;
import ua.com.alevel.util.ClassConverterUtil;
import ua.com.alevel.util.FacadeUtil;
import ua.com.alevel.view.dto.request.CinemaHallRequestDto;
import ua.com.alevel.view.dto.request.PageAndSizeData;
import ua.com.alevel.view.dto.request.SortData;
import ua.com.alevel.view.dto.response.CinemaHallResponseDto;
import ua.com.alevel.view.dto.response.PageDataResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CinemaHallFacadeImpl implements CinemaHallFacade {

    private final CinemaHallService cinemaHallService;

    public CinemaHallFacadeImpl(CinemaHallService cinemaHallService) {
        this.cinemaHallService = cinemaHallService;
    }


    @Override
    public void create(CinemaHallRequestDto cinemaHallRequestDto) {
    }

    @Override
    public void update(CinemaHallRequestDto cinemaHallRequestDto) {
    }

    @Override
    public void delete(long id) {
    }

    @Override
    public CinemaHallResponseDto findById(long id) {
        return null;
    }

    @Override
    public List<CinemaHallResponseDto> findAll() {
        return cinemaHallService.findAll()
                .stream()
                .map(ClassConverterUtil::cinemaHallToCinemaHallResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public PageDataResponse<CinemaHallResponseDto> findAll(WebRequest request) {
        return null;
    }

    private PageDataResponse<CinemaHallResponseDto> getPageDataResponseFromDataTable(PageAndSizeData pageAndSizeData, SortData sortData, DataTableResponse<CinemaHall> all) {
        List<CinemaHallResponseDto> list = all.getItems()
                .stream()
                .map(ClassConverterUtil::cinemaHallToCinemaHallResponseDto)
                .collect(Collectors.toList());
        PageDataResponse<CinemaHallResponseDto> pageDataResponse = FacadeUtil.getPageDataResponseFromDTResp(list, pageAndSizeData, sortData);
        pageDataResponse.setItemsSize(all.getItemsSize());
        pageDataResponse.initPaginationState(pageDataResponse.getCurrentPage());
        return pageDataResponse;
    }
}
