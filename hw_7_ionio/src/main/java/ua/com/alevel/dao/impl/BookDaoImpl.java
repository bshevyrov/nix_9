package ua.com.alevel.dao.impl;

import ua.com.alevel.dao.BookDao;
import ua.com.alevel.db.impl.BookDBImpl;
import ua.com.alevel.entity.Book;

import java.util.List;
import java.util.NoSuchElementException;

public class BookDaoImpl implements BookDao {


    @Override
    public void create(Book book) {
        BookDBImpl.getInstance().create(book);
    }

    @Override
    public void update(Book book) {
        BookDBImpl.getInstance().update(book);
    }

    @Override
    public void delete(Long id) {
        BookDBImpl.getInstance().delete(id);
    }

    @Override
    public boolean isExistById(Long id) {
        boolean rsl = true;
        try {
            BookDBImpl.getInstance().findById(id);
        } catch (NoSuchElementException e) {
            rsl = false;
        }
        return rsl;
    }

    @Override
    public Book findById(Long id) {
        return BookDBImpl.getInstance().findById(id);
    }

    @Override
    public List<Book> findAll() {
        return BookDBImpl.getInstance().findAll();
    }
}
