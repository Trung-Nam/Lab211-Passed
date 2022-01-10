
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
                if (choice > 0 && choice < 6) {
                    return choice;
                } else {
                    System.err.println("Number choice is range 1 to 5.");
                }
            } catch (NumberFormatException e) {
                System.err.println("You must enter choice is digit.");
            }
        }
    }

    // user choice yes or no
    public static String inputChoiceYorN() {
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

    // user choice Update or Delete
    public static String inputChoiceUorD() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String choice = sc.nextLine();
            // if choice is empty
            if (choice.isEmpty()) {
                System.out.println("choice can not empty");
                System.out.print("Enter choice again: ");
                // if user choice U or D
            } else if (choice.equalsIgnoreCase("U") || choice.equalsIgnoreCase("D")) {
                return choice;
            } else {
                System.out.print("Please enter only U or D: ");
            }
        }
    }

    //input a string id with regex
    public static String inputStringId(String msg, String regex) {
        Scanner sc = new Scanner(System.in);
        //display a message for user input
        System.out.print(msg);
        while (true) {
            try {
                //user input id
                String str = sc.nextLine();
                //check string empty
                if (str.isEmpty()) {
                    System.out.println("This property can not empty!");
                    System.out.print("Please input again: ");
                } else {
                    //if str input matches with regex then return string
                    if (str.matches(regex)) {
                        return str;
                        //if user input a negative number,display a err message
                        //and require input again
                    } else if (Integer.parseInt(str) < 0) {
                        System.out.println("ID can not negative numbers !");
                        System.out.print("Please input again: ");
                    }
                }
            } catch (Exception e) {
                System.out.println("Invalid input!Id is positive numbers and letters or both");
                System.out.print("Please input again: ");
            }
        }
    }

    //user input string name
    public static String inputStringName(String msg) {
        Scanner sc = new Scanner(System.in);
        System.out.print(msg);
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

    // input student semester
    public static String inputStudentSemester(String msg) {
        Scanner sc = new Scanner(System.in);
        System.out.print(msg);
        // loop until string semester is correct
        while (true) {
            String semester = sc.nextLine();
            // if string semester is empty
            if (semester.trim().isEmpty()) {
                System.err.println("Semester is not empty");
                System.out.print("Please enter again: ");
            } else {
                return semester;
            }
        }
    }

    // input student course
    public static String inputStudentCourse(String msg) {
        Scanner sc = new Scanner(System.in);
        System.out.print(msg);
        // loop until course name is correct
        while (true) {
            String course = sc.nextLine();
            // if course user input is empty
            if (course.trim().isEmpty()) {
                System.err.println("Name must not empty");
                System.out.print("Please input course again:");
                // if course name is java,  .net or C/C++
            } else if (course.equalsIgnoreCase("Java") || course.equalsIgnoreCase(".Net") || course.equalsIgnoreCase("C/C++")) {
                return course;
            } else {
                System.err.println("Invalid Course! Please enter only Java, .Net, C/C++");
                System.out.print("Please input course again:");
            }

        }
    }
}
