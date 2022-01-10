
public class Fruit {
    private String FruitID;
    private String FruitName;
    private double Price;
    private int Quantity;
    private String Origin;

    public Fruit() {
    }

    public Fruit(String FruitID, String FruitName, double Price, int Quantity, String Origin) {
        this.FruitID = FruitID;
        this.FruitName = FruitName;
        this.Price = Price;
        this.Quantity = Quantity;
        this.Origin = Origin;
    }

    public String getFruitID() {
        return FruitID;
    }

    public void setFruitID(String FruitID) {
        this.FruitID = FruitID;
    }

    public String getFruitName() {
        return FruitName;
    }

    public void setFruitName(String FruitName) {
        this.FruitName = FruitName;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public String getOrigin() {
        return Origin;
    }

    public void setOrigin(String Origin) {
        this.Origin = Origin;
    }
    
    
}
