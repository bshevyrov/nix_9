package ua.com.alevel.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.dao.AuthorDao;
import ua.com.alevel.dao.BookDao;
import ua.com.alevel.entity.Book;

public class BookService {

    public static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    public static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    public static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

    private final BookDao bookDao = new BookDao();

    public void create(Book book) {
        LOGGER_INFO.info("Start creating book '" + book.getName() + "'");
        bookDao.create(book);
        LOGGER_INFO.info("Finish creating book '" + book.getName() + "'");
    }

    public void update(Book book) {
        LOGGER_INFO.info("Start updating book '" + book.getName() + "'");
        bookDao.update(book);
        LOGGER_INFO.info("Finish creating book '" + book.getName() + "'");
    }

    public void delete(String name) {
        LOGGER_WARN.warn("Start book '" + name + "' delete");
        bookDao.delete(name);
        LOGGER_WARN.warn("Finish book '" + name + "' delete");
    }

    public Book findByNameOrNull(String name) {
        try {
            return bookDao.findByNameOrNull(name);
        } catch (NullPointerException e) {
            LOGGER_ERROR.error("Book '" + name + "' not found by name");
        }
        return null;
    }

    public Book[] findAll() {
        LOGGER_INFO.info("Starting find all book");
        return bookDao.findAll();
    }
}
