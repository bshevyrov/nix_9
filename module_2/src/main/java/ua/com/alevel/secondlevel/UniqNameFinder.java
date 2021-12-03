package ua.com.alevel.secondlevel;

import org.apache.commons.lang3.ArrayUtils;
import ua.com.alevel.FileHandler;

public class UniqNameFinder {

    public void findUniqString(String[] inputStr) {
        System.out.println("Input: ");
        FileHandler.arrToString(inputStr);
        for (String s : inputStr) {
            if (ArrayUtils.indexOf(inputStr, s) == ArrayUtils.lastIndexOf(inputStr, s)) {
                System.out.println("Output: ");
                FileHandler.arrToString(new String[]{s});
                break;
            }
        }
    }
}
