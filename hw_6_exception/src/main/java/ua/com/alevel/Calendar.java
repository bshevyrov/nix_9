package ua.com.alevel;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;


public class Calendar {

    private static final long MS_IN_DAY = 86_400_000L;
    private static final long MS_IN_HOUR = 3_600_000L;
    private static final long MS_IN_MINUTE = 60_000L;
    private static final long MS_IN_SEC = 1_000L;

    public long dateToMillieSeconds(String str, int inputFormatNum) {
        long rsl = 0;
        String dateStr = "";
        if (StringUtils.indexOf(str, ":") != StringUtils.INDEX_NOT_FOUND) {
            int indexOfTimeDelimiter = StringUtils.indexOf(str, ":");
            int indexOfDateDelimiterSlash = StringUtils.indexOf(str, "/");
            int indexOfDateDelimiterSpace = StringUtils.indexOf(str, " ");
            int indexOfDateDelimiter = Math.max(indexOfDateDelimiterSlash, indexOfDateDelimiterSpace);
            if (indexOfTimeDelimiter < indexOfDateDelimiter) {
                String timeStr = StringUtils.substring(str, 0, StringUtils.indexOf(str, " "));
                dateStr = StringUtils.substring(str, StringUtils.indexOf(str, " ") + 1);
                rsl = convertTimeToMillieSeconds(timeStr);
            }
            if (indexOfTimeDelimiter > indexOfDateDelimiter) {
                String timeStr = StringUtils.substring(str, StringUtils.lastIndexOf(str, " ") + 1);
                dateStr = StringUtils.substring(str, 0, StringUtils.lastIndexOf(str, " "));
                rsl = convertTimeToMillieSeconds(timeStr);
            }
        } else {
            dateStr = str;
        }
        int firstDelimiter;
        int lastDelimiter = 0;
        String dayStr = "";
        String monthStr = "";
        if (inputFormatNum == 0) {
            firstDelimiter = StringUtils.indexOf(dateStr, "/");
            lastDelimiter = StringUtils.lastIndexOf(dateStr, "/");
            dayStr = StringUtils.substring(dateStr, 0, firstDelimiter);
            monthStr = StringUtils.substring(dateStr, firstDelimiter + 1, lastDelimiter);
        }
        if (inputFormatNum == 1) {
            firstDelimiter = StringUtils.indexOf(dateStr, "/");
            lastDelimiter = StringUtils.lastIndexOf(dateStr, "/");
            dayStr = StringUtils.substring(dateStr, firstDelimiter + 1, lastDelimiter);
            monthStr = StringUtils.substring(dateStr, 0, firstDelimiter);
        }

        if (inputFormatNum == 2) {
            firstDelimiter = StringUtils.indexOf(dateStr, " ");
            lastDelimiter = StringUtils.lastIndexOf(dateStr, " ");
            dayStr = StringUtils.substring(dateStr, firstDelimiter + 1, lastDelimiter);
            monthStr = StringUtils.substring(dateStr, 0, firstDelimiter);
        }
        if (inputFormatNum == 3) {
            firstDelimiter = StringUtils.indexOf(dateStr, " ");
            lastDelimiter = StringUtils.lastIndexOf(dateStr, " ");
            monthStr = StringUtils.substring(dateStr, firstDelimiter + 1, lastDelimiter);
            dayStr = StringUtils.substring(dateStr, 0, firstDelimiter);
        }
        if (!StringUtils.isNumeric(monthStr)) {
            monthStr = String.valueOf(stringMonthToNumberValue(monthStr));
        }
        String yearStr = StringUtils.substring(dateStr, lastDelimiter + 1);
        int day = StringUtils.isBlank(dayStr) ? 0 : Integer.parseInt(dayStr) - 1;
        int month = StringUtils.isBlank(monthStr) ? 0 : Integer.parseInt(monthStr);// - 1;
        int year = StringUtils.isBlank(yearStr) ? 0 : Integer.parseInt(yearStr);
        return rsl + (day + sumOfDaysBeforeThisMonth(month, year) + yearInDays(year)) * MS_IN_DAY;
    }

    public boolean isLeapYear(int year) {
        return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
    }

    public long convertTimeToMillieSeconds(String time) {
        long timeInMillieSeconds = 0;
        int countOfDelimiter = StringUtils.countMatches(time, ":");
        switch (countOfDelimiter) {
            case 1 -> timeInMillieSeconds = hoursAndMinutes(time);
            case 2 -> timeInMillieSeconds = hoursMinuteAndSeconds(time);
            case 3 -> timeInMillieSeconds = hoursMinuteSecondAndMillieSeconds(time);
        }
        return timeInMillieSeconds;
    }

    private long hoursAndMinutes(String time) {
        String hourStr = StringUtils.substring(time, 0, StringUtils.indexOf(time, ":"));
        String minuteStr = StringUtils.substring(time, StringUtils.indexOf(time, ":") + 1);
        int hour = StringUtils.isBlank(hourStr) ? 0 : Integer.parseInt(hourStr);
        int minute = StringUtils.isBlank(minuteStr) ? 0 : Integer.parseInt(minuteStr);
        return ((minute + (hour * 60L)) * MS_IN_MINUTE);
    }

    public long hoursMinuteAndSeconds(String time) {
        int lastDelimiter = StringUtils.lastIndexOf(time, ":");
        String hoursAndMinutes = StringUtils.substring(time, 0, lastDelimiter);
        String secondStr = StringUtils.substring(time, lastDelimiter + 1);
        int second = StringUtils.isBlank(secondStr) ? 0 : Integer.parseInt(secondStr);
        return hoursAndMinutes(hoursAndMinutes) + (second * MS_IN_SEC);
    }

    public long hoursMinuteSecondAndMillieSeconds(String time) {
        int lastDelimiter = StringUtils.lastIndexOf(time, ":");
        String hoursMinuteAndSeconds = StringUtils.substring(time, 0, lastDelimiter);
        String millieSecondStr = StringUtils.substring(time, lastDelimiter + 1);
        int millieSecond = StringUtils.isBlank(millieSecondStr) ? 0 : Integer.parseInt(millieSecondStr);
        return hoursMinuteAndSeconds(hoursMinuteAndSeconds) + millieSecond;
    }

    public int yearInDays(int year) {
        int sumOfDays = 0;
        for (int i = 0; i < year; i++) {
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
            } else {
                if (days - 365 < 0) {
                    break;
                }
                days -= 365;
            }
            year++;
        }
        return year;
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

    public int monthInDays(int monthNum, int year) {
        return switch (monthNum) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> isLeapYear(year) ? 29 : 28;
            default -> 0;
        };
    }

    public int stringMonthToNumberValue(String month) {
        int rsl = 0;
        month = month.toLowerCase();
        switch (month) {
            case "январь" -> rsl = 1;
            case "февраль" -> rsl = 2;
            case "март" -> rsl = 3;
            case "апрель" -> rsl = 4;
            case "май" -> rsl = 5;
            case "июнь" -> rsl = 6;
            case "июль" -> rsl = 7;
            case "август" -> rsl = 8;
            case "сентябрь" -> rsl = 9;
            case "октябрь" -> rsl = 10;
            case "ноябрь" -> rsl = 11;
            case "декабрь" -> rsl = 12;
        }
        return rsl;
    }

    private String intMonthToStringMont(int month) {
        return switch (month) {
            case 1 -> "Январь";
            case 2 -> "Февраль";
            case 3 -> "Март";
            case 4 -> "Апрель";
            case 5 -> "Май";
            case 6 -> "Июнь";
            case 7 -> "Июль";
            case 8 -> "Август";
            case 9 -> "Сентябрь";
            case 10 -> "Октябрь";
            case 11 -> "Ноябрь";
            case 12 -> "Декабрь";
            default -> "";
        };
    }


    public String convertFromMillieSecondsToDate(long msTotal, int type) {
        String rsl = "";
        int years = 0;
        //TODO Это костыль тк отсчет идет от первого января. Вроде так
        int days = 1;//1
        if (msTotal >= MS_IN_DAY) {
            days += (msTotal / MS_IN_DAY);
            if (days >= 366) {
                years = daysInYear(days);
                days -= yearInDays(years);
            }
        }
        long time = msTotal - ((yearInDays(years) * MS_IN_DAY) + (days - 1) * MS_IN_DAY);
        String timeStr = convertMillieSecondsToTime(time);

        int monthNum = numberOfFullMonthFromSumOfDays(days, years);
        days = days - sumOfDaysBeforeThisMonth(monthNum, years);
        switch (type) {
            case 0:
                rsl = days + "/" + monthNum + "/" + years;
                break;
            case 1:
                rsl = monthNum + "/" + days + "/" + years;
                break;
            case 2:
                rsl = intMonthToStringMont(monthNum) + " " + days + " " + years;
                break;
            case 3:
                rsl = days + " " + intMonthToStringMont(monthNum) + " " + years;
                break;
        }

        if (time != 0) {
            rsl = rsl + " " + timeStr;
        }
        return rsl;
    }

    private String convertMillieSecondsToTime(long ms) {
        String rsl;
        int hours = 0;
        int minutes = 0;
        int seconds = 0;
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
        String msStr;
        if (ms == 0) {
            msStr = "000";
        } else {
            msStr = String.valueOf(ms);
            int msStrNumOfDigits = msStr.length();
            msStr = switch (msStrNumOfDigits) {
                case 1 -> "00" + msStr;
                case 2 -> "0" + msStr;
                default -> msStr;
            };
        }
        char[] msChars = msStr.toCharArray();
        if (msChars[2] > '2') {
            msChars[2] = '3';
        } else {
            msChars[2] = '0';
        }
        rsl = hours + ":" + minutes + ":" + seconds + ":" + String.valueOf(msChars);
        return rsl;
    }

    public boolean isCyrillic(String str) {
        boolean rsl = true;
        for (char c : str.toCharArray()) {
            if ((int) c > 1103 || (int) c < 1040) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }

    public String getResult(long firstOperand, int numOfOperation, long[] secondOperand, int outPutType) {
        return switch (numOfOperation) {
            case 0 -> convertFromMillieSecondsToDate(Math.abs(firstOperand - secondOperand[0]), outPutType);
            //TODO ВТОРОЙ ОПЕРАНД  ВЫХОДИТ ЗА ПРЕДЕЛЫ
            case 1 -> convertFromMillieSecondsToDate(firstOperand + secondOperand[0], outPutType);
            //TODO exception 2 операнд больше первого
            case 2 -> convertFromMillieSecondsToDate(firstOperand - secondOperand[0], outPutType);
            case 3 -> sort(ArrayUtils.add(secondOperand, firstOperand), outPutType);
            default -> "";
        };
    }

    private String sort(long[] arr, int outPutType) {
        StringBuilder builder = new StringBuilder();
        sortAsc(arr);
        builder.append("Date to Asc: ");
        for (int i = 0; i < arr.length; i++) {
            builder.append(convertFromMillieSecondsToDate(arr[i], outPutType));
            if (i == arr.length - 1) {
                builder.append(". \n");
            } else {
                builder.append(", ");
            }
        }
        sortDesc(arr);
        builder.append("Date to Desc: ");
        for (int i = 0; i < arr.length; i++) {
            builder.append(convertFromMillieSecondsToDate(arr[i], outPutType));
            if (i == arr.length - 1) {
                builder.append(". \n");
            } else {
                builder.append(", ");
            }
        }
        return builder.toString();
    }

    private void sortAsc(long[] arr) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < arr[i - 1]) {
                    swap(arr, i, i - 1);
                    sorted = false;
                }
            }
        }
    }

    private void sortDesc(long[] arr) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > arr[i - 1]) {
                    swap(arr, i, i - 1);
                    sorted = false;
                }
            }
        }
    }

    private void swap(long[] n, int first, int last) {
        long tempLong;
        tempLong = n[first];
        n[first] = n[last];
        n[last] = tempLong;
    }
}

