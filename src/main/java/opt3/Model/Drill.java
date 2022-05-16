package opt3.Model;

public class Drill extends Item {
    private String brand;
    private String type;
    private double rentPrice;

    public Drill(String brand, String type, String name, String description, int price, Boolean inRent) {
        super(name, description, price, inRent);
        this.brand = brand;
        this.type = type;
        this.rentPrice = 5;
    }
}
