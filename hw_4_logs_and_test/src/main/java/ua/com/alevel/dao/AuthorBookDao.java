package ua.com.alevel.dao;

import ua.com.alevel.db.AuthorBookDB;
import ua.com.alevel.entity.AuthorBook;

public class AuthorBookDao {

    public void create(AuthorBook authorBook) {
        AuthorBookDB.getInstance().create(authorBook);
    }

//    public void update(AuthorBook authorBook) {
//        AuthorBookDB.getInstance().update(authorBook);
//    }

//    public String[] findAuthorsIdByBookId(String bookId) {
//        return AuthorBookDB.getInstance().findAuthorsIdByBookId(bookId);
//    }
//
//    public String[] findBooksIdByAuthorId(String authorId) {
//        return AuthorBookDB.getInstance().findBooksIdByAuthorId(authorId);
//    }
}

