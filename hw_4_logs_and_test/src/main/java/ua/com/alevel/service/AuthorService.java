package ua.com.alevel.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.dao.AuthorDao;
import ua.com.alevel.entity.Author;

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

