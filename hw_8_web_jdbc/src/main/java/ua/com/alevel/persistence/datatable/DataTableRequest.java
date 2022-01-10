package ua.com.alevel.persistence.datatable;

public class DataTableRequest {

    private String sort;
    private String order;
    private long currentPage;
    private long pageSize;
    private long totalPages;

    public DataTableRequest() {
        this.sort = "id";
        this.order = "ASC";
        this.currentPage = 1;
        this.pageSize = 10;
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

    public long getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(long currentPage) {
        this.currentPage = currentPage;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(long totalPages) {
        this.totalPages = totalPages;
    }
}
