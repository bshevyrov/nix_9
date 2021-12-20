package ua.com.alevel.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    public void delete(String id) {
        LOGGER_WARN.warn("Start book '" + id + "' delete");
        bookDao.delete(id);
        LOGGER_WARN.warn("Finish book '" + id + "' delete");
    }

    public Book findByIdOrNull(String id) {
        try {
            return bookDao.findByIdOrNull(id);
        } catch (NullPointerException e) {
            LOGGER_ERROR.error("Book '" + id + "' not found");
        }
        return null;
    }

    public String findBookIdByName(String name) {
        return bookDao.findIdByName(name);
    }

    public Book[] findAll() {
        LOGGER_INFO.info("Starting find all book");
        return bookDao.findAll();
    }
}
