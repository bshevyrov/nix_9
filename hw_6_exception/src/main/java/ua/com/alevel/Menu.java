package ua.com.alevel;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Menu {
HashMap<String,String> menuInput = new HashMap<>();
    public void chooseFormat(BufferedReader reader) {
        int inputFormatNum = -1;
        while (true) {
            ScreenMenu.clearConsole();
            System.out.println("Привет, выбери формат ввода:");
            System.out.println("1. dd/mm/yy - 01/12/21");
            System.out.println("2. m/d/yyyy - 3/4/2021");
            System.out.println("3. mmm-d-yy - Март 4 21");
            System.out.println("4. dd-mmm-yyyy 00:00 - 09 Апрель 789 45:23");
            System.out.print("Введи цифру:");
            try {
                inputFormatNum = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException e) {
                System.out.println("Ты ввел не цифру повтори");
                continue;
            } catch (IOException e) {
                System.out.println("Ошибка ввода вывода.");
                continue;
            }
            if (inputFormatNum < 1 || inputFormatNum > 4) {
                System.out.println("Введена не верная цифра");
                continue;
            }
            break;
        }
        inputFistOperandInput(reader,inputFormatNum);
       // return inputFormat;
    }

    public String inputFistOperandInput(BufferedReader reader, int inputFormat ) {
        String input = "";
        while (true) {
            ScreenMenu.clearConsole();
            System.out.println("Введи первую дату в указанном формате");
            // TODO пказать формат

            System.out.print("Введи дату:");
            //TODO обработатьб формат чтобы был тот
            try {
                input = reader.readLine();
            } catch (IOException e) {
                System.out.println("Ошибка ввода вывода.");
                continue;
            }
            break;
        }
        return input;

    }

    public int operationWhatDo(BufferedReader reader) {
        int input = -1;
        while (true) {
            ScreenMenu.clearConsole();
            System.out.println("Выбери операцию какую хочешь сделать");
            System.out.println("1. Находить разницу между датами в миллисекундах, секундах, минутах, часах, днях и годах;");
            System.out.println("2. Прибавлять к дате миллисекунды, секунды, минуты, часы, дни и года;");
            System.out.println("3. Вычитать из даты миллисекунды, секунды, минуты, часы, дни и года;");
            System.out.println("4. Сравнивать перечень дат по убыванию и возрастанию;");
            System.out.print("Введи цифру:");
            try {
                input = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException e) {
                System.out.println("Ты ввел не цифру повтори");
                continue;
            } catch (IOException e) {
                System.out.println("Ошибка ввода вывода.");
                continue;
            }
            if (input < 1 || input > 4) {
                System.out.println("Введена не верная цифра");
                continue;
            }
            break;
        }
        return input;
    }

    public LinkedList<String> secondOperandsInput(BufferedReader reader) {
        LinkedList<String> inputs = new LinkedList<>();
        String inputMore;
        ScreenMenu.clearConsole();
        while (true) {
            System.out.print("Введи дату:");
            try {
                inputs.add(reader.readLine());
            } catch (IOException e) {
                System.out.println("Ошибка ввода вывода.");
                continue;
            }
            //TODO вывести режим и если 4  то продолжаем
            System.out.println("Если хочешь ввести еще дату введи 0");
            try {
                 inputMore= reader.readLine();
            } catch (IOException e) {
                System.out.println("Ошибка ввода вывода.");
                continue;            }
            if (StringUtils.isNumeric(inputMore)&&Integer.parseInt(inputMore)==0){
                continue;
            }
                break;
        }
        return inputs;
    }
    public void result(){

    }

}
