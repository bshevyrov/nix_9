package ua.com.alevel.helper;

import org.apache.commons.lang3.StringUtils;
import ua.com.alevel.StringHelperUtil;
import ua.com.alevel.TaskHelper;

import java.io.BufferedReader;
import java.io.IOException;

public class FirstMethodStarter implements TaskHelper {
    @Override
    public void run(BufferedReader reader) {

        String str;
        while (true) {

            System.out.print("Write words to revers: ");
            try {
                str = reader.readLine();

                if (StringUtils.isBlank(str)) {
                    System.out.println("String is not valid. Try again");
                    continue;
                }
                String rsl = StringHelperUtil.reverse(str);
                System.out.println("Result is: " + rsl);
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
