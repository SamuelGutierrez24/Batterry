package model;

public class RechargeableBattery extends Battery implements Rechargeable {
    
public static final char BATTERY_LITIO = 'l';

public static final char BATTERY_NIQUEL_CADIO = 'n';

public static final double FACTOR_LITIO  = 0.92;

public static final double FACTOR_NIQUEL_CADIO = 0.80;

private char type;

private int chargerNumber;

    public RechargeableBattery(String name,double voltage, double cost, double capacity, int chargerNumber, char type){

        super(name, voltage, cost, capacity);
        this.chargerNumber=chargerNumber;
        this.type = type;
    }

    @Override
    public double calculateUsefulLifeCost(){

        double out = 0;

        double factor = 0;

        if(type=='l'){
            factor = FACTOR_LITIO;
        }

        if(type=='n'){
            factor = FACTOR_NIQUEL_CADIO;
        }
        out = (cost*voltage*capacity)/1000*chargerNumber*factor;

        return out;


    }

    @Override
    public String toInfo(){
        String out = "";

        out = "Type Rechargeable battey \n" + " Name : " + name + "\n Useful life cost :" + calculateUsefulLifeCost();

        return out;
    }


}
