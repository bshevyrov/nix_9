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
                if (StringUtils.isEmpty(authorName) || StringUtils.isBlank(authorName)) {
                    System.out.println("There are blank or empty name. Please try again.");
                    Thread.sleep(3000);
                    continue;
                }
                System.out.print("Write book name:");
                String bookName = reader.readLine();
                if (StringUtils.isEmpty(bookName) || StringUtils.isBlank(bookName)) {
                    System.out.println("There are blank or empty name. Please try again.");
                    Thread.sleep(3000);
                    continue;
                }
                Book book = new Book();
                book.setName(bookName);
                bookService.create(book);

                Author newAuthor = new Author();
                newAuthor.setName(authorName);
                newAuthor.setBooksId(new String[]{bookService.findBookIdByName(bookName)});
                authorService.create(newAuthor);

                Book newBook = bookService.findByIdOrNull(bookService.findBookIdByName(bookName));
                String[] auId = new String[]{authorService.findAuthorIdByName(authorName)};
                boolean inArr = false;
                for (int i = 0; i < auId.length; i++) {
                    if (StringUtils.equals(authorService.findAuthorIdByName(authorName), auId[i])) {
                    inArr=true;
//                    auId = ArrayUtils.add(auId, authorService.findAuthorIdByName(authorName));
                    }
                }
                if (!inArr) {
                    auId = ArrayUtils.add(auId, authorService.findAuthorIdByName(authorName));
                }
                newBook.setAuthorsId(auId);


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
                if (StringUtils.isEmpty(authorId) || StringUtils.isBlank(authorId)) {
                    System.out.println("There are blank or empty name. Please try again.");
                    Thread.sleep(3000);
                    continue;
                }
                System.out.print("Write author name:");
                String authorName = reader.readLine();
                if (StringUtils.isEmpty(authorName) || StringUtils.isBlank(authorName)) {
                    System.out.println("There are blank or empty name. Please try again.");
                    Thread.sleep(3000);
                    continue;
                }
                System.out.print("Write book name:");
                String bookName = reader.readLine();
                if (StringUtils.isEmpty(bookName) || StringUtils.isBlank(bookName)) {
                    System.out.println("There are blank or empty name. Please try again.");
                    Thread.sleep(3000);
                    continue;
                }

                Author newAuthor = new Author();
                newAuthor.setName(authorName);
                newAuthor.setId(authorId);
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
            System.out.println(author.toString());
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
}
