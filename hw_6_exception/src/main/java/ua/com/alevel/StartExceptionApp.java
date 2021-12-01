package ua.com.alevel;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StartExceptionApp {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Menu menu = new Menu();
        menu.chooseFormat(reader);
   }
}
