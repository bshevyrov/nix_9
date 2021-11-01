package ua.com.alevel.entity;

public class Book {
    String authorName;
    String publisherName;
    String name;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
                this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                " author=" + authorName +
                ", publisher=" + publisherName +
                ", name='" + name + '\'' +
                '}';
    }
}
