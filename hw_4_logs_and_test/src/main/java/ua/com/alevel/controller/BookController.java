package ua.com.alevel.controller;

import ua.com.alevel.entity.Author;
import ua.com.alevel.entity.Book;
//import ua.com.alevel.entity.Publisher;
import ua.com.alevel.service.AuthorService;
import ua.com.alevel.service.BookService;
//import ua.com.alevel.service.PublisherService;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class BookController {
    private final BookService bookService = new BookService();

    private final AuthorService authorService = new AuthorService();
 //   private final PublisherService publisherService = new PublisherService();

    public void create(BufferedReader reader) {
        System.out.print("Write name of the book:");
        String bookName = null;
        try {
            bookName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print("Write author name:");
        String authorName = null;
        try {
            authorName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        System.out.print("Write publisher name:");
//        String publisherName = null;
//        try {
//            publisherName = reader.readLine();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        Book newBook = new Book();
        newBook.setName(bookName);
        newBook.setAuthorName(authorName);
//        newBook.setPublisherName(publisherName);
        bookService.create(newBook);
    }

    public void update(BufferedReader reader) {
        System.out.print("Write name of the book:");
        String bookName = null;
        try {
            bookName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print("Write author name:");
        String authorName = null;
        try {
            authorName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        System.out.println("Write publisher name:");
//        String publisherName = null;
//        try {
//            publisherName = reader.readLine();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        Book newBook = new Book();
        newBook.setName(bookName);
        bookService.create(newBook);

        Author newAuthor = new Author();
        newAuthor.setName(authorName);
        newAuthor.setBooksName(new String[]{bookName});
        authorService.create(newAuthor);

//        Publisher newPublisher = new Publisher();
//        newPublisher.setName(publisherName);
//        newPublisher.setBooksName(new String[]{bookName});
    }

    public void delete(BufferedReader reader) {
        System.out.print("Write name of book to delete:");
        String name = null;
        try {
            name = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Book book = bookService.findByName(name);
        bookService.delete(name);

      //  publisherService.delete(book.getPublisherName());
    }


    public void findAll(BufferedReader reader) {
        Book[] books = bookService.findAll();
        System.out.println(Arrays.toString(books));
//        for (Book book : books) {
//            System.out.println(book.toString());
//        }
        while (true) {
            System.out.print("Type 0 to clear and continue: ");
            try {
                int rsl = Integer.parseInt(reader.readLine());
                if (rsl == 0) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void findByName(BufferedReader reader) {
        while (true) {
            try {
                System.out.print("Write name of book:");
                String nameBook = reader.readLine();
                Book book = bookService.findByName(nameBook);
                System.out.println(book.toString());
                while (true) {
                    System.out.println("Write 0 to continue:");
                    int rsl = Integer.parseInt(reader.readLine());
                    if (rsl == 0) {
                        break;
                    }
                }
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
//    public void create(BufferedReader reader){
//
//    }
//
//    public void findAll(BufferedReader reader) {
//    }
//
//    public void findById(BufferedReader reader) {
//    }
//
//    public void delete(BufferedReader reader) {
//    }
//
//    public void update(BufferedReader reader) {
//    }

