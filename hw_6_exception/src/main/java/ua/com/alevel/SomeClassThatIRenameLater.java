package ua.com.alevel;

import org.apache.commons.lang3.StringUtils;


public class SomeClassThatIRenameLater {
    //TODO Проверка на пустые части ввода перед и аосле разделителя
    //    private static final long MS_IN_YEAR = 31_536_000_000L;
//    private static final long MS_IN_MONTH = 2_592_000_000L;
    //TODO вместо тайпа  енамчик в конверт формате
    private static final long MS_IN_DAY = 86_400_000L;
    private static final long MS_IN_HOUR = 3_600_000L;
    private static final long MS_IN_MINUTE = 60_000L;
    private static final long MS_IN_SEC = 1_000L;

    public long dateToMillieSeconds(String str, String whoFirst) {
        long rsl = 0;
        String dateStr = "";
        if (StringUtils.indexOf(str, ":") != StringUtils.INDEX_NOT_FOUND) {
            int indexOfTimeDelimiter = StringUtils.indexOf(str, ":");
            int indexOfDateDelimiter = StringUtils.indexOf(str, "/");
            if (indexOfTimeDelimiter < indexOfDateDelimiter) {
                String timeStr = str.substring(0, StringUtils.indexOf(str, " "));
                str = StringUtils.substring(str, StringUtils.indexOf(str, " ") + 1);
                rsl = convertTimeToMillieSeconds(timeStr);
            }
            if (indexOfTimeDelimiter > indexOfDateDelimiter) {
                String timeStr = str.substring(StringUtils.indexOf(str, " ") + 1);
                dateStr = StringUtils.substring(str, 0, StringUtils.indexOf(str, " "));
                rsl = convertTimeToMillieSeconds(timeStr);
            }
        }
        int firstDelimiter = StringUtils.indexOf(dateStr, "/");
        int lastDelimiter = StringUtils.lastIndexOf(dateStr, "/");
        String dayStr = "";
        String monthStr = "";
        if (StringUtils.equals(whoFirst, "date")) {
            dayStr = dateStr.substring(0, firstDelimiter);
            monthStr = dateStr.substring(firstDelimiter + 1, lastDelimiter);
        }
        if (StringUtils.equals(whoFirst, "month")) {
            dayStr = dateStr.substring(firstDelimiter + 1, lastDelimiter);
            monthStr = dateStr.substring(0, firstDelimiter);
        }
        if(!StringUtils.isNumeric(monthStr)){
            monthStr=String.valueOf(stringMonthToNumberValue(monthStr));
        }
        String yearStr = dateStr.substring(lastDelimiter + 1);
        //минус 1 потому что мы еше не закончили этот день месяц год.
        // и по факту 1 января 1 года в милисекундах есть только количество часов или минут или дней
        int day = StringUtils.isBlank(dayStr) ? 0 : Integer.parseInt(dayStr) - 1;
        int month = StringUtils.isBlank(monthStr) ? 0 : Integer.parseInt(monthStr);// - 1;
        int year = StringUtils.isBlank(yearStr) ? 0 : Integer.parseInt(yearStr);
        return rsl + (day + sumOfDaysBeforeThisMonth(month, year) + yearInDays(year)) * MS_IN_DAY;
    }

   //TODO Сделстьт если бусто но с разделителем
   public boolean isLeapYear(int year) {
        return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
    }

    public long convertTimeToMillieSeconds(String time) {
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
                break;
        }
        return timeInMillieSeconds;
    }

    private long hoursAndMinutes(String time) {
        String hourStr = time.substring(0, StringUtils.indexOf(time, ":"));
        String minuteStr = time.substring(StringUtils.indexOf(time, ":") + 1);
        int hour = StringUtils.isBlank(hourStr) ? 0 : Integer.parseInt(hourStr);
        int minute = StringUtils.isBlank(minuteStr) ? 0 : Integer.parseInt(minuteStr);
        return ((minute + (hour * 60L)) * MS_IN_MINUTE);

    }

    public long hoursMinuteAndSeconds(String time) {
        int lastDelimiter = StringUtils.lastIndexOf(time, ":");
        String hoursAndMinutes = time.substring(0, lastDelimiter);
        String secondStr = time.substring(lastDelimiter + 1);
        int second = StringUtils.isBlank(secondStr) ? 0 : Integer.parseInt(secondStr);
        return (hoursAndMinutes(hoursAndMinutes) + second) * MS_IN_SEC;

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

    private int daysInYear(long days) {
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
        /*HashMap<String, Integer> answer = new HashMap<>();
        answer.put("years", year);
        answer.put("days", (int) days);*/
        return year;
    }

    private int monthInDays(int monthNum, int year) {
        return switch (monthNum) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> isLeapYear(year) ? 29 : 28;
            default -> 0;
        };
    }

    public int sumOfDaysBeforeThisMonth(int month, int year) {
        int sumOfdays = 0;
        for (int i = 1; i < month; i++) {
            sumOfdays += monthInDays(i, year);
        }
        return sumOfdays;
    }

    public int numberOfFullMonthFromSumOfDays(int days, int year) {
        int monthNum = 1;
        if (days > 31) {
            while (true) {
                if (days - monthInDays(monthNum, year) > 0) {
                    days -= monthInDays(monthNum, year);
                    monthNum++;
                } else {
                    break;
                }
            }
        }
        return monthNum;
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

    public String convertFromMillieSecondsToDate(long msTotal) {
        int years = 0;
        //TODO Это костыль тк отсчет идет от первого января. Вроде так
        int days = 1;
        int month = 1;
        int msHours = 0;

        if (msTotal >= MS_IN_DAY) {
            days += (int) (msTotal / MS_IN_DAY);
            msHours = (int) (msTotal - (days * MS_IN_DAY));
            if (days >= 366) {
                years = daysInYear(days);
                days -= yearInDays(years);
            }
        }
                String timeStr = convertMillieSecondsToTime(days);
        int monthNum = numberOfFullMonthFromSumOfDays(days,years);
        days-=monthInDays(monthNum,years);
        String rsl = years + "/" +monthNum+ "/" +String.valueOf(days);
        //return dateWithTime;
        return rsl + " " + timeStr;
    }

    private String convertMillieSecondsToTime(long ms) {
        String rsl = "";
        int hours = 0;
        int minutes = 0;
        int seconds = 0;
        int millieSeconds = 0;
        int msHours = 0;
        int msMinutes = 0;
        int msSeconds = 0;
        int msMillieSeconds = 0;
        if (ms >= MS_IN_HOUR) {
            hours = (int) (ms / MS_IN_HOUR);
            ms -= hours * MS_IN_HOUR;
        }
        if (ms >= MS_IN_MINUTE) {
            minutes = (int) (ms / MS_IN_MINUTE);
            ms -= minutes * MS_IN_MINUTE;
        }
        if (ms >= MS_IN_SEC) {
            seconds = (int) (ms / MS_IN_SEC);
            ms -= seconds * MS_IN_SEC;
        }
        String msStr = "";
        if (ms == 0) {
            msStr = "000";
        } else {

            msStr = String.valueOf(ms);
            int msStrNumOfDigits = msStr.length();
            switch (msStrNumOfDigits) {
                case 1:
                    msStr = "00" + msStr;
                    break;
                case 2:
                    msStr = "0" + msStr;
                    break;
            }
        }
        char[] msChars = msStr.toCharArray();
        if (msChars[2] > 3) {
            msChars[2] = 3;
        } else {
            msChars[2] = 3;
        }
        rsl = hours + ":" + minutes + ":" + seconds + ":" + msStr;
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

