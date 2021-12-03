package ua.com.alevel.secondlevel;

import org.apache.commons.lang3.ArrayUtils;
import ua.com.alevel.handlers.FileHandler;

public class UniqNameFinder {

    public void findUniqString(String[] inputStr) {
        System.out.println("");
        System.out.println("Input: ");
        FileHandler.arrToString(inputStr);
        for (int i = 0; i < inputStr.length; i++) {
            if (ArrayUtils.indexOf(inputStr, inputStr[i]) == ArrayUtils.lastIndexOf(inputStr, inputStr[i])) {
                System.out.println("");
                System.out.println("Output: ");
                FileHandler.arrToString(new String[]{inputStr[i]});
                break;
            }
        }
    }
}
