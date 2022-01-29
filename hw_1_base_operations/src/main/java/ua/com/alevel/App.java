package ua.com.alevel;

import ua.com.alevel.first.First;
import ua.com.alevel.second.Second;
import ua.com.alevel.third.Third;

import java.io.IOException;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        int id = 191;
        for (int i = 41; i <61 ; i++) {
            System.out.println("INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id) VALUES ("+(id++)+", 'FIRST_CLASS', "+i+", 5);");
        }






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
