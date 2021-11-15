package ua.com.alevel.dao;

import ua.com.alevel.db.AuthorBookDB;
import ua.com.alevel.entity.Author;
import ua.com.alevel.entity.AuthorBook;

public class AuthorBookDao {
    public void create(AuthorBook authorBook) {
        AuthorBookDB.getInstance().create(authorBook);
    }

    public void update(AuthorBook authorBook) {
        AuthorBookDB.getInstance().update(authorBook);
    }

    public void findBooksByAuthorId(String authorId) {

    }

    public Author findAuthorsByBookId(String bookId) {
      AuthorBookDB.getInstance().findAuthorsByBookId(bookId);
        return
    }

}

