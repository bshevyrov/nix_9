package ua.com.alevel.firstlevel;

public class AreaOfATriangle {

    public void getArea(int[][] dots) {
        int aX = dots[0][0];
        int aY = dots[0][1];
        int bX = dots[1][0];
        int bY = dots[1][1];
        int cX = dots[2][0];
        int cY = dots[2][1];

        calculateAreaByGeronFormula(aX, aY, bX, bY, cX, cY);
    }

    private void calculateAreaByGeronFormula(int aX, int aY, int bX, int bY, int cX, int cY) {
        System.out.println("Area is: " + Math.abs(aX * (bY - cY)
                + bX * (cY - aY)
                + cX * (aY - bY)) / 2);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
