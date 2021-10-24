package ua.com.alevel;

import java.util.Arrays;
import java.util.Scanner;

public class StringHelperUtil {

    private StringHelperUtil() {
    }

    public static String reverse(String src) {
        StringBuilder stringBuilder = new StringBuilder();
        if (src.contains(" ")) {
            String[] words = stringToWords(src);
            for (int i = 0; i < words.length; i++) {
                words[i] = wordRevers(words[i]);
                stringBuilder.append(words[i]);
                if (i != words.length - 1) {
                    stringBuilder.append(" ");
                }
            }
        } else {
            stringBuilder.append(wordRevers(src));
        }
        return String.valueOf(stringBuilder);
    }

    public static String reverse(String src, int firstIndex, int lastIndex) {
        String[] words;
        int position = 0;

        if (src.contains(" ")) {
            words = stringToWords(src);
            for (int i = 0; i < words.length; i++) {
                if (position < lastIndex) {
                    if (position < firstIndex) {
                        if (position + words[i].length() < firstIndex) {
                            position = position + words[i].length() + 1;
                        } else {
                            words[i] = wordRevers(words[i], firstIndex - position, words[i].length() - 1);
                            position = position + words[i].length() + 1;
                        }
                    } else {
                        if (position + words[i].length() < lastIndex) {
                            words[i] = wordRevers(words[i], 0, words[i].length() - 1);
                            position = position + words[i].length() + 1;
                        } else {
                            words[i] = wordRevers(words[i], 0, (lastIndex - position));
                            break;
                        }
                    }
                }
            }
            StringBuilder stringBuilder1 = new StringBuilder();
            for (int i = 0; i < words.length; i++) {
                stringBuilder1.append(words[i]);
                if (i != words.length - 1) {
                    stringBuilder1.append(" ");
                }
            }
            src = stringBuilder1.toString();
        } else {
            src = wordRevers(src, firstIndex, lastIndex);
        }
        return src;
    }

    //todo delete
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
        int j = 0;

        if (finish - start == 1) {
            tmpSwap = str[start];
            str[start] = str[finish];
            str[finish] = tmpSwap;
        } else {
            for (int i = start; i < finish - 1; i++) {
                tmpSwap = str[i];
                str[i] = str[finish - (j)];
                str[finish - (j)] = tmpSwap;
                j++;
            }
        }
        return String.copyValueOf(str);
    }
}

