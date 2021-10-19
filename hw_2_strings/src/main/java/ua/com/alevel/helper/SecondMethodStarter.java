package ua.com.alevel.helper;

import ua.com.alevel.StringHelperUtil;
import ua.com.alevel.TaskHelper;
import java.io.BufferedReader;

public class SecondMethodStarter implements TaskHelper {
    @Override
    public void run(BufferedReader reader) {

        System.out.print("Write words and separate last word by space from substring: ");
        String[] compoundArguments = ArgumentsCompounded.getStringAndSubstring(reader);
        String rsl = StringHelperUtil.reverse(compoundArguments[0], compoundArguments[1]);
        System.out.println("Result is: " + rsl);
    }
}
