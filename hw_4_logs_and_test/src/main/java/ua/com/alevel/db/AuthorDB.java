package ua.com.alevel.db;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import ua.com.alevel.entity.Author;

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
        authors = ArrayUtils.add(authors, author);
    }

    public void update(Author author) {
        Author current = ArrayUtils.get(authors, findIndexByName(author.getName()));
        current.setName(author.getName());
        current.setBooksName(author.getBooksName());
        current.setAge(author.getAge());
    }

    public void delete(String name) {
        authors = ArrayUtils.remove(authors, findIndexByName(name));
    }

    private int findIndexByName(String name) {
        return ArrayUtils.indexOf(authors, findByNameOrNull(name));
    }

    public Author findByNameOrNull(String name) {
        for (Author author : authors) {
            if (StringUtils.equals(name, author.getName())) {
                return author;
            }
        }
        return null;
    }

    public Author[] findAll() {
        return authors;
    }

}
