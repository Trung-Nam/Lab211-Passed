
import static java.lang.System.exit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
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
class Manager {

    void displayMenu() {
        System.out.println("---------------Product management system----------------");
        System.out.println("1. Add Storekeeper.");
        System.out.println("2. Add Product.");
        System.out.println("3. Update Product.");
        System.out.println("4. Search product by Name, Category, Storekeeper, ReceiptDate.");
        System.out.println("5. Sort product by Expiry date, Date of manufacture.");
        System.out.println("--------------------------------------------------------");
    }

    void addStorekeeper(ArrayList<Storekeeper> StorekeeperList) {
        //user input name of storekeeper
        String newStorekeeperName = Inputter.inputStringName("Enter name of Storekeeper: ",
                "Storekeeper name is only letters", "[a-zA-z ]+");
        Storekeeper Storekeeper = new Storekeeper(newStorekeeperName);
        //add storekeeper in list
        StorekeeperList.add(Storekeeper);
        //display message when add completed
        System.out.println("Storekeeper " + newStorekeeperName + " has been added.");
    }

    void addProduct(ArrayList<Storekeeper> StorekeeperList, ArrayList<Product> ProductsList) throws ParseException {
        String newId;
        String newName;
        String newLocation;
        double newPrice;
        String newDateOfManufacture;
        String newExpiryDate;
        String newCategory;
        String newStorekeeper;
        String newReceiptDate;
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        //input id
        do {
            newId = Inputter.inputStringId("Enter id of product: ", "[a-zA-z0-9 ]+");
            if (isDuplicate(ProductsList, newId) == false) {
                System.out.println("ID is duplicated !.Please enter another ID");
            }
        } while (isDuplicate(ProductsList, newId) == false);
        //input name
        newName = Inputter.inputStringName("Enter name of product: ", "Product name is only letters", "[a-zA-z ]+");
        newName = newName.toUpperCase();
        //input location
        newLocation = Inputter.inputString("Enter location of product: ");
        //input price
        newPrice = Inputter.inputDouble("Enter price of product: ");
        //input Date Of Manufacture;
        newDateOfManufacture = Inputter.inputDateLimit("Enter Date Of Manufacture: ");
        while (true) {
            //input ExpiryDate
            newExpiryDate = Inputter.inputDate("Enter Expiry Date: ");
            if (df.parse(newDateOfManufacture).after(df.parse(newExpiryDate))) {
                System.out.println("Date of manufacture must before expiry date!");
            } else {
                break;
            }
        }
        //input category
        newCategory = Inputter.inputString("Enter category of product: ");
        //input store keeper
        showListStorekeeper(StorekeeperList);
        String keyword;
        while (true) {
            keyword = Inputter.inputStringName("Enter name of storekeeper: ", "Storekeeper name is only digits", "[a-zA-z ]+");
            if (checkNameStorekeeperExist(StorekeeperList, keyword) == false) {
                System.out.println("Your storekeeper don't exist!");
            } else {
                break;
            }
        }
        newStorekeeper = getNameStorekeeperExist(StorekeeperList, keyword);
        //input Receipt Date
        while (true) {
            newReceiptDate = Inputter.inputDateLimit("Enter Receipt date: ");
            if (df.parse(newReceiptDate).after(df.parse(newDateOfManufacture))
                    && df.parse(newReceiptDate).before(df.parse(newExpiryDate))) {
                break;
            } else {
                System.out.println("Receipt Date must after date of manufacture !");
            }
        }
        Product product = new Product(newId, newName, newLocation, newPrice, newDateOfManufacture, newExpiryDate, newCategory, newStorekeeper, newReceiptDate);
        ProductsList.add(product);
        System.out.println("Product " + newId + " has been added.");
        showListProduct(ProductsList);
    }

    void updateProduct(ArrayList<Storekeeper> StorekeeperList, ArrayList<Product> ProductsList) throws ParseException {
        String newId;
        String newName;
        String newLocation;
        double newPrice;
        String newDateOfManufacture;
        String newExpiryDate;
        String newCategory;
        String newStorekeeper;
        String newReceiptDate;
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        //check list empty or not
        if (ProductsList.isEmpty()) {
            System.out.println("Empty list !!!");
        } else {
            //search product based input id
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter product's id for search:");
            String uId = sc.nextLine().trim();
            //if user input a id not exit then display a message for user
            if (getIndexID(ProductsList, uId) == -1) {
                System.out.println("Product " + uId + " doesn't exist!");
            } else {
                int index = getIndexID(ProductsList, uId);
                //update product id
                String oldId = ProductsList.get(index).getId();
                String msgId = "Old id: " + oldId;
                System.out.println(msgId);
                do {
                    newId = Inputter.inputStringId("Enter id of product: ", "[a-zA-z0-9 ]+");
                    if (isDuplicate(ProductsList, newId) == false) {
                        System.out.println("ID is duplicated !.Please enter another ID");
                    }
                } while (isDuplicate(ProductsList, newId) == false);
                ProductsList.get(index).setId(newId);
                //update product name
                String oldName = ProductsList.get(index).getName();
                String msgName = "Old product name: " + oldName;
                System.out.println(msgName);
                newName = Inputter.inputStringName("Enter new name of product: ", "Product name is only digits", "[a-zA-z ]+");
                newName.toUpperCase();
                ProductsList.get(index).setName(newName);
                //update location
                String oldLocation = ProductsList.get(index).getLocation();
                String msgLoc = "Old product location: " + oldLocation;
                System.out.println(msgLoc);
                newLocation = Inputter.inputString("Enter location of product: ");
                ProductsList.get(index).setLocation(newLocation);
                //update price
                double oldPrice = ProductsList.get(index).getPrice();
                String msgPrice = "Old product price: " + oldPrice;
                System.out.println(msgPrice);
                newPrice = Inputter.inputDouble("Enter new price of product: ");
                ProductsList.get(index).setPrice(newPrice);
                //update Date Of Manufacture;
                String oldMa = ProductsList.get(index).getDateOfManufacture();
                String msgMa = "Old Date Of Manufacture: " + oldMa;
                System.out.println(msgMa);
                newDateOfManufacture = Inputter.inputDateLimit("Enter Date Of Manufacture: ");
                while (true) {
                    //ExpiryDate
                    String oldExp = ProductsList.get(index).getDateOfManufacture();
                    String msgExp = "Old Expiry Date: " + oldExp;
                    System.out.println(msgExp);
                    newExpiryDate = Inputter.inputDate("Enter Expiry Date: ");
                    if (df.parse(newExpiryDate).before(df.parse(newDateOfManufacture))) {
                        System.out.println("Date of manufacture must before expiry date!");
                    } else {
                        ProductsList.get(index).setDateOfManufacture(newDateOfManufacture);
                        ProductsList.get(index).setExpiryDate(newExpiryDate);
                        break;
                    }
                }
                //update category
                String oldCategory = ProductsList.get(index).getCategory();
                String msgCategory = "Old category of product: " + oldCategory;
                System.out.println(msgCategory);
                newCategory = Inputter.inputString("Enter category of product: ");
                ProductsList.get(index).setCategory(newCategory);
                //update store keeper
                showListStorekeeper(StorekeeperList);
                String oldStorekeeper = ProductsList.get(index).getStorekeeper();
                String msgSk = "Old Storekeeper name: " + oldStorekeeper;
                System.out.println(msgSk);
                String keyword;
                while (true) {
                    keyword = Inputter.inputStringName("Enter new name of storekeeper: ", "Storekeeper name is only digits", "[a-zA-z ]+");
                    if (checkNameStorekeeperExist(StorekeeperList, keyword) == false) {
                        System.out.println("Your storekeeper don't exist!");
                    } else {
                        break;
                    }
                }
                newStorekeeper = getNameStorekeeperExist(StorekeeperList, keyword);
                ProductsList.get(index).setStorekeeper(newStorekeeper);
                //update Receipt Date
                String oldReceiptDate = ProductsList.get(index).getReceiptDate();
                String msgReceiptDate = "Old Receipt date:" + oldReceiptDate;
                System.out.println(msgReceiptDate);
                while (true) {
                    newReceiptDate = Inputter.inputDateLimit("Enter new Receipt date: ");
                    if (df.parse(newReceiptDate).after(df.parse(newDateOfManufacture))
                            && df.parse(newReceiptDate).before(df.parse(newExpiryDate))) {
                        break;
                    } else {
                        System.out.println("Receipt Date must after  date of manufacture !");
                    }
                }
                ProductsList.get(index).setReceiptDate(newReceiptDate);
                //when user input completed then display a msg update successfully
                System.out.println("Product " + uId + " has been updated!!!");
                //show list product after update
                showListProduct(ProductsList);
            }
        }
    }

    void searchProduct(ArrayList<Product> ProductsList) {
        if (ProductsList.isEmpty()) {
            System.out.println("Product list is empty!");
        } else {
            int choice;
            do {
                //display menu search
                System.out.println("*************Menu Search*************");
                System.out.println("1:Search by Name.");
                System.out.println("2:Search by Category.");
                System.out.println("3:Search by Storekeeper.");
                System.out.println("4:Search by ReceiptDate");
                System.out.println("5:exit!");
                System.out.println("*************************************");
                //user input choice
                choice = Inputter.getInt("Search product by:", "Your input invalid!", 1, 5);
                switch (choice) {
                    //when user choice 1 then search by product name
                    case 1:
                        String keywordName = Inputter.inputStringName("Enter name of product want to search: ", "Product name is only digits", "[a-zA-z ]+");
                        if (CheckNameProductExist(ProductsList, keywordName) == true) {
                            System.out.format("%-8s%-20s%-15s%-15s%-25s%-25s%-15s%-20s%-20s\n",
                                    "ID", "Product Name", "Location", "Price", "Manufacture Date", "Expiry Date", "Category", "Storekeeper", "Receipt date");
                            //Traverse through all elements in array
                            for (int i = 0; i < ProductsList.size(); i++) {
                                //if in index i product name contain name or a part of name the in keyword
                                if (ProductsList.get(i).getName().toLowerCase().replaceAll(" ", "").contains(keywordName.toLowerCase().replaceAll(" ", ""))) {
                                    System.out.println(ProductsList.get(i));
                                }
                            }
                        } else {
                            System.out.println("Your product name does not exist!");
                        }
                        break;
                    //when user input choice 2 then search by category
                    case 2:
                        String keywordCategory = Inputter.inputStringName("Enter category of product want to search: ", "Product category is only digits", "[a-zA-z ]+");
                        if (checkCategoryExist(ProductsList, keywordCategory) == true) {
                            System.out.format("%-8s%-20s%-15s%-15s%-25s%-25s%-15s%-20s%-20s\n",
                                    "ID", "Product Name", "Location", "Price", "Manufacture Date", "Expiry Date", "Category", "Storekeeper", "Receipt date");
                            //Traverse through all elements in array
                            for (int i = 0; i < ProductsList.size(); i++) {
                                if (ProductsList.get(i).getCategory().equalsIgnoreCase(keywordCategory)) {
                                    System.out.println(ProductsList.get(i));
                                }
                            }
                        } else {
                            System.out.println("Your product category does not exist!");
                        }
                        break;
                    //when user input choice 3 then search by storekeeper
                    case 3:
                        String keywordStorekeeper = Inputter.inputStringName("Enter storekeeper of product want to search: ", "Product storekeeper name is only digits", "[a-zA-z ]+");
                        if (checkNameStorekeeperExistInProductList(ProductsList, keywordStorekeeper) == true) {
                            System.out.format("%-8s%-20s%-15s%-15s%-25s%-25s%-15s%-20s%-20s\n",
                                    "ID", "Product Name", "Location", "Price", "Manufacture Date", "Expiry Date", "Category", "Storekeeper", "Receipt date");
                            //Traverse through all elements in array
                            for (int i = 0; i < ProductsList.size(); i++) {
                                if (ProductsList.get(i).getStorekeeper().equalsIgnoreCase(keywordStorekeeper)) {
                                    System.out.println(ProductsList.get(i));
                                }
                            }
                        } else {
                            System.out.println("Your product storekeeper name does not exist!");
                        }
                        break;
                    //when user input choice 4 then search by ReceiptDate
                    case 4:
                        String keywordReceiptDate = Inputter.inputDateLimit("Enter Receipt date for search: ");
                        if (checkReceiptDateExist(ProductsList, keywordReceiptDate) == true) {
                            System.out.format("%-8s%-20s%-15s%-15s%-25s%-25s%-15s%-20s%-20s\n",
                                    "ID", "Product Name", "Location", "Price", "Manufacture Date", "Expiry Date", "Category", "Storekeeper", "Receipt date");
                            //Traverse through all elements in array
                            for (int i = 0; i < ProductsList.size(); i++) {
                                if (ProductsList.get(i).getReceiptDate().equalsIgnoreCase(keywordReceiptDate)) {
                                    System.out.println(ProductsList.get(i));
                                }
                            }
                        } else {
                            System.out.println("Your ReceiptDate of product does not exist!");
                        }
                        break;
                }
            } while (choice > 0 && choice < 5);
        }
    }

    void sortProduct(ArrayList<Product> ProductsList) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        if (ProductsList.isEmpty()) {
            System.out.println("List is empty!");
        } else {
            //Sort product by Expiry date.
            //loop traverse through all product in list
            for (int i = 0; i < ProductsList.size() - 1; i++) {
                //loop traverse the list of unsorted products
                for (int j = 0; j < ProductsList.size() - i - 1; j++) {
                    if (df.parse(ProductsList.get(j).getExpiryDate()).after(df.parse(ProductsList.get(j+1).getExpiryDate()))) {
                        Collections.swap(ProductsList, j, j+1);
                        //if expiry date equal then sort product by Date of manufacture
                    } else if (df.parse(ProductsList.get(j).getExpiryDate()).equals(df.parse(ProductsList.get(j+1).getExpiryDate()))) {
                        if (df.parse(ProductsList.get(j).getDateOfManufacture()).after(df.parse(ProductsList.get(j+1).getDateOfManufacture()))) {
                            Collections.swap(ProductsList, j, j+1);
                        }
                    }
                }
            }
            showListProduct(ProductsList);

        }
    }

    //checking whether a id is duplicated or not ?
    private boolean isDuplicate(ArrayList<Product> ProductsList, String id) {
        //use for-each to over employee list
        for (Product E : ProductsList) {
            //if id user input the same id have exist then return false
            if (id.equalsIgnoreCase(E.getId())) {
                return false;
            }
        }
        //if id is not exist return true
        return true;
    }

    //show information of storekeeper
    public static void showListStorekeeper(ArrayList<Storekeeper> StorekeeperList) {
        //check list empty
        if (StorekeeperList.isEmpty()) {
            System.out.println("Empty list !!!");
        } else {
            System.out.println("***********************Store keeper list***********************");
            for (Storekeeper storekeeper : StorekeeperList) {
                System.out.println(storekeeper);
            }
            System.out.println("***************************************************************");
            System.out.println("Total: " + StorekeeperList.size() + " store keeper!!!");
        }

    }

    //show information of product
    public static void showListProduct(ArrayList<Product> ProductsList) {
        //check list empty
        if (ProductsList.isEmpty()) {
            System.out.println("Empty list !!!");
        } else {
            System.out.println("Products list:");
            System.out.format("%-8s%-20s%-15s%-15s%-25s%-25s%-15s%-20s%-20s\n",
                    "ID", "Product Name", "Location", "Price", "Manufacture Date", "Expiry Date", "Category", "Storekeeper", "Receipt date");
            for (Product product : ProductsList) {
                System.out.println(product);
            }
            System.out.println("Total: " + ProductsList.size() + " product!!!");
        }
    }

    //check name storekeeper exist
    public static boolean checkNameStorekeeperExist(ArrayList<Storekeeper> StorekeeperList, String keyword) {
        // Check if country is empty
        if (StorekeeperList.isEmpty()) {
            System.out.println("List is empty!");
        }
        for (int i = 0; i < StorekeeperList.size(); i++) {
            if (StorekeeperList.get(i).getName().equalsIgnoreCase(keyword)) {
                return true;
            }
        }
        return false;
    }

    public static String getNameStorekeeperExist(ArrayList<Storekeeper> StorekeeperList, String keyword) {
        if (checkNameStorekeeperExist(StorekeeperList, keyword)) {
            for (int i = 0; i < StorekeeperList.size(); i++) {
                if (StorekeeperList.get(i).getName().equalsIgnoreCase(keyword)) {
                    return StorekeeperList.get(i).getName();
                }
            }
        } else {
            System.out.println("Your storekeeper name does not exist!");
        }
        return null;
    }

    //search a product based on id
    public int getIndexID(ArrayList<Product> ProductsList, String id) {
        //Traverse through all elements in array
        for (int i = 0; i < ProductsList.size(); i++) {
            //when id input exist in list then return index of this id
            if (ProductsList.get(i).getId().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }

    public boolean CheckNameProductExist(ArrayList<Product> ProductsList, String keywordName) {
        // Check if country is empty
        if (ProductsList.isEmpty()) {
            System.out.println("List is empty!");
        }
        //Traverse through all elements in array
        for (int i = 0; i < ProductsList.size(); i++) {
            //if in index i product name contain name or a part of name the in keyword
            if (ProductsList.get(i).getName().toLowerCase().replaceAll(" ", "").contains(keywordName.toLowerCase().replaceAll(" ", ""))) {
                return true;
            }
        }
        return false;
    }

    public boolean checkCategoryExist(ArrayList<Product> ProductsList, String keyword) {
        // Check if country is empty
        if (ProductsList.isEmpty()) {
            System.out.println("List is empty!");
        }
        //Traverse through all elements in array
        for (int i = 0; i < ProductsList.size(); i++) {
            //if in index i product category exist then return true
            if (ProductsList.get(i).getCategory().equalsIgnoreCase(keyword)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkNameStorekeeperExistInProductList(ArrayList<Product> ProductsList, String keyword) {
        // Check if country is empty
        if (ProductsList.isEmpty()) {
            System.out.println("List is empty!");
        }
        for (int i = 0; i < ProductsList.size(); i++) {
            if (ProductsList.get(i).getStorekeeper().equalsIgnoreCase(keyword)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkReceiptDateExist(ArrayList<Product> ProductsList, String keyword) {
        // Check if country is empty
        if (ProductsList.isEmpty()) {
            System.out.println("List is empty!");
        }
        for (int i = 0; i < ProductsList.size(); i++) {
            if (ProductsList.get(i).getReceiptDate().equalsIgnoreCase(keyword)) {
                return true;
            }
        }
        return false;
    }

    /*
    ngày sản xuất< ngày nhập kho<hạn sử dụng
    ngày sản xuất < ngày nhập kho< hiện tại
     */
}
