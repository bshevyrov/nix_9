import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ScreenMenu {

    public static void run(ArrayList<TaskHelper> taskHelpers, String[] descriptions) throws IOException {
        for (int i = 0; i < taskHelpers.size(); i++) {
            System.out.println("MENU: ");
            System.out.println(i + ". " + descriptions[i]);
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(bufferedReader.readLine());
        taskHelpers.get(input).run(bufferedReader);
    }


}
