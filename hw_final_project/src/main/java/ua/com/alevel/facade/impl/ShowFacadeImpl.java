package ua.com.alevel.facade.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;
import ua.com.alevel.facade.ShowFacade;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.Show;
import ua.com.alevel.service.ShowService;
import ua.com.alevel.util.ClassConverterUtil;
import ua.com.alevel.util.FacadeUtil;
import ua.com.alevel.util.WebRequestUtil;
import ua.com.alevel.view.dto.request.PageAndSizeData;
import ua.com.alevel.view.dto.request.ShowRequestDto;
import ua.com.alevel.view.dto.request.SortData;
import ua.com.alevel.view.dto.response.PageDataResponse;
import ua.com.alevel.view.dto.response.ShowResponseDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShowFacadeImpl implements ShowFacade {

    private final ShowService showService;

    public ShowFacadeImpl(ShowService showService) {
        this.showService = showService;
    }

    @Override
    public void create(ShowRequestDto showRequestDto) {
    showService.create(ClassConverterUtil.SRDtoToEntity(showRequestDto));
    }

    @Override
    public void update(ShowRequestDto showRequestDto) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public ShowResponseDto findById(long id) {
        return null;
    }

    @Override
    public List<ShowResponseDto> findAll() {
        return null;
    }

    @Override
    public PageDataResponse<ShowResponseDto> findAll(WebRequest request) {
        PageAndSizeData pageAndSizeData = WebRequestUtil.generatePageAndSizeData(request);
        SortData sortData = WebRequestUtil.generateSortData(request);
        DataTableRequest dataTableRequest = FacadeUtil.getDTReqFromPageAndSortData(pageAndSizeData, sortData);
        DataTableResponse<Show> all = showService.findAll(dataTableRequest);
        return getPageDataResponseFromDataTable(pageAndSizeData, sortData, all);
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
