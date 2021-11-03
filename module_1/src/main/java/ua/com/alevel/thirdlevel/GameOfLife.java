package ua.com.alevel.thirdlevel;

import org.apache.commons.lang3.ArrayUtils;

public class GameOfLife {

    //static int[][] sporeNextGen= new int[3][3];


    public void initialize() {
        //int[][] spores = new int[3][3];
        //spores = setLine(spores);
        int[][]spores = new int[10][10];
        spores= setGlider(spores);
        spores= setLine(spores);
        run(spores);
    }

    public void run(int[][] spores) {
        //generateField(spores);


        clearScreen();
        int[][] newArr = ArrayUtils.clone(useRule(spores));
        generateField(newArr);

        // spores= ArrayUtils.clone(sporeNextGen);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        run(newArr);
    }

    private int[][] useRule(int[][] spores) {
        int[][] rsl = new int[spores.length][spores.length];
        for (int i = 0; i < spores.length; i++) {
            for (int j = 0; j < spores[spores.length - 1].length; j++) {
                int value = checkHowManyLiveNeighbor(i, j, spores);
                if (spores[i][j] == 0) {
                    if (value == 3) {
                        rsl[i][j] = 1;

                    } else {
                        rsl[i][j] = 0;
                    }
                }
                if (spores[i][j] == 1) {
                    if ((value <= 1) || (value >= 4)) {
                        rsl[i][j] = 0;
                    }
                    if ((value == 2) || (value == 3)) {
                        rsl[i][j] = 1;
                    }
                }
            }
        }
        return rsl;

    }
        private int checkHowManyLiveNeighbor ( int row, int cell, int[][] spores){
            int rsl = 0;
        /*
//        if ((row < spores.length - 1) && (row > 0)) {
//            if ((cell < spores[spores.length - 1].length - 1) && (cell > 0)) {
//                if (spores[row - 1][cell] == 1) {
//                    rsl++;
//                }
//                if (spores[row + 1][cell] == 1) {
//                    rsl++;
//                }
//                if (spores[row][cell - 1] == 1) {
//                    rsl++;
//                }
//                if (spores[row][cell + 1] == 1) {
//                    rsl++;
//                }
//                if (spores[row - 1][cell - 1] == 1) {
//                    rsl++;
//                }
//                if (spores[row + 1][cell - 1] == 1) {
//                    rsl++;
//                }
//                if (spores[row + 1][cell + 1] == 1) {
//                    rsl++;
//                }
//                if (spores[row - 1][cell + 1] == 1) {
//                    rsl++;
//                }
//            }
////            else if (cell > 0) {
////                if (spores[row - 1][cell] == 1) {
////                    rsl++;
////                }
////                if (spores[row + 1][cell] == 1) {
////                    rsl++;
////                }
////                if (spores[row][cell - 1] == 1) {
////                    rsl++;
////                }
////                if (spores[row - 1][cell - 1] == 1) {
////                    rsl++;
////                }
////                if (spores[row + 1][cell - 1] == 1) {
////                    rsl++;
////                }
////
////            }
//            else if ((cell == 0) && ((row > 0)&& spores.length-1>row)) {
//                if (spores[row - 1][cell] == 1) {
//                    rsl++;
//                }
//                if (spores[row + 1][cell] == 1) {
//                    rsl++;
//                }
//                if (spores[row][cell + 1] == 1) {
//                    rsl++;
//                }
//                if (spores[row + 1][cell + 1] == 1) {
//                    rsl++;
//                }
//                if (spores[row - 1][cell + 1] == 1) {
//                    rsl++;
//                }
//
//            }
//
//        } else if ((row == 0) && ((cell > 0)&&cell<spores[spores.length - 1].length - 1)) {
//            if (spores[row + 1][cell] == 1) {
//                rsl++;
//            }
//            if (spores[row][cell - 1] == 1) {
//                rsl++;
//            }
//            if (spores[row][cell + 1] == 1) {
//                rsl++;
//            }
//            if (spores[row + 1][cell - 1] == 1) {
//                rsl++;
//            }
//            if (spores[row + 1][cell + 1] == 1) {
//                rsl++;
//            }
//        }
//        if ((row== spores.length-1)&&(cell== spores[spores.length-1].length)){
//            if (spores[row - 1][cell] == 1) {
//                rsl++;
//            }
//            if (spores[row][cell - 1] == 1) {
//                rsl++;
//            }
//            if (spores[row - 1][cell - 1] == 1) {
//                rsl++;
//            }
//          if (spores[row - 1][cell + 1] == 1) {
//                rsl++;
//            }
//        }
//        if((row==0)&&(cell==0)){
//            if (spores[row + 1][cell] == 1) {
//                rsl++;
//            }
//            if (spores[row][cell + 1] == 1) {
//                rsl++;
//            }
//            if (spores[row + 1][cell + 1] == 1) {
//                rsl++;
//            }
//        }
//
////    private int[][]applyFirstRule(int[][] spores){
////        if()
////
////        return rsl[][];
////    }
        if(row>0&&cell>0){
        for (int i  = -1; i <=1 ; i++) {
            for (int j = -1; j <=1 ; j++) {
                if((i==0)&&(j==0)){
                    continue;
                }
                if(i==1&&j==1){
                    System.out.println("1");
                } if(i==0&&j==1){
                    System.out.println("2");
                } if(i==1&&j==1){
                    System.out.println("3");
                }
                rsl+=spores[row+i][cell+j];
            }
        }
        }
        if(row==0&&cell>0){
            for (int i  = 0; i <=1 ; i++) {
                for (int j = -1; j <=1 ; j++) {
                    if(i==0&&j==0){
                        continue;
                    }
                    rsl+=spores[row+i][cell+j];
                }
            }

        }
        if(row>0&&cell==0) {
            for (int i  = -1; i <=1 ; i++) {
                for (int j = 0; j <=1 ; j++) {
                    if(i==0&&j==0){
                        continue;
                    }
                    rsl+=spores[row+i][cell+j];
                }
            }

        }
        if(row==spores.length-1&&cell>0){
            for (int i  = -1; i <=0 ; i++) {
                for (int j = -1; j <=1 ; j++) {
                    if(i==0&&j==0){
                        continue;
                    }
                    rsl+=spores[row+i][cell+j];
                }
            }

        }
        if(cell==spores[spores.length-1].length-1&&row>0) {
            for (int i  = -1; i <=1 ; i++) {
                for (int j = -1; j <=0 ; j++) {
                    if(i==0&&j==0){
                        continue;
                    }
                    rsl+=spores[row+i][cell+j];
                }
            }
        }
        if(cell==spores[spores.length-1].length-1&&row==spores.length-1) {
            for (int i  = -1; i <=0 ; i++) {
                for (int j = -1; j <=0 ; j++) {
                    if(i==0&&j==0){
                        continue;
                    }
                    rsl+=spores[row+i][cell+j];
                }
            }
        }
        if(cell==0&&row==0) {
            for (int i  = 0; i <=1 ; i++) {
                for (int j = 0; j <=1 ; j++) {
                    if(i==0&&j==0){
                        continue;
                    }
                    rsl+=spores[row+i][cell+j];
                }
            }
        }
*/
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int newRow = row + i;
                    int newCell = cell + j;
                    boolean inField = isInField(row + i, cell + j, spores);
                    if (!inField) {
                        continue;
                    }
                    if (i == 0 && j == 0) {
                        continue;
                    }
                    if (spores[newRow][newCell] == 1) {
                        rsl++;
                    }
                }
            }
            return rsl;
        }


        //    private void modifyStateIfAlive(int row, int cell,int[][] spores) {
//        int value = checkHowManyLiveNeighbor(row, cell, spores);
//        if ((value == 2) || value == 3) {
//            sporeNextGen[row][cell] = 1;
//        }
//        if(value<2||value>3) {
//            sporeNextGen[row][cell] = 0;
//        }
//    }
//
//    private void modifyStateIfDead(int row, int cell,int[][] spores) {
//        int value = checkHowManyLiveNeighbor(row, cell,spores);
//        if (value == 3) {
//            sporeNextGen[row][cell] = 1;
//        }else {
//            sporeNextGen[row][cell] = 0;
//        }
//    }
        public static void generateField ( int[][] spores){
            // int[][] field = new int[10][10];
//        if()
//        for (int[] x : spores) {
//            Arrays.fill(x, 0);
//        }
//        spores = setShip(spores);
            String rsl = "";
            for (int i = 0; i < spores.length; i++) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int j = 0; j < spores[spores.length - 1].length; j++) {
                    stringBuilder.append(spores[i][j]);
                }
                System.out.println(stringBuilder.toString());
            }
            System.out.println();

        }

        public static void clearScreen () {
            System.out.print("\033[H\033[2J");
            System.out.flush();

        }

        private boolean isInField ( int row, int cell, int[][] spores){
            boolean rsl = false;
            int cellLength = spores[spores.length - 1].length;
            boolean rowInField = (row >= 0 && row < spores.length);
            boolean cellInField = (cell >= 0) && (cell < cellLength);
            rsl = rowInField && cellInField;
            return rsl;
        }

        private static int[][] setLine ( int[][] field){
            field[7][1] = 1;
            field[8][1] = 1;
            field[9][1] = 1;
            return field;
        }

        private static int[][] setGlider ( int[][] field){
            field[0][2] = 1;
            field[1][0] = 1;
            field[1][2] = 1;
            field[2][1] = 1;
            field[2][2] = 1;
            return field;
        }
    }
