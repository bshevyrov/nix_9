package ua.com.alevel.db;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import ua.com.alevel.entity.Author;
import ua.com.alevel.entity.AuthorBook;

import java.util.UUID;

public final class AuthorDB {

    private static AuthorDB instance;
    private Author[] authors;

    private AuthorDB() {
        authors = new Author[0];
    }

    public static AuthorDB getInstance() {
        if (instance == null) {
            instance = new AuthorDB();
        }
        return instance;
    }

    public void create(Author author) {
        author.setId(generateId());
        authors = ArrayUtils.add(authors, author);
        AuthorBook authorBook = new AuthorBook();
        authorBook.setAuthorIds(new String[]{author.getId()});
        AuthorBookDB.getInstance().create(authorBook);
    }

    public void update(Author author) {
        Author current = ArrayUtils.get(authors, findIndexById(author.getId()));
        current.setName(author.getName());
        current.setBooksId(author.getBooksId());
//        AuthorBook authorBook = new AuthorBook();
//        authorBook.setAuthorIds(new String[]{author.getId()});
//        AuthorBookDB.getInstance().update(authorBook);
    }

    public void delete(String id) {
        authors = ArrayUtils.remove(authors, findIndexById(id));
    }

    private int findIndexById(String id) {
        return ArrayUtils.indexOf(authors, findByIdOrNull(id));
    }

    public Author findByIdOrNull(String id) {
        for (Author author : authors) {
            if (StringUtils.equals(id, author.getId())) {
                return author;
            }
        }
        return null;
    }

    public Author[] findAll() {
        return authors;
    }

    private String generateId() {
        String id = UUID.randomUUID().toString();
        if (!(findByIdOrNull(id) == null)) {
            generateId();
        }
        return id;
    }
}
