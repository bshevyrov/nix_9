package ua.com.alevel.dao.impl;

import org.apache.commons.lang3.StringUtils;
import ua.com.alevel.dao.BookDao;
import ua.com.alevel.db.impl.AuthorDBImpl;
import ua.com.alevel.db.impl.BookDBImpl;
import ua.com.alevel.entity.Author;
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
    public void delete(String id) {
        BookDBImpl.getInstance().delete(id);
    }

    @Override
    public boolean isExistById(String id) {
        boolean rsl = true;
        try {
            BookDBImpl.getInstance().findById(id);
        } catch (NoSuchElementException e) {
            rsl = false;
        }
        return rsl;
    }

    @Override
    public Book findById(String id) {
        return BookDBImpl.getInstance().findById(id);
    }

    public String findIdByName(String name) {
       String rsl = "";
        List<Author> authors = AuthorDBImpl.getInstance().findAll();
        for (Author author : authors) {
            if (StringUtils.equals(author.getName(), name)) {
                rsl = author.getId();
            }
        }
        return rsl;
    }

    @Override
    public List<Book> findAll() {
        return BookDBImpl.getInstance().findAll();
    }
}
