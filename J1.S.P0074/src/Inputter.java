
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

    public static int inputChoice() {
        System.out.println("Please input an option:");
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                int choice = Integer.parseInt(sc.nextLine());
                //if(choice is range 1 to 4
                if (choice > 0 && choice < 5) {
                    return choice;
                } else {
                    System.err.println("Number choice must in range 1-4.");
                    System.out.print("Please input choice again:");
                }
            } catch (Exception e) {
                System.out.println("Input invalid!Choice must be number 1-4");
                System.out.print("Please input again:");
            }
        }
    }

    //input matrix
    public static int[][] EnterMatrix(int MatrixNumber, int row, int col) {
        int[][] matrix = new int[row + 1][col + 1];
        // loop travesal all index of row in array
        for (int i = 1; i <= row; i++) {
            // loop travesal all index of coloumn in array
            for (int j = 1; j <= col; j++) {
                System.out.print("Enter Matrix" + MatrixNumber + "[" + i + "]" + "[" + j + "]:");
                //user input value each element of matrix
                matrix[i][j] = InputValueMatrix("Enter Matrix" + MatrixNumber + "[" + i + "]" + "[" + j + "]:");
            }
        }
        return matrix;
    }

    // input value element of matrix
    public static int InputValueMatrix(String err) {
        Scanner sc = new Scanner(System.in);
        // loop until value is correct
        while (true) {
            try {
                int value = Integer.parseInt(sc.nextLine());
                return value;
            } catch (NumberFormatException ex) {
                System.out.println("Value of matrix is digit");
                System.out.print(err);
            }
        }
    }

    // enter row or coloumn of the matrix 2
    public static int EnterRowOrColMatrix2(int rowOrColMatrix1, String err) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                int number = Integer.parseInt(sc.nextLine());
                // if number is positive number
                if (number == rowOrColMatrix1) {
                    return number;
                } else {
                    System.out.print(err);
                }
            } catch (NumberFormatException ex) {
                System.err.print("Please input only number: ");
            }
        }
    }
    
    //input int number
    public static int InputIntNumber() {
        Scanner sc = new Scanner(System.in);
        // loop until number is correct
        while (true) {
            try {
                int number = Integer.parseInt(sc.nextLine());
                // if number is positive number
                if (number > 0) {
                    return number;
                } else {
                    System.out.print("Please enter positive number: ");
                }
            } catch (NumberFormatException ex) {
                System.out.print("Please input only number: ");
            }
        }
    }
}
