package ua.com.alevel;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import ua.com.alevel.exceptions.BlankDate;
import ua.com.alevel.exceptions.IllegalDateNumbers;
import ua.com.alevel.exceptions.IllegalDateType;
import ua.com.alevel.exceptions.IllegalTimeNumbers;

import java.io.BufferedReader;
import java.io.IOException;

public class Menu {

    private static final long MS_IN_DAY = 86_400_000L;
    private static final long MS_IN_HOUR = 3_600_000L;
    private static final long MS_IN_MINUTE = 60_000L;
    private static final long MS_IN_SEC = 1_000L;
    String[] types = new String[]{"dd/mm/yy", "m/d/yyyy", "mmm-d-yy", "dd-mmm-yyyy 00:00"};
    InputChecker ic = new InputChecker();
    Calendar sC = new Calendar();

    public void chooseFormat(BufferedReader reader) {
        int inputFormatNum;
        while (true) {
            System.out.println("Выберите формат ввода");
            chooseInputType();
            try {
                inputFormatNum = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException e) {
                System.out.println("Ты ввел не цифру повтори");
                continue;
            } catch (IOException e) {
                System.out.println("Ошибка ввода вывода.");
                continue;
            }
            if (inputFormatNum < 0 || inputFormatNum > 3) {
                System.out.println("Введена не верная цифра");
                continue;
            }
            break;
        }
        inputFistOperandInput(reader, inputFormatNum);
    }

    private void chooseInputType() {
        ScreenMenu.clearConsole();
        System.out.println("0. dd/mm/yy - 01/12/21");
        System.out.println("1. m/d/yyyy - 3/4/2021");
        System.out.println("2. mmm-d-yy - Март 4 21");
        System.out.println("3. dd-mmm-yyyy 00:00 - 09 Апрель 789 45:23");
        System.out.print("Введи цифру:");
    }

    public void inputFistOperandInput(BufferedReader reader, int inputFormat) {
        String input;
        long firstOperand;
        while (true) {
            ScreenMenu.clearConsole();
            System.out.println("Введи первую дату в указанном формате");
            System.out.println(types[inputFormat]);
            System.out.print("Введи дату:");
            try {
                input = reader.readLine();
            } catch (IOException e) {
                System.out.println("Ошибка ввода вывода.");
                continue;
            }
            try {
                ic.checkFormat(inputFormat, input);
            } catch (IllegalDateType | IllegalTimeNumbers | BlankDate | IllegalDateNumbers e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }
        firstOperand = sC.dateToMillieSeconds(input, inputFormat);
        operationWhatDo(reader, firstOperand);
    }

    public void operationWhatDo(BufferedReader reader, long firstOperand) {
        int input;
        while (true) {
            ScreenMenu.clearConsole();
            System.out.println("Выбери операцию какую хочешь сделать");
            System.out.println("0. Находить разницу между датами в миллисекундах, секундах, минутах, часах, днях и годах;");
            System.out.println("1. Прибавлять к дате миллисекунды, секунды, минуты, часы, дни и года;");
            System.out.println("2. Вычитать из даты миллисекунды, секунды, минуты, часы, дни и года;");
            System.out.println("3. Сравнивать перечень дат по убыванию и возрастанию;");
            System.out.print("Введи цифру:");
            try {
                input = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException e) {
                System.out.println("Ты ввел не цифру повтори");
                continue;
            } catch (IOException e) {
                System.out.println("Ошибка ввода вывода.");
                continue;
            }
            if (input < 0 || input > 3) {
                System.out.println("Введена не верная цифра");
                continue;
            }
            break;
        }
        secondOperandsInput(reader, firstOperand, input);
    }

    public void
    secondOperandsInput(BufferedReader reader, long firstOperand, int inputOperationNum) {
        //TODO если второе число больше чем 9999 год и месяц то попросить переввести
        String inputMore;
        String inputs;
        int inputFormatNum;
        String rsl;
        int outPutType = -1;
        long[] secondOperand = new long[0];
        if (inputOperationNum == 1 || inputOperationNum == 2) {
            while (true) {
                System.out.println("Что хотите добавить/вычесть?");
                System.out.println("0. Годы");
                System.out.println("1. Дни");
                System.out.println("2. Часы");
                System.out.println("3. Минуты");
                System.out.println("4. Секунды");
                System.out.println("5. Миллисекунды");
                try {
                    inputFormatNum = Integer.parseInt(reader.readLine());
                } catch (NumberFormatException e) {
                    System.out.println("Ты ввел не цифру повтори");
                    continue;
                } catch (IOException e) {
                    System.out.println("Ошибка ввода вывода.");
                    continue;
                }
                if (inputFormatNum < 0 || inputFormatNum > 6) {
                    System.out.println("Введена не верная цифра");
                    continue;
                }
                System.out.print("Ведите значение:");
                String localInput = null;
                try {
                    localInput = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (!StringUtils.isNumeric(localInput) || Integer.parseInt(localInput) < 1) {
                    System.out.println("Не верный ввод");
                    continue;
                }
                long localRsl = switch (inputFormatNum) {
                    case 0 -> sC.yearInDays(Integer.parseInt(localInput)) * MS_IN_DAY;
                    case 1 -> Integer.parseInt(localInput) * MS_IN_DAY;
                    case 2 -> Integer.parseInt(localInput) * MS_IN_HOUR;
                    case 3 -> Integer.parseInt(localInput) * MS_IN_MINUTE;
                    case 4 -> Integer.parseInt(localInput) * MS_IN_SEC;
                    case 5 -> Integer.parseInt(localInput);
                    default -> 0;
                };
                secondOperand = ArrayUtils.add(secondOperand, localRsl);
                break;
            }
        } else {
            if (inputOperationNum != 0) {
                while (true) {
                    System.out.println("Выберите формат ввода");
                    chooseInputType();
                    try {
                        inputFormatNum = Integer.parseInt(reader.readLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Ты ввел не цифру повтори");
                        continue;
                    } catch (IOException e) {
                        System.out.println("Ошибка ввода вывода.");
                        continue;
                    }
                    if (inputFormatNum < 0 || inputFormatNum > 3) {
                        System.out.println("Введена не верная цифра");
                        continue;
                    }

                    System.out.print("Введи дату в формате " + types[inputFormatNum] + ":");
                    try {
                        inputs = reader.readLine();
                    } catch (IOException e) {
                        System.out.println("Ошибка ввода вывода.");
                        continue;
                    }
                    try {
                        ic.checkFormat(inputFormatNum, inputs);
                    } catch (IllegalDateType | IllegalTimeNumbers | BlankDate | IllegalDateNumbers e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                    secondOperand = ArrayUtils.add(secondOperand, sC.dateToMillieSeconds(inputs, inputFormatNum));
                    if (inputOperationNum != 3) {
                        break;
                    }
                    //TODO вывести режим и если 4  то продолжаем
                    System.out.println("Если хочешь ввести еще дату введи 0");
                    try {
                        inputMore = reader.readLine();
                    } catch (IOException e) {
                        System.out.println("Ошибка ввода вывода.");
                        continue;
                    }
                    if (StringUtils.isNumeric(inputMore) && Integer.parseInt(inputMore) == 0) {
                        continue;
                    }
                    break;
                }
                while (true) {
                    System.out.println("Выберите формат вывода");
                    chooseInputType();
                    try {
                        outPutType = Integer.parseInt(reader.readLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Ты ввел не цифру повтори");
                        continue;
                    } catch (IOException e) {
                        System.out.println("Ошибка ввода вывода.");
                        continue;
                    }
                    if (outPutType < 0 || outPutType > 3) {
                        System.out.println("Введена не верная цифра");
                        continue;
                    }
                    break;
                }
            }
        }
        rsl = sC.getResult(firstOperand, inputOperationNum, secondOperand, outPutType);
        System.out.println(rsl);
    }
}
