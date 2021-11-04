package ua.com.alevel.thirdlevel;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

public class GameOfLife {

    public void initialize() {
        int[][] spores = new int[50][200];
        setGlider(spores);
        setLine(spores);
        setMethuselah(spores);
        run(spores);
    }

    public void run(int[][] spores) {
        clearScreen();
        int[][] newArr = ArrayUtils.clone(useRule(spores));
        generateField(newArr);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        run(newArr);
    }

    private int[][] useRule(int[][] spores) {
        int[][] rsl = new int[spores.length][spores[spores.length-1].length];
        for (int i = 0; i < spores.length; i++) {
            for (int j = 0; j < spores[i].length; j++) {
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

    private int checkHowManyLiveNeighbor(int row, int cell, int[][] spores) {
        int rsl = 0;
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

    public static void generateField(int[][] spores) {
        clearScreen();
        for (int[] spore : spores) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < spores[spores.length - 1].length; j++) {
                stringBuilder.append(spore[j]);
            }
            System.out.println(makeUserFriendly(stringBuilder));
        }
        System.out.println();
    }

    private static String makeUserFriendly(StringBuilder stringBuilder) {
        String stringForUser;
        stringForUser = StringUtils.replaceChars(stringBuilder.toString(), "0", "░");
        stringForUser = StringUtils.replaceChars(stringForUser, "1", "█");
        return stringForUser;
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private boolean isInField(int row, int cell, int[][] spores) {
        int cellLength = spores[spores.length - 1].length;
        boolean rowInField = (row >= 0 && row < spores.length);
        boolean cellInField = (cell >= 0) && (cell < cellLength);
        return rowInField && cellInField;
    }

    private static void setLine(int[][] field) {
        field[7][1] = 1;
        field[8][1] = 1;
        field[9][1] = 1;
    }

    private static void setGlider(int[][] field) {
        field[0][2] = 1;
        field[1][0] = 1;
        field[1][2] = 1;
        field[2][1] = 1;
        field[2][2] = 1;
    }

    private static void setMethuselah(int[][] field) {
        field[20][40] = 1;
        field[21][40] = 1;
        field[21][41] = 1;
        field[22][39] = 1;
        field[22][40] = 1;

    }
}
