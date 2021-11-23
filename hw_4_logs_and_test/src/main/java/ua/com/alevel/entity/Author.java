package ua.com.alevel.entity;

import ua.com.alevel.service.BookService;

import java.util.Arrays;
import java.util.Objects;

public class Author {

    private static final BookService bookService = new BookService();

    private String id;
    private String name;
    private String[] booksId = new String[0];
    private String nickName;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getBooksId() {
        return booksId;
    }

    public void setBooksId(String[] booksId) {
        this.booksId = booksId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", nickname='" + nickName + '\'' +
                ", booksId=" + Arrays.toString(booksId) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id) && Objects.equals(name, author.name) && Arrays.equals(booksId, author.booksId) && Objects.equals(nickName, author.nickName);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, name, nickName);
        result = 31 * result + Arrays.hashCode(booksId);
        return result;
    }
}

