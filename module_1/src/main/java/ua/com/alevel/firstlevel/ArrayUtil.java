package ua.com.alevel.firstlevel;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class ArrayUtil {

    public void getAmountOfUniqNumber(int[] nums) {

        int[] uniqNumbers = new int[0];

        for (int num : nums) {
            if (!(ArrayUtils.contains(uniqNumbers, num))) {
                uniqNumbers = Arrays.copyOf(uniqNumbers, uniqNumbers.length + 1);
                uniqNumbers[uniqNumbers.length - 1] = num;
            }
        }
        System.out.println("Amount of uniq symbols are: " + uniqNumbers.length);
    }
}
