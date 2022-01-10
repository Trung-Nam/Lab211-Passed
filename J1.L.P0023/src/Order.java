
import java.util.ArrayList;

public class Order {

    private ArrayList<Fruit> ordered;
    private String name;

    public Order() {
    }

    public Order(ArrayList<Fruit> ordered, String name) {
        this.ordered = ordered;
        this.name = name;
    }

    public ArrayList<Fruit> getOrdered() {
        return ordered;
    }

    public void setOrdered(ArrayList<Fruit> ordered) {
        this.ordered = ordered;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
