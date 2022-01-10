
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
        StudentManager SManager = new StudentManager();
        ArrayList<Student> StudentList = new ArrayList<>();
        // loop until user want to exit
        while (true) {
            // display menu to main screen
            SManager.DisplayMenu();
            // user enter choice
            int choice = Inputter.inputChoice();
            switch (choice) {
                // choose 1 to create student
                case 1:
                    SManager.CreateStudent(StudentList);
                    break;
                // choose 2 to find list student and sort by name
                case 2:
                    SManager.FindAndSortStudentByName(StudentList);
                    break;
                // choose 3 to update or delete stdent by id
                case 3:
                    SManager.UpdateOrDeleteStudentById(StudentList);
                    break;
                // choose 4 to report information of student
                case 4:
                    SManager.ReportStudentInfo(StudentList);
                    break;
                // choose 5 to exit
                case 5:
                    exit(0);
            }
        }
    }

}
