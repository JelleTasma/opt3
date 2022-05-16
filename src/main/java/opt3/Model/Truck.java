package opt3.Model;

public class Truck extends Item {
    private int load;
    private int weight;
    private double rentPrice;

    public Truck(int load, int weight, String name, String description, int price, Boolean inRent) {
        super(name, description, price, inRent);
        this.load = load;
        this.weight = weight;
        this.rentPrice = (double)load * 0.10;
    }
}