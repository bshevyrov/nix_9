package ua.com.alevel.first;

import org.apache.commons.lang3.StringUtils;
import ua.com.alevel.TaskHelper;

import java.io.BufferedReader;
import java.io.IOException;


public class First implements TaskHelper {

    public void run(BufferedReader bufferedReader) {

        int sum = 0;
        char[] symbols;
        String inputString;
        System.out.print("Please enter a string: ");
        try {
            inputString = bufferedReader.readLine();
            if (StringUtils.isNotBlank(inputString)) {
                symbols = inputString.toCharArray();
                for (char ch : symbols) {
                    if (Character.isDigit(ch)) {
                        sum += Character.getNumericValue(ch);
                    }
                }
                System.out.println("Sum of numbers are: " + sum);
            } else {
                System.out.println("Input wrong, please try again..");
                run(bufferedReader);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}