package ua.com.alevel;

public class StartHelper {
    
    MathSet mS = new MathSet();

    private Number n = -13.3;
    private Number[] n1 = new Number[]{0, -13.3, -13.3f, 99, 7, 6, 7, -666};
    private Number[] n2 = new Number[]{0, 99, 123, -66.6f, -99, 0};
    private Number[] n3 = new Number[]{6};
    private MathSet m1 = new MathSet(new Number[]{66, 13.3, 13, -1, 0});
    private MathSet m2 = new MathSet(new Number[]{1, -1, 3});
    private MathSet m3 = new MathSet(new Number[]{2});


    public void greetings() {
        ScreenMenu.clearConsole();
        System.out.println("Привет, %ЮзерНейм%!");
        System.out.println("Я позаботился о тебе и предсоздал все данные чтобы не вводил их руками");
        System.out.println("То есть, будь моим ГОСТЕМ и смотри как я буду тебе показывать аккробатические трюки");
        System.out.println("Неволнуйся, никаких фокусов и магии, тебя никто не обманывает");
        System.out.println("Если захочешь проверить все САМ то ты знаешь как это сделать");
        System.out.println("Ну чтож начнем...");
        System.out.println("Number n  -13.3");
        System.out.println("Number[] ... nn  {0,-13.3,-13.3f,99,7,6,7,-666}{0,99,123,-66.6f,-99,0},{6}");
        System.out.println("MathSet  m  {66,13.3,13,-1}");
        System.out.println("MathSet ... mm  {66,13.3,13,-1,0}{1,-1,3}{2}");
        System.out.println("Жми Энтер и мы продолжим");
    }

    public void constructors() {
        ScreenMenu.clearConsole();
        System.out.println("Давай попробуем проверить конструкторы");
        System.out.println("1.MathSet(Number[] numbers) + {0,-13.3,-13.3f,99,7,6,7,-666}");
        System.out.println("2.MathSet(Number[] ... numbers) + {0,-13.3,-13.3f,99,7,6,7,-666}{0,99,123,-66.6f,-99,0},{6}");
        System.out.println("3.MathSet(MathSet ... numbers) + {66,13.3,13,-1,0}{1,-1,3}{2}");
        System.out.println("Жми Энтер и мы узнаем что получится.");
    }

    public void constructorsAnswers() {
        System.out.println("1. " + mS.createString(new MathSet(n1)));
        mS = new MathSet((n1), (n2), (n3));
        System.out.println("2. " + mS.createString(mS.toArray()));
        System.out.println("3. " + mS.createString(new MathSet((m1), (m2), (m3))));
        System.out.println("Жми Энтер и мы продолжим.");
    }

    public void methods() {
        ScreenMenu.clearConsole();
        System.out.println("Отлично!!!");
        System.out.println("Теперь я покажу тебе  как работают некоторые методы");
        System.out.println("Например ");
        System.out.println("1. MathSet(int capacity) + 2");
        System.out.println("2. void add(Number n) + -13.3");
        System.out.println("3. void add(Number ... n) + {0, 99, 123, -66.6f, -99, 0},{6},{0, -13.3, -13.3f, 99, 7, 6, 7, -666}");
        System.out.println("4. void clear(Number[] numbers) + {0, 99, 123, -66.6f, -99, 0}");
        System.out.println("Если ты готов, то нажми на Энтер. Посмотрим на результат");

    }

    public void methodsAnswer() {
        mS.clear();
        mS = new MathSet(2);
        System.out.println("1. " + "Тут мы создали новый сет с capacity = 2");
        mS.add(n);
        System.out.println("2. " + mS.createString(mS.toArray()));
        System.out.println("3. Добавляем массив массивов. Ты же помнишь, что мы выставили capacity = 2? Как думаешь что произойдет??");
        mS.add(n1);
        System.out.println("Теперь проверим что мы ничего не смогли добавить(");
        mS.createString(mS.toArray());
        System.out.println("Давай уберем ограничение и выполним  операцию 3. заново");
        mS = new MathSet(-1);
        mS.add(n2);
        mS.add(n3);
        mS.add(n1);
        System.out.println(mS.createString(mS.toArray()));
        mS.clear(n2);
        System.out.println("4. " + mS.createString(mS.toArray()));
        mS.clear();
        System.out.println("Жми Энтер и мы продолжим.");
    }

    public void methodPartTwo() {
        ScreenMenu.clearConsole();
        System.out.println("Фуууух!!Самое сложное мы прошли");
        System.out.println("Впереди нас ждет Математическое веселье!!");
        System.out.println("Ты со мной, %ЮзерНейм%?");
        System.out.println("В этой части мы будем использовать множество {66, 13.3, 13, -1, 0}");
        System.out.println("Как насчёт ");
        System.out.println("1. Number get(int index) + 3 ?");
        System.out.println("2. Number getMax() ?");
        System.out.println("3. Number getMin() ?");
        System.out.println("4. Number getAverage() ?");
        System.out.println("5. Number getMedian() ?");
        System.out.println("6. MathSet cut(int firstIndex, int lastIndex) 2,4");
        System.out.println("A?");
        System.out.println("Думаю ты запомнил куда нажать чтобы продолжить?) (Энтер)");
    }

    public void methodPartTwoAnswer() {
        mS = new MathSet(m1);
        System.out.println("1. " + mS.createString(new Number[]{mS.get(3)}));
        System.out.println("2. " + mS.createString(new Number[]{mS.getMax()}));
        System.out.println("3. " + mS.createString(new Number[]{mS.getMin()}));
        System.out.println("4. " + mS.createString(new Number[]{mS.getAverage()}));
        System.out.println("5. " + mS.createString(new Number[]{mS.getMedian()}));
        mS = new MathSet(new Number[]{66, 13.3, 13, -1, 0});
        System.out.println("6. " + mS.createString(mS.cut(2,4)));
        mS.clear();
        System.out.println("Жми Энтер и мы продолжим.");
    }

    public void methodLastPart() {
        ScreenMenu.clearConsole();
        System.out.println("Как быстро пролетело время(");
        System.out.println("Мы уже подобрались к концу");
        System.out.println("В этой части мы в каждой операции будем  использовать множество {66, 13.3, 13, -1, 0}");
        System.out.println("1.void sortDesc()");
        System.out.println("2.void sortDesc(int firstIndex, int lastIndex) + 1, 3");
        System.out.println("3.void sortDesc(Number value) + 13");
        System.out.println("4.void sortAsc()");
        System.out.println("5.void sortAsc(int firstIndex, int lastIndex) + 0, 4");
        System.out.println("6.void sortAsc(Number value) + 13");
        System.out.println("7.void intersection (MathSet ms) + {1, -1, 3,13.3}");
        System.out.println("8.void intersection (MathSet … ms) + {1, -1, 3},{2}");
        System.out.println("9.void join(MathSet ms) +  {2}");
        System.out.println("10.void join(MathSet … ms) +  {1, -1, 3},{2}");
        System.out.println("Жамкай большую кнопку.");
    }

    public void methodLastPartAnswer() {
        mS = new MathSet(new Number[]{66, 13.3, 13, -1, 0});
        mS.sortDesc();
        System.out.println("1. " + mS.createString(mS.toArray()));
        mS = new MathSet(new Number[]{66, 13.3, 13, -1, 0});
        mS.sortDesc(1, 3);
        System.out.println("2. " + mS.createString(mS.toArray()));
        mS = new MathSet(new Number[]{66, 13.3, 13, -1, 0});
        mS.sortDesc(13);
        System.out.println("3. " + mS.createString(mS.toArray()));
        mS = new MathSet(new Number[]{66, 13.3, 13, -1, 0});
        mS.sortAsc();
        System.out.println("4. " + mS.createString(mS.toArray()));
        mS = new MathSet(new Number[]{66, 13.3, 13, -1, 0});
        mS.sortAsc(0, 4);
        System.out.println("5. " + mS.createString(mS.toArray()));
        mS = new MathSet(new Number[]{66, 13.3, 13, -1, 0});
        mS.sortAsc(13);
        System.out.println("6. " + mS.createString(mS.toArray()));
        mS = new MathSet(new Number[]{66, 13.3, 13, -1, 0});
        mS.intersection(new MathSet(new Number[]{1, -1, 3,13.3}));
        System.out.println("7. " + mS.createString(mS.toArray()));
        mS = new MathSet(new Number[]{66, 13.3, 13, -1, 0});
        mS.intersection(m2, m3);
        System.out.println("8. " + mS.createString(mS.toArray()));
        mS = new MathSet(new Number[]{66, 13.3, 13, -1, 0});
        mS.join(m3);
        System.out.println("9. " + mS.createString(mS.toArray()));
        mS = new MathSet(new Number[]{66, 13.3, 13, -1, 0});
        mS.join(m2, m3);
        System.out.println("10. " + mS.createString(mS.toArray()));


        System.out.println("Это было здорово");
        System.out.println("Хорошего дня!! Пока.");
    }
}