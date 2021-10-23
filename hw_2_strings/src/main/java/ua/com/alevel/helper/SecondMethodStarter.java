package ua.com.alevel.helper;

import org.apache.commons.lang3.StringUtils;
import ua.com.alevel.StringHelperUtil;
import ua.com.alevel.TaskHelper;

import java.io.BufferedReader;
import java.io.IOException;

public class SecondMethodStarter implements TaskHelper {
    String[] strings;

    @Override
    public void run(BufferedReader reader) {

        while (true) {
            System.out.print("Write string: ");

            try {
                String str = reader.readLine();
                if (StringUtils.isBlank(str)) {
                    System.out.println("String is not valid. Try again");
                    continue;
                }
                System.out.print("Write substring to find: ");
                String subString = reader.readLine();
                if (StringUtils.isBlank(subString)) {
                    System.out.println("String is not valid. Try again");
                    continue;
                }

                strings = StringUtils.split(str, ' ');
                for (int i = 0; i < strings.length; i++) {
                    if (strings[i].contains(subString)) {
                        int firstChar = StringUtils.indexOf(strings[i], subString);
                        int lastChar = StringUtils.indexOf(strings[i], subString) + subString.length()-1;
                        strings[i] = StringHelperUtil.reverse(strings[i],
                                firstChar,
                                lastChar);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < strings.length; i++) {
                stringBuilder.append(strings[i]);
                if (i != strings.length-1) {
                    stringBuilder.append(" ");
                }
            }
            System.out.println("Result is: " + stringBuilder);
            break;
        }

    }
}
