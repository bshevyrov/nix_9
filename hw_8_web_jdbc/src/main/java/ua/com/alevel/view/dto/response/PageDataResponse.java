package ua.com.alevel.view.dto.response;

import java.util.ArrayList;
import java.util.List;

public class PageDataResponse<REQ extends ResponseDto> {

    private int currentPage;
    private int pageSize;
    private int totalPageSize;
    private long itemSize;
    private List<REQ> items;
    private final int[] pageSizeItems;
    private boolean showFirst;
    private boolean showLast;
    private boolean showPrevious;
    private boolean showNext;
    private String sort;
    private String order;
    private long currentShowFromEntries;
    private long currentShowToEntries;


    public PageDataResponse() {
        this.currentPage = 0;
        this.pageSize = 10;
        this.totalPageSize = 0;
        this.itemSize = 0;
        this.items = new ArrayList<>();
        this.pageSizeItems = new int[]{10, 25, 50, 100};
        this.showFirst = false;
        this.showLast = false;
        this.showPrevious = false;
        this.showNext = false;
    }

    public void initPaginationState(int page) {
        this.showFirst = page != 1;
        this.showLast = page != totalPageSize;
        this.showNext = page != totalPageSize;
        this.showPrevious = page - 1 != 0;
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

    public long getItemSize() {
        return itemSize;
    }

    public void setItemSize(long itemSize) {
        this.itemSize = itemSize;
    }

    public List<REQ> getItems() {
        return items;
    }

    public void setItems(List<REQ> items) {
        this.items = items;
    }

    public int[] getPageSizeItems() {
        return pageSizeItems;
    }

    public boolean isShowFirst() {
        return showFirst;
    }

    public void setShowFirst(boolean showFirst) {
        this.showFirst = showFirst;
    }

    public boolean isShowLast() {
        return showLast;
    }

    public void setShowLast(boolean showLast) {
        this.showLast = showLast;
    }

    public boolean isShowPrevious() {
        return showPrevious;
    }

    public void setShowPrevious(boolean showPrevious) {
        this.showPrevious = showPrevious;
    }

    public boolean isShowNext() {
        return showNext;
    }

    public void setShowNext(boolean showNext) {
        this.showNext = showNext;
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

    public long getCurrentShowFromEntries() {
        return currentShowFromEntries;
    }

    public void setCurrentShowFromEntries(long currentShowFromEntries) {
        this.currentShowFromEntries = currentShowFromEntries;
    }

    public long getCurrentShowToEntries() {
        return currentShowToEntries;
    }

    public void setCurrentShowToEntries(long currentShowToEntries) {
        this.currentShowToEntries = currentShowToEntries;
    }
}
