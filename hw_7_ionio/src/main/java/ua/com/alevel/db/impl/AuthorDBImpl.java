package ua.com.alevel.db.impl;

import org.apache.commons.io.FileUtils;
import ua.com.alevel.Convertor;
import ua.com.alevel.db.AuthorDB;
import ua.com.alevel.entity.Author;
import ua.com.alevel.utils.FileHandler;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class AuthorDBImpl implements AuthorDB {

    public static final Convertor convertor = new Convertor();
    private static final File authorDBFile = new File("src/main/resources/authorDB.txt");
    private static  AuthorDBImpl Instance;

    public static AuthorDBImpl getInstance() {

        if (Instance == null) {
            return new AuthorDBImpl();
        } else {
            return Instance;
        }
    }

    private AuthorDBImpl() {
    }

    @Override
    public void create(Author author) {
//        LinkedList<Author> authorLinkedList = (LinkedList<Author>) findAll();
        LinkedList<Author> authorLinkedList = new LinkedList<>();
        authorLinkedList.add(author);
        String json = convertor.objectsToJson(authorLinkedList);
        try {
            FileUtils.writeLines(authorDBFile, Collections.singleton(json));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Author author) {
        LinkedList<Author> list = convertor.fromJsonToObjects(FileHandler.readStringsFromFile(authorDBFile), new Author());
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == author.getId()) {
                list.add(i, author);
                break;
            }
        }
        String json = convertor.objectsToJson(list);
        try {
            FileUtils.writeLines(authorDBFile, Collections.singleton(json));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Author author) {
        LinkedList<Author> list = convertor.fromJsonToObjects(FileHandler.readStringsFromFile(authorDBFile), new Author());
        list.remove(author);
        String json = convertor.objectsToJson(list);
        try {
            FileUtils.writeLines(authorDBFile, Collections.singleton(json));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Author findById(Long id) {
        return findAll().stream().filter(author -> id.equals(author.getId())).findAny().get();
    }

    @Override
    public List<Author> findAll() {
        return convertor.fromJsonToObjects(FileHandler.readStringsFromFile(authorDBFile), new Author());
    }
}
