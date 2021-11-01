package ua.com.alevel.dao;

import ua.com.alevel.db.AuthorDB;
import ua.com.alevel.entity.Author;

public class AuthorDao {

    public void create(Author author){
        AuthorDB.getInstance().create(author);
    }
    public void update(Author author) {
        AuthorDB.getInstance().update(author);
    }
    public void delete(String name) {
        AuthorDB.getInstance().delete(name);
    }
    public Author findByName(String name) {
        return AuthorDB.getInstance().findByNameOrNull(name);
    }
    public Author[] findAll() {
        return AuthorDB.getInstance().findAll();
    }
}

