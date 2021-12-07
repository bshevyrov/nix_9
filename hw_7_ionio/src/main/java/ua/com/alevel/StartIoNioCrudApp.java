package ua.com.alevel;


import ua.com.alevel.entity.Book;

import java.util.LinkedList;

public class StartIoNioCrudApp {
    public static void main(String[] args) {
       /* Book book = new Book();
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
            arrA= convertor.fromJsonToObjects("[{\"booksId\":[\"1\",\"2\"],\"name\":\"111\",\"visible\":false,\"id\":\"1\"},{\"booksId\":[\"3\",\"4\"],\"name\":\"222\",\"visible\":false,\"id\":\"2\"},{\"booksId\":[\"5\",\"6\"],\"name\":\"333\",\"visible\":false,\"id\":\"3\"}]",
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

*/
        LinkedList<Book> books = new LinkedList<>();
        Book book = new Book();
        book.setId(1l);
        book.setName("b1");
        book.setPages(1);
        book.setAuthorsId(new String[]{"3", "2"});
        books.add(book);
        Book book1 = new Book();
        book1.setId(2l);
        book1.setName("b2");
        book1.setAuthorsId(new String[]{"3", "2"});
        books.add(book1);
        Convertor convertor = new Convertor();
        String json = convertor.objectsToJson(books);
       LinkedList<Book> bookLinkedList = new LinkedList<>();
       bookLinkedList = convertor.fromJsonToObjects(json, new Book());

        System.out.println(bookLinkedList.size());
        for (Book book2 : bookLinkedList) {
            System.out.println(   book2.toString());
        }

    }
}
