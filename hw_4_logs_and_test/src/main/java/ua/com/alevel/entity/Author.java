package ua.com.alevel.entity;

import java.util.Arrays;

public class Author {

    String name;
    int age;
    String[] booksName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getBooksName() {
        return booksName;
    }

    public void setBooksName(String[] booksName) {
        this.booksName = booksName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", booksName=" + Arrays.toString(booksName) +
                '}';
    }
}

