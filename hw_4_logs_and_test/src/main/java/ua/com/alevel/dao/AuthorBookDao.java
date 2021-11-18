package ua.com.alevel.dao;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import ua.com.alevel.db.AuthorBookDB;
import ua.com.alevel.entity.Author;
import ua.com.alevel.entity.AuthorBook;
import ua.com.alevel.entity.Book;

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

    public void sync() {
        BookDao bookDao = new BookDao();
        AuthorDao authorDao = new AuthorDao();
        Book[] books = bookDao.findAll();
        Author[] authors = authorDao.findAll();

        //Сравниваем В КНИГАХ айди авторов с айди АВТОРОВ
        for (int i = 0; i < books.length; i++) {
            for (int j = 0; j < authors.length; j++) {
                //Берем у автора Список айди Книг
                String[] authorBooksId = authors[j].getBooksId();
                //Проходим по списку айди книг АВТОРА
                boolean haveCopy = false;
                for (int k = 0; k < authorBooksId.length; k++) {
                    // Если айди книги есть в списке айди книг автора то пропускаем,
                    // иначе добавляем в список айди книгАвтора айди книга
                    if (StringUtils.equals(books[i].getId(), authorBooksId[k])) {
                        haveCopy = true;
                    }
                }
                if (!haveCopy) {
                    authorBooksId = ArrayUtils.add(authorBooksId, books[i].getId());
                }
                //Правильно делаю??
                Author updatebleAuthor = authors[j];
                updatebleAuthor.setBooksId(authorBooksId);
            }
        }
        for (int i = 0; i < authors.length; i++) {
            for (int j = 0; j < books.length; j++) {

            }
        }


//        BookDao.get all = books
//        authorDao.getAll = authors
//        for
//        if books.get id or thising = author
//        set books = author
//        autho set book;
    }
}

