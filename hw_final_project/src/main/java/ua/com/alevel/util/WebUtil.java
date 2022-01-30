package ua.com.alevel.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.WebRequest;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.BaseEntity;
import ua.com.alevel.view.dto.request.PageAndSizeData;
import ua.com.alevel.view.dto.request.SortData;
import ua.com.alevel.view.dto.response.PageDataResponse;
import ua.com.alevel.view.dto.response.ResponseDto;

import java.util.Objects;

public final class WebUtil {

    public static final String DEFAULT_SORT_PARAM_VALUE = "created";
    public static final String DEFAULT_ORDER_PARAM_VALUE = "desc";
    public static final int DEFAULT_PAGE_PARAM_VALUE = 1;
    public static final int DEFAULT_SIZE_PARAM_VALUE = 10;
    public static final String PUBLISHER_PARAM = "publisher";
    public static final String BOOK_SEARCH_PARAM = "bookSearch";
    private static final String PAGE_PARAM = "page";
    private static final String SIZE_PARAM = "size";
    private static final String SORT_PARAM = "sort";
    private static final String ORDER_PARAM = "order";

    private WebUtil() {
    }
    public static PageAndSizeData generatePageAndSizeData(WebRequest webRequest) {
        int page = webRequest.getParameter(PAGE_PARAM) != null ? Integer.parseInt(Objects.requireNonNull(webRequest.getParameter(PAGE_PARAM))) : DEFAULT_PAGE_PARAM_VALUE;
        int size = webRequest.getParameter(SIZE_PARAM) != null ? Integer.parseInt(Objects.requireNonNull(webRequest.getParameter(SIZE_PARAM))) : DEFAULT_SIZE_PARAM_VALUE;
        return new PageAndSizeData(page, size);
    }

    public static PageAndSizeData defaultPageAndSizeData() {
        return new PageAndSizeData(DEFAULT_PAGE_PARAM_VALUE, DEFAULT_SIZE_PARAM_VALUE);
    }

    public static SortData generateSortData(WebRequest webRequest) {
        String sort = StringUtils.isNotBlank(webRequest.getParameter(SORT_PARAM)) ? Objects.requireNonNull(webRequest.getParameter(SORT_PARAM)) : DEFAULT_SORT_PARAM_VALUE;
        String order = StringUtils.isNotBlank(webRequest.getParameter(ORDER_PARAM)) ? Objects.requireNonNull(webRequest.getParameter(ORDER_PARAM)) : DEFAULT_ORDER_PARAM_VALUE;
        return new SortData(sort, order);
    }

    public static SortData defaultSortData() {
        return new SortData(DEFAULT_SORT_PARAM_VALUE, DEFAULT_ORDER_PARAM_VALUE);
    }
    public static DataTableRequest generateDataTableRequestByWebRequest(WebRequest request) {
        DataTableRequest dataTableRequest = new DataTableRequest();
        int page = StringUtils.isBlank(request.getParameter(PAGE_PARAM))
                ? DEFAULT_PAGE_PARAM_VALUE
                : Integer.parseInt(request.getParameter(PAGE_PARAM));
        int size = StringUtils.isBlank(request.getParameter(SIZE_PARAM))
                ? DEFAULT_SIZE_PARAM_VALUE
                : Integer.parseInt(request.getParameter(SIZE_PARAM));
        String sort = StringUtils.isBlank(request.getParameter(SORT_PARAM))
                ? DEFAULT_SORT_PARAM_VALUE
                : request.getParameter(SORT_PARAM);
        String order = StringUtils.isBlank(request.getParameter(ORDER_PARAM))
                ? DEFAULT_ORDER_PARAM_VALUE
                : request.getParameter(ORDER_PARAM);
        dataTableRequest.setOrder(order);
        dataTableRequest.setSort(sort);
        dataTableRequest.setPageSize(size);
        dataTableRequest.setCurrentPage(page);
        return dataTableRequest;
    }

    public static PageDataResponse<? extends ResponseDto> initPageData(
            DataTableResponse<? extends BaseEntity> tableResponse) {
        PageDataResponse<? extends ResponseDto> pageDataResponse = new PageDataResponse<>();
        pageDataResponse.setCurrentPage(tableResponse.getCurrentPage());
        pageDataResponse.setPageSize(tableResponse.getPageSize());
        pageDataResponse.setOrder(tableResponse.getOrder());
        pageDataResponse.setSort(tableResponse.getSort());
        pageDataResponse.setItemsSize(tableResponse.getItemsSize());
        //
        pageDataResponse.initPaginationState(tableResponse.getCurrentPage());
        return pageDataResponse;
    }
}