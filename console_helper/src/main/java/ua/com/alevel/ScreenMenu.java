package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ScreenMenu {

    private ScreenMenu() {
    }

    public static void run(ArrayList<TaskHelper> taskHelpers, ArrayList<String> descriptions) throws IOException {
       addExitTaskAndDescription(taskHelpers, descriptions);

        System.out.println("MENU: ");
        for (int i = 0; i < taskHelpers.size(); i++) {
            System.out.println(i + ". " + descriptions.get(i));
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(bufferedReader.readLine());
        taskHelpers.get(input).run(bufferedReader);

    }
    private static void addExitTaskAndDescription(ArrayList<TaskHelper> taskHelpers, ArrayList<String> descriptions) {
        descriptions.add(descriptions.size(), "Press me if you want to exit");
        taskHelpers.add(taskHelpers.size() , reader -> {
            System.out.println("Thank You and Good Bye");
            System.exit(0);
        });
    }

}
