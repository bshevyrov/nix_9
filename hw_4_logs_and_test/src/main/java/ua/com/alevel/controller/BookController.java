package ua.com.alevel.controller;

import org.apache.commons.lang3.StringUtils;
import ua.com.alevel.entity.Author;
import ua.com.alevel.entity.Book;
import ua.com.alevel.service.AuthorService;
import ua.com.alevel.service.BookService;

import java.io.BufferedReader;
import java.io.IOException;

public class BookController {
    private final BookService bookService = new BookService();

    private final AuthorService authorService = new AuthorService();

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
        System.out.print("Write Year of the book:");
        int bookYear = 0;
        try {
            bookYear = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Book newBook = new Book();
        newBook.setName(bookName);
        newBook.setAuthorName(authorName);
        newBook.setYear(bookYear);
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
        Book newBook = new Book();
        newBook.setName(bookName);
        bookService.update(newBook);
        Author newAuthor = new Author();
        newAuthor.setName(authorName);
        newAuthor.setBooksName(new String[]{bookName});
        authorService.update(newAuthor);
    }

    public void delete(BufferedReader reader) {
        System.out.print("Write name of book to delete:");
        String name = null;
        try {
            name = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        bookService.delete(name);
    }

    public void findAll(BufferedReader reader) {
        Book[] books = bookService.findAll();
        for (Book book : books) {
            System.out.println(book.toString());
        }
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
                Book book = bookService.findByNameOrNull(nameBook);
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
