package ua.com.alevel.controller;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import ua.com.alevel.entity.Author;
import ua.com.alevel.entity.Book;
import ua.com.alevel.service.AuthorService;
import ua.com.alevel.service.BookService;
import ua.com.alevel.service.impl.AuthorServiceImpl;
import ua.com.alevel.service.impl.BookServiceImpl;
import ua.com.alevel.utils.NavigationMenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class BookController {

    private final AuthorService authorService = new AuthorServiceImpl();
    private final BookService bookService = new BookServiceImpl();

    public void create(BufferedReader reader) {
        String[] authorsOfThisBook = new String[0];
        while (true) {
            try {
                NavigationMenu.clearScreen();
                System.out.print("Write name of the book:");
                String bookName = reader.readLine();
                if (!isStringOk(bookName)) {
                    continue;
                }
                System.out.print("Write count of pages:");
                String pages = reader.readLine();
                if (!StringUtils.isNumeric(pages)) {
                    System.out.println("There are no numbers. Please try again.");
                    Thread.sleep(3000);
                    continue;
                }
                int bookPages = Integer.parseInt(pages);
                while (true) {
                    System.out.print("Write author name:");
                    String authorName = reader.readLine();
                    if (!isStringOk(authorName)) {
                        continue;
                    }
                    authorsOfThisBook = ArrayUtils.add(authorsOfThisBook, authorName);
                    System.out.print("If you want to add another author of " + bookName + " please write 1:");
                    String inputAnswer = reader.readLine();
                    if (StringUtils.isNumeric(inputAnswer) && Integer.parseInt(inputAnswer) == 1) {
                        continue;
                    } else {
                        break;
                    }
                }
                for (String s : authorsOfThisBook) {
                    //Поиск авторов у текущей созданой книги в базе авторов
                    //Если автор ненайден, то создаем базовую сушьность автора
                    String curAuthId = authorService.findIdByName(s);
                    if (StringUtils.equals(curAuthId, "")) {
                        Author author = new Author();
                        author.setName(s);
                        authorService.create(author);
                    }
                }
                String[] curAuthsId = new String[0];
                //Создаем список айдишников  авторов этой книги
                for (String s : authorsOfThisBook) {
                    curAuthsId = ArrayUtils.add(curAuthsId, authorService.findIdByName(s));
                }
                //Если книга не найдена в базе то добавляем
                if (StringUtils.equals(bookService.findIdByName(bookName), "")) {
                    Book newBook = new Book();
                    newBook.setName(bookName);
                    newBook.setPages(bookPages);
                    newBook.setAuthorsId(curAuthsId);
                    bookService.create(newBook);
                } else {
                    //если  книга найдена в базе // то кней надо присетитть авторов
                    Book currrentBook = bookService.findById(bookService.findIdByName(bookName));
                    currrentBook.setName(bookName);
                    currrentBook.setPages(bookPages);
                    String[] authIds = new String[0];
                    //берем список айдишников авторов у текущей книги
                    // если их нет
                    if (currrentBook.getAuthorsId() == null || currrentBook.getAuthorsId().length == 0) {
                        String [] auId = new String[0];
                        for (String s : authorsOfThisBook) {
                            authIds = ArrayUtils.add(authIds,authorService.findIdByName(s));
                        }

                      /*  //Достаем всех авторов
                        List<Author> authors = authorService.findAll();
                        for (Author author : authors) {
                            //Доставем у автора все айдишники книг
                            String[] authorBooksId = author.getBooksId();
                            for (String s : authorBooksId) {
                                //Если айдишник книги у автора совпадает с айди текущей книги
                                //То добавляем в список айдиавторов ТЕКУЩЕЙ книги, айди автора из базы
                                if (s.equals(bookService.findIdByName(bookName))) {
                                    authIds = ArrayUtils.add(authIds, author.getId());
                                }
                            }
                        }
//                        if (currrentBook.getAuthorsId() != null) {
//                            authIds = currrentBook.getAuthorsId();
//                        }*/
                    } /*else {
                        // если у текущей книги есть автора то делаем из них список айдиавторов текущей книги
                        authIds = currrentBook.getAuthorsId();
                    }
                    //что это??
                    // создаем список Новых айди авторов текущей книги  из айдиавторов текущей книги
                    String[] newAuthorsId = authIds;
                    //проходим по списку айдиавторов текущей книги
                    for (String authId : authIds) {
                        boolean alreadyInArr = false;
                        String tmp = "";
                        //ПРоходим по списку имен текущей книги
                        for (String s1 : authorsOfThisBook) {
                            //если айдиавторов текущей книги совпадает с айдиавтора  из базы
                            if (StringUtils.equals(authId, authorService.findIdByName(s1))) {
                                alreadyInArr = true;//получается что последний совпадающий элемент сохраняется, первые затираются
                                tmp = s1;//ЧТО ЭТО ЗА МУВ??
                                //Если автора совпадают, то сохранить имя
                            }
                        }                   //Мув века блять
                        if (!alreadyInArr) {//если не в базе, то добавить в список Новых айди авторов текущей книги ПУСТОЕ ПОЛЕ
                            newAuthorsId = ArrayUtils.add(newAuthorsId, authorService.findIdByName(tmp));
                        }
                    }
                    //сетим Новый список текущих авторов*/
                    currrentBook.setAuthorsId(authIds);
                    bookService.update(currrentBook);
                }
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void update(BufferedReader reader) {
        while (true) {
            try {
                NavigationMenu.clearScreen();
                System.out.print("Write Id of the book:");
                String bookId = reader.readLine();
                if (!isStringOk(bookId)) {
                    continue;
                }
                System.out.print("Write count of pages:");
                String pages = reader.readLine();
                if (!StringUtils.isNumeric(pages)) {
                    System.out.println("There are no numbers. Please try again.");
                    Thread.sleep(3000);
                    continue;
                }
                int bookPages = Integer.parseInt(pages);
                System.out.print("Write name of the book:");
                String bookName = reader.readLine();
                if (!isStringOk(bookName)) {
                    continue;
                }
                Book newBook = new Book();
                newBook.setId(bookId);
                newBook.setName(bookName);
                newBook.setPages(bookPages);
                newBook.setAuthorsId(bookService.findById(bookId).getAuthorsId());
                bookService.update(newBook);
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void delete(BufferedReader reader) {
        while (true) {
            System.out.print("Write id of book to delete:");
            try {
                String name = reader.readLine();
                if (!isStringOk(name)) {
                    continue;
                }
                bookService.delete(name);
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void findAll(BufferedReader reader) {
        List<Book> books = bookService.findAll();
        for (Book book : books) {
            if (book.getPages() == 0) {
                continue;
            }
            System.out.println(book);
        }
        while (true) {
            System.out.println("SAVE ID!!!!");
            System.out.println("SCREEN WILL BE CLEANED");
            System.out.print("Type 0 to clear and continue: ");
            try {
                String input = reader.readLine();
                if (!StringUtils.isNumeric(input)) {
                    System.out.println("You write not number. Please try again");
                    continue;
                }
                int rsl = Integer.parseInt(input);
                if (rsl == 0) {
                    break;
                } else {
                    continue;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void findById(BufferedReader reader) {
        while (true) {
            try {
                System.out.print("Write id of book:");
                String idBook = reader.readLine();
                if (!isStringOk(idBook)) {
                    continue;
                }
                Book book = bookService.findById(idBook);
                System.out.println(book != null ? book.toString() : "Sorry book not found");
                while (true) {
                    System.out.println("Write 0 to continue:");
                    String input = reader.readLine();
                    if (!StringUtils.isNumeric(input)) {
                        System.out.println("You write not number. Please try again");
                        continue;
                    }
                    int rsl = Integer.parseInt(input);
                    if (rsl == 0) {
                        break;
                    } else {
                        continue;
                    }
                }
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean isStringOk(String s) {
        boolean rsl = true;
        if (StringUtils.isEmpty(s) || StringUtils.isBlank(s)) {
            System.out.println("There are blank or empty name. Please try again.");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            rsl = false;
        }
        return rsl;
    }
}
