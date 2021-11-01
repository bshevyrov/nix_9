package ua.com.alevel.service;

import ua.com.alevel.dao.BookDao;
import ua.com.alevel.dao.PublisherDao;
import ua.com.alevel.entity.Book;
import ua.com.alevel.entity.Publisher;

public class PublisherService {

    private final PublisherDao publisherDao = new PublisherDao();
//    private final BookDao bookDao = new BookDao();

    public void create(Publisher publisher) {

        publisherDao.create(publisher);

    }

    public void update(Publisher publisher) {

        publisherDao.update(publisher);
//        Book[] books = publisher.getBooks();
//        for (Book book : books) {
//            bookDao.update(book);
//        }
    }

    public void delete(String name) {
        publisherDao.delete(name);
//        deletePublisherBooksFromBook(publisherDao.findByName(name));


        //TODO вынести в метод повторный код


    }

    public Publisher findByName(String name) {
        return publisherDao.findByName(name);
    }

    public Publisher[] findAll() {
        return publisherDao.findAll();
    }

//    private void deletePublisherBooksFromBook(Publisher publisher) {
//
//        //Book[] books = bookDao.findAll();
//
//        Book[] publisherBooks = publisher.getBooks();
//        for (Book book : publisherBooks) {
//            bookDao.delete(book.getId());
//        }
//
//
//        //1
////        for(Book book : books) {
////           // if(books.length==1){
////                bookDao.delete(book.getId());
////         //   }
//
//
//        //2
//
////   //         Book[] books= ArrayUtils.remove(findAll(), ArrayUtils.indexOf(findAll(),book));
////   //         publisher.setBooks(books);
////    //        publisherDao.update(books);
//    }


}

