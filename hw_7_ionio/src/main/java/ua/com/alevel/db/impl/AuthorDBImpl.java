package ua.com.alevel.db.impl;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import ua.com.alevel.Convertor;
import ua.com.alevel.db.AuthorDB;
import ua.com.alevel.entity.Author;
import ua.com.alevel.utils.FileHandler;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class AuthorDBImpl implements AuthorDB {

    public static final Convertor convertor = new Convertor();
    private static final File authorDBFile = new File("src/main/resources/authorDB.txt");
    private static AuthorDBImpl Instance;

    public static AuthorDBImpl getInstance() {
        if (Instance == null) {
            return new AuthorDBImpl();
        } else {
            return Instance;
        }
    }

    private AuthorDBImpl() {
        if (!authorDBFile.exists()) {
            try {
                FileUtils.touch(authorDBFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void create(Author author) {
        LinkedList<Author> authorLinkedList = new LinkedList<>();
        if (authorDBFile.exists()&&authorDBFile.length()>0) {
            authorLinkedList = (LinkedList<Author>) findAll();
        } else {
            authorLinkedList = new LinkedList<>();
        }
        author.setId(generateId());
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
    public void delete(String id) {
        LinkedList<Author> list = convertor.fromJsonToObjects(FileHandler.readStringsFromFile(authorDBFile), new Author());
        for (int i = 0; i < list.size(); i++) {
            if (StringUtils.equals(list.get(i).getId(),id)) {
                list.remove(i);
                break;
            }
        }
        String json = convertor.objectsToJson(list);


        try {
            FileUtils.deleteQuietly(authorDBFile);

            FileUtils.writeLines(authorDBFile, Collections.singleton(json));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Author findById(String id) {
        Author author= null;

try {
    author = findAll().stream().filter(author1 -> id.equals(author1.getId())).findFirst().get();
} catch (NoSuchElementException | NullPointerException e ){
    return null;
}

        return author;
    }

    @Override
    public List<Author> findAll() {
        if(FileUtils.sizeOf(authorDBFile)==0){
            return null;
        }
        return convertor.fromJsonToObjects(FileHandler.readStringsFromFile(authorDBFile), new Author());
    }
    private String generateId() {
        String id = UUID.randomUUID().toString();
        if (!(findById(id) == null)) {
            generateId();
        }
        return id;
    }
}
