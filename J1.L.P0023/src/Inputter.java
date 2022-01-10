
import java.util.Scanner;
import java.util.regex.Pattern;

public class Inputter {

    public static String EnterFruitID() {
        Scanner sc = new Scanner(System.in);
        // loop until string id is correct
        while (true) {
            String id = sc.nextLine();
            // if string is empty
            if (id.trim().isEmpty()) {
                System.err.println("Id is not empty");
                System.out.print("Please enter again: ");
            } else {
                return id;
            }
        }
    }

    public static String EnterFruitName() {
        Scanner sc = new Scanner(System.in);
        // create pattern name contain only character in alphabet
        Pattern patternName = Pattern.compile("^[a-zA-Z ]+$");
        /*
        ^ : start the regex
        [a-zA-Z ]+ regex contain all character lowercase and uppercase in alphabet and user can re-enter many time
        $ : end of regex
         */
        // loop until name is correct
        while (true) {
            String name = sc.nextLine();
            // if name user input is empty
            if (name.trim().isEmpty()) {
                System.err.println("Fruit Name must not empty");
                System.out.print("Please input name again:");
                // if character find in the name can macth the regex in the pattern name
            } else if (patternName.matcher(name).find()) {
                return name;
            } else {
                System.err.println("Invalid Fruit Name! Please enter again");
                System.out.print("Please input name again:");
            }

        }
    }

    public static double EnterFruitPrice() {
        Scanner sc = new Scanner(System.in);
        // loop Price until the Price is correct
        while (true) {
            // if try error the program will run catch
            try {
                String price = sc.nextLine();
                // if price is empty
                if (price.trim().isEmpty()) {
                    System.err.println("Price must not empty");
                    System.out.print("Please enter agian: ");
                } else {
                    double FruitPrice = Double.parseDouble(price);
                    // if price greater than zero
                    if (FruitPrice > 0) {
                        return FruitPrice;
                    } else {
                        System.err.println("Price is greater than rezo");
                        System.out.print("Please enter price: ");
                    }
                }
            } catch (NumberFormatException e) {
                // display the error if salary negative or have string
                System.err.println("You must input only number!");
                System.out.print("Please enter price: ");
            }
        }
    }

    public static int EnterFruitQuantity() {
        Scanner sc = new Scanner(System.in);
        // loop quantity until the quantity is correct
        while (true) {
            // if try error the program will run catch
            try {
                String quantity = sc.nextLine();
                if (quantity.trim().isEmpty()) {
                    System.err.println("Quantity must not empty");
                    System.out.print("Please enter agian: ");
                } else {
                    int FruitQuantity = Integer.parseInt(quantity);
                    // if Fruit Quantity greater than zero
                    if (FruitQuantity > 0) {
                        return FruitQuantity;
                    } else {
                        System.err.println("Quantity is greater than rezo");
                        System.out.print("Please enter Quantity: ");
                    }
                }
            } catch (NumberFormatException e) {
                // display the error if salary negative or have string
                System.err.println("You must input only number!");
                System.out.print("Please enter Quantity: ");
            }
        }
    }

    public static String EnterFruitOrigin() {
        Scanner sc = new Scanner(System.in);
        // loop until string Origin is correct
        while (true) {
            String origin = sc.nextLine();
            // if string is empty
            if (origin.trim().isEmpty()) {
                System.err.println("Origin is not empty");
                System.out.print("Please enter again: ");
            } else {
                return origin;
            }
        }
    }

    public static int SelectOption() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Choice option: ");
        // loop until choice is correct
        while (true) {
            // if try error the program will run catch
            try {
                int choice = Integer.parseInt(sc.nextLine());
                // if choice is positive number 
                if (choice > 0 && choice < 5) {
                    return choice;
                } else {
                    System.err.println("number choice is rage 1 to 4");
                    System.out.print("Plese enter choice again: ");
                }
            } catch (NumberFormatException e) {
                System.err.println("You must enter choice is digit");
                System.out.print("Plese enter choice again: ");
            }
        }
    }

    public static int getInt(String msg, int min, int max) {
        Scanner sc = new Scanner(System.in);
        String stringInt = null;
        while (true) {
            try {
                System.out.println(msg);
                stringInt = sc.nextLine();
                int choice = Integer.parseInt(stringInt);
                //check input within condition
                if (min <= choice && choice <= max) {
                    return choice;
                } else {
                    System.out.println("Number inrange " + min + " to " + max);
                }
            } catch (NumberFormatException ex) {
                //
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
}
