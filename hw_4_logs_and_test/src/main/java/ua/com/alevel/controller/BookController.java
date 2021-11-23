package ua.com.alevel.controller;

import org.apache.commons.lang3.ArrayUtils;
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
        String[] authorsOfThisBook = new String[0];
        while (true) {
            try {
                NavigationMenu.clearScreen();
                System.out.print("Write name of the book:");
                String bookName = reader.readLine();
                if (!isStringOk(bookName)) {
                    continue;
                }
                System.out.print("Write count of pages:");
                String pages = reader.readLine();
                if (!StringUtils.isNumeric(pages)) {
                    System.out.println("There are no numbers. Please try again.");
                    Thread.sleep(3000);
                    continue;
                }
                int bookPages = Integer.parseInt(pages);
                while (true) {
                    System.out.print("Write author name:");
                    String authorName = reader.readLine();
                    if (!isStringOk(authorName)) {
                        continue;
                    }
                    authorsOfThisBook = ArrayUtils.add(authorsOfThisBook, authorName);
                    System.out.print("If you want to add another author of " + bookName + " please write 1:");
                    String inputAnswer = reader.readLine();
                    if (StringUtils.isNumeric(inputAnswer) && Integer.parseInt(inputAnswer) == 1) {
                        continue;
                    } else {
                        break;
                    }
                }
                for (String s : authorsOfThisBook) {
                    Author author = new Author();
                    author.setName(s);
                    authorService.create(author);
                }
                Book newBook = new Book();
                newBook.setName(bookName);
                newBook.setPages(bookPages);
                String[] authorsId = new String[0];
                for (String s : authorsOfThisBook) {
                    authorsId = ArrayUtils.add(authorsId, authorService.findAuthorIdByName(s));
                }
                newBook.setAuthorsId(authorsId);
                bookService.create(newBook);
                for (int i = 0; i < authorsOfThisBook.length; i++) {
                    Author author = authorService.findByIdOrNull(authorService.findAuthorIdByName(authorsOfThisBook[i]));
                    String[] booksId = author.getBooksId();
                    boolean inArr = false;
                    for (int j = 0; j < booksId.length; j++) {
                        if (StringUtils.equals(booksId[j], bookService.findBookIdByName(bookName))) {
                            inArr = true;
                        }
                    }
                    if (!inArr) {
                        booksId = ArrayUtils.add(booksId, bookService.findBookIdByName(bookName));
                    }
                    author.setBooksId(booksId);
                }
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void update(BufferedReader reader) {
        String[] authorsOfThisBook = new String[0];

        while (true) {
            try {
                NavigationMenu.clearScreen();
                System.out.print("Write Id of the book:");
                String bookId = reader.readLine();
                if (!isStringOk(bookId)) {
                    continue;
                }
                System.out.print("Write count of pages:");
                String pages = reader.readLine();
                if (!StringUtils.isNumeric(pages)) {
                    System.out.println("There are no numbers. Please try again.");
                    Thread.sleep(3000);
                    continue;
                }
                int bookPages = Integer.parseInt(pages);
                System.out.print("Write name of the book:");
                String bookName = reader.readLine();
                if (!isStringOk(bookName)) {
                    continue;
                }
//                while (true) {
//                    System.out.print("Write author name:");
//                    String authorName = reader.readLine();
//                    if (!isStringOk(id)) {
//                        continue;
//                    }
//                    System.out.print("If you want to add another author of " + bookName + " please write 1:");
//                    String inputAnswer = reader.readLine();
//                    if (StringUtils.isNumeric(inputAnswer) && Integer.parseInt(inputAnswer) == 1) {
//                        continue;
//                    } else {
//                        break;
//                    }
//                }
                //todo set authors id?
                Book newBook = new Book();
                newBook.setId(bookId);
                newBook.setName(bookName);
                newBook.setPages(bookPages);
                bookService.update(newBook);
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void delete(BufferedReader reader) {
        while (true) {
            System.out.print("Write id of book to delete:");
            try {
                String name = reader.readLine();
                if (!isStringOk(name)) {
                    continue;
                }
                bookService.delete(name);
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void findAll(BufferedReader reader) {
        Book[] books = bookService.findAll();
        for (Book book : books) {
            if (book.getPages() == 0) {
                continue;
            }
            System.out.println(book);
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
                if (!isStringOk(idBook)) {
                    continue;
                }
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

    private boolean isStringOk(String s) {
        boolean rsl = true;
        if (StringUtils.isEmpty(s) || StringUtils.isBlank(s)) {
            System.out.println("There are blank or empty name. Please try again.");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            rsl = false;
        }
        return rsl;
    }
}
