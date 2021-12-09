package ua.com.alevel.dao.impl;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import ua.com.alevel.dao.AuthorDao;
import ua.com.alevel.db.impl.AuthorDBImpl;
import ua.com.alevel.entity.Author;

import java.util.Collection;
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
    public void delete(String id) {
        AuthorDBImpl.getInstance().delete(id);
    }

    @Override
    public boolean isExistById(String id) {

        boolean rsl = true;
        try {
            AuthorDBImpl.getInstance().findById(id);
        } catch (NoSuchElementException e) {
            rsl = false;
        }
        return rsl;
    }

    public String findIdByName(String name) {
        String rsl = "";
        Collection<Author> authors = AuthorDBImpl.getInstance().findAll();
        authors = CollectionUtils.emptyIfNull(authors);
        for (Author author : authors) {
            if (StringUtils.equals(author.getName(), name)) {
                rsl = author.getId();
            }
        }

        return rsl;
    }

    @Override
    public Author findById(String id) {
        return AuthorDBImpl.getInstance().findById(id);
    }

    @Override
    public List<Author> findAll() {
        return AuthorDBImpl.getInstance().findAll();
    }
}
