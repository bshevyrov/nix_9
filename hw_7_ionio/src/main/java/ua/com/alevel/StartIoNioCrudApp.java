package ua.com.alevel;


import com.google.gson.Gson;
import ua.com.alevel.entity.Author;

public class StartIoNioCrudApp {
    public static void main(String[] args) {
        Author author = new Author();
        author.setName("asd");
        author.setBooksId(new String[]{"1","2"});
        String rsl =        Convertor.objectToJson(author);
        System.out.println(rsl);
        Gson gson = new Gson();
        System.out.println(gson.toJson(author));
//        {"name":"asd","booksId":["1","2"],"visible":false}


    }
}
