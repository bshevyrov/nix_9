package ua.com.alevel.firstlevel;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class KnightMove {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    String[] a = new String[65];


    public void generateField(String[] cells) {
        if (cells[cells.length - 1] == null) {
            Arrays.fill(cells, " ");
        }
        System.out.println("♞");
        System.out.println("♘");
        System.out.println("");
        System.out.println("         A   B   C   D   E   F   G   H");
        System.out.println("");
        System.out.println("       ╔═══════════════════════════════╗");
        System.out.println("    8  ║ " + a[1] + " │ " + a[2] + " │ " + a[3] + " │ " + a[4] + " │ " + a[5] + " │ " + a[6] + " │ " + a[7] + " │ " + a[8] + " ║  8   ");
        System.out.println("       ╟───┼───┼───┼───┼───┼───┼───┼───╢");
        System.out.println("    7  ║ " + a[9] + " │ " + a[10] + " │ " + a[11] + " │ " + a[12] + " │ " + a[13] + " │ " + a[14] + " │ " + a[15] + " │ " + a[16] + " ║  7");
        System.out.println("       ╟───┼───┼───┼───┼───┼───┼───┼───╢");
        System.out.println("    6  ║ " + a[17] + " │ " + a[18] + " │ " + a[19] + " │ " + a[20] + " │ " + a[21] + " │ " + a[22] + " │ " + a[23] + " │ " + a[24] + " ║  6");
        System.out.println("       ╟───┼───┼───┼───┼───┼───┼───┼───╢");
        System.out.println("    5  ║ " + a[25] + " │ " + a[26] + " │ " + a[27] + " │ " + a[28] + " │ " + a[29] + " │ " + a[30] + " │ " + a[31] + " │ " + a[32] + " ║  5");
        System.out.println("       ╟───┼───┼───┼───┼───┼───┼───┼───╢");
        System.out.println("    4  ║ " + a[33] + " │ " + a[34] + " │ " + a[35] + " │ " + a[36] + " │ " + a[37] + " │ " + a[38] + " │ " + a[39] + " │ " + a[40] + " ║  4");
        System.out.println("       ╟───┼───┼───┼───┼───┼───┼───┼───╢");
        System.out.println("    3  ║ " + a[41] + " │ " + a[42] + " │ " + a[43] + " │ " + a[44] + " │ " + a[45] + " │ " + a[46] + " │ " + a[47] + " │ " + a[48] + " ║  3");
        System.out.println("       ╟───┼───┼───┼───┼───┼───┼───┼───╢");
        System.out.println("    2  ║ " + a[49] + " │ " + a[50] + " │ " + a[51] + " │ " + a[52] + " │ " + a[53] + " │ " + a[54] + " │ " + a[55] + " │ " + a[56] + " ║  2");
        System.out.println("       ╟───┼───┼───┼───┼───┼───┼───┼───╢");
        System.out.println("    1  ║ " + a[57] + " │ " + a[58] + " │ " + a[59] + " │ " + a[60] + " │ " + a[61] + " │ " + a[62] + " │ " + a[63] + " │ " + a[64] + " ║  1");
        System.out.println("       ╚═══════════════════════════════╝");
        System.out.println("");
        System.out.println("         A   B   C   D   E   F   G   H");

    }

    public int findCellByCords(char letter, int num) {
        return getNumFromLetter(letter) * (9 - (num));
    }

    private int getNumFromLetter(char letter) {
        String[] lettersSynopsis = new String[]{" ", "A", "B", "C", "D", "E", "F", "G", "H"};

        return ArrayUtils.indexOf(
                lettersSynopsis, Character.toString(letter));
    }
public void isPossibleTurn(char letter, int num){

}
}
