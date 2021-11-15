package ua.com.alevel.entity;

import ua.com.alevel.dao.AuthorBookDao;

import java.util.Objects;

public class Book {

    private String id;
    private String name;
    private String authorId;

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
//                ", authorName='" + authorName + '\'' +
                '}';
    }
    public void findAllAuthor(String id){
        AuthorBookDao authorBookDao = new AuthorBookDao();
         Author[] authors = authorBookDao.findAuthorsByBookId(id);
    }
//    @Override
//    public int hashCode() {
//        return Objects.hash(authorName, name, id);
//    }
}
