package ua.com.alevel.service;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import ua.com.alevel.dao.AuthorDao;
import ua.com.alevel.dao.BookDao;
import ua.com.alevel.entity.Author;
import ua.com.alevel.entity.Book;
//import ua.com.alevel.entity.Publisher;

public class BookService {

    private final BookDao bookDao = new BookDao();
    private final AuthorDao authorDao = new AuthorDao();
//    private final PublisherDao publisherDao = new PublisherDao();

    public void create(Book book) {
        bookDao.create(book);
        Author authorOfBook = new Author();
        authorOfBook.setBooksName(new String[]{book.getName()});
        authorOfBook.setName(book.getAuthorName());

        if (authorDao.findByName(book.getAuthorName()) == null) {
            authorDao.create(authorOfBook);
        } else {
            Author authorFromDb = authorDao.findByName(book.getAuthorName());
            String[] books = authorFromDb.getBooksName();
            books = ArrayUtils.add(books, book.getName());
            authorFromDb.setBooksName(books);
            authorDao.update(authorFromDb);
        }
    }

    public void update(Book book) {
        bookDao.update(book);
    }

    public void delete(String name) {
        Book book = bookDao.findByName(name);
        Author author = authorDao.findByName(book.getAuthorName());
        String[] books = author.getBooksName();
        bookDao.delete(name);
        if (books.length == 1) {
            authorDao.delete(books[0]);
        } else {
            for (int i = 0; i < books.length; i++) {
                if (StringUtils.equals(books[i], name)) {
                    books = ArrayUtils.remove(books, i);
                    break;
                }
            }
            author.setBooksName(books);
            authorDao.update(author);
        }
    }


    public Book findByName(String name) {
        return bookDao.findByName(name);
    }

    public Book[] findAll() {
        return bookDao.findAll();
    }
}
