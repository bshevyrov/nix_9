package ua.com.alevel.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.dao.AuthorDao;
import ua.com.alevel.dao.BookDao;
import ua.com.alevel.entity.Author;
import ua.com.alevel.helpers.InputValueMenuHandler;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AuthorService {

    private final AuthorDao authorDao = new AuthorDao();
    private final BookDao bookDao = new BookDao();

    public static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    public static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    public static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

    public void create(Author author) {
        LOGGER_INFO.info("Start creating author '" + author.getName() + "'");
        authorDao.create(author);
        LOGGER_INFO.info("Finish creating author '" + author.getName() + "'");
        if (bookDao.findByNameOrNull(author.getBooksName()[0]) == null) {
            LOGGER_INFO.info("There are no book '" + author.getBooksName() + "' in DB");
            InputValueMenuHandler.addBookFromAuthorHandler(new BufferedReader(new InputStreamReader(System.in)));
        }
    }

    public void update(Author author) {
        LOGGER_INFO.info("Start updating Author '" + author.getName() + "'");
        authorDao.update(author);
        LOGGER_INFO.info("Finish updating Author '" + author.getName() + "'");
    }

    public void delete(String name) {
        LOGGER_WARN.warn("Start author '" + name + "' delete");
        // Author author = findByName(name);
        authorDao.delete(name);
        LOGGER_WARN.warn("Finish author '" + name + "' delete");
//TODO СПРОСИТЬ ЖЕЛАЕМ ЛИ УДАЛИТЬ

//        String[] books = author.getBooksName();
//        for (String book : books) {
//            bookDao.delete(book);
//        }
    }

    public Author findByName(String name) {
        try {
            return authorDao.findByNameOrNull(name);
        } catch (NullPointerException e) {
            LOGGER_ERROR.error("Author '" + name + "' not found by name");
        }
        return null;
    }

    public Author[] findAll() {
        LOGGER_INFO.info("Starting find all book");
        return authorDao.findAll();
    }
}
