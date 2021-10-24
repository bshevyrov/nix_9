package ua.com.alevel.controller;

import org.apache.commons.lang3.StringUtils;
import ua.com.alevel.entity.User;
import ua.com.alevel.service.UserService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserController {
    private final UserService userService = new UserService();

    public void run() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int input;
        String str;
        System.out.println();
        System.out.println("Greetings, my friend!!!");

        try {
            runNavigation();
            while ((str = bufferedReader.readLine()) != null) {
                if (!StringUtils.isNumeric(str)) {
                    System.out.println("Only numbers allowed. Please try again");
                    continue;
                }
                input = Integer.parseInt(str);
                if (input < 0 || input > 5) {
                    System.out.println("Wrong number. Please try again");
                }
                crud(input, bufferedReader);
                //break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void runNavigation() {
        System.out.println();
        System.out.println("1. Create user");
        System.out.println("2. Update user");
        System.out.println("3. Delete user");
        System.out.println("4. Find user by id");
        System.out.println("5. Find all users");
        System.out.println("0. Exit Program");
        System.out.println();
        System.out.print("Please make your choose: ");
    }

    private void crud(int position, BufferedReader reader) {
        //todo hardcode ;(((
        switch (position) {
            case 1 -> create(reader);
            case 2 -> update(reader);
            case 3 -> delete(reader);
            case 4 -> findById(reader);
            case 5 -> findAll();
            case 0 -> System.exit(0);
        }
        runNavigation();
    }

    private void findAll() {
        User[] userList = userService.findAll();
        for (User user : userList) {
            System.out.println(user.toString());
        }
    }

    private void findById(BufferedReader reader) {
        String id = "";

        try {
            System.out.print("Id: ");
            id = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        User user = new User();
        user.setId(id);
        System.out.println(userService.findById(id));
    }

    private void delete(BufferedReader reader) {
        String id = "";

        try {
            System.out.print("Id: ");
            id = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        User user = new User();
        user.setId(id);
        userService.delete(id);
    }

    private void update(BufferedReader reader) {
        String id = "";
        String name = "";
        String tempAge;
        int age = 0;

        while (true) {
            try {
                System.out.print("Id: ");
                id = reader.readLine();
                System.out.print("Name: ");
                name = reader.readLine();
                if (!StringUtils.isAlpha(name)) {
                    System.out.println("Name must contain only letters. Please try again");
                    continue;
                }
                System.out.print("Age: ");
                tempAge = reader.readLine();
                if (!StringUtils.isNumeric(tempAge)) {
                    System.out.println("Age must contain only numbers. Please try again");
                    continue;
                }
                age = Integer.parseInt(tempAge);
                if (age <= 0 || age > 120) {
                    System.out.println("Allowed age from 1 to 120. Please try again");
                    continue;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            User user = new User();
            user.setId(id);
            user.setName(name);
            user.setAge(age);
            userService.update(user);
            break;
        }
    }


    private void create(BufferedReader reader) {

        String name = "";
        String tempAge;
        int age = 0;
        while (true) {
            try {
                System.out.print("Name: ");
                name = reader.readLine();
                if (!StringUtils.isAlpha(name)) {
                    System.out.println("Only letters allowed. Please try again");
                    continue;
                }
                System.out.print("Age: ");
                tempAge = reader.readLine();
                if (!StringUtils.isNumeric(tempAge)) {
                    System.out.println("Only numbers allowed. Please try again");
                    continue;
                }
                age = Integer.parseInt(tempAge);
                if (age <= 0 || age > 120) {
                    System.out.println("Allowed age from 1 to 120. Please try again");
                    continue;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            User user = new User();
            user.setName(name);
            user.setAge(age);
            userService.create(user);
            break;
        }

    }
}
