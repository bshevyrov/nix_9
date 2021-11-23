package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StartCollectionApp {

    public static void main(String[] args) {
        StartHelper sH = new StartHelper();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // while (true) {
        try {
            sH.greetings();
            String next = reader.readLine();

            sH.constructors();
            next = reader.readLine();
            sH.constructorsAnswers();
            // }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
