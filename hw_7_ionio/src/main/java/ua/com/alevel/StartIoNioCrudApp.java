package ua.com.alevel;


import com.google.gson.Gson;
import ua.com.alevel.entity.Author;
import ua.com.alevel.entity.BaseEntity;
import ua.com.alevel.entity.Book;
import ua.com.alevel.exceptions.JsonException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StartIoNioCrudApp {
    public static void main(String[] args) {
        Book book = new Book();
        book.setPages(123);
        book.setId(1234L);

        Author author = new Author();
        author.setBooksId(new String[]{"1","2"});
        author.setName("asd");
        Author author1 = new Author();
        author1.setBooksId(new String[]{"3","4"});
        author1.setName("222");
        ArrayList<Author> aL = new ArrayList<>();
        aL.add(author);
        aL.add(author1);
         Gson gson = new Gson();
        String ggsn= gson.toJson(aL);
//        System.out.println("!!!");
//        System.out.println(ggsn);
//        System.out.println("!!!");
        LinkedList<Author> arrA = new LinkedList<>();
        Convertor convertor = new Convertor();
        System.out.println("[{\"booksId\":[\"1\",\"2\"],\"name\":\"111\",\"visible\":false,\"id\":\"1\"},{\"booksId\":[\"3\",\"4\"],\"name\":\"222\",\"visible\":false,\"id\":\"2\"},{\"booksId\":[\"5\",\"6\"],\"name\":\"333\",\"visible\":false,\"id\":\"3\"}]");
        try {
            arrA= convertor.fromJsonToObject("[{\"booksId\":[\"1\",\"2\"],\"name\":\"111\",\"visible\":false,\"id\":\"1\"},{\"booksId\":[\"3\",\"4\"],\"name\":\"222\",\"visible\":false,\"id\":\"2\"},{\"booksId\":[\"5\",\"6\"],\"name\":\"333\",\"visible\":false,\"id\":\"3\"}]",
                    new Author());
        } catch (JsonException e) {
            e.printStackTrace();
        }




        System.out.println(arrA.size());
        for (Author author2 : arrA) {
            System.out.println(author2.toString());
        }


//        gson.fromJson()
//        {"name":"asd","booksId":["1","2"],"visible":false}


    }
}
