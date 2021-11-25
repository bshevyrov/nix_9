package ua.com.alevel;

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
        return year;
    }
/*

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
    public long createLongDateFromStringAndType(String str, int type){
        long dateInMs=0;
        switch (type){
            case 1:dateInMs=dateFirstFormat(str);
                break;
            case 2:dateInMs=monthFirstFormat(str);
                break;
            case 3:dateInMs=stringMonthFormat(str);
                break;
            case 4:dateInMs=stringMonthWithTimeFormat(str);
                break;
        }

        return 0;
    }
*/

    public long dateFirstFormat(String str) {
        Scanner scanner = new Scanner(str);
        scanner.useDelimiter("/");
        int day = Integer.parseInt(scanner.next());
        int month = Integer.parseInt(scanner.next());
        int year = Integer.parseInt(scanner.next());

//TODO ВЫчести 1 месяц тк мы его еще не закончили
        return (day * MS_IN_DAY) + monthInDays(month, year) + yearInDays(year);
    }

    private int monthInDays(String month, int year) {
        month = month.toLowerCase();
        return switch (month) {
            case "январь", "март", "май", "июль", "август", "октябрь", "декабрь" -> 31;
            case "апрель", "июнь", "сентябрь", "ноябрь" -> 30;
            default -> isLeapYear(year) ? 29 : 28;
        };
    }

    private int monthInDays(int monthNum, int year) {
        return switch (monthNum) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            default -> isLeapYear(year) ? 29 : 28;
        };

    }
//    private int monthInDays(String month){
//
//    }
}

