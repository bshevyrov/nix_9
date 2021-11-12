package ua.com.alevel.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.dao.AuthorDao;
import ua.com.alevel.entity.Author;

public class AuthorService {

    private final AuthorDao authorDao = new AuthorDao();

    public static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    public static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    public static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

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

    public void delete(String name) {
        LOGGER_WARN.warn("Start author '" + name + "' delete");
        authorDao.delete(name);
        LOGGER_WARN.warn("Finish author '" + name + "' delete");
    }

    public Author findByNameOrNull(String name) {
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
