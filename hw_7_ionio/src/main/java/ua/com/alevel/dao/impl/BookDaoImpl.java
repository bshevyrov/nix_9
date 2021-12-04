package ua.com.alevel.dao.impl;

import ua.com.alevel.dao.BookDao;
import ua.com.alevel.entity.Book;

import java.util.List;

public class BookDaoImpl implements BookDao {
    @Override
    public void create(Book book) {

    }

    @Override
    public void update(Book book) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public boolean isExistById(Long id) {
        return false;
    }

    @Override
    public Book findById(Long id) {
        return null;
    }

    @Override
    public List<Book> findAll() {
        return null;
    }
}
