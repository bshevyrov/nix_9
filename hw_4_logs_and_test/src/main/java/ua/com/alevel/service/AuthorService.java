package ua.com.alevel.service;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.dao.AuthorDao;
import ua.com.alevel.dao.BookDao;
import ua.com.alevel.entity.Author;
import ua.com.alevel.entity.Book;

public class AuthorService {

    public static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    public static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    public static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

    private final AuthorDao authorDao = new AuthorDao();

    public void create(Author author) {
        LOGGER_INFO.info("Start creating author '" + author.getName() + "'");
        authorDao.create(author);
        LOGGER_INFO.info("Finish creating Author '" + author.getName() + "'");
    }

    public void update(Author author) {
        LOGGER_INFO.info("Start updating Author '" + author.getName() + "'");
        authorDao.update(author);
        LOGGER_INFO.info("Finish updating Author '" + author.getName() + "'");
    }

    public void delete(String id) {
        LOGGER_WARN.warn("Start author '" + id + "' delete");
        authorDao.delete(id);
//        BookDao bookDao = new BookDao();
//        Book[] books = bookDao.findAll();
//        for (int i = 0; i < books.length; i++) {
//            String[] aIds = books[i].getAuthorId();
//            for (int j = 0; j < aIds.length; j++) {
//                if (StringUtils.equals(aIds[j], id)) {
//                    aIds = ArrayUtils.remove(aIds, j);
//                    books[i].setAuthorsId(aIds);
//                }
//            }
//        }
        LOGGER_WARN.warn("Finish author '" + id + "' delete");
    }

    public Author findByIdOrNull(String id) {
        try {
            return authorDao.findByIdOrNull(id);
        } catch (NullPointerException e) {
            LOGGER_ERROR.error("Author '" + id + "' not found ");
        }
        return null;
    }

    public String findAuthorIdByName(String name) {
        return authorDao.findAuthorIdByIdName(name);
    }

    public Author[] findAll() {
        LOGGER_INFO.info("Starting find all book");
        return authorDao.findAll();
    }

}

