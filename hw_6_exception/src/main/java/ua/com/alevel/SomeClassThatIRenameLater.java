package ua.com.alevel;

import org.apache.commons.lang3.StringUtils;


public class SomeClassThatIRenameLater {

  /*  private long fistDate ;
    private int action = 0;
    private long[] lastDates;

*/

    //    private static final long MS_IN_YEAR = 31_536_000_000L;
//    private static final long MS_IN_MONTH = 2_592_000_000L;
    private static final long MS_IN_DAY = 86_400_000L;
    // private static final long MS_IN_HOUR = 3_600_000L;
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

    //TODO если StringUtils.INDEX_NOT_FOUND : то без времени
    public long stringMonthWithTimeFormat(String str) {
        int indexOfSpaceBetweenDateAndTime = StringUtils.lastIndexOf(str, " ");
        //если разделитель пробел 1 то это только год
        if (StringUtils.indexOf(str, " ") == StringUtils.lastIndexOf(str, " ")) {
            long date = yearInDays(Integer.parseInt(str.substring(0, indexOfSpaceBetweenDateAndTime))) * MS_IN_DAY;
        } else { //если разделитель не один то это дата, месяц словом  и потом вркмя
            String dateString = str.substring(0, indexOfSpaceBetweenDateAndTime);
            String timeString = str.substring(indexOfSpaceBetweenDateAndTime + 1);
            long rsl = dayStringMonthYear(dateString) + time(timeString);
        }

        return 0;
    }

    public long time(String time) {
        long timeInMillieSeconds = 0;
        int countOfDelimiter = StringUtils.countMatches(time, ":");
        switch (countOfDelimiter) {
            case 1:
                timeInMillieSeconds = hoursAndMinutes(time);
                break;
            case 2:
                timeInMillieSeconds = hoursMinutAndSeconds(time);
                break;
            case 3:
                timeInMillieSeconds = hoursMinutSecondAndMillieSeconds(time);
        }
        return timeInMillieSeconds;
    }

    private long hoursAndMinutes(String time) {
        String hourStr = time.substring(0, StringUtils.indexOf(time, ":"));
        String minuteStr = time.substring(StringUtils.indexOf(time, ":" + 1));
        int hour = StringUtils.isBlank(hourStr) ? 0 : Integer.parseInt(hourStr);
        int minute = StringUtils.isBlank(minuteStr) ? 0 : Integer.parseInt(minuteStr);
        return (minute + (hour * 60L) * MS_IN_MINUTE);

    }

    public long hoursMinutAndSeconds(String time) {
        //todo вызвать предыдущий метод. передать туда сабстринг от нуля до ластДелиметр
        int firstDelimiter = StringUtils.indexOf(time, ":");
        int secondDelimiter = StringUtils.indexOf(time.substring(firstDelimiter + 1), ":");
        int lastDelimiter = StringUtils.lastIndexOf(time, ":");
        String hourStr = time.substring(0, firstDelimiter);
        String minuteStr = time.substring(secondDelimiter + 1, lastDelimiter);
        String secondStr = time.substring(lastDelimiter + 1);

        int hour = StringUtils.isBlank(hourStr) ? 0 : Integer.parseInt(hourStr);
        int minute = StringUtils.isBlank(minuteStr) ? 0 : Integer.parseInt(minuteStr);
        int second = StringUtils.isBlank(secondStr) ? 0 : Integer.parseInt(secondStr);
        return (minute + (hour * 60L) * MS_IN_MINUTE) + second * MS_IN_SEC;

    }

    public long hoursMinutSecondAndMillieSeconds(String time) {
        //todo вызвать предыдущий метод. передать туда сабстринг от нуля до ластДелиметр
        int firstDelimiter = StringUtils.indexOf(time, ":");
        int secondDelimiter = StringUtils.indexOf(time.substring(firstDelimiter + 1), ":");
        int thirdDelimiter = StringUtils.indexOf(time.substring(secondDelimiter + 1), ":");
        int lastDelimiter = StringUtils.lastIndexOf(time, ":");

        String hourStr = time.substring(0, firstDelimiter);
        String minuteStr = time.substring(secondDelimiter + 1, secondDelimiter);
        String secondStr = time.substring(secondDelimiter + 1, lastDelimiter);
        String millieSecondStr = time.substring(lastDelimiter + 1);

        int hour = StringUtils.isBlank(hourStr) ? 0 : Integer.parseInt(hourStr);
        int minute = StringUtils.isBlank(minuteStr) ? 0 : Integer.parseInt(minuteStr);
        int second = StringUtils.isBlank(secondStr) ? 0 : Integer.parseInt(secondStr);
        int millieSecond = StringUtils.isBlank(millieSecondStr) ? 0 : Integer.parseInt(millieSecondStr);

        return (minute + (hour * 60L) * MS_IN_MINUTE) + second * MS_IN_SEC + millieSecond;
    }

    public long dayStringMonthYear(String str) {
        return 0;
    }

    public long dateFirstFormat(String str) {
        int firstDelimiter = StringUtils.indexOf(str, "/");
        int lastDelimiter = StringUtils.lastIndexOf(str, "/");
        String dayStr = str.substring(0, firstDelimiter);
        String monthStr = str.substring(firstDelimiter + 1, lastDelimiter);
        String yearStr = str.substring(lastDelimiter + 1);
        //минус 1 потому что мы еше не закончили этот день месяц год.
        // и по факту 1 января 1 года в милисекундах есть только количество часов или минут или дней
        int day = StringUtils.isBlank(dayStr) ? 0 : Integer.parseInt(dayStr) - 1;
        int month = StringUtils.isBlank(monthStr) ? 0 : Integer.parseInt(monthStr) - 1;
        int year = StringUtils.isBlank(yearStr) ? 0 : Integer.parseInt(yearStr);
        return (day + monthInDays(month, year) + yearInDays(year)) * MS_IN_DAY;
    }

    public long monthFirstFormat(String str) {
        int firstDelimiter = StringUtils.indexOf(str, "/");
        int lastDelimiter = StringUtils.lastIndexOf(str, "/");
        String dayStr = str.substring(firstDelimiter + 1, lastDelimiter);
        String monthStr = str.substring(0, firstDelimiter);
        String yearStr = str.substring(lastDelimiter + 1);
        //минус 1 потому что мы еше не закончили этот день месяц год.
        // и по факту 1 января 1 года в милисекундах есть только количество часов или минут или дней
        int day = StringUtils.isBlank(dayStr) ? 0 : Integer.parseInt(dayStr) - 1;
        int month = StringUtils.isBlank(monthStr) ? 0 : Integer.parseInt(monthStr) - 1;
        int year = StringUtils.isBlank(yearStr) ? 0 : Integer.parseInt(yearStr);
        return (day + monthInDays(month, year) + yearInDays(year)) * MS_IN_DAY;
    }

    public long stringMonthFirstFormat(String str) {
        // Не полный ввод запрещен
        int firstDelimiter = StringUtils.indexOf(str, " ");
        int lastDelimiter = StringUtils.lastIndexOf(str, " ");
        String dayStr = str.substring(firstDelimiter + 1, lastDelimiter);
        String monthStr = str.substring(0, firstDelimiter);
        String yearStr = str.substring(lastDelimiter + 1);
        //минус 1 потому что мы еше не закончили этот день месяц год.
        // и по факту 1 января 1 года в милисекундах есть только количество часов или минут или дней
        int day = Integer.parseInt(dayStr) - 1;
        int month = stringMonthToNumberValue(monthStr) - 1;
        int year = Integer.parseInt(yearStr);
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
        int rsl = 0;
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
        boolean rsl = true;
        for (char c : str.toCharArray()) {
            System.out.println(rsl);
            if ((int) c > 1103 || (int) c < 1040) {
                rsl = false;
            }
        }
        return rsl;
    }
//    private int monthInDays(String month){
//
//    }
}

