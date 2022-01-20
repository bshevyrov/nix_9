package ua.com.alevel.persistence.datatable;

import java.util.Objects;

public class DataTableRequest {

    private String sort;
    private String order;
    private int currentPage;
    private int pageSize;

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

    @Override
    public String toString() {
        return "DataTableRequest{" +
                "sort='" + sort + '\'' +
                ", order='" + order + '\'' +
                ", currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataTableRequest that = (DataTableRequest) o;
        return currentPage == that.currentPage && pageSize == that.pageSize && Objects.equals(sort, that.sort) && Objects.equals(order, that.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sort, order, currentPage, pageSize);
    }
}
