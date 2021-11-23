package ua.com.alevel;

import java.math.BigDecimal;

public class MathSet {

    private int capacity = -1;
    Number[] numbers = new Number[0];
    //todo нужен ли
    boolean haveNull = false;

    public MathSet(int capacity) {
        this.capacity = capacity;
    }

    public MathSet() {
    }

    public MathSet(Number[] numbers) {
        this.numbers = removeDuplicates(numbers);
    }

    public MathSet(Number[]... numbers) {
        for (Number[] number : numbers) {
            add(number);
        }
    }

    public MathSet(MathSet numbers) {
        this.numbers = numbers.toArray();
    }

    public MathSet(MathSet... numbers) {
        Number[] temporaryNumberArr = new Number[0];
        for (MathSet number : numbers) {
            for (Number number1 : number.toArray()) {
                temporaryNumberArr = addToArr(temporaryNumberArr, number1);
            }
            add(temporaryNumberArr);
        }
    }

    void add(Number n) {
        Number[] tempNumber = new Number[numbers.length + 1];
        if (capacity == -1 || capacity > numbers.length) {
            if (numbers.length == 0) {
                numbers = new Number[]{n};
            } else {
                for (int i = 0; i < tempNumber.length - 1; i++) {
                    tempNumber[i] = numbers[i];
                }
                tempNumber[tempNumber.length - 1] = n;
                numbers = removeDuplicates(tempNumber);
            }
        } else {
            System.out.println("Множество заполнено. Необходимо изменить Capasity" + Thread.currentThread().getName());
        }
    }

    void add(Number... n) {
        if (capacity == -1 || capacity >= this.numbers.length + n.length) {
            for (Number number : n) {
                add(number);
            }
//            numbers = removeDuplicates(this.numbers);
        } else {
            System.out.println("Множество заполнено. Необходимо изменить Capasity");
        }
    }

    void join(MathSet ms) {
        Number[] tempNum = ms.toArray();
        add(ms.toArray());
    }

    void join(MathSet... ms) {
        for (MathSet mathSet : ms) {
            Number[] tempNum = mathSet.toArray();
            add(tempNum);
        }
    }

    void intersection(MathSet ms) {
        Number[] temporaryNumberArr = new Number[0];

        for (Number number : ms.toArray()) {
            for (Number number1 : this.numbers) {
                if (number.equals(number1)) {
                    temporaryNumberArr = addToArr(temporaryNumberArr, number1);
                }
            }
        }
        this.numbers = removeDuplicates(temporaryNumberArr);
    }

    void intersection(MathSet... ms) {
        Number[] temporaryNumberArr = new Number[0];
        for (MathSet m : ms) {
            for (Number number : m.toArray()) {
                temporaryNumberArr = addToArr(temporaryNumberArr, number);
            }
        }
        temporaryNumberArr = removeDuplicates(temporaryNumberArr);
        intersection(new MathSet(temporaryNumberArr));
    }

    public void sortDesc() {
        //убывание
        sortDesc(0, this.numbers.length);
    }

    public void sortDesc(int firstIndex, int lastIndex) {
//
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = firstIndex + 1; i < lastIndex; i++) {
                if (new BigDecimal(numbers[i].toString()).compareTo(new BigDecimal(numbers[i - 1].toString())) > 0) {
                    swap(this.numbers, i, i - 1);
                    sorted = false;
                }
            }
        }
    }

    public void sortDesc(Number value) {
        sortDesc(findIndex(value), this.numbers.length);
    }

    public void sortAsc() {
        //убывание
        sortAsc(0, this.numbers.length);
    }

    public void sortAsc(int firstIndex, int lastIndex) {
        //убывание
        Number[] currentNumbers = this.numbers;
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = firstIndex + 1; i < lastIndex; i++) {
                if (new BigDecimal(numbers[i].toString()).compareTo(new BigDecimal(numbers[i - 1].toString())) < 0) {
                    swap(this.numbers, i, i - 1);
                    sorted = false;
                }
            }
        }
    }

    public void sortAsc(Number value) {
        sortAsc(findIndex(value), this.numbers.length);
    }

    public Number get(int index) {
        return this.numbers[index];

    }

    public Number getMax() {
        sortDesc();
        return this.numbers[0];
    }

    public Number getMin() {
        sortAsc();
        return this.numbers[0];
    }

    public Number getAverage() {
        BigDecimal sum = new BigDecimal("0");
        int count = 0;
        for (Number number : this.numbers) {
            sum = sum.add(new BigDecimal(String.valueOf(number)));
            count++;
        }
        return sum.divide(new BigDecimal(count));
    }

    public Number getMedian() {
        Number tempNumber = null;
        if (this.numbers.length % 2 == 0) {
            tempNumber = (new BigDecimal(numbers[this.numbers.length / 2].toString())
                    .add(new BigDecimal(numbers[(this.numbers.length / 2) + 1].toString())))
                    .divide(new BigDecimal("2"));
        } else {
            tempNumber = numbers[((numbers.length - 1) / 2) + 1];
        }
        return tempNumber;
    }

    public Number[] toArray() {
        return numbers;
    }

    public Number[] toArray(int firstIndex, int lastIndex) {
        Number[] tempNumbers = new Number[0];
        for (int i = firstIndex; i < lastIndex; i++) {
            tempNumbers = addToArr(tempNumbers, numbers[i]);
        }
        return tempNumbers;
    }


    public MathSet cut(int firstIndex, int lastIndex) {
        return new MathSet(toArray(firstIndex, lastIndex));
    }

    void clear() {
        for (int i = 0; i < this.numbers.length; i++) {
            this.numbers[i] = null;
        }
    }

    void clear(Number[] numbers) {
        for (Number number : numbers) {
            for (int i = 0; i < this.numbers.length; i++) {
                if (number.equals(this.numbers[i])) {
                    this.numbers[i] = null;
                }
            }
            this.numbers = removeNull(this.numbers);
        }
    }

    private void swap(Number[] n, int first, int last) {
        Number tempNumber;
        tempNumber = n[first];
        n[first] = n[last];
        n[last] = tempNumber;
    }

    private Number[] sortAsc(Number[] numbers) {
        if (checkForNull(numbers)) {
            numbers = removeNull(numbers);
        }

        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 1; i < numbers.length; i++) {

                if (new BigDecimal(numbers[i].toString()).compareTo(new BigDecimal(numbers[i - 1].toString())) < 0) {
                    swap(numbers, i, i - 1);
                    sorted = false;
                }
            }
        }

        return numbers;
    }

    private Number[] copyOf(Number[] numbers, int size) {
        Number[] tempNumber = new Number[size];
        System.arraycopy(numbers, 0, tempNumber, 0, size);
        return tempNumber;
    }

    private Number[] addToArr(Number[] numbers, Number number) {
        Number[] tempNum = new Number[0];
        if (numbers.length == 0) {
            tempNum = new Number[1];
            tempNum[tempNum.length - 1] = number;
        }
        if (numbers.length > 0) {
            tempNum = new Number[numbers.length + 1];
            for (int i = 0; i < numbers.length; i++) {
                tempNum[i] = numbers[i];
            }
            tempNum[tempNum.length - 1] = number;
        }
        return tempNum;
    }

    private Number[] removeDuplicates(Number[] numbers) {
        normalizeDoubleToFloat(numbers);
        // numbers = sortAsc(numbers);
        Number[] uniqNumber = new Number[numbers.length];
//        if (numbers.length == 0 || numbers.length == 1) {
//            return numbers;
//        }
        Number[] temp = new Number[numbers.length];
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            boolean flag = false;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i].equals(numbers[j])) {
                    flag = true;
                }
            }
            if (!flag) {
                temp[count++] = numbers[i];
            }
        }
        Number[] tmp2 = new Number[count];
        for (int i = 0; i < count; i++) {
            tmp2[i] = temp[i];
        }
        return tmp2;
    }

    private boolean checkForNull(Number[] numbers) {
        boolean rsl = false;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == null) {
                rsl = true;
                haveNull = true;
                break;
            }
        }
        return rsl;
    }

    private Number[] removeNull(Number[] numbers) {
        Number[] tempNumber = new Number[0];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == null) {
                continue;
            }
            tempNumber = addToArr(tempNumber, numbers[i]);
        }
        return tempNumber;
    }

    private void normalizeDoubleToFloat(Number[] n) {
        for (int i = 0; i < n.length; i++) {
            if (n[i] != null && n[i].getClass().getSimpleName().equals("Double")) {
                n[i] = (float) n[i].doubleValue();
            }
        }
    }

    private int findIndex(Number number) {
        int index = -1;
        for (int i = 0; i < this.numbers.length; i++) {
            if (number.equals(numbers[i])) {
                index = i;
            }
        }
        return index;
    }

    public String createString(Number[] n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n.length; i++) {
            sb.append(n[i]);
            sb.append(" ");
        }
        return sb.toString();
    }

    public String createString(MathSet m) {
        StringBuilder sb = new StringBuilder();
        Number[] n = m.toArray();
        for (int i = 0; i < n.length; i++) {
            sb.append(n[i].toString());
            sb.append(" ");
        }
        String rsl = sb.toString();
        return rsl;
    }
}

/*
    MathSet()
2. MathSet(int capacity)
        3. MathSet(Number[] numbers)
        4. MathSet(Number[] ... numbers)
        5. MathSet(MathSet numbers)
        6. MathSet(MathSet ... numbers)

        класс должен иметь следующие методы:


        1. void add(Number n)
        2. void add(Number ... n)
        //бьеденение без дубликатов

        3. void join(MathSet ms)
        4. void join(MathSet ... ms)
        //то что есть там и там
        //5 лонг и 5 инт это одно и тоже??
        // приводим к большему типу
        5. void intersection(MathSet ms)
        6. void intersection (MathSet ... ms)

        7. void sortDesc()
        //от первого  к последнего номера элемента
        8. void sortDesc(int firstIndex, int lastIndex)
        //от числа НУМБЕР и до конца
         9. void sortDesc(Number value)

        10. void sortAsc()
        11. void sortAsc(int firstIndex, int lastIndex)
        12. void sortAsc(Number value)
        // лучит по номеру элемента
        13. Number get(int index)
        14. Number getMax()
        15. Number getMin()
        // посередке/2
        16. Number getAverage()
         по статистике среднее например 1.4.5 - 4 медиана ,????
        17. Number getMedian()
        //вернут ьмассив намберов
        18. Number[] toArray();
        //вернут ьмассив намберов в диапазоне

        19. Number[] toArray(int firstIndex, int lastIndex);
        // вырезать и вернуть
        20. MathSet cut(int firstIndex, int lastIndex)
         вычестить
        21. void clear()
        удалить нумберс
        22. void clear(Number[] numbers) */
