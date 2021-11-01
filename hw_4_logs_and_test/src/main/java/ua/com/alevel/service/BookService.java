package ua.com.alevel.service;

import org.apache.commons.lang3.ArrayUtils;
import ua.com.alevel.dao.AuthorDao;
import ua.com.alevel.dao.BookDao;
import ua.com.alevel.dao.PublisherDao;
import ua.com.alevel.entity.Author;
import ua.com.alevel.entity.Book;
import ua.com.alevel.entity.Publisher;

public class BookService {

    private final BookDao bookDao = new BookDao();
//    private final AuthorDao authorDao =  new AuthorDao();
//    private final PublisherDao publisherDao = new PublisherDao();

    public void create(Book book) {

       // Author[] authors = book.getAuthors();
//        Publisher publisher = book.getPublisher();

        bookDao.create(book);
//        publisherDao.create(publisher);
//        for (Author author : authors) {
//            authorDao.create(author);
//        }
    }

    public void update(Book book) {

//        Author[] authors = book.getAuthors();
//        Publisher publisher =book.getPublisher();

        bookDao.update(book);
//        publisherDao.update(publisher);
//        for (Author author : authors) {
//            authorDao.update(author);
//        }
            }
    public void delete(String name) {

        bookDao.delete(name);
//       deleteBookFromPublisher(findById(id));
//        deleteBookFromAuthors(findById(id));
    }


    public Book findByName(String name) {
        return bookDao.findByName(name);
    }

    public Book[] findAll(){
        return bookDao.findAll();
    }

//    private void deleteBookFromPublisher(Book book) {
//
//        Publisher publisher = publisherDao.findByName(findById(book.getId()).getPublisher().getName());
//
//        if (publisher.getBooks().length == 1) {
//            publisherDao.delete(publisher.getName());
//        }
//        //TODO refactor
//        Book[] books = ArrayUtils.remove(findAll(), ArrayUtils.indexOf(findAll(), book));
//        publisher.setBooks(books);
//        publisherDao.update(publisher);
//    }
//
//    private void deleteBookFromAuthors(Book book) {
//        Author[] authors = authorDao.findAll();
//        for (Author author : authors) {
//            if(author.getBooks().length==1) {
//                authorDao.delete(author.getEmail());
//            }
//            //TODO вынести в метод повторный код
//            Book[] books= ArrayUtils.remove(findAll(), ArrayUtils.indexOf(findAll(),book));
//            author.setBooks(books);
//            authorDao.update(author);
//        }
//    }
}
