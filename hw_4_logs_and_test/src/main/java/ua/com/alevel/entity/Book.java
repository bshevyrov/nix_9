package ua.com.alevel.entity;

import org.apache.commons.lang3.ArrayUtils;
import ua.com.alevel.service.AuthorService;

import java.util.Arrays;

public class Book {

    private String id;
    private String name;
    private String[] authorsId = new String[0];

    AuthorService authorService = new AuthorService();

    public String[] getAuthorId() {
        return authorsId;
    }

    public void setAuthorId(String[] authorsId) {
        this.authorsId = authorsId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String[] getAuthorsOfTheBookById(){
        String[] rsl = new String[0];
        for (String s : authorsId) {
            rsl = ArrayUtils.add(rsl, authorService.findByIdOrNull(s).getName());
        }
        return rsl;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name +
                ", author='" + Arrays.toString(getAuthorsOfTheBookById()) +
                '}';
    }
//    public void findAllAuthor(String id){
//        AuthorBookDao authorBookDao = new AuthorBookDao();
//         Author[] authors = authorBookDao.findAuthorsByBookId(id);
//    }
//    @Override
//    public int hashCode() {
//        return Objects.hash(authorName, name, id);
//    }
}
