package ua.com.alevel;

import java.math.BigDecimal;

public class MathSet {

    private int capacity = -1;
    Number[] numbers = new Number[0];

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
            System.out.println("Множество заполнено. Необходимо изменить Capacity");
        }
    }

    void add(Number... n) {
        if (capacity == -1 || capacity >= this.numbers.length + n.length) {
            for (Number number : n) {
                add(number);
            }
        } else {
            System.out.println("Множество заполнено. Необходимо изменить Capacity");
        }
    }

    void join(MathSet ms) {
        add(ms.toArray());
    }

    void join(MathSet... ms) {
        for (MathSet mathSet : ms) {
            add(mathSet.toArray());
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
        intersection(new MathSet(temporaryNumberArr));
    }

    public void sortDesc() {
        sortDesc(0, this.numbers.length);
    }

    public void sortDesc(int firstIndex, int lastIndex) {
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
        sortAsc(0, this.numbers.length);
    }

    public void sortAsc(int firstIndex, int lastIndex) {
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
        Number tempNumber;
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

        Number[] temp = new Number[numbers.length];
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            boolean flag = false;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i].equals(numbers[j])) {
                    flag = true;
                    break;
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

    private Number[] removeNull(Number[] numbers) {
        Number[] tempNumber = new Number[0];
        for (Number number : numbers) {
            if (number == null) {
                continue;
            }
            tempNumber = addToArr(tempNumber, number);
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
        for (Number number : n) {
            sb.append(number);
            sb.append(" ");
        }
        return sb.toString();
    }

    public String createString(MathSet m) {
        StringBuilder sb = new StringBuilder();
        Number[] n = m.toArray();
        for (Number number : n) {
            sb.append(number.toString());
            sb.append(" ");
        }
        return sb.toString();
    }
}
