package ua.com.alevel;

import java.math.BigDecimal;

public class MathSet {
    //TODO разобраться с NULL
    //TODO проверить что втулил везде  АДД вместо АДДту аррей
    //11.03 в начале
    //запрет расширения массива если он достиг капасити
    //вместимость
    //Если будет АДД не впускать или просить пересоздать

    //мб добавить метод капасити и Мас сет
    int capacity = -1;

    /*// переделать в to string
    public Number[] getNumbers() {
        return this.numbers;
    }*/

    //todo проверить что за рамки капасити не выходит
    public void setNumbers(Number[] numbers) {
        this.numbers = numbers;
    }

    Number[] numbers;
    boolean haveNull = false;

    public MathSet(int capacity) {
        //запрет расширения массива если он достиг капасити

        this.capacity = capacity;
    }

    public MathSet() {
    }

    public MathSet(Number[] numbers) {
        this.numbers = removeDuplicates(numbers);
    }

    public MathSet(Number[]... numbers) {
        Number[] temporaryNumberArr = new Number[0];
        for (Number[] number : numbers) {
            add(number);
           /* for (Number number1 : number) {
                temporaryNumberArr = ArrayUtils.add(temporaryNumberArr, number1);
            }*/
        }
        //this.numbers = removeDuplicates(temporaryNumberArr);
    }

    public MathSet(MathSet numbers) {
        this.numbers = numbers.toArray();
    }

    public MathSet(MathSet... numbers) {
        //   Number[] temporaryNumberArr = new Number[0];
        for (MathSet number : numbers) {
            Number[] tempNum = number.toArray();
            add(tempNum);
//            for (Number number1 : tempNum) {
//                temporaryNumberArr= ArrayUtils.add(temporaryNumberArr,number1);
//            }
        }
//        this.numbers = removeDuplicates(temporaryNumberArr);
    }

    void add(Number n) {
        this.numbers = addToArr(this.numbers, n);
        this.numbers = removeDuplicates(this.numbers);
    }

    void add(Number... n) {
        for (Number number : n) {
            add(n);
        }
        this.numbers = removeDuplicates(this.numbers);
    }

    void join(MathSet ms) {
        Number[] tempNum = ms.toArray();
        add(tempNum);
    }

    void join(MathSet... ms) {
        // ghfdbkmyj kb hf.,jnftn
        for (MathSet mathSet : ms) {
            Number[] tempNum = mathSet.toArray();
            add(tempNum);
        }
    }

    void intersection(MathSet ms) {
        Number[] temporaryNumberArr = new Number[0];
        // int index=0;
//        Number[] tempNum = ;
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
        //Правильно ли работает?    персечение с первым МС или пересечение с результатом первого пересечения МС
        Number[] temporaryNumberArr = new Number[0];
        for (MathSet m : ms) {
            intersection(m);
        }
    }

    public void sortDesc() {
        //убывание
        sortDesc(0, this.numbers.length);
    }

    public void sortDesc(int firstIndex, int lastIndex) {
        //убывание
        //от фирст до ласт или включительно ласт
        Number[] currentNumbers = this.numbers;
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
            sum.add(new BigDecimal(String.valueOf(number)));
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
        return this.numbers;
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
        }
    }

    private void swap(Number[] n, int first, int last) {
        Number tempNumber;
        tempNumber = n[first];
        n[first] = n[last];
        n[last] = tempNumber;
    }

    private Number[] sortAsc(Number[] numbers) {
        //возраст

        if (checkForNull(numbers)) {
            // haveNull = true;
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
        numbers = sortAsc(numbers);
        Number[] uniqNumber = new Number[numbers.length];
        int index = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (!numbers[i - 1].equals(numbers[i])) {
                uniqNumber[index++] = numbers[i];
            }
        }
        return copyOf(uniqNumber, index);
    }


    private boolean checkForNull(Number[] numbers) {
        boolean rsl = false;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == null) {
                rsl = true;
                haveNull=true;
                break;
            }
        }
        return rsl;
    }

    //    private void keepOneNull(Number[] numbers){
//        Number[] tempNumber = new Number[0];
//        boolean haveNull = false;
//        int count = 0;
//        for (int i = 0; i < numbers.length; i++) {
//            if(numbers[i]==null){
//                haveNull = true;
//                continue;
//            }
//            tempNumber = addToArr(tempNumber, numbers[i]);
//            if(haveNull){
//                tempNumber = addToArr(tempNumber, null);
//                numbers= tempNumber;
//            }
//            numbers= tempNumber;
//
//        }
//    }
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


    private int findIndex(Number number) {
        int index = -1;
        for (int i = 0; i < this.numbers.length; i++) {
            if (number.equals(numbers[i])) {
                index = i;
            }
        }
        return index;
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
