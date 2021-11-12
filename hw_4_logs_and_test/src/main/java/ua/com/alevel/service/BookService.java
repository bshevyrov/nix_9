package ua.com.alevel.service;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.dao.AuthorDao;
import ua.com.alevel.dao.BookDao;
import ua.com.alevel.entity.Author;
import ua.com.alevel.entity.Book;

public class BookService {

    public static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    public static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    public static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

    private final BookDao bookDao = new BookDao();
    private final AuthorDao authorDao = new AuthorDao();


    public void create(Book book) {
        if (authorDao.findByNameOrNull(book.getAuthorName()) != null) {
            LOGGER_INFO.info("Author '" + book.getAuthorName() + "' already in DB");
            Author author = authorDao.findByNameOrNull(book.getAuthorName());
            String[] books = author.getBooksName();
            books = ArrayUtils.add(books, book.getName());
            LOGGER_INFO.info("Start adding book '" + book.getName() + "' to Author '" + book.getAuthorName() + "'");
            author.setBooksName(books);
            LOGGER_INFO.info("Finishing add book to author");
        }

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
        String authorOfTheBookName=bookDao.findByNameOrNull(name).getAuthorName();
        bookDao.delete(name);
        LOGGER_WARN.warn("Finish book '" + name + "' delete");
        if (authorDao.findByNameOrNull(authorOfTheBookName) != null) {
            LOGGER_WARN.warn("Find Author");
            Author author = authorDao.findByNameOrNull(
                   authorOfTheBookName);
            String[] books = author.getBooksName();
            for (int i = 0; i < books.length; i++) {
                if (StringUtils.equals(books[i], name)) {
                    LOGGER_WARN.warn("Deleting book from author");
                    books = ArrayUtils.remove(books, i);
                    author.setBooksName(books);
                }
            }
        }
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
