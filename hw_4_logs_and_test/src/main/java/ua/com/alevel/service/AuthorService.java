package ua.com.alevel.service;

import ua.com.alevel.dao.AuthorDao;
import ua.com.alevel.dao.BookDao;
import ua.com.alevel.entity.Author;
import ua.com.alevel.helpers.InputValueMenuHandler;
import ua.com.alevel.helpers.NavigationMenu;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AuthorService {

    private final AuthorDao authorDao = new AuthorDao();
    private final BookDao bookDao = new BookDao();

    public void create(Author author) {
        authorDao.create(author);
        if (bookDao.findByNameOrNull(author.getBooksName()[0]) == null) {
            InputValueMenuHandler.addBookFromAuthorHandler(new BufferedReader(new InputStreamReader(System.in)));
        }
    }

    public void update(Author author) {
        authorDao.update(author);
    }

    public void delete(String name) {
        Author author = findByName(name);
        authorDao.delete(name);
        String[] books = author.getBooksName();
        for (String book : books) {
            bookDao.delete(book);
        }
    }

    public Author findByName(String name) {
        return authorDao.findByNameOrNull(name);
    }

    public Author[] findAll() {
        return authorDao.findAll();
    }
}
