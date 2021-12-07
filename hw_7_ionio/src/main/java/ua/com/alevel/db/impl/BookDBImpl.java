package ua.com.alevel.db.impl;

import org.apache.commons.io.FileUtils;
import ua.com.alevel.Convertor;
import ua.com.alevel.db.BaseDB;
import ua.com.alevel.entity.Book;
import ua.com.alevel.utils.FileHandler;


import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BookDBImpl implements BaseDB<Book> {

    public static final Convertor convertor = new Convertor();
    private static final File bookDBFile = new File("src/main/resources/bookDB.txt");
    private static BookDBImpl Instance;

    public static BookDBImpl getInstance() {
        if (Instance == null) {
            return new BookDBImpl();

        }else{
            return Instance;
        }
    }

    private BookDBImpl() {
    }

    @Override
    public void create(Book book) {
        LinkedList<Book> bookLinkedList;
        if (bookDBFile.exists()) {
            bookLinkedList = (LinkedList<Book>) findAll();
        } else {
            bookLinkedList = new LinkedList<>();
        }
        bookLinkedList.add(book);
        String json = convertor.objectsToJson(bookLinkedList);
        try {
            FileUtils.writeLines(bookDBFile, Collections.singleton(json));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Book book) {
        LinkedList<Book> list = convertor.fromJsonToObjects(FileHandler.readStringsFromFile(bookDBFile), new Book());
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == book.getId()) {
                list.add(i, book);
                break;
            }
        }
        String json = convertor.objectsToJson(list);
        try {
            FileUtils.writeLines(bookDBFile, Collections.singleton(json));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        LinkedList<Book> list = convertor.fromJsonToObjects(FileHandler.readStringsFromFile(bookDBFile), new Book());
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                list.remove(i);
                break;
            }
        }
        String json = convertor.objectsToJson(list);
        try {
            FileUtils.deleteQuietly(bookDBFile);
            FileUtils.writeLines(bookDBFile, Collections.singleton(json));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Book findById(Long id) {
        return findAll().stream().filter(book -> id.equals(book.getId())).findAny().get();
    }

    @Override
    public List<Book> findAll() {
        return convertor.fromJsonToObjects(FileHandler.readStringsFromFile(bookDBFile), new Book());
    }
}
