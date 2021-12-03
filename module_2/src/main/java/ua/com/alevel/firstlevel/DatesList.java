package ua.com.alevel.firstlevel;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import ua.com.alevel.handlers.FileHandler;

public class DatesList {
    //1.22
    public void separateStringByOneEntry(String[] inputStr) {
        System.out.println("");
        System.out.println("Input: ");
        FileHandler.arrToString(inputStr);
        String[] separatedStrings = new String[0];
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
        System.out.println("");
        System.out.println("Output: ");
        FileHandler.arrToString(separatedStrings);
    }

}
