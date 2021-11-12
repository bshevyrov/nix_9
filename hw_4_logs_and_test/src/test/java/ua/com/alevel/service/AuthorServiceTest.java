package ua.com.alevel.service;

import org.junit.jupiter.api.*;
import ua.com.alevel.entity.Author;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AuthorServiceTest {

    private final static AuthorService authorService = new AuthorService();
    private final static int AUTHOR_SIZE = 11;

    @BeforeAll
    public static void setUp() {
        for (int i = 0; i < AUTHOR_SIZE; i++) {
            Author author = new Author();
            author.setName("Name" + i);
            author.setBooksName(new String[]{"BookName" + i});
            author.setAge(i);
            authorService.create(author);
        }
        Assertions.assertEquals(AUTHOR_SIZE, authorService.findAll().length);
    }

    @Order(1)
    @Test
    public void whenCreateAuthorThenFindAllNotNull() {
        Author author = new Author();
        author.setBooksName(new String[]{"BookName"});
        author.setName("Author Name");
        author.setAge(18);
        authorService.create(author);
        verifyAuthorArrayIsNotEmpty();
    }

    @Order(2)
    @Test
    public void whenCreateAuthorWithSomeFieldsAreEmptyThenFindAllNotNull() {
        Author author = new Author();
        author.setBooksName(new String[]{"BookName"});
        author.setName("");
        author.setAge(0);
        authorService.create(author);
        verifyAuthorArrayIsNotEmpty();
    }

    @Order(3)
    @Test
    public void whenCreateAuthorWithNullNameThenFindAllNotNull() {
        Author author = new Author();
        author.setBooksName(new String[]{"BookName"});
        author.setName(null);
        author.setAge(0);
        authorService.create(author);
        verifyAuthorArrayIsNotEmpty();
    }

    @Order(4)
    @Test
    public void whenFindAllUserThenReturnRightSize() {
        Author[] authors = authorService.findAll();
        int rsl = authors.length;
        int expected = 14;
        Assertions.assertEquals(expected, rsl);
    }

    @Order(5)
    @Test
    public void whenDeleteThenFindAllSizeMinusOne() {
        Author[] authors = authorService.findAll();
        String name = authors[authors.length - 1].getName();
        authorService.delete(name);
        int rsl = authorService.findAll().length;
        int expected = 13;
        Assertions.assertEquals(expected, rsl);
    }

    @Order(6)
    @Test
    public void whenFindByNameThenNotNull() {
        Author[] authors = authorService.findAll();
        Author lastAuthor = authors[authors.length - 1];
        String name = authors[authors.length - 1].getName();
        Author authorRsl = authorService.findByNameOrNull(name);
        Assertions.assertEquals(lastAuthor, authorRsl);
    }

    @Order(7)
    @Test
    public void whenFindByNameRandomNameThenNull() {
        String name = "q1";
        Assertions.assertNull(authorService.findByNameOrNull(name));
    }

    @Order(8)
    @Test
    public void whenUpdateAuthorThenFindByNameReturnUpdateFields() {
        Author[] authors = authorService.findAll();
        String name = authors[authors.length - 1].getName();
        Author newAuthor = new Author();
        newAuthor.setName(name);
        newAuthor.setBooksName(new String[]{"BookName"});
        newAuthor.setAge(9999);
        authorService.update(newAuthor);
        Assertions.assertEquals(newAuthor, authorService.findByNameOrNull(name));
    }

    private void verifyAuthorArrayIsNotEmpty() {
        Author[] authors = authorService.findAll();
        Assertions.assertNotNull(authors);
    }
}