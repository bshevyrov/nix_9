package ua.com.alevel;

import java.util.Arrays;

public class StartCollectionApp {
    public static void main(String[] args) {
        MathSet m = new MathSet();
        Number[] num = new Number[]{0,1,2,null,null,null};
        MathSet m1 = new MathSet(num);
        m1.sortDesc(0,4);
        Arrays.toString(m1.toArray());
    }
}
