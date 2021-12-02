package ua.com.alevel;

public class StartModuleApp {
    public static void main(String[] args) {
    DatesList datesList = new DatesList();
     String[] i = datesList.readStringsFromFile();
datesList.separateStringByOneEntry(i);
    }
}
