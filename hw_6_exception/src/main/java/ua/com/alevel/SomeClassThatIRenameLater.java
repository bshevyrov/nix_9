package ua.com.alevel;

import org.apache.commons.lang3.StringUtils;

public class SomeClassThatIRenameLater {

    private static final long MS_IN_YEAR = 31_536_000_000L;
    private static final long MS_IN_MONTH = 2_592_000_000L;
    private static final long MS_IN_DAY = 86_400_000L;
    private static final long MS_IN_HOUR = 3_600_000L;
    private static final long MS_IN_MINUTE = 60_000L;
    private static final long MS_IN_SEC = 1_000L;

    private int defineFormatOfDate(String date) {

        return 0;
    }

    private boolean isLeapYear(int year) {
        return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
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
}

