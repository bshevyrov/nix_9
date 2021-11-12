package ua.com.alevel.service;

import org.junit.jupiter.api.*;
import ua.com.alevel.entity.Author;
import ua.com.alevel.entity.Book;

import java.util.Arrays;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookServiceTest {

    private final static BookService bookService = new BookService();
    private final static int BOOKS_SIZE = 10;

    @BeforeAll
    public static void setUp() {
        for (int i = 0; i < BOOKS_SIZE; i++) {
            Book book = new Book();
            book.setName("Name" + i);
            book.setAuthorName("AuthorName" + i);
            book.setYear(i);
            bookService.create(book);
        }
        Assertions.assertEquals(BOOKS_SIZE, bookService.findAll().length);
    }

    @Order(1)
    @Test
    public void whenCreateBookThenFindAllNotNull() {
        Book book = new Book();
        book.setAuthorName("Author Name");
        book.setName("Book Name");
        book.setYear(1988);
        bookService.create(book);
        verifyBookArrayIsNotEmpty();
    }

    @Order(2)
    @Test
    public void whenCreateBookWithSomeFieldsAreEmptyThenFindAllNotNull() {
        Book book = new Book();
        book.setAuthorName("");
        book.setName("");
        book.setYear(0);
        bookService.create(book);
        verifyBookArrayIsNotEmpty();
    }

    @Order(3)
    @Test
    public void whenCreateBookWithNullNameThenFindAllNotNull() {
        Book book = new Book();
        book.setAuthorName("null");
        book.setName(null);
        book.setYear(0);
        bookService.create(book);
        verifyBookArrayIsNotEmpty();
    }

    @Order(4)
    @Test
    public void whenFindAllUserThenReturnRightSize() {
        Book[] books = bookService.findAll();
        int rsl = books.length;
        int expected = 13;
        Assertions.assertEquals(expected, rsl);
    }

    @Order(5)
    @Test
    public void whenDeleteThenFindAllSizeMinusOne() {
        Book[] books = bookService.findAll();
        String name = books[books.length - 1].getName();
        bookService.delete(name);
        int rsl = bookService.findAll().length;
        int expected = 12;
        Assertions.assertEquals(expected, rsl);
    }

    @Order(6)
    @Test
    public void whenFindByNameThenNotNull() {
        Book[] books = bookService.findAll();
        Book lastBook = books[books.length - 1];
        String name = books[books.length - 1].getName();
        Book bookRsl = bookService.findByNameOrNull(name);
        Assertions.assertEquals(lastBook, bookRsl);
    }

    @Order(7)
    @Test
    public void whenFindByNameRandomNameThenNull() {
        String name = "q1";
        Assertions.assertNull(bookService.findByNameOrNull(name));
    }

    @Order(8)
    @Test
    public void whenUpdateBookThenFindByNameReturnUpdateFields() {
        Book[] books = bookService.findAll();
        String name = books[books.length - 1].getName();
        Book newBook = new Book();
        newBook.setName(name);
        newBook.setAuthorName("AUTHOR");
        newBook.setYear(9999);
        bookService.update(newBook);
        Assertions.assertEquals(newBook, bookService.findByNameOrNull(name));
    }

    @Order(9)
    @Test
    public void whenCreateBookButAuthorAlreadyExistThenAddBookToAuthorBooks() {
        Author author = new Author();
        author.setBooksName(new String[]{"BookName"});
        author.setName("Author Name2");
        author.setAge(18);
        AuthorService authorService = new AuthorService();
        authorService.create(author);
        Book book = new Book();
        book.setAuthorName("Author Name2");
        book.setName("Book Name99");
        book.setYear(1988);
        bookService.create(book);
        int expectedBooksSize = 2;
        int rsl = authorService.findByNameOrNull(author.getName())
                .getBooksName().length;
        Assertions.assertEquals(expectedBooksSize, rsl);
    }

    @Order(10)
    @Test
    public void whenDeleteBookThenDeleteBookFromAuthor() {
        bookService.delete("Book Name99");
        AuthorService authorService = new AuthorService();
        int rsl = authorService.findByNameOrNull("Author Name2").getBooksName().length;
        System.out.println(Arrays.toString(authorService.findByNameOrNull("Author Name2").getBooksName()));
        Assertions.assertEquals(1, rsl);
    }

    private void verifyBookArrayIsNotEmpty() {
        Book[] books = bookService.findAll();
        Assertions.assertNotNull(books);
    }
}