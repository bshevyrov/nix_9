package ua.com.alevel.third;

import org.apache.commons.lang3.StringUtils;
import ua.com.alevel.TaskHelper;

import java.io.BufferedReader;
import java.io.IOException;

public class Third implements TaskHelper {

    private String inputString;

    public void run(BufferedReader reader) {
        int input;

        System.out.print("Please enter number of lesson: ");
        try {
            inputString = reader.readLine();

            if (StringUtils.isNumeric(inputString)) {
                input = Integer.parseInt(inputString);
                if (input > 0 && input < 11) {
                    getTime(input);
                } else {
                    System.out.println("Input wrong, please try again..");
                    run(reader);
                }
            } else {
                System.out.println("Input wrong, please try again..");
                run(reader);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getTime(int input) {

        int dayStartedAt = 9 * 60;
        int lessonEndAt = 0;

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
