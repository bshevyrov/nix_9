package ua.com.alevel.controller;

import org.apache.commons.lang3.StringUtils;
import ua.com.alevel.entity.Author;
import ua.com.alevel.entity.Book;
import ua.com.alevel.helpers.NavigationMenu;
import ua.com.alevel.service.AuthorService;
import ua.com.alevel.service.BookService;

import java.io.BufferedReader;
import java.io.IOException;

public class BookController {

    private final AuthorService authorService = new AuthorService();
    private final BookService bookService = new BookService();

    public void create(BufferedReader reader) {
        while (true) {
            try {
                NavigationMenu.clearScreen();
                System.out.print("Write name of the book:");
                String bookName = reader.readLine();
                if (StringUtils.isEmpty(bookName) || StringUtils.isBlank(bookName)) {
                    System.out.println("There are blank or empty name. Please try again.");
                    Thread.sleep(3000);
                    continue;
                }
                while (true) {
                    System.out.print("Write author name:");
                    String authorName = reader.readLine();
                    if (StringUtils.isEmpty(authorName) || StringUtils.isBlank(authorName)) {
                        System.out.println("There are blank or empty name. Please try again.");
                        Thread.sleep(3000);
                        continue;
                    }
                    Author author = new Author();
                    author.setName(authorName);
                    authorService.create(author);

                    Book newBook = new Book();
                    newBook.setName(bookName);
                    newBook.setAuthorId(new String[]{authorService.findAuthorIdByName(authorName)});
                    bookService.create(newBook);

                    System.out.print("If you want to add another author of " + bookName + " please write 1:");
                    String inputAnswer = reader.readLine();
                    if (StringUtils.isNumeric(inputAnswer) && Integer.parseInt(inputAnswer) == 1) {
                        continue;
                    } else {
                        break;
                    }
                }
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void update(BufferedReader reader) {
        Book newBook = new Book();
        while (true) {
            try {
                NavigationMenu.clearScreen();
                System.out.print("Write name of the book:");
                String bookName = reader.readLine();
                if (StringUtils.isEmpty(bookName) || StringUtils.isBlank(bookName)) {
                    System.out.println("There are blank or empty name. Please try again.");
                    Thread.sleep(3000);
                    continue;
                }
                newBook.setName(bookName);
                while (true) {
                    System.out.print("Write author name:");
                    String authorName = reader.readLine();
                    if (StringUtils.isEmpty(authorName) || StringUtils.isBlank(authorName)) {
                        System.out.println("There are blank or empty name. Please try again.");
                        Thread.sleep(3000);
                        continue;
                    }
                    // newBook.setAuthorName(authorName);
                    bookService.update(newBook);
                    System.out.print("If you want to add another author of " + bookName + " please write 1:");
                    String inputAnswer = reader.readLine();
                    if (StringUtils.isNumeric(inputAnswer) && Integer.parseInt(inputAnswer) == 1) {
                        continue;
                    } else {
                        break;
                    }
                }
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void delete(BufferedReader reader) {
        System.out.print("Write id of book to delete:");
        try {
            String name = reader.readLine();
            bookService.delete(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public void findById(BufferedReader reader) {
        while (true) {
            try {
                System.out.print("Write id of book:");
                String idBook = reader.readLine();
                Book book = bookService.findByIdOrNull(idBook);
                System.out.println(book != null ? book.toString() : "Sorry book not found");
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
