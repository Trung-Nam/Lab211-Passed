
import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.Hashtable;

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
        FruitShopManager ShopManager = new FruitShopManager();
        Inputter inputter = new Inputter();
        ArrayList<Fruit> listFruits = new ArrayList();
        listFruits.add(new Fruit("1", "Coconut", 2, 10, "Viet Nam"));
        listFruits.add(new Fruit("2", "Orange", 3, 15, "US"));
        listFruits.add(new Fruit("3", "Apple", 4, 6, "Thailand"));
        listFruits.add(new Fruit("4", "Grape", 6, 3, "France"));
        Hashtable<String, Order> orderHashtable = new Hashtable<>();
        while (true) {
            //Display menu
            ShopManager.DisplayMenu();
            //Allow user selec option
            int choice = inputter.SelectOption();
            switch (choice) {
                //Create Fruit
                case 1:
                    ShopManager.CreateFruit(listFruits);
                    break;
                //View orders
                case 2:
                    ShopManager.ViewOrders(listFruits,orderHashtable);
                    break;
                //Shopping (for buyer)
                case 3:
                    ShopManager.Shopping(listFruits,orderHashtable);
                    break;
                //Exit
                case 4:
                    exit(0);
            }
        }
    }

}
