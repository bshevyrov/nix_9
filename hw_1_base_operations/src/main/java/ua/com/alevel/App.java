package ua.com.alevel;

import ua.com.alevel.first.First;
import ua.com.alevel.second.Second;
import ua.com.alevel.third.Third;

import java.io.IOException;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<String> descriptions = new ArrayList<>();
        ArrayList<TaskHelper> taskHelpers = new ArrayList<>();
        descriptions.add("I can sum all number in a string");
        taskHelpers.add(new First());
        descriptions.add("I can count how many each letters in a string");
        taskHelpers.add(new Second());
        descriptions.add("I can show you when 1 to 10 lesson is end");
        taskHelpers.add(new Third());
        ScreenMenu.addExitTaskAndDescription(taskHelpers,descriptions);
        try {
            while(true) {
                ScreenMenu.run(taskHelpers, descriptions);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
