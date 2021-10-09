package ua.com.alevel;

import java.util.Scanner;

public class Third {

    public static void main(String[] args) {

        int dayStartedAt = 9 * 60;
        int lessonEndAt = 0;

        System.out.print("Please enter number of lesson: ");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        switch (input) {
            case 1:
                lessonEndAt = dayStartedAt + 45;
                break;
            case 2:
                lessonEndAt = dayStartedAt + 45 * 2 + 5;
                break;
            case 3:
                lessonEndAt = dayStartedAt + 45 * 3 + 5 + 15;
                break;
            case 4:
                lessonEndAt = dayStartedAt + 45 * 4 + 5 * 2 + 15;
                break;
            case 5:
                lessonEndAt = dayStartedAt + 45 * 5 + 5 * 2 + 15 * 2;
                break;
            case 6:
                lessonEndAt = dayStartedAt + 45 * 6 + 5 * 3 + 15 * 2;
                break;
            case 7:
                lessonEndAt = dayStartedAt + 45 * 7 + 5 * 3 + 15 * 3;
                break;
            case 8:
                lessonEndAt = dayStartedAt + 45 * 8 + 5 * 4 + 15 * 3;
                break;
            case 9:
                lessonEndAt = dayStartedAt + 45 * 9 + 5 * 4 + 15 * 4;
                break;
            case 10:
                lessonEndAt = dayStartedAt + 45 * 10 + 5 * 5 + 15 * 4;
                break;
            default:
        }
        System.out.println(input + " Lesson will end at: " + lessonEndAt / 60 + ":" + ((lessonEndAt) - (lessonEndAt / 60) * 60));
    }
}
