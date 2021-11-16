package ua.com.alevel.entity;

import org.apache.commons.lang3.ArrayUtils;
import ua.com.alevel.service.BookService;

import java.util.Arrays;

public class Author {

    private String id;
    private String name;
    private String[] booksId = new String[0];

    BookService bookService = new BookService();

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

    private String[] getBooksWroteByAuthorById() {
        String[] rsl = new String[0];
        for (String s : booksId) {
            rsl = ArrayUtils.add(rsl, bookService.findByIdOrNull(s).getName());
        }
        return rsl;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name=" + name +
                ", books=" + Arrays.toString(getBooksWroteByAuthorById()) +
                '}';
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Author author = (Author) o;
//        return id == author.id && Objects.equals(name, author.name) && Arrays.equals(booksName, author.booksName);
//    }
//
//    @Override
//    public int hashCode() {
//        int result = Objects.hash(name, id);
//        result = 31 * result + Arrays.hashCode(booksName);
//        return result;
//    }
}

