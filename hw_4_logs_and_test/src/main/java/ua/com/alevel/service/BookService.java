package ua.com.alevel.service;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.dao.AuthorDao;
import ua.com.alevel.dao.BookDao;
import ua.com.alevel.entity.Author;
import ua.com.alevel.entity.Book;
import ua.com.alevel.helpers.InputValueMenuHandler;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BookService {

    public static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    public static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    public static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

    private final BookDao bookDao = new BookDao();
    private final AuthorDao authorDao = new AuthorDao();

    public void create(Book book) {
        LOGGER_INFO.info("Start creating book '" + book.getName() + "'");
        bookDao.create(book);
        LOGGER_INFO.info("Finish creating book '" + book.getName() + "'");
        if (authorDao.findByNameOrNull(book.getAuthorName()) == null) {
            LOGGER_INFO.info("There are no author '" + book.getAuthorName() + "' in DB");
            InputValueMenuHandler.addAuthorFromBookHandler(new BufferedReader(new InputStreamReader(System.in)));
        }
    }

    public void update(Book book) {
        bookDao.update(book);
    }

    public void delete(String name) {
        LOGGER_WARN.warn("Start book '" + name + "' delete");
//        Book book = bookDao.findByNameOrNull(name);
//        Author author = authorDao.findByNameOrNull(book.getAuthorName());
//        String[] books = author.getBooksName();
        bookDao.delete(name);
        LOGGER_WARN.warn("Finish book '" + name + "' delete");
//TODO СПРОСИТЬ ЖЕЛАЕМ ЛИ УДАЛИТЬ АВТОРА

//        if (books.length == 1) {
//            authorDao.delete(books[0]);
//        } else {
//            for (int i = 0; i < books.length; i++) {
//                if (StringUtils.equals(books[i], name)) {
//                    books = ArrayUtils.remove(books, i);
//                    break;
//                }
//            }
//            author.setBooksName(books);
//            authorDao.update(author);
//        }
    }

    public Book findByNameOrNull(String name) {
        try {

            return bookDao.findByNameOrNull(name);
        } catch (NullPointerException e){
            LOGGER_ERROR.error("Book '" + name +"' not found by name");
        }
        return null;
    }

    public Book[] findAll() {
        return bookDao.findAll();
    }
}
