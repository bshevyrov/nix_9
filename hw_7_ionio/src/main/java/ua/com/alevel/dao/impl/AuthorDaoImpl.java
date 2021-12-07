package ua.com.alevel.dao.impl;

import ua.com.alevel.dao.AuthorDao;
import ua.com.alevel.db.impl.AuthorDBImpl;
import ua.com.alevel.entity.Author;

import java.util.List;
import java.util.NoSuchElementException;

public class AuthorDaoImpl implements AuthorDao {


    @Override
    public void create(Author author) {
        AuthorDBImpl.getInstance().create(author);
    }

    @Override
    public void update(Author author) {
        AuthorDBImpl.getInstance().update(author);
    }

    @Override
    public void delete(Long id) {
        AuthorDBImpl.getInstance().delete(id);
    }

    @Override
    public boolean isExistById(Long id) {

        boolean rsl = true;
        try {
            AuthorDBImpl.getInstance().findById(id);
        } catch (NoSuchElementException e) {
            rsl = false;
        }
        return rsl;
    }

    @Override
    public Author findById(Long id) {
        return AuthorDBImpl.getInstance().findById(id);
    }

    @Override
    public List<Author> findAll() {
        return AuthorDBImpl.getInstance().findAll();
    }
}
