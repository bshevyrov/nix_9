package ua.com.alevel;

import ua.com.alevel.firstlevel.AreaOfATriangle;
import ua.com.alevel.firstlevel.ArrayUtil;
import ua.com.alevel.firstlevel.KnightMove;

import java.util.Arrays;

public class StartApp {
    public static void main(String[] args) {
        System.out.println("Hello World!!!");

        //new ArrayUtil().getAmountOfUniqNumber(new int[]{1, 4, 5, 1, 1, 3});
       // new AreaOfATriangle().getArea(new int[][]{{1, 3}, {2, -5}, {-8, 4}});
   new KnightMove().generateField();
   new KnightMove().addStartPointToChessField(4,'D');
   new KnightMove().addFinishPointToChessField(5,'B');

       new KnightMove().checkMove(4,'D',5,'B');
    }
}
