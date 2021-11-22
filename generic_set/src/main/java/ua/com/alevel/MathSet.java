package ua.com.alevel;

import org.apache.commons.lang3.ArrayUtils;

import java.math.BigDecimal;
import java.util.Arrays;

public class MathSet {
    //TODO проверить что втулил везде  АДД вместо АДДту аррей
    //11.03 в начале
    //запрет расширения массива если он достиг капасити
    //вместимость
    //Если будет АДД не впускать или просить пересоздать

    //мб добавить метод капасити и Мас сет
    int capacity = -1;

    // переделать в to string
    public Number[] getNumbers() {
        return this.numbers;
    }

    //todo проверить что за рамки капасити не выходит
    public void setNumbers(Number[] numbers) {
        this.numbers = numbers;
    }

    Number[] numbers;

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
        this.numbers = numbers.getNumbers();
    }

    public MathSet(MathSet... numbers) {
        //   Number[] temporaryNumberArr = new Number[0];
        for (MathSet number : numbers) {
            Number[] tempNum = number.getNumbers();
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
        Number[] tempNum = ms.getNumbers();
        add(tempNum);
    }

    void join(MathSet... ms) {
        // ghfdbkmyj kb hf.,jnftn
        for (MathSet mathSet : ms) {
            Number[] tempNum = mathSet.getNumbers();
            add(tempNum);
        }
    }

    void intersection(MathSet ms) {
        Number[] temporaryNumberArr = new Number[0];
        // int index=0;
        Number[] tempNum = ms.getNumbers();
        for (Number number : tempNum) {
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
        Number[] currentNumbers = this.numbers;
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 1; i < currentNumbers.length; i++) {
                if (new BigDecimal(numbers[i].toString()).compareTo(new BigDecimal(numbers[i - 1].toString())) > 0) {
                    swap(this.numbers, i, i - 1);
                    sorted = false;
                }
            }
        }
    }

    public void sortAsc() {
        //убывание
        Number[] currentNumbers = this.numbers;
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 1; i < currentNumbers.length; i++) {
                if (new BigDecimal(numbers[i].toString()).compareTo(new BigDecimal(numbers[i - 1].toString())) < 0) {
                    swap(this.numbers, i, i - 1);
                    sorted = false;
                }
            }
        }
    }

    public Number[] sortAsc(Number[] numbers) {
        //возраст
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

    private void swap(Number[] n, int first, int last) {
        Number tempNumber;
        tempNumber = n[first];
        n[first] = n[last];
        n[last] = tempNumber;
    }

    private Number[] copyOf(Number[] numbers, int size){
        Number[] tempNumber = new Number[size];
        System.arraycopy(numbers,0,tempNumber,0,size);
        return tempNumber;
    }
    private Number[] addToArr(Number[] numbers, Number number){
      Number[] temp = new Number[numbers.length+1];
      temp[numbers.length-1] =number;
        return temp;
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

    public void returnClass(Number n) {
        System.out.println(n.getClass().getSimpleName());
        System.out.println(new BigDecimal("1242365376657"));
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
