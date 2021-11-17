package ua.com.alevel.entity;

import org.apache.commons.lang3.ArrayUtils;
import ua.com.alevel.service.AuthorService;

import java.util.Arrays;
import java.util.Objects;

public class Book {

    private static final AuthorService authorService = new AuthorService();

    private String id;
    private String name;
    private String[] authorsId; // = new String [0];

    public String[] getAuthorId() {
        return authorsId;
    }

    public void setAuthorsId(String[] authorsId) {
        this.authorsId = authorsId;
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

    private String[] getAuthorsOfTheBookById() {
        String[] rsl = new String[0];
        for (String s : authorsId) {
            rsl = ArrayUtils.add(rsl, authorService.findByIdOrNull(s).getName());
        }
        return rsl;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name +
                ", author='" + Arrays.toString(getAuthorsOfTheBookById()) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(name, book.name) && Arrays.equals(authorsId, book.authorsId);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, name);
        result = 31 * result + Arrays.hashCode(authorsId);
        return result;
    }
}
