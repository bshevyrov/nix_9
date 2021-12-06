package ua.com.alevel;


import com.google.gson.Gson;
import ua.com.alevel.entity.Author;
import ua.com.alevel.entity.Book;
import ua.com.alevel.entity.TestE;
import ua.com.alevel.exceptions.JsonException;

public class StartIoNioCrudApp {
    public static void main(String[] args) {
        Book book = new Book();
        book.setPages(123);
        book.setId(1234L);

        Author author = new Author();
        author.setBooksId(new String[]{"1","2"});
        author.setName("asd");

        try {
//            Convertor.fromJsonToObject("{\"id\":null,\"visible\":false,\"name\":\"asd\",\"booksId\":[\"1\",\"2\"],\"nickName\":\"null\"}",
//                    Author.class);
            Convertor.fromJsonToObject("{\"visible\":false,\"booksId\":[\"1\",\"2\"],\"id\":null,\"name\":\"asd\",\"nickName\":\"null\"}",
                    Author.class);
        } catch (JsonException e) {
            e.printStackTrace();
        }

//        gson.fromJson()
//        {"name":"asd","booksId":["1","2"],"visible":false}


    }
}
