package ua.com.alevel;

import java.util.Arrays;
import java.util.HashMap;

public class MathSet {

    private int capacity = -1;
    private int minSizeOfNumber = 6;
    private int percentsOfLoading = 75;
    private int triggerForResizing = (capacity * percentsOfLoading) / 100;

    private Number[] numbers = new Number[minSizeOfNumber];

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    MathSet() {
    }

    MathSet(int capacity) {
        //TODO ПРоверить  везде ли проверяется условие не вылащить зп капасити
        setCapacity(capacity);
    }

    MathSet(Number[] numbers) {
        //TODO А ТУТ ВАЖНО КАПАСИТИ????
        this.numbers = Arrays.copyOf(this.numbers,numbers.length);
        this.numbers = numbers;
    }

    MathSet(Number[] ... numbers){

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
        3. void join(MathSet ms)
        4. void join(MathSet ... ms)
        5. void intersection(MathSet ms)
        6. void intersection (MathSet ... ms)
        7. void sortDesc()
        8. void sortDesc(int firstIndex, int lastIndex)
        9. void sortDesc(Number value)
        10. void sortAsc()
        11. void sortAsc(int firstIndex, int lastIndex)
        12. void sortAsc(Number value)
        13. Number get(int index)
        14. Number getMax()
        15. Number getMin()
        16. Number getAverage()
        17. Number getMedian()
        18. Number[] toArray();
        19. Number[] toArray(int firstIndex, int lastIndex);
        20. MathSet cut(int firstIndex, int lastIndex)
        21. void clear()
        22. void clear(Number[] numbers) */
