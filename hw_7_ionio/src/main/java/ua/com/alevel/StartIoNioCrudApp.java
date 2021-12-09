package ua.com.alevel;


import ua.com.alevel.utils.CrudMenu;

public class StartIoNioCrudApp {
    public static void main(String[] args) {
//не работате создание авторов после книги, тоесть им не присваиваються ники и после создания книги при создании авторов им не присваивается бук айди
        new CrudMenu().run();
    }
}
