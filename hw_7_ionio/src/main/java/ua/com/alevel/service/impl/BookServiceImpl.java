package ua.com.alevel.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.dao.BookDao;
import ua.com.alevel.dao.impl.BookDaoImpl;
import ua.com.alevel.entity.Book;
import ua.com.alevel.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    public static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    public static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    public static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

    private final BookDao bookDao = new BookDaoImpl();

    @Override
    public void create(Book book) {
        LOGGER_INFO.info("Start creating book '" + book.getName() + "'");
        bookDao.create(book);
        LOGGER_INFO.info("Finish creating book '" + book.getName() + "'");

    }

    @Override
    public void update(Book book) {
        LOGGER_INFO.info("Start updating book '" + book.getName() + "'");
        bookDao.update(book);
        LOGGER_INFO.info("Finish creating book '" + book.getName() + "'");

    }

    @Override
    public void delete(String id) {
        LOGGER_WARN.warn("Start book '" + id + "' delete");
        bookDao.delete(id);

        LOGGER_WARN.warn("Finish book '" + id + "' delete");

    }

    @Override
    public Book findById(String id) {

        try {
            return bookDao.findById(id);
        } catch (NullPointerException e) {
            LOGGER_ERROR.error("Book '" + id + "' not found");
        }
        return null;
    }

    @Override
    public String findIdByName(String name) {
        return bookDao.findIdByName(name);

    }

    @Override
    public List<Book> findAll() {
        LOGGER_INFO.info("Starting find all book");
        return bookDao.findAll();
    }
}
