package ua.com.alevel.entity;

public class AuthorBook {

    private String authorId;
    private String[] bookIds;

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorIds) {
        this.authorId = authorId;
    }

    public String[] getBookIds() {
        return bookIds;
    }

    public void setBookIds(String[] bookIds) {
        this.bookIds = bookIds;
    }
}
