
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ASUS G731G
 */
class Inputter {

    //input choice
    public static int inputChoice() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input your choice: ");
        int input = 0;
        while (true) {
            try {
                do {
                    //user input
                    input = Integer.parseInt(sc.nextLine());
                    //check if input is a positive number then display a message
                    //the require user input again
                    if (input < 0) {
                        System.err.print("Choice cannot be a negative number ! "
                                + "\nPlease input again: ");
                        //if input over range 1-5 display a message and require input a gain
                    } else if (input == 0 || input > 5) {
                        System.err.print("Sorry we don't have choice is " + input
                                + " !" + "\nPlease input again: ");
                    }
                } while (input < 1 || input > 5);
                break;
            } catch (Exception e) {
                System.err.print("Your choice must be number in range [1-5]"
                        + "\nPlease input again: ");
            }
        }
        return input;
    }

    //input a string with regex
    public static String inputStringRegex(String msg, String err, String regex) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(msg);
            String str = sc.nextLine();
            //check string empty
            if (str.isEmpty()) {
                System.out.println("This property can not empty!");
            } else {
                //if str input matches with regex then return string
                if (str.matches(regex)) {
                    return str;
                } else {
                    //if str input difference regex then display error msg
                    System.out.println(err);
                }
            }
        }
    }

    //input a float number
    public static float inputFloatNumber(String msg) {
        float number = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println(msg);
        while (true) {
            try {
                number = Float.parseFloat(sc.nextLine());
                //check user input a negative number or not ?
                //if it is a negative number display a message and re-input
                if (number < 0) {
                    System.out.println("Area can't a negative number");
                    System.out.println("Please input again: ");
                } else {
                    //when number >0 then return
                    return number;
                }
            } catch (Exception e) {
                System.out.println("Area must be the numbers!");
                System.out.println("Please input again: ");
            }
        }
    }
}
