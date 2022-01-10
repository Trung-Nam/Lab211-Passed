
import static java.lang.System.exit;

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
        CalculatorMatrix calMatrix = new CalculatorMatrix();
        Inputter Inputter = new Inputter();
        while (true) {
            //step 1: dislay the menu
            calMatrix.displayMenu();
            //step 2: user input an option
            int choice = Inputter.inputChoice();
            switch (choice) {
                case 1:
                    //step 3: when user choice 1 Addition matrixes
                    calMatrix.AdditionMatrix();
                    break;
                case 2:
                    //step 4: when user choice 2 Subtraction matrixes
                    calMatrix.SubtractionMatrix();
                    break;
                case 3:
                    //step 5: when user choice 3 Multiplication matrixes
                    calMatrix.MultiplicationMatrix();
                    break;
                //step 6: exit program
                case 4:
                    exit(0);
            }
        }
    }

}
