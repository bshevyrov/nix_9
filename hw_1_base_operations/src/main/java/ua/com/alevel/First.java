package ua.com.alevel;

import java.util.Scanner;

public class First {

    public static void start() {

        int sum = 0;

        System.out.print("Please enter a string: ");
        Scanner scanner = new Scanner(System.in);
        char[] symbols = scanner.nextLine().toCharArray();
        for (char ch : symbols) {
            if (Character.isDigit(ch)) {
                sum += Character.getNumericValue(ch);
            }
        }
        System.out.println("Sum of numbers are: " + sum);
    }


}