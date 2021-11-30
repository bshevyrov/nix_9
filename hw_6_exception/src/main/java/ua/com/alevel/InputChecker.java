package ua.com.alevel;

import org.apache.commons.lang3.StringUtils;
import ua.com.alevel.exceptions.BlankDate;
import ua.com.alevel.exceptions.IllegalDateNumbers;
import ua.com.alevel.exceptions.IllegalDateType;
import ua.com.alevel.exceptions.IllegalTimeNumbers;

import java.util.Locale;

public class InputChecker {

    //TODOпроверитьт на правильынй разедлитель
    //TODO рить что дата перед числом
    private static SomeClassThatIRenameLater sC = new SomeClassThatIRenameLater();

    public void checkFormat(int type, String str) throws IllegalDateType, IllegalTimeNumbers, BlankDate, IllegalDateNumbers {
        switch (type) {
            case 0:
                dateSlashFormatCheck(str);
                break;
            case 1:
                monthSlashFormatCheck(str);
                break;
            case 2:
                monthStringFormatCheck(str);
                break;
            case 3:
                daySpaceMonthStringFormatChecker(str);
                break;
        }
    }

    private void daySpaceMonthStringFormatChecker(String str) throws IllegalDateType, IllegalDateNumbers, IllegalTimeNumbers, BlankDate {
        int countOfSeparator = StringUtils.countMatches(str, " ");
        int dateTimeSeparator = StringUtils.indexOf(str, ":");
        if (countOfSeparator < 1) {
            throw new IllegalDateType("Не верное количество разделителей между датой");
        }
        String date = "";
        String time = "";
        if (dateTimeSeparator != -1) {
            date = StringUtils.substring(str, 0, StringUtils.lastIndexOf(str, " "));
            time = StringUtils.substring(str, StringUtils.lastIndexOf(str, " ") + 1);
        } else {
            date = str;
        }
        if (countOfSeparator < 2) {
            throw new IllegalDateType("В дате мало разделительных знаков");
        }
        if (str.length() < 3) {
            throw new BlankDate("Дата не может быть пустая");
        }
        String day = StringUtils.substring(date, 0, StringUtils.indexOf(str, " "));
        String month = StringUtils.substring(date, StringUtils.indexOf(str, " ") + 1, StringUtils.lastIndexOf(str, " "));
        String year = StringUtils.substring(date, StringUtils.lastIndexOf(str, " ") + 1);
        if (!StringUtils.isBlank(day)) {
            if (!StringUtils.isNumeric(day)) {
                throw new IllegalDateType("День должен быть числом");
            }
        }
        if (!StringUtils.isBlank(month)) {
            if (!sC.isCyrillic(month)) {
                throw new IllegalDateType("Месяц должен быть написан кириллицей");
            }
        }
        if (!StringUtils.equalsAny(month.toLowerCase(Locale.ROOT), "январь", "февраль",
                "март", "апрель", "май", "июнь", "июль", "август", "сентябрь",
                "октябрь", "ноябрь", "декабрь")) {
            throw new IllegalDateType("Название месяца введено не корректно.");
        }
        if (!StringUtils.isBlank(year)) {
            if (!StringUtils.isNumeric(year)) {
                throw new IllegalDateType("Год должен быть числом");
            }
        }
        if (Integer.parseInt(day) < 1
                || Integer.parseInt(day) >
                sC.monthInDays(sC.stringMonthToNumberValue(month),
                        Integer.parseInt(year))) {
            throw new IllegalDateNumbers("Неверное количество дней");
        }
        if (Integer.parseInt(year) < 0 || Integer.parseInt(year) > 9999) {
            throw new IllegalDateNumbers("Неверное количество месяцев");
        }
        if (dateTimeSeparator > 1) {
            timeChecker(time);
        }
    }

    private void monthStringFormatCheck(String str) throws IllegalDateType, BlankDate, IllegalDateNumbers, IllegalTimeNumbers {
        int countOfSeparator = StringUtils.countMatches(str, " ");
        if (countOfSeparator != 2) {
            throw new IllegalDateType("Не верное количество раделителей между датой");
        }
        String date = str;
        String month = StringUtils.substring(date, 0, StringUtils.indexOf(str, " "));
        String day = StringUtils.substring(date, StringUtils.indexOf(str, " ") + 1, StringUtils.lastIndexOf(str, " "));
        String year = StringUtils.substring(date, StringUtils.lastIndexOf(str, " ") + 1);
        if (!StringUtils.isBlank(day)) {
            if (!StringUtils.isNumeric(day)) {
                throw new IllegalDateType("День должен быть числом");
            }
        }
        if (!sC.isCyrillic(month)) {
            throw new IllegalDateType("Месяц должен быть написан кириллицей");
        }
        if (!StringUtils.equalsAny(month.toLowerCase(Locale.ROOT), "январь", "февраль",
                "март", "апрель", "май", "июнь", "июль", "август", "сентябрь",
                "октябрь", "ноябрь", "декабрь")) {
            throw new IllegalDateType("Название месяца введено не корректно");
        }
        if (!StringUtils.isBlank(year)) {
            if (!StringUtils.isNumeric(year)) {
                throw new IllegalDateType("Год должен быть числом");
            }
        }
        if (Integer.parseInt(day) < 1
                || Integer.parseInt(day) >
                sC.monthInDays(sC.stringMonthToNumberValue(month),
                        Integer.parseInt(year))) {
            throw new IllegalDateNumbers("Неверное количество дней");
        }
        if (Integer.parseInt(year) < 0 || Integer.parseInt(year) > 9999) {
            throw new IllegalDateNumbers("Неверное количество месяцев");
        }
    }

    private void monthSlashFormatCheck(String str) throws IllegalDateType, BlankDate, IllegalDateNumbers, IllegalTimeNumbers {
        int countOfSeparator = StringUtils.countMatches(str, "/");
        int dateTimeSeparatorIndex = StringUtils.indexOf(str, " ");
        if (dateTimeSeparatorIndex > 1) {
            throw new IllegalDateType("Пробелов больше чем надо");
        }
        String date = StringUtils.substring(str, 0, StringUtils.indexOf(str, " "));
        String time = " ";
        if (dateTimeSeparatorIndex == 1) {
            time = StringUtils.substring(str, StringUtils.indexOf(str, " ") + 1);
        }
        if (countOfSeparator < 2) {
            throw new IllegalDateType("В дате мало разделительных знаков");
        }
        if (str.length() < 3) {
            throw new BlankDate("Дата не может быть пустая");
        }
        String month = StringUtils.substring(date, 0, StringUtils.indexOf(str, "/"));
        String day = StringUtils.substring(date, StringUtils.indexOf(str, "/") + 1, StringUtils.lastIndexOf(str, "/"));
        String year = StringUtils.substring(date, StringUtils.lastIndexOf(str, "/") + 1);
        if (!StringUtils.isBlank(month)) {
            if (!StringUtils.isNumeric(month)) {
                throw new IllegalDateType("Месяц должен быть числом");
            }
        }
        if (!StringUtils.isBlank(day)) {
            if (!StringUtils.isNumeric(day)) {
                throw new IllegalDateType("День должен быть числом");
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
            timeChecker(time);
        }
    }

    private void dateSlashFormatCheck(String str) throws BlankDate, IllegalDateType, IllegalDateNumbers, IllegalTimeNumbers {
        int countOfSeparator = StringUtils.countMatches(str, "/");
        int dateTimeSeparatorIndex = StringUtils.indexOf(str, " ");
        if (dateTimeSeparatorIndex > 1) {
            throw new IllegalDateType("Пробелов больше чем надо");
        }
        String date = str;
        String time = " ";
        if (dateTimeSeparatorIndex == 1) {
            date = StringUtils.substring(str, 0, StringUtils.indexOf(str, " "));
            time = StringUtils.substring(str, StringUtils.indexOf(str, " ") + 1);
        }
        if (countOfSeparator < 2) {
            throw new IllegalDateType("В дате мало разделительных знаков");
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
        if (Integer.parseInt(month) < 1 || Integer.parseInt(month) > 12) {
            throw new IllegalDateNumbers("Неверное количество месяцев");
        }
        if (Integer.parseInt(day) < 1
                || Integer.parseInt(day) >
                sC.monthInDays(Integer.parseInt(month),
                        Integer.parseInt(year))) {
            throw new IllegalDateNumbers("Неверное количество дней");
        }
        if (Integer.parseInt(year) < 0 || Integer.parseInt(year) > 9999) {
            throw new IllegalDateNumbers("Неверное количество месяцев");
        }
        if (dateTimeSeparatorIndex == 1) {
            timeChecker(time);
        }
    }

    private void timeChecker(String time) throws IllegalTimeNumbers, IllegalDateType {
        int countOfSeparatorTime = StringUtils.countMatches(time, ":");
        if (countOfSeparatorTime > 3) {
            throw new IllegalDateType("Разделителей времени много");
        }
        if (countOfSeparatorTime == 1) {
            String hour = StringUtils.substring(time, 0, StringUtils.indexOf(time, ":"));
            String minute = StringUtils.substring(time, StringUtils.indexOf(time, ":") + 1);
            checkHourAndMinutes(hour, minute);
        }
        if (countOfSeparatorTime == 2) {
            String hour = StringUtils.substring(time, 0, StringUtils.indexOf(time, ":"));
            String minute = StringUtils.substring(time, StringUtils.indexOf(time, ":") + 1, StringUtils.lastIndexOf(time, ":"));
            String sec = StringUtils.substring(time, StringUtils.lastIndexOf(time, ":") + 1);
            checkHourAndMinutes(hour, minute);
            checkHourAndMinutesAndSec(sec);
        }
        if (countOfSeparatorTime == 3) {
            String hour = StringUtils.substring(time, 0, StringUtils.indexOf(time, ":"));
            time = StringUtils.substring(time, StringUtils.indexOf(time, ":") + 1);
            String minute = StringUtils.substring(time, 0, StringUtils.indexOf(time, ":"));
            time = StringUtils.substring(time, StringUtils.indexOf(time, ":") + 1);
            String sec = StringUtils.substring(time, 0, StringUtils.indexOf(time, ":"));
            String ms = StringUtils.substring(time, StringUtils.lastIndexOf(time, ":") + 1);
            checkHourAndMinutes(hour, minute);
            checkHourAndMinutesAndSec(sec);
            checkHourAndMinutesAndSecAndMs(ms);
        }
    }

    private void checkHourAndMinutesAndSecAndMs(String ms) throws IllegalTimeNumbers {
        if (!StringUtils.isNumeric(ms)) {
            throw new IllegalTimeNumbers("Неверные символы времени");
        }
        if (ms.length() < 1 || ms.length() > 3) {
            throw new IllegalTimeNumbers("Неверное количество символов времени");
        }
        if (Integer.parseInt(ms) < 0 || Integer.parseInt(ms) > 999) {
            throw new IllegalTimeNumbers("Обозначение часов вне рамок земного времени");
        }
    }

    private void checkHourAndMinutesAndSec(String sec) throws IllegalTimeNumbers {
        if (!StringUtils.isNumeric(sec)) {
            throw new IllegalTimeNumbers("Неверные символы времени");
        }
        if (sec.length() < 1 || sec.length() > 2) {
            throw new IllegalTimeNumbers("Неверное количество символов времени");
        }
        if (Integer.parseInt(sec) < 0 || Integer.parseInt(sec) > 59) {
            throw new IllegalTimeNumbers("Обозначение часов вне рамок земного времени");
        }
    }

    private void checkHourAndMinutes(String hour, String minute) throws IllegalTimeNumbers {
        if (!StringUtils.isNumeric(hour) || !StringUtils.isNumeric(minute)) {
            throw new IllegalTimeNumbers("Неверные символы времени");
        }
        if ((hour.length() < 1 || minute.length() < 1) || ((hour.length() > 2 || minute.length() > 2))) {
            throw new IllegalTimeNumbers("Неверное количество символов времени");
        }
        if (Integer.parseInt(hour) < 0 || Integer.parseInt(hour) > 24) {
            throw new IllegalTimeNumbers("Обозначение часов вне рамок земного времени");
        }
        if (Integer.parseInt(minute) < 0 || Integer.parseInt(hour) > 59) {
            throw new IllegalTimeNumbers("Неверное количество минут");
        }
    }
}
