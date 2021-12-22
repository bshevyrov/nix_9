package ua.com.alevel.util;

import org.springframework.web.context.request.WebRequest;
import ua.com.alevel.view.dto.request.PageAndSizeData;
import ua.com.alevel.view.dto.request.SortData;

import java.util.Objects;

public final class WebRequestUtil {

    private static final String PAGE_PARAM = "page";
    private static final String SIZE_PARAM = "size";
    private static final String SORT_PARAM = "sort";
    private static final String ORDER_PARAM = "order";
    public static final String DEFAULT_SORT_PARAM_VALUE = "name";
    public static final String DEFAULT_ORDER_PARAM_VALUE = "desc";
    public static final int DEFAULT_PAGE_PARAM_VALUE = 1;
    public static final int DEFAULT_SIZE_PARAM_VALUE = 10;

    public WebRequestUtil() {
    }

    public static PageAndSizeData generatePageAndSizeData(WebRequest webRequest) {
        int page = webRequest.getParameter(PAGE_PARAM) != null
                ? Integer.parseInt(Objects.requireNonNull(webRequest.getParameter(PAGE_PARAM)))
                : DEFAULT_PAGE_PARAM_VALUE;

        int size = webRequest.getParameter(SIZE_PARAM) != null
                ? Integer.parseInt(Objects.requireNonNull(webRequest.getParameter(SIZE_PARAM)))
                : DEFAULT_SIZE_PARAM_VALUE;
        return new PageAndSizeData(page, size);
    }

    public static PageAndSizeData defaultPageAndSortData() {
        return new PageAndSizeData(DEFAULT_PAGE_PARAM_VALUE, DEFAULT_SIZE_PARAM_VALUE);
    }

    public static SortData defaultSortData(WebRequest webRequest) {
        String sort = webRequest.getParameter(SORT_PARAM) != null
                ? Objects.requireNonNull(webRequest.getParameter(SORT_PARAM))
                : DEFAULT_SORT_PARAM_VALUE;

        String order = webRequest.getParameter(ORDER_PARAM) != null
                ? Objects.requireNonNull(webRequest.getParameter(ORDER_PARAM))
                : DEFAULT_ORDER_PARAM_VALUE;
        return new SortData(sort, order);
    }

    public static SortData defaultSortData() {
        return new SortData(DEFAULT_SORT_PARAM_VALUE, DEFAULT_ORDER_PARAM_VALUE);
    }
}
