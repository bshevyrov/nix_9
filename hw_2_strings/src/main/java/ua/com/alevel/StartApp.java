package ua.com.alevel;

public class StartApp {
    public static void main(String[] args) {
        System.out.println(Logic.reverse("hello world"));
        System.out.println(Logic.reverse("hello world", "worl"));
        System.out.println(Logic.reverse("hello world", 3, 7));
    }
}
