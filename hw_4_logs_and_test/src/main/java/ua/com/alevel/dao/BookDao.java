package ua.com.alevel.dao;

import org.apache.commons.lang3.StringUtils;
import ua.com.alevel.db.BookDB;
import ua.com.alevel.entity.Book;

public class BookDao {

    public void create(Book book) {
        BookDB.getInstance().create(book);
    }

    public void update(Book book) {
        BookDB.getInstance().update(book);
    }

    public void delete(String id) {
        BookDB.getInstance().delete(id);
    }

    public Book findByIdOrNull(String id) {
        return BookDB.getInstance().findByIdOrNull(id);
    }

    public String findIdByName(String name) {
        String rsl = "";
        Book[] books = BookDB.getInstance().findAll();
        for (Book book1 : books) {
            if (StringUtils.equals(book1.getName(), name)) {
                rsl = book1.getId();
            }
        }
        return rsl;
    }

    public Book[] findAll() {
        return BookDB.getInstance().findAll();
    }
}
