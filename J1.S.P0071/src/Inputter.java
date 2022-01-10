
import java.text.ParseException;
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

    public static int inputChoice() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            // if try error the program will run catch
            try {
                System.out.print("Enter your choice: ");
                int choice = Integer.parseInt(sc.nextLine());
                // if choice is positive number 
                if (choice > 0 && choice < 5) {
                    return choice;
                } else {
                    System.err.println("Number choice is range 1 to 4.");
                }
            } catch (NumberFormatException e) {
                System.err.println("You must enter choice is digit.");
            }
        }
    }

    // Enter string Requirement Name
    public static String EnterRequirementName() {
        Scanner sc = new Scanner(System.in);
        // loop until Requirement Name is correct
        while (true) {
            String RequirementName = sc.nextLine();
            // if Requirement Name user input is empty
            if (RequirementName.trim().isEmpty()) {
                System.err.println("Requirement Name name must not empty");
                System.out.print("Please input again:");
            } else {
                return RequirementName;
            }
        }
    }
    // enter string task type

    public static String EnterTaskType() {
        Scanner sc = new Scanner(System.in);
        int input = 0;
        String TaskType = "";
        System.out.println("*******Task Type*******");
        System.out.println("1.Code");
        System.out.println("2.Test");
        System.out.println("3.Design");
        System.out.println("4.Review");
        System.out.print("Task Type:");
        // loop salary until the salary is correct
        while (true) {
            // if try error the program will run catch
            try {
                input = Integer.parseInt(sc.nextLine());
                if (input > 0 && input < 5) {
                    // if user choose 1
                    if (input == 1) {
                        return TaskType = "Code";
                    }
                    // if user choose 2
                    if (input == 2) {
                        return TaskType = "Test";
                    }
                    // if user choose 3
                    if (input == 3) {
                        return TaskType = "Design";
                    }
                    // if user choose 4
                    if (input == 4) {
                        return TaskType = "Review";
                    }
                }
            } catch (NumberFormatException e) {
                // display the error if salary negative or have string
                System.out.println("You must input only 1.Code, 2.Test, 3.Design, 4.Review");
                System.out.print("Please choice again: ");
            }

        }
    }

    // enter date 
    public static String EnterDate() {
        Scanner sc = new Scanner(System.in);
        // loop until date is correct
        while (true) {
            // check the error of format date
            try {
                String Sdate = sc.nextLine().trim();
                // if date is empty
                if (Sdate.trim().isEmpty()) {
                    System.err.println("Date is not empty");
                    System.out.print("Please enter again: ");
                } else {
                    SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
                    Date currentDate = Calendar.getInstance().getTime();
                    Date date = formatDate.parse(Sdate);
                    // if the user enters not correct of the date
                    if (!Sdate.equalsIgnoreCase(formatDate.format(date))) {
                        System.out.println("Date does not exist!");
                        System.out.print("please enter date: ");
                        // if date in the future
                    } else if (date.before(currentDate)) {
                        System.out.println("Date must in the future");
                        System.out.print("please enter again: ");
                    } else {
                        return Sdate;
                    }
                }
            } catch (ParseException ex) {
                System.out.println("invalid date! Please input form: dd-MM-yyyy");
                System.out.print("please enter date: ");
            }
        }
    }

    // enter string assignee
    public static String EnterAssignee() {
        /*
        ^ : start the regex
        [a-zA-Z ]+ regex contain all character lowercase and uppercase in alphabet and user can re-enter many time
        $ : end of regex
         */
        Scanner sc = new Scanner(System.in);
        // loop until Assignee is correct
        while (true) {
            String Assignee = sc.nextLine();
            // if Assignee user input is empty
            if (Assignee.trim().isEmpty()) {
                System.err.println("Assignee must not empty");
                System.out.print("Please input again:");
                // if character find in the name can macth the regex in the pattern name
            } else if (Assignee.matches("^[a-zA-Z ]+$")) {
                return Assignee;
            } else {
                System.err.println("Invalid Assignee! Please enter again");
                System.out.print("Please input again:");
            }

        }

    }

    // enter string reviewer
    public static String EnterReviewer() {
        Scanner sc = new Scanner(System.in);
        // loop until Reviewer is correct
        while (true) {
            String Reviewer = sc.nextLine();
            // if Reviewer user input is empty
            if (Reviewer.trim().isEmpty()) {
                System.err.println("Reviewer must not empty");
                System.out.print("Please input again:");
                // if character find in the name can macth the regex in the pattern name
            } else if (Reviewer.matches("^[a-zA-Z ]+$")) {
                return Reviewer;
            } else {
                System.err.println("Invalid Reviewer! Please enter again");
                System.out.print("Please input again:");
            }

        }
    }

    public static double EnterPlanFrom() {
        Scanner sc = new Scanner(System.in);
        //loop until time is correct
        while (true) {
            try {
                String time = sc.nextLine();
                if (time.isEmpty()) {
                    System.out.println("Time must not empty");
                    System.out.print("Please enter agian: ");
                } else {
                    double input = Double.parseDouble(time);
                    //if number is positive number
                    if (input >= 8 && input <= 17.5 && input % 0.5 == 0) {
                        return Double.parseDouble(time);
                    } else {
                        System.err.println("Plan From within 8h-17h30 > 8.0, 8.5, 9.0, ⇔ 9.5 ...-> 17.5");
                        System.out.print("Please enter Plan From: ");
                    }
                }
            } catch (NumberFormatException e) {
                // display the error if time negative or have string
                System.err.println("You must input only number!");
                System.out.print("Please enter Plan From: ");
            }
        }
    }

    // enter time plan to
    public static double EnterPlanTo() {
        Scanner sc = new Scanner(System.in);
        // loop until time is correct
        while (true) {
            // if try error the program will run catch
            try {
                String time = sc.nextLine();
                if (time.trim().isEmpty()) {
                    System.err.println("Time must not empty");
                    System.out.print("Please enter agian: ");
                } else {
                    double input = Double.parseDouble(time);
                    // if number is positive number
                    if (input >= 8 && input <= 17.5 && input % 0.5 == 0) {
                        return Double.parseDouble(time);
                    } else {
                        System.err.println("Plan From within 8h-17h30 > 8.0, 8.5, 9.0, ⇔ 9.5 ...-> 17.5");
                        System.out.print("Please enter Plan To: ");
                    }
                }
            } catch (NumberFormatException e) {
                // display the error if time negative or have string
                System.err.println("You must input only number!");
                System.out.print("Please enter Plan To: ");
            }
        }
    }

    // enter string id
    public static int EnterID() {
        Scanner sc = new Scanner(System.in);
        // loop until choice is correct
        while (true) {
            // if try error the program will run catch
            try {
                int ID = Integer.parseInt(sc.nextLine());
                // if ID is positive number 
                if (ID > 0) {
                    return ID;
                } else {
                    System.err.println("ID is positive number");
                    System.out.print("Plese enter ID again: ");
                }
            } catch (NumberFormatException e) {
                System.err.println("You must enter ID is digit");
                System.out.print("Plese enter choice again: ");
            }
        }

    }
}
