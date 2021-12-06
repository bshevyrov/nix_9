package ua.com.alevel;

import org.apache.commons.lang3.StringUtils;

public class JsonVerification {

    public static boolean stringVerification(String str) {
        str = cleanString(str);
        if (str.length() == 0) {
            return true;
        }
        if (isAllNeededSymbolsHavePair(str)) {
            for (int i = 0; i < (str.length()) / 2; i++) {
                if (str.charAt(i) != str.charAt((str.length()) / 2)) {
                    return false;
                }
            }
        } else {
            return false;
        }
        System.out.println(str);
        return true;
    }

    private static String cleanString(String str) {
        str = deleteAllOtherSymbols(str);
        str = removeSmallPair(str);
        str = deleteAllOtherSymbols(str);
        return str;
    }

    private static boolean isAllNeededSymbolsHavePair(String str) {
        return StringUtils.countMatches(str, '{') == StringUtils.countMatches(str, '}')
                && (StringUtils.countMatches(str, '(') == StringUtils.countMatches(str, ')'))
                && (StringUtils.countMatches(str, '[') == StringUtils.countMatches(str, ']'));
    }

    private static String deleteAllOtherSymbols(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '{' || str.charAt(i) == '}'
                    || str.charAt(i) == '(' || str.charAt(i) == ')'
                    || str.charAt(i) == '[' || str.charAt(i) == ']') {
                stringBuilder.append(str.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    private static boolean isProtagonist(char first, char second) {
        return ((first == '{') && (second == '}'))
                || (((first == '(') && (second == ')')))
                || (((first == '[') && (second == ']')));
    }

    private static String removeSmallPair(String str) {
        char[] string = str.toCharArray();

        for (int i = 0; i < string.length - 1; i++) {
            if (isProtagonist(string[i], string[i + 1])) {
                string[i] = ' ';
                string[i + 1] = ' ';
                i++;
            }
        }
        return new String(string);
    }
}


