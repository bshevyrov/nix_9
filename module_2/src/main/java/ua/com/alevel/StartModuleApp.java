package ua.com.alevel;

import java.io.File;

public class StartModuleApp {

    public static void main(String[] args) {

        File dates = new File("src/main/resources/dates.txt");
        File names = new File("src/main/resources/names.txt");

        //new DatesList().separateStringByOneEntry(FileHandler.readStringsFromFile(dates));
        new UniqNameFinder().findUniqString(FileHandler.readStringsFromFile(names));
    }
}
