package ua.com.alevel.helpers;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.controller.AuthorController;
import ua.com.alevel.controller.BookController;

import java.io.BufferedReader;
import java.io.IOException;

public class InputValueMenuHandler {

    private static final BookController bookController = new BookController();
    private static final AuthorController authorController = new AuthorController();

    public static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");

    public static void mainLevelHandler(BufferedReader reader) {
        while (true) {
            NavigationMenu.runNavigationMainLevel();
            int inputMenuValue;
            try {
                String input = reader.readLine();
                if (!StringUtils.isNumeric(input)) {
                    System.out.println("You write not number. Please try again");
                    continue;
                }
                inputMenuValue = Integer.parseInt(reader.readLine());
                if (inputMenuValue <0||inputMenuValue>5) {
                    System.out.println("Please write correct number");
                    continue;
                }
                switch (inputMenuValue) {
                    case 1 -> createLevelHandler(reader);
                    case 2 -> updateLevelHandler(reader);
                    case 3 -> deleteLevelHandler(reader);
                    case 4 -> findByKeyLevelHandler(reader);
                    case 5 -> findAllLevelHandler(reader);
                    case 0 -> System.exit(0);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void findAllLevelHandler(BufferedReader reader) {
        while (true) {
            NavigationMenu.runNavigationFindAllLevel(reader);
            int inputMenuValue;
            try {
                String input = reader.readLine();
                if (!StringUtils.isNumeric(input)) {
                    System.out.println("You write not number. Please try again");
                    continue;
                }
                inputMenuValue = Integer.parseInt(reader.readLine());
                if (inputMenuValue <0||inputMenuValue>2) {
                    System.out.println("Please write correct number");
                    continue;
                }
                switch (inputMenuValue) {
                    case 1 -> bookController.findAll(reader);
                    case 2 -> authorController.findAll(reader);
                    case 0 -> mainLevelHandler(reader);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void findByKeyLevelHandler(BufferedReader reader) {
        while (true) {
            NavigationMenu.runNavigationFindByKeyLevel(reader);
            int inputMenuValue;
            try {
                String input = reader.readLine();
                if (!StringUtils.isNumeric(input)) {
                    System.out.println("You write not number. Please try again");
                    continue;
                }
                inputMenuValue = Integer.parseInt(reader.readLine());
                if (inputMenuValue <0||inputMenuValue>2) {
                    System.out.println("Please write correct number");
                    continue;
                }
                switch (inputMenuValue) {
                    case 1 -> bookController.findById(reader);
                    case 2 -> authorController.findById(reader);
                    case 0 -> mainLevelHandler(reader);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void deleteLevelHandler(BufferedReader reader) {
        while (true) {
            NavigationMenu.runNavigationDeleteLevel(reader);
            int inputMenuValue;
            try {
                String input = reader.readLine();
                if (!StringUtils.isNumeric(input)) {
                    System.out.println("You write not number. Please try again");
                    continue;
                }
                inputMenuValue = Integer.parseInt(reader.readLine());
                if (inputMenuValue <0||inputMenuValue>2) {
                    System.out.println("Please write correct number");
                    continue;
                }
                switch (inputMenuValue) {
                    case 1 -> bookController.delete(reader);
                    case 2 -> authorController.delete(reader);
                    case 0 -> mainLevelHandler(reader);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void updateLevelHandler(BufferedReader reader) {
        while (true) {
            NavigationMenu.runNavigationUpdateLevel(reader);
            int inputMenuValue;
            try {
                String input = reader.readLine();
                if (!StringUtils.isNumeric(input)) {
                    System.out.println("You write not number. Please try again");
                    continue;
                }
                inputMenuValue = Integer.parseInt(reader.readLine());
                if (inputMenuValue <0||inputMenuValue>2) {
                    System.out.println("Please write correct number");
                    continue;
                }
                switch (inputMenuValue) {
                    case 1 -> bookController.update(reader);
                    case 2 -> authorController.update(reader);
                    case 0 -> mainLevelHandler(reader);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void createLevelHandler(BufferedReader reader) {
        while (true) {
            NavigationMenu.runNavigationCreateLevel();
            int inputMenuValue;
            try {
                String input = reader.readLine();
                if (!StringUtils.isNumeric(input)) {
                    System.out.println("You write not number. Please try again");
                    continue;
                }
                inputMenuValue = Integer.parseInt(reader.readLine());
                if (inputMenuValue <0||inputMenuValue>2) {
                    System.out.println("Please write correct number");
                    continue;
                }
                switch (inputMenuValue) {
                    case 1 -> bookController.create(reader);
                    case 2 -> authorController.create(reader);
                    case 0 -> mainLevelHandler(reader);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}




