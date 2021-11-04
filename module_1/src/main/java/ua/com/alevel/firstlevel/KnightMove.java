package ua.com.alevel.firstlevel;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class KnightMove {

    private static final String START_POINT_ICON = "♘";
    private static final String FINISH_POINT_ICON = "♞";

    static String[][] cell = new String[9][9];
    public void start(){
        if (cell[cell.length - 1][cell.length - 1] == null){
                      for (String[] strings : cell) {
                Arrays.fill(strings, " ");
            }
        }

        System.out.println();
        System.out.println("         A   B   C   D   E   F   G   H");
        System.out.println();
        System.out.println("       ╔═══════════════════════════════╗");
        System.out.println("    8  ║ " + cell[8][1] + " │ " + cell[8][2] + " │ " + cell[8][4] + " │ " + cell[8][4] + " │ " + cell[8][5] + " │ " + cell[8][6] + " │ " + cell[8][7] + " │ " + cell[8][8] + " ║  8   ");
        System.out.println("       ╟───┼───┼───┼───┼───┼───┼───┼───╢");
        System.out.println("    7  ║ " + cell[7][1] + " │ " + cell[7][2] + " │ " + cell[7][3] + " │ " + cell[7][4] + " │ " + cell[7][5] + " │ " + cell[7][6] + " │ " + cell[7][7] + " │ " + cell[7][8] + " ║  7");
        System.out.println("       ╟───┼───┼───┼───┼───┼───┼───┼───╢");
        System.out.println("    6  ║ " + cell[6][1] + " │ " + cell[6][2] + " │ " + cell[6][3] + " │ " + cell[6][4] + " │ " + cell[6][5] + " │ " + cell[6][6] + " │ " + cell[6][7] + " │ " + cell[6][8] + " ║  6");
        System.out.println("       ╟───┼───┼───┼───┼───┼───┼───┼───╢");
        System.out.println("    5  ║ " + cell[5][1] + " │ " + cell[5][2] + " │ " + cell[5][3] + " │ " + cell[5][4] + " │ " + cell[5][5] + " │ " + cell[5][6] + " │ " + cell[5][7] + " │ " + cell[5][8] + " ║  5");
        System.out.println("       ╟───┼───┼───┼───┼───┼───┼───┼───╢");
        System.out.println("    4  ║ " + cell[4][1] + " │ " + cell[4][2] + " │ " + cell[4][3] + " │ " + cell[4][4] + " │ " + cell[4][5] + " │ " + cell[4][6] + " │ " + cell[4][7] + " │ " + cell[4][8] + " ║  4");
        System.out.println("       ╟───┼───┼───┼───┼───┼───┼───┼───╢");
        System.out.println("    3  ║ " + cell[3][1] + " │ " + cell[3][2] + " │ " + cell[3][3] + " │ " + cell[3][4] + " │ " + cell[3][5] + " │ " + cell[3][6] + " │ " + cell[3][7] + " │ " + cell[3][8] + " ║  3");
        System.out.println("       ╟───┼───┼───┼───┼───┼───┼───┼───╢");
        System.out.println("    2  ║ " + cell[2][1] + " │ " + cell[2][2] + " │ " + cell[2][3] + " │ " + cell[2][4] + " │ " + cell[2][5] + " │ " + cell[2][6] + " │ " + cell[2][7] + " │ " + cell[2][8] + " ║  2");
        System.out.println("       ╟───┼───┼───┼───┼───┼───┼───┼───╢");
        System.out.println("    1  ║ " + cell[1][1] + " │ " + cell[1][2] + " │ " + cell[1][3] + " │ " + cell[1][4] + " │ " + cell[1][5] + " │ " + cell[1][6] + " │ " + cell[1][7] + " │ " + cell[1][8] + " ║  1");
        System.out.println("       ╚═══════════════════════════════╝");
        System.out.println();
        System.out.println("         A   B   C   D   E   F   G   H");
    }

    public boolean checkMove(int numStart, char letterStart, int numFinish, char letterFinish) {
        return( (Math.abs(numFinish - numStart) == 2)
                && (Math.abs(getNumFromLetter(letterFinish)
                - getNumFromLetter(letterStart)) == 1))||((Math.abs(numFinish - numStart) == 1)
                && (Math.abs(getNumFromLetter(letterFinish)
                - getNumFromLetter(letterStart)) == 2));
    }

    public void addStartPointToChessField(int num, char letter) {
        cell[num][getNumFromLetter(letter)] = START_POINT_ICON;
    }

    public void addFinishPointToChessField(int num, char letter) {
        cell[num][getNumFromLetter(letter)] = FINISH_POINT_ICON;
    }

    private int getNumFromLetter(char letter) {
        String[] lettersSynopsis = new String[]{" ", "A", "B", "C", "D", "E", "F", "G", "H"};

        return ArrayUtils.indexOf(
                lettersSynopsis, Character.toString(letter));
    }
}


