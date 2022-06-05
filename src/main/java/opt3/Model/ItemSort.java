package opt3.Model;

import java.util.ArrayList;

public class ItemSort {
    private String name;
    private boolean brand;
    private boolean weight;
    private boolean load;
    private boolean type;
    private double dayPrice;
    private double DL;
    private double IV;
    private double IW;

    public static ArrayList<ItemSort> sorts = new ArrayList<ItemSort>();

    public ItemSort(String name, boolean brand, boolean weight, boolean load, boolean type, double dayPrice,  double DL, double IV, double IW){
        this.name = name;
        this.brand = brand;
        this.weight = weight;
        this.load = load;
        this.type = type;
        this.dayPrice = dayPrice;
        this.DL = DL;
        this.IV = IV;
        this.IW = IW;
    }

    public String getName(){return this.name;}
    public boolean getBrand(){return this.brand;}
    public boolean getWeight(){return this.weight;}
    public boolean getLoad(){return this.load;}
    public boolean getType(){return this.type;}
    public double getDayPrice(){return this.dayPrice;}
    public double getDL(){return this.DL;}
    public double getIV(){return this.IV;}
    public double getIW(){return this.IW;}
    public double calculateDayPrice(){
        double total = 0;
        if(this.dayPrice != 0.00)
            total += this.dayPrice;
        if(this.DL != 0.00)
            total += this.DL;
        if(this.IV != 0.00)
            total += this.IV;
        if(this.IW != 0.00)
            total += this.IW;
        return total;
    }

}
