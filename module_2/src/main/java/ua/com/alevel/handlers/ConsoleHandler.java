package ua.com.alevel.handlers;

import org.apache.commons.lang3.StringUtils;
import ua.com.alevel.firstlevel.DatesList;
import ua.com.alevel.secondlevel.UniqNameFinder;
import ua.com.alevel.thirdlevel.Logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHandler {

    private static final File dates = new File("src/main/resources/dates.txt");
    private static final File names = new File("src/main/resources/names.txt");
    private static final File input = new File("src/main/resources/input.txt");
    private static final File output = new File("src/main/resources/output.txt");

     public static void startConsole() {
        while (true) {
            System.out.println("");
            System.out.println("Привет!!!");
            System.out.println("Все файлы лежат в ресурсах");
            System.out.println("На экран будут выведены входящие данные, в первых двух заданиях");
            System.out.println("Третье задание  молчаливо пишется в файл");
            System.out.println("1. Переформатирование даты");
            System.out.println("2. Нахождение уникальной строки");
            System.out.println("3. Самый короткий путь");
            System.out.println("0. Выход");
            System.out.print("Сделай свой выбор:");

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                String inputStr = reader.readLine();
                if (!StringUtils.isNumeric(inputStr)) {
                    System.out.println("Не цифра введена, попробуй еще");
                    continue;
                }
                int inputNum = Integer.parseInt(inputStr);
                switch (inputNum) {
                    case 0 -> System.exit(0);
                    case 1 -> new DatesList().separateStringByOneEntry(FileHandler.readStringsFromFile(dates));
                    case 2 -> new UniqNameFinder().findUniqString(FileHandler.readStringsFromFile(names));
                    case 3 -> FileHandler.writeToFile(
                            output,
                            new Logic().findEasyWay(
                                    FileHandler.readStringsFromFile(input)));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
