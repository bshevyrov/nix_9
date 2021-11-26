package ua.com.alevel;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StartExceptionApp {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ConsoleHelper consoleHelper = new ConsoleHelper();
        SomeClassThatIRenameLater sC = new SomeClassThatIRenameLater();

        System.out.println(sC.dateFirstFormat("/11/2286"));
        System.out.println(sC.dateFirstFormat("1/11/2286"));
        System.out.println(sC.monthFirstFormat("11/1/2286"));
        System.out.println(sC.dateFirstFormat("2//"));
        System.out.println(sC.dateFirstFormat("2/1/0"));
        System.out.println(sC.monthFirstFormat("1/2/0"));
        System.out.println("~~~~~~~~");
        System.out.println(sC.monthFirstFormat("11/20/2286"));
        System.out.println(sC.dateFirstFormat("20/11/2286"));
       System.out.println(sC.stringMonthFirstFormat("Ноябрь 20 2286"));

//        System.out.println(sC.stringMonthWithTimeFormat("11 ноябрь 2286 00:00:00:000"));

    }
}
