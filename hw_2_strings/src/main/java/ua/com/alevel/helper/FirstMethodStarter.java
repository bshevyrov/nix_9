package ua.com.alevel.helper;

import ua.com.alevel.StringHelperUtil;
import ua.com.alevel.TaskHelper;
import java.io.BufferedReader;
import java.io.IOException;

public class FirstMethodStarter implements TaskHelper {
    @Override
    public void run(BufferedReader reader) {
        try {
            System.out.print("Write words to revers: ");
            String rsl = StringHelperUtil.reverse(reader.readLine());
            System.out.println("Result is: " + rsl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
