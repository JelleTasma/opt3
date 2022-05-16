package opt3.Model;

public class Car extends Item {
    private String brand;
    private int weight;
    private int rentPrice;

    public Car(String brand, int weight, String name, String description, int price, Boolean inRent) {
        super(name, description, price, inRent);
        this.brand = brand;
        this.weight = weight;
        this.rentPrice = 50;
    }

}
