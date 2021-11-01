package ua.com.alevel.dao;

import ua.com.alevel.db.BookDB;
import ua.com.alevel.entity.Book;

public class BookDao {

    public void create(Book book) {
        BookDB.getInstance().create(book);
    }

    public void update(Book book) {
        BookDB.getInstance().update(book);
    }

    public void delete(String name) {
        BookDB.getInstance().delete(name);
    }

    public Book findByName(String name) {
        return BookDB.getInstance().findByNameOrNull(name);
    }

    public Book[] findAll() {
        return BookDB.getInstance().findAll();
    }
}
