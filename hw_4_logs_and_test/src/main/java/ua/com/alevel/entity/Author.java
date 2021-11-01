package ua.com.alevel.entity;

import java.util.Arrays;

public class Author {
    String name;
  //  String email;
    String[] booksName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }

    public String[] getBooksName() {
        return booksName;
    }

    public void setBooksName(String[] booksName) {
        this.booksName = booksName;

    }

//    public String arrayBooksToString(){
//        StringBuilder builder = new StringBuilder();
//        for (Book book : books) {
//            builder.append(book.toString());
//        }
//        return builder.toString();


    //  }
    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
               // ", email='" + email + '\'' +
                ", books=" + Arrays.toString(booksName) +
                '}';
    }
}
