package ua.com.alevel;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;

public class ConsoleHelper {

    public void greetings(BufferedReader reader){
        ScreenMenu.clearConsole();
        System.out.println("Привет %ЮзерНейь%!");
        System.out.println("Давай поиграем в Календарь!");

    }

    public void inputFirstDate(BufferedReader reader){
        ScreenMenu.clearConsole();
        System.out.println("Введи дату в указаном формате :");

    }

    public void whatActionToDo(BufferedReader reader){
        ScreenMenu.clearConsole();
        System.out.println("1. Находить разницу между датами в миллисекундах, секундах, минутах, часах, днях и годах?");
        System.out.println("2. Прибавлять к дате миллисекунды, секунды, минуты, часы, дни и года?");
        System.out.println("3. Вычитать из даты миллисекунды, секунды, минуты, часы, дни и года?");
        System.out.println("4. Сравнивать перечень дат по убыванию и возрастанию?");
        System.out.println("");
    }
    public void inputLastDate(BufferedReader reader){
        ScreenMenu.clearConsole();
        System.out.println("Введи дату в указаном формате :");
        System.out.println("Введи дату в указаном формате :");

    }
    public void chooseFormat(BufferedReader reader){
        System.out.println("Выбери формат даты:");
        System.out.println("1. dd/mm/yyyy");
        System.out.println("2. m/d/yyyy");
        System.out.println("3. mmm-d-yyyy");
        System.out.println("4. dd-mmm-yyyy 00:00:000");
        System.out.println("");
    }

    public void chooseTypeOfDifference(){

    }

}
