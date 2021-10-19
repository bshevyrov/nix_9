package ua.com.alevel.helper;

import ua.com.alevel.StringHelperUtil;
import ua.com.alevel.TaskHelper;
import java.io.BufferedReader;

public class ThirdMethodStarter implements TaskHelper {
    @Override
    public void run(BufferedReader reader) {

        System.out.print("Write words and separate by spaces two numbers: ");
        String[] compoundArguments = ArgumentsCompounded.getStingAndTwoNum(reader);
        String rsl = StringHelperUtil.reverse(compoundArguments[0],
                Integer.parseInt(compoundArguments[1]),
                Integer.parseInt(compoundArguments[2]));
        System.out.println("Result is: " + rsl);
    }
}