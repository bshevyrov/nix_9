package ua.com.alevel;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StartExceptionApp {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ConsoleHelper consoleHelper = new ConsoleHelper();
        SomeClassThatIRenameLater sC = new SomeClassThatIRenameLater();

        System.out.println(sC.monthIsNumber("/5/47 00:24:00:000","date"));
        System.out.println(sC.monthIsString("1256 14:59","date"));
        System.out.println(sC.monthIsNumber("11//2286","month"));
        System.out.println(sC.monthIsNumber("11/1/2286","month"));

        System.out.println(sC.monthIsNumber("/2/ :2","date"));
        System.out.println(sC.monthIsNumber("1/11/2286","date"));
        System.out.println(sC.monthIsNumber("11//2286","month"));
        System.out.println(sC.monthIsNumber("11/1/2286","month"));
//        System.out.println(sC.monthIsNumber("2//"));
//        System.out.println(sC.monthIsNumber("2/1/0"));
//        System.out.println(sC.monthIsNumber("1/2/0"));
        System.out.println("~~~~~~~~");
       /* System.out.println(sC.monthFirstFormat("11/20/2286"));
        System.out.println(sC.dateFirstFormat("20/11/2286"));
       System.out.println(sC.stringMonthFirstFormat("Ноябрь 20 2286"));*/

//        System.out.println(sC.stringMonthWithTimeFormat("11 ноябрь 2286 00:00:00:000"));

    }
}
