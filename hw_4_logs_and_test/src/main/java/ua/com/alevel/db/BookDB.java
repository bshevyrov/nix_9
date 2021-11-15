package ua.com.alevel.db;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import ua.com.alevel.entity.Book;

import java.util.UUID;

public final class BookDB {

    private Book[] books;
    private static BookDB instance;

    private BookDB() {
        books = new Book[0];
    }

    public static BookDB getInstance() {
        if (instance == null) {
            instance = new BookDB();
        }
        return instance;
    }

    public void create(Book book) {
        book.setId(generateId());
        books = ArrayUtils.add(books, book);
    }

    private String generateId() {
        String id = UUID.randomUUID().toString();
        if (!(findByIdOrNull(id) == null)) {
            generateId();
        }
        return id;
    }

    public void update(Book book) {
        Book current = ArrayUtils.get(books, getIndexById(book.getId()));
        current.setName(book.getName());
       // current.setAuthorName(book.getAuthorName());

    }

    public void delete(String id) {
        books = ArrayUtils.remove(books, getIndexById(id));
    }

    private int getIndexById(String id) {
        return ArrayUtils.indexOf(books, findByIdOrNull(id));
    }

    public Book findByIdOrNull(String id) {
        for (Book book : books) {
            if (StringUtils.equals(id, book.getId())) {
                return book;
            }
        }
        return null;
    }

    public Book[] findAll() {
        return books;
    }
}
