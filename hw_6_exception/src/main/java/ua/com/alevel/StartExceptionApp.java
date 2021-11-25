package ua.com.alevel;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StartExceptionApp {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ConsoleHelper consoleHelper = new ConsoleHelper();
        SomeClassThatIRenameLater sC = new SomeClassThatIRenameLater();

        System.out.println(sC.dateFirstFormat("20/11/2286"));
        System.out.println(sC.monthFirstFormat("11/20/2286"));
        System.out.println(sC.stringMonthFirstFormat("Ноябрь 20 2286"));


    }
}
