package model;

public class Battery {

    protected String name;

    protected double voltage;

    protected double cost;

    protected double capacity;

    public Battery (String name, double voltage, double cost, double capacity){

        this.name = name;
        this.voltage = voltage;
        this.cost = cost;
        this.capacity = capacity;

    }

    public String toInfo(){
        String out = "";

        out = "Type : Battery no rechargeable \n" + "Name : " + name + " \n Useful life cost: " + 0;
        return out;
    }


    
}
