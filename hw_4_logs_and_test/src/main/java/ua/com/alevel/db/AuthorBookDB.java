package ua.com.alevel.db;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import ua.com.alevel.entity.AuthorBook;

public class AuthorBookDB {

    private static AuthorBookDB instance;
    private AuthorBook[] authorBooks;

    private AuthorBookDB() {
        authorBooks = new AuthorBook[0];
    }

    public static AuthorBookDB getInstance() {
        if (instance == null) {
            instance = new AuthorBookDB();
        }
        return instance;
    }

    public void create(AuthorBook authorBook) {
        authorBooks = ArrayUtils.add(authorBooks, authorBook);
    }

//    public void update(AuthorBook authorBook) {
////        if (authorBook.getBookIds()!=null){
////            AuthorBook current = ArrayUtils.get(authorBooks, findIndexById(authorBook.()));
////            current.setName(author.getName());
////            current.setBooksName(author.getBooksName());
////        }
////        if (authorBook.getAuthorIds()!=null){
////
////        }
////
////        AuthorBook current = ArrayUtils.get(authorBooks, findIndexById(author.getId()));
////        current.setName(author.getName());
////        current.setBooksName(author.getBooksName());
//    }

    public String[] findBooksIdByAuthorId(String authorId) {
        String[] rsl = new String[0];
        for (AuthorBook authorBook : authorBooks) {
            String[] bookAuthorIds = authorBook.getAuthorIds();
            for (String bookAuthorId : bookAuthorIds) {
                if (StringUtils.equals(bookAuthorId, authorId)) {
                    rsl = authorBook.getBookIds();
                }
            }
        }
        return rsl;
    }

    public String[] findAuthorsIdByBookId(String bookId) {
        String[] rsl = new String[0];
        for (AuthorBook authorBook : authorBooks) {
            String[] authorBookIds = authorBook.getBookIds();
            for (String authorBookId : authorBookIds) {
                if (StringUtils.equals(authorBookId, bookId)) {
                    rsl = ArrayUtils.add(rsl, authorBookId);
                }
            }
        }
        return rsl;
    }
//    public void delete(String id) {
//        authors = ArrayUtils.remove(authors, findIndexById(id));
//    }
//
//    private int findIndexById(String id) {
//        return ArrayUtils.indexOf(authors, findByIdOrNull(id));
//    }
//
//    public Author findByIdOrNull(String id) {
//        for (Author author : authors) {
//            if (StringUtils.equals(id, author.getId())) {
//                return author;
//            }
//        }
//        return null;
//    }
//
//    public Author[] findAll() {
//        return authors;
}



