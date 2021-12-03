package ua.com.alevel;

import ua.com.alevel.secondlevel.UniqNameFinder;
import ua.com.alevel.thirdlevel.Logic;

import java.io.File;

public class StartModuleApp {

    public static void main(String[] args) {

        File dates = new File("src/main/resources/dates.txt");
        File names = new File("src/main/resources/names.txt");
        File input = new File("src/main/resources/input.txt");
        File output = new File("src/main/resources/output.txt");

        //new DatesList().separateStringByOneEntry(FileHandler.readStringsFromFile(dates));
       // new UniqNameFinder().findUniqString(FileHandler.readStringsFromFile(names));
        new Logic().findEasyWay(FileHandler.readStringsFromFile(input));

    }
}
