package ua.com.alevel.controller;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import ua.com.alevel.entity.Author;
import ua.com.alevel.entity.Book;
import ua.com.alevel.service.AuthorService;
import ua.com.alevel.service.BookService;
import ua.com.alevel.service.impl.AuthorServiceImpl;
import ua.com.alevel.service.impl.BookServiceImpl;
import ua.com.alevel.utils.NavigationMenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class BookController {

    private final AuthorService authorService = new AuthorServiceImpl();
    private final BookService bookService = new BookServiceImpl();

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
                    String curAuthId = authorService.findIdByName(s);
                    if (StringUtils.equals(curAuthId, "")) {
                        Author author = new Author();
                        author.setName(s);
                        authorService.create(author);
                    }
                }
                String[] curAuthsId = new String[0];
                for (String s : authorsOfThisBook) {
                    curAuthsId = ArrayUtils.add(curAuthsId, authorService.findIdByName(s));
                }
                if (StringUtils.equals(bookService.findIdByName(bookName), "")) {
                    Book newBook = new Book();
                    newBook.setName(bookName);
                    newBook.setPages(bookPages);
                    newBook.setAuthorsId(curAuthsId);
                    bookService.create(newBook);
                } else {
                    Book currrentBook = bookService.findById(bookService.findIdByName(bookName));
                    currrentBook.setName(bookName);
                    currrentBook.setPages(bookPages);
                    String[] authIds = new String[0];
                    if (currrentBook.getAuthorsId() == null) {
                        List<Author> authors = authorService.findAll();
                        for (Author author : authors) {
                            String[] authorBooksId = author.getBooksId();
                            for (String s : authorBooksId) {
                                if (s.equals(bookService.findIdByName(bookName))) {
                                    authIds = ArrayUtils.add(authIds, author.getId());
                                }
                            }
                        }
                    }
                    if (currrentBook.getAuthorsId() != null) {
                        authIds = currrentBook.getAuthorsId();
                    }
                    String[] newAuthorsId = authIds;
                    for (String authId : authIds) {
                        boolean alreadyInArr = false;
                        String tmp = "";
                        for (String s1 : authorsOfThisBook) {
                            if (StringUtils.equals(authId, authorService.findIdByName(s1))) {
                                alreadyInArr = true;
                                tmp = s1;
                            }
                        }
                        if (!alreadyInArr) {
                            newAuthorsId = ArrayUtils.add(newAuthorsId, authorService.findIdByName(tmp));
                        }
                    }
                    currrentBook.setAuthorsId(newAuthorsId);
                    bookService.update(currrentBook);
                }
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void update(BufferedReader reader) {
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
                Book newBook = new Book();
                newBook.setId(bookId);
                newBook.setName(bookName);
                newBook.setPages(bookPages);
                newBook.setAuthorsId(bookService.findById(bookId).getAuthorsId());
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
        List<Book> books = bookService.findAll();
        for (Book book : books) {
            if (book.getPages() == 0) {
                continue;
            }
            System.out.println(book);
        }
        while (true) {
            System.out.println("SAVE ID!!!!");
            System.out.println("SCREEN WILL BE CLEANED");
            System.out.print("Type 0 to clear and continue: ");
            try {
                String input = reader.readLine();
                if (!StringUtils.isNumeric(input)) {
                    System.out.println("You write not number. Please try again");
                    continue;
                }
                int rsl = Integer.parseInt(input);
                if (rsl == 0) {
                    break;
                } else {
                    continue;
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
                Book book = bookService.findById(idBook);
                System.out.println(book != null ? book.toString() : "Sorry book not found");
                while (true) {
                    System.out.println("Write 0 to continue:");
                    String input = reader.readLine();
                    if (!StringUtils.isNumeric(input)) {
                        System.out.println("You write not number. Please try again");
                        continue;
                    }
                    int rsl = Integer.parseInt(input);
                    if (rsl == 0) {
                        break;
                    } else {
                        continue;
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
