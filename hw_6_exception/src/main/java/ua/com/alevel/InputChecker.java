package ua.com.alevel;

import org.apache.commons.lang3.StringUtils;
import ua.com.alevel.exceptions.BlankDate;
import ua.com.alevel.exceptions.IllegalDateNumbers;
import ua.com.alevel.exceptions.IllegalDateType;

public class InputChecker {
    private static SomeClassThatIRenameLater sC = new SomeClassThatIRenameLater();

    public checkFormat(int type, String str) {
        switch (type) {

//            dd/mm/yy
            case 1:
                break;
            case 2:
                break;

            case 3:
                break;

            case 4:
                break;

        }
    }


    private boolean dateSlashFormatCheck(String str) throws BlankDate, IllegalDateType, IllegalDateNumbers {
        int countOfSeparator = StringUtils.countMatches(str, "/");
        int dateTimeSeparatorIndex = StringUtils.indexOf(str, " ");

        if (dateTimeSeparatorIndex > 1) {
            throw new IllegalDateType("Пробелов больше чем надо");
        }
        String date = StringUtils.substring(str, 0, StringUtils.indexOf(str, " "));
        String time = StringUtils.substring(str, StringUtils.indexOf(str, " ") + 1);


        if (countOfSeparator < 2) {
            throw new IllegalDateType("Дата должна соответствовать формату dd/mm/yyyy");
        }
        if (str.length() < 3) {
            throw new BlankDate("Дата не может быть пустая");
        }
        String day = StringUtils.substring(date, 0, StringUtils.indexOf(str, "/"));
        String month = StringUtils.substring(date, StringUtils.indexOf(str, "/") + 1, StringUtils.lastIndexOf(str, "/"));
        String year = StringUtils.substring(date, StringUtils.lastIndexOf(str, "/") + 1);
        if (!StringUtils.isBlank(day)) {
            if (!StringUtils.isNumeric(day)) {
                throw new IllegalDateType("День должен быть числом");
            }
        }
        if (!StringUtils.isBlank(month)) {
            if (!StringUtils.isNumeric(month)) {
                throw new IllegalDateType("Месяц должен быть числом");
            }
        }
        if (!StringUtils.isBlank(year)) {
            if (!StringUtils.isNumeric(year)) {
                throw new IllegalDateType("Год должен быть числом");
            }
        }
        if (Integer.parseInt(day) < 1
                || Integer.parseInt(day) >
                sC.monthInDays(Integer.parseInt(month),
                        Integer.parseInt(year))) {
            throw new IllegalDateNumbers("Неверное количество дней");

        }
        if (Integer.parseInt(month) < 1 || Integer.parseInt(month) > 12) {
            throw new IllegalDateNumbers("Неверное количество месяцев");

        }
        if (Integer.parseInt(year) < 0 || Integer.parseInt(year) > 9999) {
            throw new IllegalDateNumbers("Неверное количество месяцев");

        }
        if (dateTimeSeparatorIndex == 1) {
            int countOfSeparatorTime = StringUtils.countMatches(str, ":");
            if (countOfSeparatorTime > 3) {
                throw new IllegalDateType("Разделителей времени много");
            }
            if (countOfSeparatorTime = 1) {
            }
            if (countOfSeparatorTime = 2) {
            }
            if (countOfSeparatorTime = 3) {
            }

        }

    }
}
