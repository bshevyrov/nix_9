package ua.com.alevel;

import org.apache.commons.lang3.StringUtils;
import ua.com.alevel.firstlevel.AreaOfATriangle;
import ua.com.alevel.firstlevel.ArrayUtil;
import ua.com.alevel.firstlevel.KnightMove;
import ua.com.alevel.secondlevel.BinaryTree;
import ua.com.alevel.secondlevel.StringVerification;
import ua.com.alevel.thirdlevel.GameOfLife;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class StartApp {
    public static void main(String[] args) {
        String str = "";
        while (true) {
            clearConsole();
            System.out.println("~~~~~Level One~~~~~");
            System.out.println("1. Check uniq symbols");
            System.out.println("2. Chess Knight");
            System.out.println("3. Array of triangle");
            System.out.println("~~~~~Level Two~~~~~");
            System.out.println("4. {[}){{))))");
            System.out.println("5. Binary tree depth");
            System.out.println("~~~~Level three~~~~");
            System.out.println("6. Game of Life DEMO");
            System.out.println(str);
            str = "";
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int inputValue = 0;
            String inputString = "";
            try {
                inputString = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (StringUtils.isNumeric(inputString)) {
                inputValue = Integer.parseInt(inputString);
                if (inputValue >= 1 && inputValue <= 6) {
                    starterTaskNumber(inputValue, reader);
                } else {
                    str = "Please write number between 1 and 6";
                }
            } else {
                str = "U write  symbol not number";
            }
        }
    }

    private static void starterTaskNumber(int inputValue, BufferedReader reader) {

        switch (inputValue) {
            case 1:
                runArrayUtil(reader);
                break;
            case 2:
                runKnightMove(reader);
                break;
            case 3:
                runAreaOfATriangle(reader);
                break;
            case 4:
                runStringVerification(reader);
                break;
            case 5:
                runBinaryTree(reader);
                break;
            case 6:
                runGameOfLife(reader);
                break;

        }
    }

    private static void runGameOfLife(BufferedReader reader) {
        new GameOfLife().initialize();
    }

    private static void runBinaryTree(BufferedReader reader) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        clearConsole();
        System.out.println("Lets crate a tree");
        System.out.println("How many numbers do you want to write in tree?: ");

        int size = scanner.nextInt();
        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Please write " + (i + 1) + " number");
            int val = scanner.nextInt();
            data[i] = val;
        }

        new BinaryTree().run(data);

    }

    private static void runStringVerification(BufferedReader reader) {
        clearConsole();
        System.out.println("Lets check string");
        System.out.print("Write a string: ");
        try {
            String input = reader.readLine();
            System.out.println(new StringVerification().stringVerification(input) ?
                    "String accepted" : "String decline");
            Thread.sleep(5000);

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    private static void runAreaOfATriangle(BufferedReader reader) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        clearConsole();
        System.out.println("Lets find Area of a triangle");
        System.out.println("Please write coord of first point");
        System.out.print("Ax: ");

        int aXNum = scanner.nextInt();

        System.out.print("aY: ");
        int aYNum = scanner.nextInt();

        System.out.print("Bx: ");

        int bXNum = scanner.nextInt();

        System.out.print("By: ");
        int bYNum = scanner.nextInt();

        System.out.print("Cx: ");
        int cXNum = scanner.nextInt();

        System.out.print("cY: ");
        int cYNum = scanner.nextInt();
        new AreaOfATriangle().getArea(new int[][]{{aXNum, aYNum}, {bXNum, bYNum}, {cXNum, cYNum}});


    }

    private static void runKnightMove(BufferedReader reader) {

        while (true) {

            clearConsole();
            new KnightMove().start();
            System.out.println("Hello, lets write start coords! OR 0 to exit chess");
            System.out.print("Please write number of cell");
            String inputNumberString = null;
            int inputNumber = -1;
            try {
                inputNumberString = reader.readLine();
                if (StringUtils.isNumeric(inputNumberString) && inputNumberString.length() == 1) {


                    inputNumber = Integer.parseInt(inputNumberString);
                    if (inputNumber == 0) {
                        break;
                    }
                    if (inputNumber < 1 || inputNumber > 8) {
                        System.out.println("Number must be from 1 to 8");
                        try {
                            Thread.sleep(3000);
                            continue;
                        } catch (InterruptedException e) {
                            e.printStackTrace();

                        }
                    }
                } else {
                    System.out.println("Write one number please");
                    try {
                        Thread.sleep(3000);
                        continue;
                    } catch (InterruptedException e) {
                        e.printStackTrace();

                    }
                }

                System.out.print("Please write letter of cell:");
                String inputLetterString = reader.readLine().toUpperCase(Locale.ROOT);
                if (!StringUtils.isAlpha(inputLetterString) || (inputLetterString.length() != 1)) {
                    System.out.println("Write one letter please:");
                    try {
                        Thread.sleep(3000);
                        continue;
                    } catch (InterruptedException e) {
                        e.printStackTrace();

                    }
                }
                clearConsole();
                new KnightMove().start();
                System.out.println("Lets write finish coords!");
                System.out.print("Please write number of cell:");
                String inputNumberStringFinish = reader.readLine();
                int inputNumberFinish = -1;
                if (!StringUtils.isNumeric(inputNumberStringFinish)
                        || inputNumberStringFinish.length() != 1) {
                    System.out.println("Write one number  please:");
                    try {
                        Thread.sleep(3000);
                        continue;
                    } catch (InterruptedException e) {
                        e.printStackTrace();

                    }
                } else {

                    inputNumberFinish = Integer.parseInt(inputNumberStringFinish);
                    if (inputNumberFinish > 8 && inputNumberFinish < 1) {

                        System.out.println("Number must be from 1 to 8");
                        try {
                            Thread.sleep(3000);
                            continue;
                        } catch (InterruptedException e) {
                            e.printStackTrace();

                        }
                    }
                }
                System.out.print("Please write letter of cell:");
                String inputLetterStringFinish = null;
                try {
                    inputLetterStringFinish = reader.readLine().toUpperCase(Locale.ROOT);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (inputLetterStringFinish.length() != 1 || !StringUtils.isAlpha(inputLetterStringFinish)) {
                    System.out.println("Write one letter please:");
                    try {
                        Thread.sleep(3000);
                        continue;
                    } catch (InterruptedException e) {
                        e.printStackTrace();

                    }
                }

                if (new KnightMove().checkMove(inputNumber, inputLetterString.charAt(0),
                        inputNumberFinish, inputLetterStringFinish.charAt(0))) {
                    new KnightMove().addStartPointToChessField(inputNumber, inputLetterString.charAt(0));
                    new KnightMove().addFinishPointToChessField(inputNumberFinish, inputLetterStringFinish.charAt(0));
                    new KnightMove().start();
                    System.out.println("Thats all.");
                } else {
                    System.out.println("Wrong turn");
                    try {
                        Thread.sleep(5000);
                        continue;
                    } catch (InterruptedException e) {
                        e.printStackTrace();

                    }
                    break;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

   private static void clearConsole(){
       
           System.out.print("\033[H\033[2J");
           System.out.flush();
       
   }
   
    private static void runArrayUtil(BufferedReader reader) {
        int[] inputArray = new int[0];

        while (true) {
            clearConsole();
            System.out.println();
            System.out.print("Write  positive number:");
            String input = null;
            try {
                input = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (StringUtils.isNumeric(input)) {
                int inputNum = Integer.parseInt(input);
                inputArray = Arrays.copyOf(inputArray, inputArray.length + 1);
                inputArray[inputArray.length - 1] = inputNum;
                System.out.println("Add another number? 1:Yes 2:No");
                String choice = null;
                try {
                    choice = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (StringUtils.isNumeric(choice)) {
                    int value = Integer.parseInt(choice);
                    if (value == 1) {
                        continue;
                    }
                } else {
                    System.out.println("Please write positive numbers");
                    try {
                        Thread.sleep(3000);
                        continue;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("Please write positive numbers");
                try {
                    Thread.sleep(3000);
                    continue;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            new ArrayUtil().getAmountOfUniqNumber(inputArray);
            break;
        }
    }
}
