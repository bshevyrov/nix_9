package ua.com.alevel;


import com.google.gson.Gson;
import ua.com.alevel.entity.Author;
import ua.com.alevel.entity.Book;
import ua.com.alevel.entity.TestE;

public class StartIoNioCrudApp {
    public static void main(String[] args) {
        Book book = new Book();
        book.setPages(123);
        book.setId(1234L);

        Author author = new Author();
        author.setName("asd");
        author.setBooksId(new String[]{"1","2"});

        Convertor.fromJsonToObject("{\"id\":null,\"visible\":false,\"name\":\"asd\",\"booksId\":[\"1\",\"2\"],\"nickName\":\"null\"}",
                Author.class);

//        gson.fromJson()
//        {"name":"asd","booksId":["1","2"],"visible":false}


    }
}
