package ua.com.alevel.controller;

import org.apache.commons.lang3.ArrayUtils;
import ua.com.alevel.entity.Author;
import ua.com.alevel.helpers.NavigationMenu;
import ua.com.alevel.service.AuthorService;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class AuthorController {

    private final AuthorService authorService = new AuthorService();
    private final Author author = new Author();

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


    public void findByName(BufferedReader reader) {
        while (true) {
            try {
                System.out.print("Write email:");
                String name = reader.readLine();
                Author author = authorService.findByName(name);
                System.out.println(author.toString());
                while (true) {
                    System.out.println("Write 0 to :");
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

    public void update(BufferedReader reader) {
        while (true) {
            try {
                System.out.print("Write name:");
                String authorName = reader.readLine();
                System.out.print("Write email:");
                String authorEmail = reader.readLine();
                //TODO ATENCION
                String[] authorBooks = new String[1];
                while (true) {
                    NavigationMenu.clearScreen();
                    System.out.print("Write book name:");
                    String book = reader.readLine();
                    ArrayUtils.add(authorBooks, book);
                    NavigationMenu.clearScreen();
                    System.out.println("Do you want add one more book ?");
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    //todo проверка на число
                    int addMoreBook = Integer.parseInt(reader.readLine());
                    if (addMoreBook == 2) {
                        break;
                    }
                }
                author.setName(authorName);
              //  author.setEmail(authorEmail);
                author.setBooksName(authorBooks);
                authorService.update(author);
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        }
    }

    public void create(BufferedReader reader) {
        while (true) {
            try {
                System.out.print("Write name:");
                String authorName = reader.readLine();
                System.out.print("Write email:");
                String authorEmail = reader.readLine();
                String[] authorBooks = new String[0];
                while (true) {
                    System.out.print("Write book name:");
                    String book = reader.readLine();
                    authorBooks = Arrays.copyOf(authorBooks, authorBooks.length + 1);
                    authorBooks[authorBooks.length - 1] = book;
                    NavigationMenu.clearScreen();
                    System.out.println("Do you want add one more book ?");
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    System.out.println("Please make you chose: ");
                    //todo проверка на число
                    int addMoreBook = Integer.parseInt(reader.readLine());
                    if (addMoreBook == 2) {
                        break;
                    }
                }
                author.setName(authorName);
            //    author.setEmail(authorEmail);
                author.setBooksName(authorBooks);
                authorService.create(author);
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        }
    }
}
