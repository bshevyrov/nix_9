package ua.com.alevel;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StartExceptionApp {
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
     public void chooseFormat(BufferedReader reader) {
        while (true) {
            ScreenMenu.clearConsole();
            System.out.println("Привет, выбери формат ввода:");
            System.out.println("1. dd/mm/yy - 01/12/21");
            System.out.println("2. m/d/yyyy - 3/4/2021");
            System.out.println("3. mmm-d-yy - Март 4 21");
            System.out.println("4. dd-mmm-yyyy 00:00 - 09 Апрель 789 45:23");
            System.out.print("Введи цифру:");
            try {
                int input = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException e) {
                System.out.println("Ты ввел не цифру повтори");
            } catch (IOException e) {
                System.out.println("Ошибка ввода вывода.");
            }
        }
}

    }
}
