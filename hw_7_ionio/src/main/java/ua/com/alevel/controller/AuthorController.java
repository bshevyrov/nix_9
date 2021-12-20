package ua.com.alevel.controller;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import ua.com.alevel.entity.Author;
import ua.com.alevel.entity.Book;
import ua.com.alevel.service.AuthorService;
import ua.com.alevel.service.BookService;
import ua.com.alevel.service.impl.AuthorServiceImpl;
import ua.com.alevel.service.impl.BookServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class AuthorController {

    private final BookService bookService = new BookServiceImpl();
    private final AuthorService authorService = new AuthorServiceImpl();

    public void create(BufferedReader reader) {
        while (true) {
            try {
                System.out.print("Write author name:");
                String authorName = reader.readLine();
                if (!isStringOk(authorName)) {
                    continue;
                }
                System.out.print("Write author nickname:");
                String nickName = reader.readLine();
                if (!isStringOk(nickName)) {
                    continue;
                }
                System.out.print("Write book name:");
                String bookName = reader.readLine();
                if (!isStringOk(bookName)) {
                    continue;
                }
                String newBookId = bookService.findIdByName(bookName);
                if (StringUtils.equals(newBookId, "")) {
                    Book book = new Book();
                    book.setName(bookName);
                    bookService.create(book);
                }
                String findedId = authorService.findIdByName(authorName);
                if (!StringUtils.equals(findedId, "")) {
                    Author currentAuthor = authorService.findById(findedId);
                    currentAuthor.setId(findedId);
                    currentAuthor.setNickName(nickName);
                    String newAuthorsBookId = bookService.findIdByName(bookName);
                    boolean alreadyInArr = false;
                    for (String s : currentAuthor.getBooksId()) {
                        if (StringUtils.equals(newAuthorsBookId, s)) {
                            alreadyInArr = true;
                        }
                    }
                    if (!alreadyInArr) {
                        currentAuthor.setBooksId(ArrayUtils.add(currentAuthor.getBooksId(), newAuthorsBookId));
                    }
                    authorService.update(currentAuthor);
                } else {
                    Author author = new Author();
                    author.setName(authorName);
                    author.setNickName(nickName);
                    author.setBooksId(new String[]{bookService.findIdByName(bookName)});
                    authorService.create(author);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            break;
        }
    }

    public void update(BufferedReader reader) {
        while (true) {
            try {
                System.out.print("Write author id:");
                String authorId = reader.readLine();
                if (!isStringOk(authorId)) {
                    continue;
                }
                System.out.print("Write author name:");
                String authorName = reader.readLine();
                if (!isStringOk(authorName)) {
                    continue;
                }
                System.out.print("Write author nickname:");
                String nickName = reader.readLine();
                if (!isStringOk(nickName)) {
                    continue;
                }

                Author newAuthor = new Author();
                newAuthor.setName(authorName);
                newAuthor.setId(authorId);
                newAuthor.setNickName(nickName);
                newAuthor.setBooksId(authorService.findById(authorId).getBooksId());
                authorService.update(newAuthor);
            } catch (Exception e) {
                e.printStackTrace();
            }
            break;
        }
    }

    public void delete(BufferedReader reader) {
        while (true) {
            System.out.print("Write name:");
            try {
                String name = reader.readLine();
                if (!isStringOk(name)) {
                    continue;
                }
                authorService.delete(name);
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void findAll(BufferedReader reader) {
        List<Author> authors = authorService.findAll();
        for (Author author : authors) {
            if (StringUtils.isNoneEmpty(author.getNickName())) {
                System.out.println(author);
            }
        }
        while (true) {
            try {
                System.out.println("SAVE ID!!!!");
                System.out.println("SCREEN WILL BE CLEANED");
                System.out.print("Type 0 to clear and continue: ");
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
                System.out.print("Write id:");
                String id = reader.readLine();
                if (!isStringOk(id)) {
                    continue;
                }
                Author author = authorService.findById(id);
                System.out.println(author != null ? author.toString() : "Sorry book not found");
                while (true) {
                    System.out.print("Write 0 to exit:");
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
