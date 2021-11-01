package ua.com.alevel.helpers;

import java.io.BufferedReader;
import java.io.IOException;

public class NavigationMenu {
   // private final InputValueMenuHandler inputValueMenuHandler = new InputValueMenuHandler();

    public static void runNavigationMainLevel() {
       // while (true) {
            clearScreen();
            System.out.println("This is main level");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("");
            System.out.println("1. Create");
            System.out.println("2. Update");
            System.out.println("3. Delete");
            System.out.println("4. Find by key");
            System.out.println("5. Find all");
            System.out.println("0. Exit Program");
            System.out.println();
            System.out.print("Please make your choose: ");

              //  InputValueMenuHandler.mainLevelHandler(reader);

       // }
    }

    public  static void runNavigationCreateLevel() {

            clearScreen();
            System.out.println("This is Create level");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("");
            System.out.println("1. Create Book");
            System.out.println("2. Create Author");
            System.out.println("3. Create Publisher");
            System.out.println("0. To Main level");
            System.out.println();
            System.out.print("Please make your choose: ");

           // inputValueMenuHandler.mainLevelHandler( reader);


    }

    public static void runNavigationUpdateLevel(BufferedReader reader) {
    //    while (true) {
            clearScreen();
            System.out.println("This is Update level");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("");
            System.out.println("1. Update Book");
            System.out.println("2. Update Author");
            System.out.println("3. Update Publisher");
            System.out.println("0. To Main level");
            System.out.println();
            System.out.print("Please make your choose: ");
           // inputValueMenuHandler.updateLevelHandler(reader);
        }
  //  }

    public static void runNavigationDeleteLevel(BufferedReader reader) {
       // while (true) {
            clearScreen();
            System.out.println("This is Delete level");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("");
            System.out.println("1. Delete Book");
            System.out.println("2. Delete Author");
            System.out.println("3. Delete Publisher");
            System.out.println("0. To Main level");
            System.out.println();
            System.out.print("Please make your choose: ");
           // inputValueMenuHandler.deleteLevelHandler(reader);

        }
  //  }

    public static void runNavigationFindByKeyLevel(BufferedReader reader) {
     //   while (true) {
            clearScreen();
            System.out.println("This is Find by key level");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("");
            System.out.println("1. Find Book by id");
            System.out.println("2. Find Author by email");
            System.out.println("3. Find Publisher by name");
            System.out.println("0. To Main level");
            System.out.println();
            System.out.print("Please make your choose: ");
           // //inputValueMenuHandler.findByKeyLevelHandler(reader);
        }
   // }

    public static void runNavigationFindAllLevel(BufferedReader reader) {
    //    while (true) {
            clearScreen();
            System.out.println("This is Find all level");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("");
            System.out.println("1. Find all Book");
            System.out.println("2. Find all Author");
            System.out.println("3. Find all Publisher");
            System.out.println("0. To Main level");
            System.out.println();
            System.out.print("Please make your choose: ");
           // inputValueMenuHandler.findAllLevelHandler(reader);
        }
   // }


    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();

    }
}
