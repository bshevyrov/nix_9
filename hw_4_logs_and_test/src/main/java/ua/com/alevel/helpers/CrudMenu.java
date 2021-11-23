package ua.com.alevel.helpers;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CrudMenu {

    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputValueMenuHandler.mainLevelHandler(reader);
    }
}