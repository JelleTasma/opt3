package opt3.Model;

import java.util.ArrayList;

public class Item {
    private String soort;
    private String name;
    private String description;
    private int price;
    private Boolean inRent;
    private User user;
    private String customer;
    private String stock;
    private String brand;
    private int weight;
    private int rentPrice;

    public static final ArrayList<Item> items = new ArrayList<>();

    // make a new items in the constructor
    public Item(String name, String description, int price, Boolean inRent){
        this.soort = soort;
        this.name = name;
        this.description = description;
        this.price = price;
        this.inRent = inRent;
        this.user = null;
        this.customer = "";
        this.stock = "Ja";
    }

    // add the get and set methods
    public String getName(){return name;}
    public String getDescription(){return description;}
    public int getPrice(){return price;}
    public Boolean getInRent(){return inRent;}
    public User getUser(){return user;}
    public String getCustomer(){return customer;}
    public String getStock(){return stock;}
    public void endRent(){
        this.inRent = false;
        this.user = null;
        this.customer = "";
        this.stock = "Ja";
    }
    public void startRent(User user, String customer){
        this.inRent = true;
        this.user = user;
        this.customer = customer;
        this.stock = "Nee";
    }


}
