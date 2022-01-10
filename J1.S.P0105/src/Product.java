
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ASUS G731G
 */
public class Product {

    private String id;
    private String name;
    private String location;
    private double price;
    private String dateOfManufacture;
    private String expiryDate;
    private String category;
    private String storekeeper;
    private String receiptDate;

    public Product() {
    }

    public Product(String id, String name, String location, double price, String dateOfManufacture, String expiryDate, String category, String storekeeper, String receiptDate) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.price = price;
        this.dateOfManufacture = dateOfManufacture;
        this.expiryDate = expiryDate;
        this.category = category;
        this.storekeeper = storekeeper;
        this.receiptDate = receiptDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(String dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStorekeeper() {
        return storekeeper;
    }

    public void setStorekeeper(String storekeeper) {
        this.storekeeper = storekeeper;
    }

    public String getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(String receiptDate) {
        this.receiptDate = receiptDate;
    }

    @Override
    public String toString() {
        String result;
        result = String.format("%-8s%-20s%-15s%-15s%-25s%-25s%-15s%-20s%-20s\n",this.id,this.name,this.location,this.price,this.dateOfManufacture,this.expiryDate,this.category,this.storekeeper,this.receiptDate);
        return result;
    }
}
