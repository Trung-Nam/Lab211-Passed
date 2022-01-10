
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class FruitShopManager {

    public static void DisplayMenu() {
        System.out.println("FRUIT SHOP SYSTEM");
        System.out.println("1. Create");
        System.out.println("2. View orders");
        System.out.println("3. Shopping (for buyer)");
        System.out.println("4. Exit");
    }

    public static boolean CheckDuplicateID(String id, ArrayList<Fruit> listFruit) {
        for (int i = 0; i < listFruit.size(); i++) {
            if (id.equalsIgnoreCase(listFruit.get(i).getFruitID())) {
                return true;
            }

        }
        return false;
    }

    public static String ChoiceYorN(String msg) {
        Scanner sc = new Scanner(System.in);
        System.out.print(msg);
        // loop until choice is correct
        while (true) {

            String choice = sc.nextLine();
            // if user choice Y or N
            if (choice.equalsIgnoreCase("N") || choice.equalsIgnoreCase("Y")) {
                return choice;
            } else {
                System.out.println("Plese must enter only Y or N");
            }
        }
    }

    public static void CreateFruit(ArrayList<Fruit> listFruit) {

        String choice = "";
        // loop until user choice No
        while (!choice.equalsIgnoreCase("N")) {
            System.out.print("Enter fruit id: ");
            String fruitID = Inputter.EnterFruitID();
            if (CheckDuplicateID(fruitID, listFruit)) {
                System.out.println("Duplicate Fruit!");
                return;
            }
            System.out.print("Enter fruit name: ");
            String fruitName = Inputter.EnterFruitName();
            System.out.print("Enter Price: ");
            double fruitPrice = Inputter.EnterFruitPrice();
            System.out.print("Enter quantity: ");
            int fruitQuantity = Inputter.EnterFruitQuantity();
            System.out.print("Enter origin: ");
            String fruitOrigin = Inputter.EnterFruitOrigin();
            // check if duplicate fruit
            if (checkDublicateFruit(listFruit, fruitID, fruitName, fruitOrigin)) {
                System.out.println("Fruit already exists!");
            } else {
                listFruit.add(new Fruit(fruitID, fruitName, fruitPrice, fruitQuantity, fruitOrigin));
                System.out.println("Add fruit successful!");
                DisplayListFruit(listFruit);
            }
            choice = ChoiceYorN("Do you want to continue(Y/N): ");
        }
    }

    public static boolean checkDublicateFruit(ArrayList<Fruit> listFruit, String id, String name, String origin) {
        //traverse all elements of arraylist
        for (int i = 0; i < listFruit.size(); i++) {
            if (listFruit.get(i).getFruitID().equalsIgnoreCase(id)
                    && listFruit.get(i).getFruitName().equalsIgnoreCase(name)
                    && listFruit.get(i).getOrigin().equalsIgnoreCase(origin)) {
                return true;
            }
        }
        return false;
    }

    public static void DisplayListFruit(ArrayList<Fruit> listFruit) {
        System.out.format("%-5s%-15s%-15s%-15s%-15s\n", "ID", "Fruit Name", "Price", "Quantity", "Origin");
        for (int i = 0; i < listFruit.size(); i++) {
            System.out.format("%-5s%-15s%-15s%-15s%-15s\n", listFruit.get(i).getFruitID(), listFruit.get(i).getFruitName(), listFruit.get(i).getPrice(),
                    listFruit.get(i).getQuantity(), listFruit.get(i).getOrigin());
        }
        System.out.println("");
    }

    public static void Shopping(ArrayList<Fruit> listFruits, Hashtable<String, Order> orderHashtable) {
        System.out.println("----- Shopping -----");
        ArrayList<Fruit> listOder = new ArrayList();
        while (true) {
            System.out.println("List of Fruit:");
            DisplayListFruit(listFruits);
            //input id of fruit want to search
            System.out.print("Enter fruit ID:");
            String id = Inputter.EnterFruitID();
            //get index of fruit
            int IndexOfFruit = FindLocationFruitById(listFruits, id);
            //check if found to fruit
            if (IndexOfFruit >= 0) {
                //if quantity greater than 0
                if (listFruits.get(IndexOfFruit).getQuantity() > 0) {
                    System.out.println("Your selected:" + listFruits.get(IndexOfFruit).getFruitName());
                    // input quantity of fruit want by
                    int quantityToBuy = Inputter.getInt("Please input quantity:", 1, listFruits.get(IndexOfFruit).getQuantity());
                    boolean checkExistsShopping = false;
                    //traverse all elements of arraylist
                    for (int i = 0; i < listOder.size(); i++) {
                        //if list has been exist fruit
                        if (listOder.get(i).getFruitID().equalsIgnoreCase(id)) {
                            //when user buy more the same fruit then add more quantity
                            listOder.get(i).setQuantity(listOder.get(i).getQuantity() + quantityToBuy);
                            checkExistsShopping = true;
                            //set again quantity that shop have after sale
                            listFruits.get(IndexOfFruit).setQuantity(listFruits.get(IndexOfFruit).getQuantity() - quantityToBuy);
                            break;
                        }
                    }
                    //if fruit cant exist then add in list 
                    if (checkExistsShopping == false) {
                        Fruit fruitOrdered = new Fruit(id, listFruits.get(IndexOfFruit).getFruitName(),
                                listFruits.get(IndexOfFruit).getPrice(), quantityToBuy, listFruits.get(IndexOfFruit).getOrigin());
                        //add in list order
                        listOder.add(fruitOrdered);
                        listFruits.get(IndexOfFruit).setQuantity(listFruits.get(IndexOfFruit).getQuantity() - quantityToBuy);
                        System.out.println("Order successful!");
                    }
                } else {
                    System.out.println("Fruit is out of stock");
                }
                String choice = ChoiceYorN("Do you want to order now (Y/N):");
                //if want to order now
                if (choice.equalsIgnoreCase("Y")) {
                    break;
                }
            } else {
                System.out.println("Fruit not found!");
            }
        }
        //input name of customer
        String name = Inputter.inputStringName("Input your name:");
        //add order table
        Order order = new Order(listOder, name);
        int orderNumber = orderHashtable.size();
        orderHashtable.put(String.valueOf(orderNumber), order);
        System.out.println("Order completed!");
    }

    public static void displayListOrderedFruit(ArrayList<Fruit> listOrderedFruit) {
        double amount;
        int total = 0;
        System.out.format("%-15s%-15s%-15s%-15s\n", "Product", "Quantity", "Price", "Amount");
        // Loop to access all information of the fruits customer has ordered
        for (int i = 0; i < listOrderedFruit.size(); i++) {
            Fruit ordered = listOrderedFruit.get(i);
            amount = listOrderedFruit.get(i).getPrice() * listOrderedFruit.get(i).getQuantity();
            total += amount;
            System.out.format("%-15s%-15s%-15s%-15s\n", ordered.getFruitName(), ordered.getQuantity(), ordered.getPrice(), amount);
        }
        System.out.println("Total:" + total);
    }

    public static int FindLocationFruitById(ArrayList<Fruit> listFruits, String id) {
        //traverse all elements of arraylist
        for (int i = 0; i < listFruits.size(); i++) {
            // check if duplicate id
            if (listFruits.get(i).getFruitID().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }

    public static void ViewOrders(ArrayList<Fruit> listFruits, Hashtable<String, Order> orderHashtable) {
        System.out.println("----- View Order -----");
        // Check list order is empty or not
        if (orderHashtable.isEmpty()) {
            System.out.println("List Order Is Empty.\n");
        } else {

            for (Map.Entry<String, Order> listCustomer : orderHashtable.entrySet()) {
                String customerName = listCustomer.getValue().getName();
                //get name of a customer
                System.out.println("Customer: " + customerName);
                //display the information customer ordered
                System.out.format("%-15s%-15s%-15s%-15s\n", "Product", "Quantity", "Price", "Amount");
                double sumPrice = 0;
                ArrayList<Fruit> order = listCustomer.getValue().getOrdered();
                // Loop to access all information order fruit
                for (int i = 0; i < order.size(); i++) {
                    double amount = order.get(i).getPrice() * order.get(i).getQuantity();
                    sumPrice += amount;
                    System.out.format("%-15s%-15s%-15s%-15s\n", order.get(i).getFruitName(), order.get(i).getQuantity(), order.get(i).getPrice(), amount);
                }
                System.out.println("Total:" + sumPrice + "$");
            }
        }
    }
}
