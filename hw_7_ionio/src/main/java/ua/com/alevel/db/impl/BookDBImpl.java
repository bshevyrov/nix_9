package ua.com.alevel.db.impl;

import ua.com.alevel.db.BaseDB;
import ua.com.alevel.entity.Book;


import java.io.File;
import java.util.List;

public class BookDBImpl implements BaseDB<Book> {

    private static final File bookDbFile = new File("src/main/resources/db/bookdb.txt");

    @Override
    public void create(Book book) {

    }

    @Override
    public void update(Book book) {

    }

    @Override
    public void delete(Book book) {

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
