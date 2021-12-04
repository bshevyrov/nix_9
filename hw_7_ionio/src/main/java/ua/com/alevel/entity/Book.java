package ua.com.alevel.entity;

public class Book extends BaseEntity {

    private String name;
    private String[] authorsId;
    private int pages;

    public Book() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getAuthorsId() {
        return authorsId;
    }

    public void setAuthorsId(String[] authorsId) {
        this.authorsId = authorsId;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
