package ua.com.alevel.persistence.datatable;

import ua.com.alevel.persistence.entity.BaseEntity;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class DataTableResponse<E extends BaseEntity> {

    private List<E> eList;
    private long eListSize;
    private Map<Object, Object> otherParamMap;
    private int currentPage;
    private int pageSize;
    private int totalPageSize;
    private String sort;
    private String order;

    public DataTableResponse() {
        this.currentPage = 1;
        this.pageSize = 10;
        this.eList = Collections.emptyList();
        this.otherParamMap = Collections.emptyMap();
    }


    public List<E> geteList() {
        return eList;
    }

    public void seteList(List<E> eList) {
        this.eList = eList;
    }

    public long geteListSize() {
        return eListSize;
    }

    public void seteListSize(long eListSize) {
        this.eListSize = eListSize;
    }

    public Map<Object, Object> getOtherParamMap() {
        return otherParamMap;
    }

    public void setOtherParamMap(Map<Object, Object> otherParamMap) {
        this.otherParamMap = otherParamMap;
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

    public int getTotalPageSize() {
        return totalPageSize;
    }

    public void setTotalPageSize(int totalPageSize) {
        this.totalPageSize = totalPageSize;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
