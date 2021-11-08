package ua.com.alevel.service;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import ua.com.alevel.dao.AuthorDao;
import ua.com.alevel.dao.BookDao;
import ua.com.alevel.entity.Author;
import ua.com.alevel.entity.Book;
import ua.com.alevel.helpers.NavigationMenu;

public class BookService {

    private final BookDao bookDao = new BookDao();
    private final AuthorDao authorDao = new AuthorDao();

    public void create(Book book) {
        bookDao.create(book);
       if(authorDao.findByNameOrNull(book.getAuthorName())==null){
           NavigationMenu.runNavigationAddBookFromAuthor();
       }
    }

    public void update(Book book) {
        bookDao.update(book);
    }

    public void delete(String name) {
        Book book = bookDao.findByNameOrNull(name);
        Author author = authorDao.findByNameOrNull(book.getAuthorName());
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

    public Book findByNameOrNull(String name) {
        return bookDao.findByNameOrNull(name);
    }

    public Book[] findAll() {
        return bookDao.findAll();
    }
}
