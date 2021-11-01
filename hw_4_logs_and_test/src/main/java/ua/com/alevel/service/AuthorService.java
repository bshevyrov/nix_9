package ua.com.alevel.service;

import ua.com.alevel.dao.AuthorDao;
import ua.com.alevel.dao.BookDao;
import ua.com.alevel.entity.Author;
import ua.com.alevel.entity.Book;

public class AuthorService {

    private final AuthorDao authorDao = new AuthorDao();
   // private final BookDao bookDao = new BookDao();

    //TODO переделать на 1 книгу паблишера и автора
    public void create(Author author) {
        authorDao.create(author);
//        Book[] books = author.getBooks();
//        for (Book book : books) {
//            if (!(book == null)) {
//                bookDao.create(book);
//            }
//        }
    }

    public void update(Author author) {
        authorDao.update(author);
//        Book[] books = author.getBooks();
//        for (Book book : books) {
//            bookDao.update(book);
//
//        }
    }

    public void delete(String email) {
        authorDao.delete(email);

//        Book[] books = findByEmail(email).getBooks();
//        for (Book book : books) {
//            bookDao.delete(book.getId());
//
//        }

    }

    public Author findByName(String name) {
        return authorDao.findByName(name);
    }

    public Author[] findAll() {
        return authorDao.findAll();
    }
}
