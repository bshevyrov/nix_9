package ua.com.alevel;

import org.apache.commons.lang3.ArrayUtils;

import java.io.*;

public class FileHandler {

    public static String[] readStringsFromFile(File file) {
        String[] input = new String[0];
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while (reader.ready()) {
                input = ArrayUtils.add(input, reader.readLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return input;
    }
     public static void writeToFile(File file, String str){
         BufferedWriter writer = new BufferedWriter(new FileWriter(file,str));
     }



    public static void arrToString(String[] str){
        for (String separatedString : str) {
            System.out.println(separatedString);
        }
    }
}

