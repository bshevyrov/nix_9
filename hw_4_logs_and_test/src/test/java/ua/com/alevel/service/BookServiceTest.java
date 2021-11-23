package ua.com.alevel.service;

import org.junit.jupiter.api.*;
import ua.com.alevel.entity.Book;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookServiceTest {

    private final static BookService bookService = new BookService();
    private final static int BOOKS_SIZE = 10;

    @BeforeAll
    public static void setUp() {
        for (int i = 0; i < BOOKS_SIZE; i++) {
            Book book = new Book();
            book.setName("Name" + i);
            book.setPages(i+1);
            bookService.create(book);
        }
        Assertions.assertEquals(BOOKS_SIZE, bookService.findAll().length);
    }

    @Order(1)
    @Test
    public void whenCreateBookThenFindAllNotNull() {
        Book book = new Book();
        book.setName("Book Name");
        book.setPages(99);
        bookService.create(book);
        verifyBookArrayIsNotEmpty();
    }

    @Order(2)
    @Test
    public void whenCreateBookWithSomeFieldsAreEmptyThenFindAllNotNull() {
        Book book = new Book();
        book.setName("");
        book.setPages(99);
        bookService.create(book);
        verifyBookArrayIsNotEmpty();
    }

    @Order(3)
    @Test
    public void whenCreateBookWithNullNameThenFindAllNotNull() {
        Book book = new Book();
        book.setName(null);
        book.setPages(99);
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
        String id = books[books.length - 1].getId();
        bookService.delete(id);
        int rsl = bookService.findAll().length;
        int expected = 12;
        Assertions.assertEquals(expected, rsl);
    }

    @Order(6)
    @Test
    public void whenFindByIdThenNotNull() {
        Book[] books = bookService.findAll();
        Book lastBook = books[books.length - 1];
        String id = books[books.length - 1].getId();
        Book bookRsl = bookService.findByIdOrNull(id);
        Assertions.assertEquals(lastBook, bookRsl);
    }

    @Order(7)
    @Test
    public void whenFindByIdRandomIdThenNull() {
        String id = "q1";
        Assertions.assertNull(bookService.findByIdOrNull(id));
    }

    @Order(8)
    @Test
    public void whenUpdateBookThenFindByIdReturnUpdateFields() {
        Book[] books = bookService.findAll();
        String id = books[books.length - 1].getId();
        Book newBook = new Book();
        newBook.setId(id);
        newBook.setPages(99);
        newBook.setName("AUTHOR");
        bookService.update(newBook);
        Assertions.assertEquals(newBook, bookService.findByIdOrNull(id));
    }

    private void verifyBookArrayIsNotEmpty() {
        Book[] books = bookService.findAll();
        Assertions.assertNotNull(books);
    }
}