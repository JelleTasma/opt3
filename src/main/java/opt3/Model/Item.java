package opt3.Model;

import java.util.ArrayList;

public class Item implements StartRent, EndRent {
    private String soort;
    private String name;
    private String description;
    private double price;
    private String brand;
    private int weight;
    private int load;
    private String type;
    private Boolean inRent;
    private User user;
    private String customer;
    private String stock;


    public static final ArrayList<Item> items = new ArrayList<>();

    // make a new items in the constructor
    public Item(String soort, String name, String description, double price, Boolean inRent, String brand, int weight, int load, String type){
        this.soort = soort;
        this.name = name;
        this.description = description;
        this.price = price;
        this.brand = brand;
        this.weight = weight;
        this.load = load;
        this.type = type;
        this.inRent = inRent;
        this.user = null;
        this.customer = "";
        this.stock = "Ja";
    }

    // add the get and set methods
    public String getSoort(){return this.soort;}
    public String getName(){return this.name;}
    public String getDescription(){return this.description;}
    public double getPrice(){return this.price;}
    public String getBrand(){return this.brand;}
    public String getType(){return this.type;}
    public int getWeight(){return this.weight;}
    public int getLoad(){return this.load;}
    public Boolean getInRent(){return inRent;}
    public User getUser(){return user;}
    public String getCustomer(){return customer;}
    public String getStock(){return stock;}
    @Override
    public void endRent(){
        this.inRent = false;
        this.user = null;
        this.customer = "";
        this.stock = "Ja";
    }
    @Override
    public void startRent(User user, String customer){
        this.inRent = true;
        this.user = user;
        this.customer = customer;
        this.stock = "Nee";
    }
}
