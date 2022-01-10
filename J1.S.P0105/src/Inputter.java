
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
                    } else {
                        System.err.println("Id is positive numbers and letters or both");
                        System.out.print("Please input again: ");
                    }
                }
            } catch (Exception e) {
                System.err.println("Invalid input!Id is positive numbers and letters or both");
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
                System.err.println("Invalid input!");
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
                    System.err.println("Price can't a negative number");
                    System.out.print("Please input again: ");
                } else {
                    //when number >0 then return
                    return number;
                }
            } catch (Exception e) {
                System.err.println("Price must be the numbers!");
                System.out.print("Please input again: ");
            }
        }
    }

    public static String inputDate(String msg) {
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
                        return sDate;
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

    //input a date without in the Future
    public static String inputDateLimit(String msg) {
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

    public static int getInt(String message, String error, int min, int max) {
        while (true) {
            try {
                System.out.println(message);
                Scanner sc = new Scanner(System.in);
                int num;
                num = Integer.parseInt(sc.nextLine());
                if (min <= num && num <= max) {
                    return num;
                } else {
                    System.out.println("Please input number inrange [" + min + " - " + max + "]");
                }
            } catch (Exception e) {
                System.out.println(error);
            }
        }
    }
}
