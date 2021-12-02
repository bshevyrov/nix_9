package ua.com.alevel;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class DatesList {
    //1.22
    private static final File file = new File("src/main/resources/dates.txt");

    public String[] readStringsFromFile() {
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

    public String[] separateStringByOneEntry(String[] inputStr) {
        String[] separatedStrings = new String[0];
        String tmpStr = "";
        StringBuilder builder = new StringBuilder();
        for (String s : inputStr) {
            for (int i = 0; i < s.length() - 10; i++) {
                if (StringUtils.isNumeric(String.valueOf(s.charAt(i)))
                        && StringUtils.isNumeric(String.valueOf(s.charAt(i + 1)))) {
                    // 05/04/2020 OR 04-05-2020
                    if ((i + 5 < s.length()) && (s.charAt(i + 2) == s.charAt(i + 5))) {
                        if (s.charAt(i + 5) == '/') {
                            builder.append(s, i + 6, i + 10);
                            builder.append(s, i + 3, i + 5);
                            builder.append(s, i, i + 2);
                            separatedStrings = ArrayUtils.add(separatedStrings, builder.toString());
                            builder.delete(0, builder.length());
                            i += 10;
                        }
                        if (s.charAt(i + 2) == '-') {
                            builder.append(s, i + 6, i + 10);
                            builder.append(s, i, i + 2);
                            builder.append(s, i + 3, i + 5);
                            separatedStrings = ArrayUtils.add(separatedStrings, builder.toString());
                            builder.delete(0, builder.length());
                            i += 10;
                        }
                    }
                    //2020/04/05
                    if ((i + 7 < s.length()) && (s.charAt(i + 4) == s.charAt(i + 7)) && s.charAt(i + 4) == '/') {
                        builder.append(s, i, i + 4);
                        builder.append(s, i + 5, i + 7);
                        builder.append(s, i + 8, i + 10);
                        separatedStrings = ArrayUtils.add(separatedStrings, builder.toString());
                        builder.delete(0, builder.length());
                        i += 10;
                    }
                }
            }
        }
        System.out.println(separatedStrings.length);
        for (String separatedString : separatedStrings) {
            System.out.println(separatedString);
        }
        return separatedStrings;
    }
}
