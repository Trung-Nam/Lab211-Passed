
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
public class Inputter {

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
                        //if input over range 1-6 display a message and require input a gain
                    } else if (input == 0 || input > 6) {
                        System.err.print("Sorry we don't have choice is " + input
                                + " !" + "\nPlease input again: ");
                    }
                } while (input < 1 || input > 6);
                break;
            } catch (Exception e) {
                System.err.print("Your choice must be number in range [1-6]"
                        + "\nPlease input again: ");
            }
        }
        return input;
    }

    //input a string with regex
    public static String inputStringRegex(String msg, String err, String regex) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(msg);
            String str = sc.nextLine();
            //check string empty
            if (str.isEmpty()) {
                System.err.println("This property can not empty!");
            } else {
                //if str input matches with regex then return string
                if (str.matches(regex)) {
                    return str;
                } else {
                    //if str input difference regex then display error msg
                    System.err.println(err);
                }
            }
        }
    }

    //input a string id with regex
    public static String inputStringId(String msg, String regex) {
        Scanner sc = new Scanner(System.in);
        //display a message for user input
        System.out.println(msg);
        while (true) {
            try {
                //user input id
                String str = sc.nextLine();
                //check string empty
                if (str.isEmpty()) {
                    System.err.println("This property can not empty!");
                    System.out.print("Please input again: ");
                } else {
                    //if str input matches with regex then return string
                    if (str.matches(regex)) {
                        return str;
                        //if user input a negative number,display a err message
                        //and require input again
                    } else if (Integer.parseInt(str) < 0) {
                        System.err.println("ID can not negative numbers !");
                        System.out.print("Please input again: ");
                    }
                }
            } catch (Exception e) {
                System.err.println("Invalid input!Id is positive numbers and digits or both");
                System.out.print("Please input again: ");
            }
        }
    }

    //input a string Name with regex
    public static String inputStringName(String msg, String err, String regex) {
        Scanner sc = new Scanner(System.in);
        //display a message for user input
        System.out.println(msg);
        while (true) {
            try {
                //user input id
                String str = sc.nextLine();
                //check string empty
                if (str.isEmpty()) {
                    System.err.println("This property can not empty!");
                    System.out.print("Please input again: ");
                } else {
                    //if str input matches with regex then return string
                    if (str.matches(regex)) {
                        return str;
                        //check user input a number 
                        //if input is number then display a err message an re-input
                    } else if (Integer.parseInt(str) < 0 || Integer.parseInt(str) > 0) {
                        System.err.println(err + " can not is numbers !");
                        System.out.print("Please input again: ");
                    } else {
                        System.err.println(err);
                        System.out.print("Please input again: ");
                    }
                }
            } catch (Exception e) {
                System.err.println("Invalid input !" + err);
                System.out.print("Please input again: ");
            }
        }
    }

    //input a string phone with regex
    public static String inputStringPhone(String msg, String regex) {
        Scanner sc = new Scanner(System.in);
        //display a message for user input
        System.out.println(msg);
        while (true) {
            try {
                //user input id
                String str = sc.nextLine();
                //check string empty
                if (str.isEmpty()) {
                    System.err.println("This property can not empty!");
                    System.out.print("Please input again: ");
                } else {
                    //if str input matches with regex then return string
                    if (str.matches(regex)) {
                        return str;
                        //check user input a negative number 
                        //if input is number then display a err message an re-input
                    } else if (Integer.parseInt(str) < 0) {
                        System.err.println("Phone number can not is negative numbers !");
                        System.out.print("Please input again: ");
                        //check input to short
                    } else if (str.length() < 3) {
                        System.err.println("Phone number is only numbers and more than 3 numbers.");
                        System.out.print("Please input again: ");
                        //another worong input
                    }
                }
            } catch (Exception e) {
                System.err.println("Invalid input!Phone number is only numbers.");
                System.out.print("Please input again: ");
            }
        }
    }

    //input a date
    public static String inputDate(String msg) {
        Date date = new Date();
        //display message for user
        System.out.println(msg);
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                String Date = sc.nextLine();
                // Check if input is empty
                if (Date.isEmpty()) {
                    System.err.println("Date empty !!!");
                    System.out.print("Please input again: ");
                } else {
                    // User input correct format ["dd/MM/yyyy"]
                    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                    //Parses text from  string to produce a date
                    date = df.parse(Date);
                    //The if else statement checks if the entered string is in the correct date format,
                    //and the year before now then return date
                    Date currentDate = Calendar.getInstance().getTime();
                    if (Date.equalsIgnoreCase(df.format(date)) && date.before(currentDate)) {
                        return Date;
                    } else if (Date.equalsIgnoreCase(df.format(date)) && date.after(currentDate)) {
                        System.err.println("Your input can not a date in the future.");
                        System.out.print("Please input again: ");
                    } else {
                        //Displays an error when the user enters 
                        //the wrong date and does not exist.
                        System.err.println("Your date is not exist.");
                        System.out.print("Please input again: ");
                    }
                }

            } catch (Exception e) {
                //If the date entered is not in the correct format, 
                //it cannot parse the date
                System.err.println("Your input invalid. This is not date.");
                System.out.print("Please input again: ");
            }
        }
    }

    //input sex
    public static String inputSex(String msg) {
        Scanner sc = new Scanner(System.in);
        String sex;
        //display message for user input
        System.out.println(msg);
        while (true) {
            sex = sc.nextLine().trim();
            //compare user input with 3 type of sex 
            if (sex.equalsIgnoreCase("male") || sex.equalsIgnoreCase("female") || sex.equalsIgnoreCase("other")) {
                return sex;
                //when user input a null string
            } else if (sex.equalsIgnoreCase("")) {
                System.err.println("Employee sex is not to blank");
                System.out.print("Please input again: ");
                //when user input another special characters
            } else {
                System.err.println("Sex input invalid!");
                System.out.print("Please input again: ");
            }
        }
    }

    //input a double number
    public static double inputDouble(String msg) {
        double number = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println(msg);
        while (true) {
            try {
                number = Double.parseDouble(sc.nextLine());
                //check user input a negative number or not ?
                //if it is a negative number display a message and re-input
                if (number < 0) {
                    System.err.println("Salary can't a negative number");
                    System.out.print("Please input again: ");
                } else {
                    //when number >0 then return
                    return number;
                }
            } catch (Exception e) {
                System.err.println("Salary must be the numbers!");
                System.out.print("Please input again: ");
            }
        }
    }

    // get a non-blank 
    public static String inputString(String msg) {
        Scanner sc = new Scanner(System.in);
        //display a message for user input
        System.out.println(msg);
        while (true) {
            try {
                //user input id
                String str = sc.nextLine();
                //check string empty
                if (str.isEmpty()) {
                    System.err.println("This property can not empty!");
                    System.out.print("Please input again: ");
                } else {
                    //if str is not empty then return str
                    return str;
                }
            } catch (Exception e) {
                System.err.println("Invalid input address ! ");
                System.out.print("Please input again: ");
            }
        }
    }
}
