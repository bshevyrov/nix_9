package ua.com.alevel.utils;

import org.apache.commons.lang3.ArrayUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileHandler {
    public static String readStringsFromFile(File file) {
        String input = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while (reader.ready()) {
                input = reader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return input;
    }
}