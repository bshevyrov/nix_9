package ua.com.alevel;

public class StartHelper {
    MathSet mS = new MathSet();

    private Number n = -13.3;
    private Number[] n1 = new Number[]{0, -13.3, -13.3f, 99, 7, 6, 7, -666};
    private Number[] n2 = new Number[]{0, 99, 123, -66.6f, -99, 0};
    private Number[] n3 = new Number[]{6};
    private MathSet m = new MathSet(new Number[]{66, 13.3, 13, -1});
    private MathSet m1 = new MathSet(new Number[]{66, 13.3, 13, -1, 0});
    private MathSet m2 = new MathSet(new Number[]{1, -1, 3});
    private MathSet m3 = new MathSet(new Number[]{2});


    public void greetings() {
        ScreenMenu.clearConsole();
        System.out.println("Привет %ЮзерНейм%!");
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
        // System.out.println("2.MathSet(int capacity");
        System.out.println("1.MathSet(Number[] numbers) + {0,-13.3,-13.3f,99,7,6,7,-666}");
        System.out.println("2.MathSet(Number[] ... numbers) + {0,-13.3,-13.3f,99,7,6,7,-666}{0,99,123,-66.6f,-99,0},{6}");
//        System.out.println("3.MathSet(MathSet numbers)");
        System.out.println("3.MathSet(MathSet ... numbers) + {66,13.3,13,-1,0}{1,-1,3}{2}");
        System.out.println("Жми Энтер и мы узнаем что получится.");
    }

    public void constructorsAnswers() {

        System.out.println("1. " + mS.createString(new MathSet(n1)));
        System.out.println("2. " + mS.createString(new MathSet((n1), (n2), (n3))));
        System.out.println("3. " + mS.createString(new MathSet((m1), (m2), (m3))));
        System.out.println("Жми Энтер и мы узнаем что получится.");
    }


}
