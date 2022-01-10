
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
public class Inputter {

    //user input string name
    public String inputStringName() {
        Scanner sc = new Scanner(System.in);
        // loop until name is correct
        while (true) {
            String name = sc.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Name can't empty");
                System.out.print("Please input name again:");
            } else if (name.matches("^[a-zA-Z ]+$")) {
                return name;
            } else {
                System.out.println("Invalid Name!");
                System.out.print("Please input name again:");
            }
        }
    }

    //user input string address
    public String inputStringAddress() {
        Scanner sc = new Scanner(System.in);
        // loop check until name is correct
        while (true) {
            String address = sc.nextLine();
            // if address is empty
            if (address.trim().isEmpty()) {
                System.out.println("Address must not empty");
                System.out.print("Please input address again:");
            } else {
                return address;
            }
        }
    }

    public double inputDoubleSalary() {
        Scanner sc = new Scanner(System.in);
        // loop salary until the salary is correct
        while (true) {
            try {
                double salary = Double.parseDouble(sc.nextLine());
                //if salary is positive number
                if (salary > 0) {
                    return salary;
                } else {
                    System.out.println("Salary is greater than zero");
                    System.out.print("Please input salary:");
                }
            } catch (NumberFormatException ex) {
                // display the error if salary  have string
                System.out.println("You must input digit.");
                System.out.print("Please input salary:");
            }
        }
    }
}
