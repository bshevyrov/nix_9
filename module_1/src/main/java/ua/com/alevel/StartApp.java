package ua.com.alevel;

import ua.com.alevel.secondlevel.StringVerification;

public class StartApp {
    public static void main(String[] args) {
        System.out.println("Hello World!!!");

        //new ArrayUtil().getAmountOfUniqNumber(new int[]{1, 4, 5, 1, 1, 3});
       // new AreaOfATriangle().getArea(new int[][]{{1, 3}, {2, -5}, {-8, 4}});


        //
        //        new KnightMove().generateField();
        //        new KnightMove().addStartPointToChessField(4,'D');
        //        new KnightMove().addFinishPointToChessField(5,'B');
        //        new KnightMove().checkMove(4,'D',9,'B');
       boolean rsl = new StringVerification().stringVerification("(");
        System.out.println(rsl?"This string pass verification.":"Sorry this string have problem");
    }
}
