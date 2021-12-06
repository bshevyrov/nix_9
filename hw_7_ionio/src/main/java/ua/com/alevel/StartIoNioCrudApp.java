package ua.com.alevel;


import com.google.gson.Gson;
import ua.com.alevel.entity.Author;
import ua.com.alevel.entity.Book;
import ua.com.alevel.entity.TestE;
import ua.com.alevel.exceptions.JsonException;

import java.util.ArrayList;
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
        System.out.println("!!!");
        System.out.println(ggsn);
        System.out.println("!!!");
        try {
//            Convertor.fromJsonToObject("{\"id\":null,\"visible\":false,\"name\":\"asd\",\"booksId\":[\"1\",\"2\"],\"nickName\":\"null\"}",
//                    Author.class);
            Convertor.fromJsonToObject("[{\"booksId\":[\"1\",\"2\"],\"name\":\"asd\",\"visible\":false,\"name\":\"222\"},{\"booksId\":[\"3\",\"4\"],\"name\":\"222\",\"visible\":false,\"name\":\"222\"},{\"booksId\":[\"3\",\"4\"],\"name\":\"222\",\"visible\":false,\"name\":\"222\"}]",
                    Author.class);
        } catch (JsonException e) {
            e.printStackTrace();
        }

//        gson.fromJson()
//        {"name":"asd","booksId":["1","2"],"visible":false}


    }
}
