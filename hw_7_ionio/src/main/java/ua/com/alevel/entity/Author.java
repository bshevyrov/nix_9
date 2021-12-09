package ua.com.alevel.entity;

import java.util.Arrays;

public class Author extends BaseEntity {

    private String name;
    private String nickName;
    private String[] booksId;

    public Author() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getBooksId() {
        return booksId;
    }

    public void setBooksId(String[] booksId) {
        this.booksId = booksId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", booksId=" + Arrays.toString(booksId) +
//                ", visible=" + visible +
                '}';
    }
}
