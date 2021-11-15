package ua.com.alevel.entity;

import java.util.Arrays;
import java.util.Objects;

public class Author {

    private String id;
    private String name;
    private String booksId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public String[] getBooksName() {
//        return booksName;
//    }

//    public void setBooksName(String[] booksName) {
//        this.booksName = booksName;
//    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
//                ", booksName=" + Arrays.toString(booksName) +
                '}';
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Author author = (Author) o;
//        return id == author.id && Objects.equals(name, author.name) && Arrays.equals(booksName, author.booksName);
//    }
//
//    @Override
//    public int hashCode() {
//        int result = Objects.hash(name, id);
//        result = 31 * result + Arrays.hashCode(booksName);
//        return result;
//    }
}

