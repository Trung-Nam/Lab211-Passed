
import java.text.ParseException;
import java.util.ArrayList;

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

    public static void main(String[] args) throws ParseException{
        Inputter Inputter = new Inputter();
        Manager Manager = new Manager();
        ArrayList<Storekeeper> StorekeeperList = new ArrayList<>();
        ArrayList<Product> ProductsList = new ArrayList<>();
        while (true) {
            //step 1:Display a menu 
            Manager.displayMenu();
            //step 2:ask users to select an option 
            int choice = Inputter.inputChoice();
            switch (choice) {
                case 1:
                    //step 3: choice 1 then add storekeeper
                    Manager.addStorekeeper(StorekeeperList);
                    break;
                case 2:
                    //step 4: choice 2 then add product
                    Manager.addProduct(StorekeeperList, ProductsList);
                    break;
                case 3:
                    //step 5: choice 3 then update product
                    Manager.updateProduct(StorekeeperList, ProductsList);
                    break;
                case 4:
                    //step 6: choice 4 then Search product by Name, Category, Storekeeper, ReceiptDate
                    Manager.searchProduct(ProductsList);
                    break;
                case 5:
                    //step 7: choice 5 then Sort product by Expiry date, Date of manufacture
                    Manager.sortProduct(ProductsList);
                    break;
            }
        }
    }
}
