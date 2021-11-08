package ua.com.alevel.db;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import ua.com.alevel.entity.Book;

import java.util.UUID;

public final class BookDB {

    private   Book[] books;
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
        books = ArrayUtils.add(books, book);
    }
//
//    private String generateIdIsbn() {
//        String id = UUID.randomUUID().toString();
//        if(!(findByNameOrNull(id)==null)){
//            generateIdIsbn();
//        }
//        return id;
//    }

    public void update(Book book) {
        Book current = ArrayUtils.get(books, getIndexByName(book.getName()));
        current.setName(book.getName());
        current.setAuthorName(book.getAuthorName());
        current.setYear(book.getYear());
    }

    public void delete(String name) {
       books= ArrayUtils.remove(books, getIndexByName(name));
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
