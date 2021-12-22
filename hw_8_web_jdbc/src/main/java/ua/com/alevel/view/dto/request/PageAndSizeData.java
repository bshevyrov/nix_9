package ua.com.alevel.view.dto.request;

public class PageAndSizeData {

    private int page;
    private int size;

    public PageAndSizeData() {
    }

    public PageAndSizeData(int page, int size) {
        this.page = page;
        this.size = size;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "PageAndSizeData{" +
                "page=" + page +
                ", size=" + size +
                '}';
    }
}

