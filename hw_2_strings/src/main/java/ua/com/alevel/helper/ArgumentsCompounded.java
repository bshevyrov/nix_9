package ua.com.alevel.helper;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;

public class ArgumentsCompounded {

    public static String[] getStringAndSubstring(BufferedReader reader) {

        String[] strings = new String[2];
        String[] inputWordsSeparatedByWSpace = new String[0];
        StringBuilder stringBuilder = new StringBuilder();

        try {
            inputWordsSeparatedByWSpace = StringUtils.splitPreserveAllTokens(reader.readLine(), ' ');
        } catch (IOException e) {
            e.printStackTrace();
        }
        int indexOfLastWord = inputWordsSeparatedByWSpace.length - 2;
        for (int i = 0; i <= indexOfLastWord; i++) {
            stringBuilder.append(inputWordsSeparatedByWSpace[i]);
            if (i != indexOfLastWord) {
                stringBuilder.append(" ");
            }
        }
        strings[0] = stringBuilder.toString();
        stringBuilder.delete(0, stringBuilder.length());
        stringBuilder.append(inputWordsSeparatedByWSpace[inputWordsSeparatedByWSpace.length - 1]);
        strings[1] = stringBuilder.toString();

        return strings;
    }

    public static String[] getStingAndTwoNum(BufferedReader reader) {
        String[] strings = new String[3];
        String[] inputWordsSeparatedByWSpace = new String[0];
        StringBuilder rsl = new StringBuilder();

        try {
            inputWordsSeparatedByWSpace = StringUtils.splitPreserveAllTokens(reader.readLine(), ' ');
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < inputWordsSeparatedByWSpace.length - 2; i++) {
            rsl.append(inputWordsSeparatedByWSpace[i]);
            rsl.append(" ");
        }
        strings[0] = rsl.toString();
        strings[1] = inputWordsSeparatedByWSpace[inputWordsSeparatedByWSpace.length - 2];
        strings[2] = inputWordsSeparatedByWSpace[inputWordsSeparatedByWSpace.length - 1];

        return strings;
    }
}