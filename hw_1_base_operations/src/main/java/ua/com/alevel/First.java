package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class First {

    public static void start() {

        int sum = 0;
        char[] symbols = new char[0];

        System.out.print("Please enter a string: ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            symbols = bufferedReader.readLine().toCharArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (char ch : symbols) {
            if (Character.isDigit(ch)) {
                sum += Character.getNumericValue(ch);
            }
        }
        System.out.println("Sum of numbers are: " + sum);
    }
}