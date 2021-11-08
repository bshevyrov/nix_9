package ua.com.alevel.service;

import ua.com.alevel.dao.AuthorDao;
import ua.com.alevel.dao.BookDao;
import ua.com.alevel.entity.Author;
import ua.com.alevel.entity.Book;

public class AuthorService {

    private final AuthorDao authorDao = new AuthorDao();
    private final BookDao bookDao = new BookDao();

    public void create(Author author) {
        authorDao.create(author);
        Book book = new Book();
        book.setName(author.getBooksName()[0]);
        book.setAuthorName(author.getName());
        bookDao.create(book);
    }

    public void update(Author author) {
        authorDao.update(author);
    }

    public void delete(String name) {

        Author author = findByName(name);
        authorDao.delete(name);
        String[] books = author.getBooksName();
        for (int i = 0; i < books.length; i++) {
            bookDao.delete(books[i]);
        }
    }

    public Author findByName(String name) {
        return authorDao.findByNameOrNull(name);
    }

    public Author[] findAll() {
        return authorDao.findAll();
    }
}
