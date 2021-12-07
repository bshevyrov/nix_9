package ua.com.alevel.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.dao.AuthorDao;
import ua.com.alevel.dao.impl.AuthorDaoImpl;
import ua.com.alevel.entity.Author;
import ua.com.alevel.service.AuthorService;

import java.util.List;

public class AuthorServiceImpl implements AuthorService {

    public static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    public static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    public static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

    private final AuthorDao authorDao = new AuthorDaoImpl();
    @Override
    public void create(Author author) {
        LOGGER_INFO.info("Start creating author '" + author.getName() + "'");
        authorDao.create(author);
        LOGGER_INFO.info("Finish creating Author '" + author.getName() + "'");

    }

    @Override
    public void update(Author author) {
        LOGGER_INFO.info("Start updating Author '" + author.getName() + "'");
        authorDao.update(author);
        LOGGER_INFO.info("Finish updating Author '" + author.getName() + "'");

    }

    @Override
    public void delete(String id) {
        LOGGER_WARN.warn("Start author '" + id + "' delete");
        authorDao.delete(id);

        LOGGER_WARN.warn("Finish author '" + id + "' delete");

    }

    @Override
    public Author findById(String id) {
        try {
            return authorDao.findById(id);
        } catch (NullPointerException e) {
            LOGGER_ERROR.error("Author '" + id + "' not found ");
        }
        return null;
    }

    @Override
    public List<Author> findAll() {
        LOGGER_INFO.info("Starting find all book");
        return authorDao.findAll();
    }

    public String findIdByName(String name) {
        return authorDao.findIdByName(name);
    }
}
