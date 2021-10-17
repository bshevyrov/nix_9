package ua.com.alevel;


import java.util.Arrays;
import java.util.Scanner;

public class Logic {
    public static String reverse(String src) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] words = stringToWords(src);
        for (int i = 0; i < words.length; i++) {
            words[i] = wordRevers(words[i]);
            stringBuilder.append(words[i]);
            if (i != words.length - 1) {
                stringBuilder.append(" ");
            }
        }


        return String.valueOf(stringBuilder);
    }

    public static String reverse(String src, String dest) {
        return "";

    }

    public static String reverse(String src, int firstIndex, int lastIndex) {
        return "";

    }

    private static String[] stringToWords(String string) {
        String[] words = new String[string.length() / 2];
        int index = 0;
        Scanner scanner = new Scanner(string);

        while (true) {
            if (scanner.hasNext()) {
                words[index++] = scanner.next();
            } else {
                break;
            }
        }
        return Arrays.copyOf(words, index);
    }

    private static String wordRevers(String string) {
        char tmpSwap;
        char[] str = string.toCharArray();
        for (int i = 0; i < str.length / 2; i++) {
            tmpSwap = str[i];
            str[i] = str[str.length - (i + 1)];
            str[str.length - (i + 1)] = tmpSwap;
        }
        return String.copyValueOf(str);
    }
}

