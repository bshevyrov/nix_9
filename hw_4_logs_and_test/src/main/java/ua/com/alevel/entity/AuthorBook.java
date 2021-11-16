package ua.com.alevel.entity;

public class AuthorBook {

    private String[] authorIds;
    private String[] bookIds;

    public String[] getAuthorIds() {
        return authorIds;
    }

    public void setAuthorId(String[] authorIds) {
        this.authorIds = authorIds;
    }

    public String[] getBookIds() {
        return bookIds;
    }

    public void setBookIds(String[] bookIds) {
        this.bookIds = bookIds;
    }
}
