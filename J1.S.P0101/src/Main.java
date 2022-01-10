
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
        ArrayList<Employee> Elist = new ArrayList<>();
        EmployeeManager Emanager = new EmployeeManager();
        Inputter inputter = new Inputter();
        int choice;
        while(true) {
            //step 1: display a menu
            Emanager.displayMenu();
                //step 2: ask user select an option in menu
                choice = inputter.inputChoice();
            switch (choice) {
                case 1:
                    //step 3: when user choice option 1 then add employee
                    Emanager.addEmployee(Elist);
                    break;
                case 2:
                    //step 4: when user choice option 2 then update employee
                    Emanager.updateEmployee(Elist);
                    break;
                case 3:
                    //step 5: when user choice option 3 then remove employee
                    Emanager.removeEmployee(Elist);
                    break;
                case 4:
                    //step 6: when user choice option 4 then search employee by name
                    Emanager.searchEmployeeByName(Elist);
                    break;
                case 5:
                    //step 7: when user choice option 5 then sort employee
                    Emanager.sortEmployeeBySalary(Elist);
                    break;
                case 6:
                    //step 8: when user choice option 6 then exit
                    exit(0);
                    break;
            }
        }
    }

}
