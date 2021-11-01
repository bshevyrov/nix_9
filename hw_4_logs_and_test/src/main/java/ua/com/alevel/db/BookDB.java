package ua.com.alevel.db;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import ua.com.alevel.entity.Book;

import java.util.UUID;

public final class BookDB {

    private final Book[] books;
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
       // String id = generateId();
//        book.setName(id);
        ArrayUtils.add(books, book);
    }
//
//    private String generateId() {
//        String id = UUID.randomUUID().toString();
//        if(!(findByIdOrNull(id)==null)){
//            generateId();
//        }
//        return id;
//    }

    public void update(Book book) {
        Book current = ArrayUtils.get(books, getIndexByName(book.getName()));
        current.setName(book.getName());
        current.setAuthorName(book.getAuthorName());
        current.setPublisherName(book.getPublisherName());
    }

    public void delete(String name) {
        ArrayUtils.remove(books, getIndexByName(name));
    }

    private int getIndexByName(String name) {
        return ArrayUtils.indexOf(books, findByNameOrNull(name));
    }

    public Book findByNameOrNull(String name) {
        for (Book book : books) {
            if (StringUtils.equals(name, book.getName())) {
                return book;
            }
        }
        return null;
    }

    public Book[] findAll() {
        return books;
    }

}
