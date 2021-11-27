package ua.com.alevel;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;


public class SomeClassThatIRenameLater {
    //TODO Проверка на пустые части ввода перед и аосле разделителя
    //    private static final long MS_IN_YEAR = 31_536_000_000L;
//    private static final long MS_IN_MONTH = 2_592_000_000L;
    private static final long MS_IN_DAY = 86_400_000L;
    // private static final long MS_IN_HOUR = 3_600_000L;
    private static final long MS_IN_MINUTE = 60_000L;
    private static final long MS_IN_SEC = 1_000L;


\

    private HashMap<String, Integer> convertFromMillieSecondsToDate(long ms) {
        if (ms >= MS_IN_DAY) {
            long days = ms / MS_IN_DAY;
          int  msHours = (int) (ms - (days * MS_IN_DAY));
            if (days >= 365) {
                HashMap<String, Integer> yearAndDay = daysInYear(days);
            }
        }


    }


   /* public long createLongDateFromStringAndType(String str, int type) {
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
    }*/

    //TODO если StringUtils.INDEX_NOT_FOUND : то без времени
//    public long stringMonthWithTimeFormat(String str) {
//        int countOfSpaceBetweenDateAndTime = StringUtils.countMatches(str, " ");
//        //если разделитель пробел 1 то это только год
//        long date;
//        if (countOfSpaceBetweenDateAndTime == 1) {
//            date = yearInDays(Integer.parseInt(str.substring(0, StringUtils.indexOf(str, " ")))) * MS_IN_DAY;
//        } else { //если разделитель не один то это дата, месяц словом  и потом вркмя
//            String dateString = str.substring(0, StringUtils.lastIndexOf(str, " "));
//            date = dayStringMonthYear(dateString);
//        }
//
//        String timeString = str.substring(StringUtils.lastIndexOf(str, " ") + 1);
//
//        long rsl = date+time(timeString);
//        return rsl;
//    }


    public long monthIsNumber(String str, String whoFirst) {
        long rsl = 0;
        if (StringUtils.indexOf(str, ":") != StringUtils.INDEX_NOT_FOUND) {
            int indexOfTimeDelimiter = StringUtils.indexOf(str, ":");
            int indexOfDateDelimiter = StringUtils.indexOf(str, "/");
            if (indexOfTimeDelimiter < indexOfDateDelimiter) {
                String timeStr = str.substring(0, StringUtils.indexOf(str, " "));
                str = StringUtils.substring(str, StringUtils.indexOf(str, " ") + 1);
                rsl = time(timeStr);
            }
            if (indexOfTimeDelimiter > indexOfDateDelimiter) {
                String timeStr = str.substring(StringUtils.indexOf(str, " ") + 1);
                str = StringUtils.substring(str, 0, StringUtils.indexOf(str, " "));
                rsl = time(timeStr);
            }
        }
        int firstDelimiter = StringUtils.indexOf(str, "/");
        int lastDelimiter = StringUtils.lastIndexOf(str, "/");
        String dayStr = "";
        String monthStr = "";
        if (StringUtils.equals(whoFirst, "date")) {
            dayStr = str.substring(0, firstDelimiter);
            monthStr = str.substring(firstDelimiter + 1, lastDelimiter);
        }
        if (StringUtils.equals(whoFirst, "month")) {
            dayStr = str.substring(firstDelimiter + 1, lastDelimiter);
            monthStr = str.substring(0, firstDelimiter);
        }
        String yearStr = str.substring(lastDelimiter + 1);
        //минус 1 потому что мы еше не закончили этот день месяц год.
        // и по факту 1 января 1 года в милисекундах есть только количество часов или минут или дней
        int day = StringUtils.isBlank(dayStr) ? 0 : Integer.parseInt(dayStr) - 1;
        int month = StringUtils.isBlank(monthStr) ? 0 : Integer.parseInt(monthStr) - 1;
        int year = StringUtils.isBlank(yearStr) ? 0 : Integer.parseInt(yearStr);
        return rsl + (day + monthInDays(month, year) + yearInDays(year)) * MS_IN_DAY;
    }

    public long monthIsString(String str, String whoFirst) {
        long rsl = 0;
        if (StringUtils.indexOf(str, ":") != StringUtils.INDEX_NOT_FOUND) {
            int indexOfTimeDelimiter = StringUtils.indexOf(str, ":");
            int indexOfDateDelimiter = StringUtils.indexOf(str, "/");
            if (indexOfTimeDelimiter < indexOfDateDelimiter) {
                String timeStr = str.substring(0, StringUtils.indexOf(str, " "));
                str = StringUtils.substring(str, StringUtils.indexOf(str, " ") + 1);
                rsl = time(timeStr);
            }
            if (indexOfTimeDelimiter > indexOfDateDelimiter) {
                String timeStr = str.substring(StringUtils.indexOf(str, " ") + 1);
                str = StringUtils.substring(str, 0, StringUtils.indexOf(str, " "));
                rsl = time(timeStr);
            }
        }
        int firstDelimiter = StringUtils.indexOf(str, " ");
        int lastDelimiter = StringUtils.lastIndexOf(str, " ");
        String dayStr = "";
        String monthStr = "";
        if (!(firstDelimiter == lastDelimiter && firstDelimiter == -1)) {
            if (StringUtils.equals(whoFirst, "date")) {
                dayStr = str.substring(0, firstDelimiter);
                monthStr = str.substring(firstDelimiter + 1, lastDelimiter);
            }
            if (StringUtils.equals(whoFirst, "month")) {
                dayStr = str.substring(firstDelimiter + 1, lastDelimiter);
                monthStr = str.substring(0, firstDelimiter);
            }
        }
        String yearStr = str.substring(lastDelimiter + 1);
        //минус 1 потому что мы еше не закончили этот день месяц год.
        // и по факту 1 января 1 года в милисекундах есть только количество часов или минут или дней

        int day = StringUtils.isBlank(dayStr) ? 0 : Integer.parseInt(dayStr) - 1;
        int month = StringUtils.isBlank(monthStr) ? 0 : stringMonthToNumberValue(monthStr) - 1;
        int year = StringUtils.isBlank(yearStr) ? 0 : Integer.parseInt(yearStr);
        return rsl + (day + monthInDays(month, year) + yearInDays(year)) * MS_IN_DAY;
        //TODO Сделстьт если бусто но с разделителем
    }

    public boolean isLeapYear(int year) {
        return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
    }

    public long time(String time) {
        long timeInMillieSeconds = 0;
        int countOfDelimiter = StringUtils.countMatches(time, ":");
        switch (countOfDelimiter) {
            case 1:
                timeInMillieSeconds = hoursAndMinutes(time);
                break;
            case 2:
                timeInMillieSeconds = hoursMinuteAndSeconds(time);
                break;
            case 3:
                timeInMillieSeconds = hoursMinuteSecondAndMillieSeconds(time);
        }
        return timeInMillieSeconds;
    }

    private long hoursAndMinutes(String time) {
        String hourStr = time.substring(0, StringUtils.indexOf(time, ":"));
        String minuteStr = time.substring(StringUtils.indexOf(time, ":") + 1);
        int hour = StringUtils.isBlank(hourStr) ? 0 : Integer.parseInt(hourStr);
        int minute = StringUtils.isBlank(minuteStr) ? 0 : Integer.parseInt(minuteStr);
        return (minute + (hour * 60L) * MS_IN_MINUTE);

    }

    public long hoursMinuteAndSeconds(String time) {
        int lastDelimiter = StringUtils.lastIndexOf(time, ":");
        String hoursAndMinutes = time.substring(0, lastDelimiter);
        String secondStr = time.substring(lastDelimiter + 1);
        int second = StringUtils.isBlank(secondStr) ? 0 : Integer.parseInt(secondStr);
        return hoursAndMinutes(hoursAndMinutes) + second * MS_IN_SEC;

    }

    public long hoursMinuteSecondAndMillieSeconds(String time) {
        int lastDelimiter = StringUtils.lastIndexOf(time, ":");
        String hoursMinuteAndSeconds = time.substring(0, lastDelimiter);
        String millieSecondStr = time.substring(lastDelimiter + 1);
        int millieSecond = StringUtils.isBlank(millieSecondStr) ? 0 : Integer.parseInt(millieSecondStr);
        return hoursMinuteAndSeconds(hoursMinuteAndSeconds) + millieSecond;
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

    private HashMap<String, Integer> daysInYear(long days) {
        int year = 0;
        while (true) {

            if (isLeapYear(year)) {
                if (days - 366 < 0) {
                    break;
                }
                days -= 366;
                year++;
            } else {
                if (days - 365 < 0) {
                    break;
                }
                days -= 365;
                year++;
            }
        }
        HashMap<String, Integer> answer = new HashMap<>();
        answer.put("years", year);
        answer.put("days", (int) days);
        return answer;
    }

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

}

