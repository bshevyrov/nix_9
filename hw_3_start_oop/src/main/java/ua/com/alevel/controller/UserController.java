package ua.com.alevel.controller;

import ua.com.alevel.entity.User;
import ua.com.alevel.service.UserService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class UserController {
    private final UserService userService = new UserService();

    public void run() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        System.out.println();
        System.out.println("Greetings, my friend!!!");

        try {
            runNavigation();
            while ((input = bufferedReader.readLine()) != null) {
                crud(input, bufferedReader);
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

    private void crud(String position, BufferedReader reader) {
        //todo hardcode ;(((
        switch (position) {
            case "1" -> create(reader);
            case "2" -> update(reader);
            case "3" -> delete(reader);
            case "4" -> findById(reader);
            case "5" -> findAll();
            case "0" -> System.exit(0);
        }

        runNavigation();
    }

    private void findAll() {
        List<User> userList = userService.findAll();
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
        int age = 0;


        try {
            System.out.print("Id: ");
            id = reader.readLine();
            System.out.print("Name: ");
            name = reader.readLine();
            System.out.print("Age: ");
            age = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        userService.update(user);

    }


    private void create(BufferedReader reader) {

        String name = "";
        int age = 0;

        try {
            System.out.print("Name: ");
            name = reader.readLine();
            System.out.print("Age: ");
            age = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        User user = new User();
        user.setName(name);
        user.setAge(age);
        userService.create(user);

    }
}
