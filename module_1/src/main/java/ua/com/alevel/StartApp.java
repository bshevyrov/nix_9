package ua.com.alevel;

import ua.com.alevel.firstlevel.AreaOfATriangle;
import ua.com.alevel.firstlevel.ArrayUtil;
import ua.com.alevel.firstlevel.KnightMove;

public class StartApp {
    public static void main(String[] args) {
        System.out.println("Hello World!!!");

        //new ArrayUtil().getAmountOfUniqNumber(new int[]{1, 4, 5, 1, 1, 3});
       // new AreaOfATriangle().getArea(new int[][]{{1, 3}, {2, -5}, {-8, 4}});
   // new KnightMove().generateField();
        System.out.println( new KnightMove().findCellByCords('H',8));
    }
}
