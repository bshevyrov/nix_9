package ua.com.alevel.dao;

import org.apache.commons.lang3.StringUtils;
import ua.com.alevel.db.AuthorDB;
import ua.com.alevel.entity.Author;

public class AuthorDao {

    public void create(Author author) {
        AuthorDB.getInstance().create(author);
    }

    public void update(Author author) {
        AuthorDB.getInstance().update(author);
    }

    public void delete(String id) {
        AuthorDB.getInstance().delete(id);
    }

    public Author findByIdOrNull(String id) {
        return AuthorDB.getInstance().findByIdOrNull(id);
    }

    public String findAuthorIdByIdName(String name) {
        String rsl = "";
        Author[] authors = AuthorDB.getInstance().findAll();
        for (Author author : authors) {
            if (StringUtils.equals(author.getName(), name)) {
                rsl = author.getId();
            }
        }
        return rsl;
    }

    public Author[] findAll() {
        return AuthorDB.getInstance().findAll();
    }
}

