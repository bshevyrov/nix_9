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
            String next="";
            next = reader.readLine();

            sH.constructors();
            next = reader.readLine();
            sH.constructorsAnswers();
            next = reader.readLine();
            sH.methods();
            next = reader.readLine();
            sH.methodsAnswer();
            next = reader.readLine();
            sH.methodPartTwo();
            next = reader.readLine();
            sH.methodPartTwoAnswer();
            next = reader.readLine();
            sH.methodLastPart();
            next = reader.readLine();
            sH.methodLastPartAnswer();
            next = reader.readLine();

            // }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
