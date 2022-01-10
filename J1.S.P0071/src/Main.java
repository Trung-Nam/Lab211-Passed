
import static java.lang.System.exit;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS G731G
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Task> TaskList = new ArrayList<>();
        int[] idLast = new int[1];
        TaskManager manager = new TaskManager();
        // loop until user want exit
        while (true) {
            // step1 : display menu
            manager.DisplayMenu();
            // step2 : user select an option
            int choice = Inputter.inputChoice();
            switch (choice) {
                // step3 : choose 1 to add task
                case 1:
                    manager.AddTask(TaskList, idLast);
                    break;
                // step4 : choose 2 to delete task
                case 2:
                    manager.DeleteTask(TaskList);
                    break;
                // step5 : choose 3 to show task
                case 3:
                    manager.ShowTask(TaskList);
                    break;
                // step6 : choose 4 to exit
                case 4:
                    exit(0);
            }
        }
    }

}
