package ua.com.alevel;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StartExceptionApp {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ConsoleHelper consoleHelper = new ConsoleHelper();
        SomeClassThatIRenameLater sC = new SomeClassThatIRenameLater();
        System.out.println(sC.isLeapYear(1));
        System.out.println(sC.isLeapYear(2));
        System.out.println(sC.isLeapYear(3));
        System.out.println(sC.isLeapYear(4));
        System.out.println(sC.dateFirstFormat("11/12/2222"));

    }
}
