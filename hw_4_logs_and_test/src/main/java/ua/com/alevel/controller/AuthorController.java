package ua.com.alevel.controller;

import ua.com.alevel.entity.Author;
import ua.com.alevel.service.AuthorService;

import java.io.BufferedReader;
import java.io.IOException;

public class AuthorController {

    private final AuthorService authorService = new AuthorService();
    private final Author author = new Author();

    public void create(BufferedReader reader) {
        while (true) {
            try {
                System.out.print("Write author name:");
                String authorName = reader.readLine();
                System.out.print("Write book name:");
                String book = reader.readLine();
                author.setName(authorName);
           //     author.setBooksName(new String[]{book});
                authorService.create(author);
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        }
    }

    public void update(BufferedReader reader) {
        try {
            System.out.print("Write author name:");
            String authorName = reader.readLine();
            System.out.print("Write book name:");
            String book = reader.readLine();
            author.setName(authorName);
          //  author.setBooksName(new String[]{book});
            authorService.update(author);
        } catch (IOException e) {
            e.printStackTrace();
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
                System.out.println(author!=null?author.toString():"Sorry book not found");
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
