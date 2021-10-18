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
        StringBuilder stringBuilder = new StringBuilder();

        String[] words = stringToWords(src);
        for (int i = 0; i < words.length; i++) {
            if (words[i].contains(dest)) {
                words[i] = wordRevers(words[i], words[i].lastIndexOf(dest),
                        words[i].lastIndexOf(dest) + dest.length());
            }
            stringBuilder.append(words[i]);
            if (i != words.length - 1) {
                stringBuilder.append(" ");
            }
        }
        return String.valueOf(stringBuilder);
    }

    public static String reverse(String src, int firstIndex, int lastIndex) {



        return wordRevers(src, firstIndex, lastIndex);

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

    private static String wordRevers(String string, int start, int finish) {
        char tmpSwap;
        char[] str = string.toCharArray();
        int j = 1;
        if (((start + finish) / 2) > 1) {
            for (int i = start; i < start + (start + finish / 2); i++) {

                tmpSwap = str[i];
                str[i] = str[finish - j];
                str[finish - j] = tmpSwap;
                j++;
            }
        } else {
            tmpSwap = str[start];
            str[start] = str[finish - j];
            str[finish - j] = tmpSwap;
        }


        return String.copyValueOf(str);
    }
}

