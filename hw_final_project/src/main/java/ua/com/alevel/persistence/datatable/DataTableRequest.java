package ua.com.alevel.persistence.datatable;

import java.util.Collections;
import java.util.Map;

public class DataTableRequest {

    private int currentPage;
    private int pageSize;
    private String order;
    private String sort;
    private Map<String, String[]> requestParamMap;

    public DataTableRequest() {
        requestParamMap = Collections.emptyMap();
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public Map<String, String[]> getRequestParamMap() {
        return requestParamMap;
    }

    public void setRequestParamMap(Map<String, String[]> requestParamMap) {
        this.requestParamMap = requestParamMap;
    }
}