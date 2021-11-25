package ua.com.alevel;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;


public class SomeClassThatIRenameLater {

  /*  private long fistDate ;
    private int action = 0;
    private long[] lastDates;

*/

    //    private static final long MS_IN_YEAR = 31_536_000_000L;
//    private static final long MS_IN_MONTH = 2_592_000_000L;
    private static final long MS_IN_DAY = 86_400_000L;
    private static final long MS_IN_HOUR = 3_600_000L;
    private static final long MS_IN_MINUTE = 60_000L;
    private static final long MS_IN_SEC = 1_000L;


    private int defineFormatOfDate(String date) {

        return 0;
    }

    private int[] convertFromMillieSecondsToDate(long ms) {
        return new int[]{0};
    }

    private long convertFromDateToMillieSeconds(int[] date) {
        return 0;
    }

    private boolean isDateWithTime(String date) {
        return date.contains(" ");
    }

    public boolean isDateWithString(String date) {
        boolean rsl = false;
        char[] dateByChars = date.toCharArray();
        for (char dateByChar : dateByChars) {
            if (StringUtils.isAlpha(String.valueOf(dateByChar))) {
                rsl = true;
            }
        }
        return rsl;
    }

    public long createLongDateFromStringAndType(String str, int type) {
        long dateInMs = 0;
        switch (type) {
            case 1:
                dateInMs = dateFirstFormat(str);
                break;
            case 2:
                dateInMs = monthFirstFormat(str);
                break;
            case 3:
                dateInMs = stringMonthFirstFormat(str);
                break;
            case 4:
                dateInMs = stringMonthWithTimeFormat(str);
                break;
        }

        return dateInMs;
    }

    private long stringMonthWithTimeFormat(String str) {
    }

    public long stringMonthFirstFormat(String str) {
        Scanner scanner = new Scanner(str);
        scanner.useDelimiter(" ");
        //минус 1 потому что мы еше не закончили этот день месяц год.
        // и по факту 1 января 1 года в милисекундах есть только количество часов или минут или дней
        String month = scanner.next();
        int day = Integer.parseInt(scanner.next()) - 1;
        int year = Integer.parseInt(scanner.next());
        //минус 1 месяц тут. ибо от строки не отнимешь
        return (day + monthInDays(stringMonthToNumberValue(month)-1, year) + yearInDays(year)) * MS_IN_DAY;
    }

    public long monthFirstFormat(String str) {
        Scanner scanner = new Scanner(str);
        scanner.useDelimiter("/");
        //минус 1 потому что мы еше не закончили этот день месяц год.
        // и по факту 1 января 1 года в милисекундах есть только количество часов или минут или дней
        int month = Integer.parseInt(scanner.next()) - 1;
        int day = Integer.parseInt(scanner.next()) - 1;
        int year = Integer.parseInt(scanner.next());
        return (day + monthInDays(month, year) + yearInDays(year)) * MS_IN_DAY;
    }

    public long dateFirstFormat(String str) {
        Scanner scanner = new Scanner(str);
        scanner.useDelimiter("/");
        //минус 1 потому что мы еше не закончили этот день месяц год.
        // и по факту 1 января 1 года в милисекундах есть только количество часов или минут или дней
        int day = Integer.parseInt(scanner.next()) - 1;
        int month = Integer.parseInt(scanner.next()) - 1;
        int year = Integer.parseInt(scanner.next());
        return (day + monthInDays(month, year) + yearInDays(year)) * MS_IN_DAY;
    }

    public boolean isLeapYear(int year) {
        return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
    }

    public int yearInDays(int year) {
        int sumOfDays = 0;
        for (int i = 1; i <= year; i++) {
            if (isLeapYear(i)) {
                sumOfDays += 366;
            } else {
                sumOfDays += 365;
            }
        }
        return sumOfDays;
    }

   /* private int monthInDays(String month, int year) {
        month = month.toLowerCase();
        return switch (month) {
            case "январь", "март", "май", "июль", "август", "октябрь", "декабрь" -> 31;
            case "апрель", "июнь", "сентябрь", "ноябрь" -> 30;
            case "февраль" -> isLeapYear(year) ? 29 : 28;
            default -> 0;
        };
    }*/

    private int monthInDays(int monthNum, int year) {
        return switch (monthNum) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> isLeapYear(year) ? 29 : 28;
            default -> 0;
        };
    }

    private int stringMonthToNumberValue(String month) {
        int rsl =0;
        month = month.toLowerCase();
        switch (month) {
            case "январь":
                rsl = 1;
                break;
            case "февраль":
                rsl = 2;
                break;
            case "март":
                rsl = 3;
                break;
            case "апрель":
                rsl = 4;
                break;
            case "май":
                rsl = 5;
                break;
            case "июнь":
                rsl = 6;
                break;
            case "июль":
                rsl = 7;
                break;
            case "август":
                rsl = 8;
                break;
            case "сентябрь":
                rsl = 9;
                break;
            case "октябрь":
                rsl = 10;
                break;
            case "ноябрь":
                rsl = 11;
                break;
            case "декабрь":
                rsl = 12;
                break;
        }
        return rsl;
    }
    public boolean isCyrillic(String str) {
        boolean rsl=true;
        for (char c : str.toCharArray()) {
            System.out.println(rsl);
            if((int)c>1103||(int)c<1040) {
                rsl = false;
            }
        }
      return rsl;
    }
//    private int monthInDays(String month){
//
//    }
}

