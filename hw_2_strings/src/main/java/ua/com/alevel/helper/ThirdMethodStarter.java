package ua.com.alevel.helper;

import org.apache.commons.lang3.StringUtils;
import ua.com.alevel.StringHelperUtil;
import ua.com.alevel.TaskHelper;

import java.io.BufferedReader;
import java.io.IOException;

public class ThirdMethodStarter implements TaskHelper {

    @Override
    public void run(BufferedReader reader) {
        String str = "";
        String firstNum = "";
        String secondNum = "";
        while (true) {
            System.out.print("Write string: ");
            try {
                str = reader.readLine();

                if (StringUtils.isBlank(str)) {
                    System.out.println("String is not valid. Try again");
                    continue;
                }
                System.out.print("Write first number: ");

                firstNum = reader.readLine();

                if (!StringUtils.isNumeric(firstNum)) {
                    System.out.println("Its not number. Try again");
                    continue;
                }
                if (Integer.parseInt(firstNum) < 0 && Integer.parseInt(firstNum) >= str.length()) {
                    System.out.println("Abnormal fist number. Try again");
                    continue;
                }
                System.out.print("Writer second number: ");

                secondNum = reader.readLine();
                if (!StringUtils.isNumeric(secondNum)) {
                    System.out.println("Its not number. Try again");
                    continue;
                }
                if (Integer.parseInt(secondNum) < Integer.parseInt(firstNum) &&
                        Integer.parseInt(secondNum) >= str.length()) {
                    System.out.println("Abnormal second number. Try again");
                    continue;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        }
        String rsl = StringHelperUtil.reverse(str, Integer.parseInt(firstNum), Integer.parseInt(secondNum));
        System.out.println("Result is: " + rsl);
    }
}