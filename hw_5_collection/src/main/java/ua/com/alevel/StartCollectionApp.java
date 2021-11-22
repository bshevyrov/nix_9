package ua.com.alevel;

import java.util.Arrays;

public class StartCollectionApp {
    public static void main(String[] args) {
        MathSet m = new MathSet();
        m.returnClass(3.15f);
        Number[] num = new Number[]{4,0,1,2,3,4};
        MathSet m1 = new MathSet(num);
        m1.sortDesc();
        System.out.println((Arrays.toString(m1.getNumbers())));
    }
}
