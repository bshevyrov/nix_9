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
            authorService.create(author);
        }
        Assertions.assertEquals(AUTHOR_SIZE, authorService.findAll().length);
    }

    @Order(1)
    @Test
    public void whenCreateAuthorThenFindAllNotNull() {
        Author author = new Author();
        author.setName("Author Name");
        authorService.create(author);
        verifyAuthorArrayIsNotEmpty();
    }

    @Order(2)
    @Test
    public void whenCreateAuthorWithSomeFieldsAreEmptyThenFindAllNotNull() {
        Author author = new Author();
        author.setName("");
        authorService.create(author);
        verifyAuthorArrayIsNotEmpty();
    }

    @Order(3)
    @Test
    public void whenCreateAuthorWithNullNameThenFindAllNotNull() {
        Author author = new Author();
        author.setName(null);
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
        String id = authors[authors.length - 1].getId();
        authorService.delete(id);
        int rsl = authorService.findAll().length;
        int expected = 13;
        Assertions.assertEquals(expected, rsl);
    }

    @Order(6)
    @Test
    public void whenFindByIdThenNotNull() {
        Author[] authors = authorService.findAll();
        Author lastAuthor = authors[authors.length - 1];
        String id = authors[authors.length - 1].getId();
        Author authorRsl = authorService.findByIdOrNull(id);
        Assertions.assertEquals(lastAuthor, authorRsl);
    }

    @Order(7)
    @Test
    public void whenFindByIdRandomIdThenNull() {
        String id = "q1-dsafdsadsa-dadsadsa2-2";
        Assertions.assertNull(authorService.findByIdOrNull(id));
    }

    @Order(8)
    @Test
    public void whenUpdateAuthorThenFindByIdReturnUpdateFields() {
        Author[] authors = authorService.findAll();
        String id = authors[authors.length - 1].getId();
        Author newAuthor = new Author();
        newAuthor.setName("qqq");
        newAuthor.setId(id);
        authorService.update(newAuthor);
        Assertions.assertEquals(newAuthor, authorService.findByIdOrNull(id));
    }

    private void verifyAuthorArrayIsNotEmpty() {
        Author[] authors = authorService.findAll();
        Assertions.assertNotNull(authors);
    }
}