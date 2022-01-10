
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

    // User enter choose number base input
    public static int ChoiceNumberBaseInput() {
        System.out.println("------------- MENU -----------------");
        System.out.println("Choose the base number input");
        System.out.println("1.binary");
        System.out.println("2.decimal");
        System.out.println("3.hexadecimal");
        System.out.print("Enter your choice: ");
        Scanner sc = new Scanner(System.in);
        // loop until number you choose is correct
        while (true) {
            try {
                int number = Integer.parseInt(sc.nextLine());
                // if number is out of range to choose
                if (number < 1 || number > 3) {
                    System.out.println("Choice only range 1 to 3 (1.binary, 2.decimal, 3.hexadecimal)");
                    System.out.print("Plese enter choose: ");
                } else {
                    return number;
                }
            } catch (NumberFormatException e) {
                System.out.println("invalid choice! Please enter only number");
                System.out.print("Please enter choose: ");
            }
        }
    }

    // User enter choose number base output
    public static int ChoiceNumberBaseOutput() {
        System.out.println("");
        System.out.println("Choose the base number output");
        System.out.println("1.binary");
        System.out.println("2.decimal");
        System.out.println("3.hexadecimal");
        System.out.print("Enter your choice: ");
        Scanner sc = new Scanner(System.in);
        // loop until number you choose is correct
        while (true) {
            try {
                // if number is out of range to choose
                int number = Integer.parseInt(sc.nextLine());
                if (number < 1 || number > 3) {
                    System.out.println("Choice only range 1 to 3 (1.binary, 2.decimal, 3.hexadecimal)");
                    System.out.print("Plese enter choose: ");
                } else {
                    return number;
                }
            } catch (NumberFormatException e) {
                System.out.println("invalid choice! Please enter only number");
                System.out.print("Please enter choose: ");
            }
        }
    }

    // user choice to continue convert or not
    public static String ChoiceRepetitiveProgramOrNot() {
        System.out.print("Do you want to continue program(Y/N): ");
        Scanner sc = new Scanner(System.in);
        // loop until choice is correct
        while (true) {
            String choice = sc.nextLine();
            // if user enter true choice
            if (choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("N")) {
                return choice;
            } else {
                System.out.println("Plese enter only Y or N");
                System.out.print("Please enter again: ");
            }
        }
    }

    public static String EnterValueBinary() {
        Scanner sc = new Scanner(System.in);
        // loop until the string binary is correct
        while (true) {
            String binary = sc.nextLine();
            // if character find in string binary match the pattern 
            if (binary.matches("^[0-1]{1,}+$")) {
                return binary;
            } else {
                System.out.println("invalid Binary! Please enter only 0 or 1");
                System.out.print("Enter value binary: ");
            }
        }
    }

    // user enter value of decimal
    public static String EnterValueDecimal() {
        Scanner sc = new Scanner(System.in);
        // loop until string decimal is correct
        while (true) {
            String decimal = sc.nextLine();
            // if character find in string decimal match the pattern
            if (decimal.matches("^[0-9]{1,}+$")) {
                return decimal;
            } else {
                System.out.println("invalid Decimal! Please enter only 0 to 9");
                System.out.print("Enter value decimal: ");
            }
        }
    }

    // user enter value of hexadecimal
    public static String EnterValueHexadecimal() {
        Scanner sc = new Scanner(System.in);
        // loop until string hexadecimal correct
        while (true) {
            String hexadecimal = sc.nextLine();
            // if character find in string hexadecimal match the pattern
            if (hexadecimal.matches("^[0-9A-Fa-f]{1,}+$")) {
                return hexadecimal;
            } else {
                System.out.println("invalid Hexadecimal! Please enter only 0 to 9 or A to F");
                System.out.print("Enter value hexadecimal: ");
            }
        }
    }
}
