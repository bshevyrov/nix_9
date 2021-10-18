package ua.com.alevel.first;

import ua.com.alevel.TaskHelper;

import java.io.BufferedReader;
import java.io.IOException;


public class First implements TaskHelper {

    public void run(BufferedReader bufferedReader) {

        int sum = 0;
        char[] symbols = new char[0];

        System.out.print("Please enter a string: ");
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