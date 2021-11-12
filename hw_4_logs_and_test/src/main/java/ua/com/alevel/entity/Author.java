package ua.com.alevel.entity;

import java.util.Arrays;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return age == author.age && Objects.equals(name, author.name) && Arrays.equals(booksName, author.booksName);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, age);
        result = 31 * result + Arrays.hashCode(booksName);
        return result;
    }
}

