package ua.com.alevel;

import ua.com.alevel.helper.FirstMethodStarter;
import ua.com.alevel.helper.SecondMethodStarter;
import ua.com.alevel.helper.ThirdMethodStarter;

import java.io.IOException;
import java.util.ArrayList;

public class StartApp {
    public static void main(String[] args) {

        ArrayList<TaskHelper> taskHelpers = new ArrayList<>();
        ArrayList<String> descriptions = new ArrayList<>();

        taskHelpers.add(new FirstMethodStarter());
        descriptions.add("I can revers word or words separated by space ");
        taskHelpers.add((new SecondMethodStarter()));
        descriptions.add("I can revers  subString  from  word.");
        taskHelpers.add((new ThirdMethodStarter()));
        descriptions.add("I can revers part of words nearest to the diapason");
        try {
            ScreenMenu.run(taskHelpers, descriptions);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
