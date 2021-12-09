package ua.com.alevel.entity;

import java.util.Arrays;

public class Book extends BaseEntity {

    private String name;
    private int pages;
    private String[] authorsId;

    public Book() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String[] getAuthorsId() {
        return authorsId;
    }

    public void setAuthorsId(String[] authorsId) {
        this.authorsId = authorsId;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pages=" + pages +
                ", authorsId=" + Arrays.toString(authorsId) +
                ", visible=" + visible +
                '}';
    }
}
