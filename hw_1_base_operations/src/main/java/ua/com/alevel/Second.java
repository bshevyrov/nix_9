package ua.com.alevel;

import java.util.Arrays;
import java.util.Scanner;

public class Second {

    public char[][] getLettersSequence(char[] symbols) {

        int index = 0;
        char[][] letters = new char[symbols.length][2];

        for (char ch : symbols) {
            if (Character.isAlphabetic(ch)) {
                if (isInArray(ch, letters)) {
                    letters[findIndexByValue(ch, letters)][1] += 1;
                } else {
                    letters[index][0] = ch;
                    letters[index][1] = '1';
                    index++;
                }
            }
        }
        return Arrays.copyOf(letters, index);
    }

    public void toString(char[][] arr) {

        for (char[] chars : arr) {
            System.out.println(chars[0] + " - " + chars[1]);
        }
    }

    private boolean isInArray(char c, char[][] chars) {

        boolean rsl = false;

        for (char[] aChar : chars) {
            if (c == aChar[0]) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }


    private int findIndexByValue(char c, char[][] ch) {
        int rsl = -1;
        for (int i = 0; i < ch.length; i++) {
            if (c == ch[i][0]) {
                rsl = i;
            }
        }
        return rsl;
    }

    public static void start() {

        Second second = new Second();

        System.out.print("Please enter a string: ");
        Scanner scanner = new Scanner(System.in);
        char[] symbols = scanner.nextLine().toLowerCase().toCharArray();
        Arrays.sort(symbols);
        char[][] rsl = second.getLettersSequence(symbols);
        System.out.println("Char sequence:");
        second.toString(rsl);
    }
}

