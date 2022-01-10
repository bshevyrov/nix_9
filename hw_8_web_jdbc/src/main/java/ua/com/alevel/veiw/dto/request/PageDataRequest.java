package ua.com.alevel.veiw.dto.request;

import java.util.ArrayList;
import java.util.List;

public class PageDataRequest extends RequestDto{

//    private List<REQ> items;
//    private long itemSize;

    private String sort;
    private String order;
//    private boolean showFirst;
//    private boolean showLast;
//    private boolean showPrevious;
//    private boolean showNext;
    private long pageSize;
    private long currentPage;
    private int totalPageSize;


    public PageDataRequest() {
        this.currentPage = 1;
        this.pageSize = 10;
//        this.itemSize = 0;
//        this.items = new ArrayList<>();
//        this.showFirst = false;
//        this.showLast = false;
//        this.showPrevious = false;
//        this.showNext = false;
    }

//    public void initPaginationState(int page) {
//        this.showFirst = page != 1;
//        this.showLast = page != totalPageSize;
//        this.showNext = page != totalPageSize;
//        this.showPrevious = page - 1 != 0;
//    }
//
//    public List<REQ> getItems() {
//        return items;
//    }
//
//    public void setItems(List<REQ> items) {
//        this.items = items;
//    }
//
//    public long getItemSize() {
//        return itemSize;
//    }
//
//    public void setItemSize(long itemSize) {
//        this.itemSize = itemSize;
//    }
//
//    public boolean isShowFirst() {
//        return showFirst;
//    }
//
//    public void setShowFirst(boolean showFirst) {
//        this.showFirst = showFirst;
//    }
//
//    public boolean isShowLast() {
//        return showLast;
//    }
//
//    public void setShowLast(boolean showLast) {
//        this.showLast = showLast;
//    }
//
//    public boolean isShowPrevious() {
//        return showPrevious;
//    }
//
//    public void setShowPrevious(boolean showPrevious) {
//        this.showPrevious = showPrevious;
//    }
//
//    public boolean isShowNext() {
//        return showNext;
//    }
//
//    public void setShowNext(boolean showNext) {
//        this.showNext = showNext;
//    }

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

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(long currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPageSize() {
        return totalPageSize;
    }

    public void setTotalPageSize(int totalPageSize) {
        this.totalPageSize = totalPageSize;
    }

}
