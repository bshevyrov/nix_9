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

public class AuthorController {

    private final BookService bookService = new BookService();
    private final AuthorService authorService = new AuthorService();


    public void create(BufferedReader reader) {
        while (true) {
            try {
                NavigationMenu.clearScreen();
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
                //Проверяем наличие книги в базе если ее нет то создаем
                String newBookId = bookService.findBookIdByName(bookName);
                if (StringUtils.equals(newBookId, "")) {
                    Book book = new Book();
                    book.setName(bookName);
                    bookService.create(book);
                }
                //если автор уже в базе до добавим ему книгу
                String findedId = authorService.findAuthorIdByName(authorName);
                if (!StringUtils.equals(findedId, "")) {
                    Author currentAuthor = authorService.findByIdOrNull(findedId);
                    currentAuthor.setId(findedId);
                    currentAuthor.setNickName(nickName);
                    //проверяем есть ли у автора эта книга и если нет о добавляем айди
                    String newAuthorsBookId = bookService.findBookIdByName(bookName);
                    boolean alreadyInArr = false;
                    for (String s : currentAuthor.getBooksId()) {
                        if (StringUtils.equals(newAuthorsBookId, s)) {
                            alreadyInArr = true;
                        }
                    }
                    if (!alreadyInArr) {
                        Book book = new Book();
                        book.setName(bookName);
                        bookService.create(book);
                        currentAuthor.setBooksId(ArrayUtils.add(currentAuthor.getBooksId(), newAuthorsBookId));
                    }
                    //
                    authorService.update(currentAuthor);
                } else {
                    Author author = new Author();
                    author.setName(authorName);
                    author.setNickName(nickName);
                    author.setBooksId(new String[]{bookService.findBookIdByName(bookName)});
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
                NavigationMenu.clearScreen();
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
                System.out.print("Write book name:");
                String bookName = reader.readLine();
                if (!isStringOk(bookName)) {
                    continue;
                }

                Author newAuthor = new Author();
                newAuthor.setName(authorName);
                newAuthor.setId(authorId);
                newAuthor.setNickName(nickName);
                //todo boks id realy need?
                newAuthor.setBooksId(new String[]{bookService.findBookIdByName(bookName)});
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
        Author[] authors = authorService.findAll();
        for (Author author : authors) {
            if (StringUtils.isNoneEmpty(author.getNickName())) {
                System.out.println(author.toString());
            }
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
                System.out.print("Write id:");
                String id = reader.readLine();
                if (!isStringOk(id)) {
                    continue;
                }
                Author author = authorService.findByIdOrNull(id);
                System.out.println(author != null ? author.toString() : "Sorry book not found");
                while (true) {
                    System.out.print("Write 0 to exit:");
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
