
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Step 1:User enter the first date with [dd/mm/yyyy]
        Date firstDate = inputDate("Please enter the first date: ");
        //Step 2:User enter the second date with [dd/mm/yyyy]
        Date secondDate = inputDate("Please enter the second date: ");
        //Step 3:Compare and display
        compareAndDisplay(firstDate, secondDate);
    }

    private static Date inputDate(String msg) {
        Date date = new Date();
        //display message for user input
        System.out.print(msg);
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                String sDate = sc.nextLine();
                // Check if input is empty
                if (sDate.isEmpty()) {
                    System.err.println("Date empty !!!");
                    System.out.print("Please input again: ");
                } else {
                    //fomat date for user input follow [dd/mm/yyyy]
                    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                    // cast to convert from Date to String
                    date = df.parse(sDate);
                    // use if else to compare user entered string matches the format or not
                    if (sDate.equalsIgnoreCase(df.format(date))) {
                        // if the format is correct will return date
                        return date;
                    } else {
                        // display error message if the date entered is incorrect or does not exist
                        // Ex: 30/02/2001
                        System.out.print("Your date is not exist.");
                        System.out.print("\nPlease input again: ");
                    }
                }
            } catch (Exception e) {
                //in case an exception occurs
                // if the date entered is not in the correct format, it will not be able to parse the date
                System.out.println("Your input invalid.This is not date");
                //it will ask for re-input
                System.out.print("Please input again: ");
            }

        }
    }

    private static void compareAndDisplay(Date firstDate, Date secondDate) {
        //if firstDate before secondDate display message:Date1 before Date2
        if (firstDate.before(secondDate)) {
            System.out.println("\nDate1 is before Date2");
            //if firstDate after secondate display message:Date2 before Date1    
        } else if (firstDate.after(secondDate)) {
            System.out.println("\nDate2 is before Date1");
            //if two date the same    
        } else {
            System.out.println("\nTwo date is the same");
        }
    }

}
