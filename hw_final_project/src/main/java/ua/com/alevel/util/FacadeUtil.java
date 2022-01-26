package ua.com.alevel.util;

import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.view.dto.request.PageAndSizeData;
import ua.com.alevel.view.dto.request.SortData;
import ua.com.alevel.view.dto.response.PageDataResponse;
import ua.com.alevel.view.dto.response.ResponseDto;

import java.util.List;

public final class FacadeUtil {

    private FacadeUtil() {
    }

    public static DataTableRequest getDTReqFromPageAndSortData(PageAndSizeData pageAndSizeData, SortData sortData) {
        DataTableRequest dataTableRequest = new DataTableRequest();
        dataTableRequest.setOrder(sortData.getOrder());
        dataTableRequest.setSort(sortData.getSort());
        dataTableRequest.setCurrentPage(pageAndSizeData.getPage());
        dataTableRequest.setPageSize(pageAndSizeData.getSize());
        return dataTableRequest;
    }

    public static <RES extends ResponseDto> PageDataResponse<RES> getPageDataResponseFromDTResp(List<RES> items, PageAndSizeData pageAndSizeData, SortData sortData) {
        PageDataResponse<RES> pageData = new PageDataResponse<>();
        pageData.setItems(items);
        pageData.setCurrentPage(pageAndSizeData.getPage());
        pageData.setPageSize(pageAndSizeData.getSize());
        pageData.setOrder(sortData.getOrder());
        pageData.setSort(sortData.getSort());
        return pageData;
    }
}
