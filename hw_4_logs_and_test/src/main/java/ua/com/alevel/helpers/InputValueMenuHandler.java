package ua.com.alevel.helpers;

import ua.com.alevel.controller.AuthorController;
import ua.com.alevel.controller.BookController;

import java.io.BufferedReader;
import java.io.IOException;

public class InputValueMenuHandler {

    private static final BookController bookController = new BookController();
    private static final AuthorController authorController = new AuthorController();


    public static void mainLevelHandler(BufferedReader reader) {
        while (true) {
            NavigationMenu.runNavigationMainLevel();
            int inputMenuValue = 0;
            try {
                inputMenuValue = Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }

            switch (inputMenuValue) {

                case 1 -> createLevelHandler(reader);
                case 2 -> updateLevelHandler(reader);
                case 3 -> deleteLevelHandler(reader);
                case 4 -> findByKeyLevelHandler(reader);
                case 5 -> findAllLevelHandler(reader);
                case 0 -> System.exit(0);
            }
        }
    }

    public static void findAllLevelHandler(BufferedReader reader) {
        while (true) {
            NavigationMenu.runNavigationFindAllLevel(reader);
            int inputMenuValue = 0;
            try {
                inputMenuValue = Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }

            switch (inputMenuValue) {
                case 1 -> bookController.findAll(reader);
                case 2 -> authorController.findAll(reader);
//                case 3 -> publisherController.findAll(reader);
                case 0 -> mainLevelHandler(reader);
            }
        }
    }

    public static void findByKeyLevelHandler(BufferedReader reader) {
        while (true) {
            NavigationMenu.runNavigationFindByKeyLevel(reader);
            int inputMenuValue = 0;
            try {
                inputMenuValue = Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }

            switch (inputMenuValue) {
                case 1 -> bookController.findByName(reader);
                case 2 -> authorController.findByName(reader);
//                case 3 -> publisherController.findByName(reader);
                case 0 -> mainLevelHandler(reader);
            }
        }
    }

    public static void deleteLevelHandler(BufferedReader reader) {
        while (true) {
            NavigationMenu.runNavigationDeleteLevel(reader);
            int inputMenuValue = 0;
            try {
                inputMenuValue = Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }

            switch (inputMenuValue) {
                case 1 -> bookController.delete(reader);
                case 2 -> authorController.delete(reader);
//                case 3 -> publisherController.delete(reader);
                case 0 -> mainLevelHandler(reader);
            }
        }
    }

    public static void updateLevelHandler(BufferedReader reader) {
        while (true) {
            NavigationMenu.runNavigationUpdateLevel(reader);
            int inputMenuValue = 0;
            try {
                inputMenuValue = Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }

            switch (inputMenuValue) {
                case 1 -> bookController.update(reader);
                case 2 -> authorController.update(reader);
                //case 3 -> publisherController.update(reader);
                case 0 -> mainLevelHandler(reader);
            }
        }
    }

    public static void createLevelHandler(BufferedReader reader) {
        while (true) {
            NavigationMenu.runNavigationCreateLevel();
            int inputMenuValue = 0;
            try {
                inputMenuValue = Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            switch (inputMenuValue) {
                case 1 -> bookController.create(reader);
                case 2 -> authorController.create(reader);
//                case 3 -> publisherController.create(reader);
                case 0 -> mainLevelHandler(reader);
            }
        }
    }
}
