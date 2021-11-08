package ua.com.alevel.helpers;

import java.io.BufferedReader;

public class NavigationMenu {

    public static void runNavigationMainLevel() {
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
    }

    public static void runNavigationCreateLevel() {
        clearScreen();
        System.out.println("This is Create level");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("");
        System.out.println("1. Create Book");
        System.out.println("2. Create Author");
        System.out.println("0. To Main level");
        System.out.println();
        System.out.print("Please make your choose: ");
    }

    public static void runNavigationUpdateLevel(BufferedReader reader) {
        clearScreen();
        System.out.println("This is Update level");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("");
        System.out.println("1. Update Book");
        System.out.println("2. Update Author");
        System.out.println("0. To Main level");
        System.out.println();
        System.out.print("Please make your choose: ");
    }

    public static void runNavigationDeleteLevel(BufferedReader reader) {

        clearScreen();
        System.out.println("This is Delete level");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("");
        System.out.println("1. Delete Book");
        System.out.println("2. Delete Author");
        System.out.println("0. To Main level");
        System.out.println();
        System.out.print("Please make your choose: ");
    }

    public static void runNavigationFindByKeyLevel(BufferedReader reader) {
        clearScreen();
        System.out.println("This is Find by name level");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("");
        System.out.println("1. Find Book by name");
        System.out.println("2. Find Author by name");
        System.out.println("0. To Main level");
        System.out.println();
        System.out.print("Please make your choose: ");
    }

    public static void runNavigationFindAllLevel(BufferedReader reader) {
        clearScreen();
        System.out.println("This is Find all level");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("");
        System.out.println("1. Find all Book");
        System.out.println("2. Find all Author");
        System.out.println("0. To Main level");
        System.out.println();
        System.out.print("Please make your choose: ");
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
