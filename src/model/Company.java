package model;

public class Company{
	
    public static final int MAX_BATTERIES = 10;
	private Battery[] batteries;

	public Company() {
        this.batteries = new Battery[MAX_BATTERIES];
	}

    public Company(Battery[] batteries){
        this.batteries = batteries;
    }
	

    public void registerBattery(String name, double voltage, double cost, double capacity){
        int emtyPos = getEmtyPosition();
        batteries[emtyPos] = new Battery(name, voltage, cost, capacity);

    }

    public void registerRechargeableBattery(String name, double voltage, double cost, double capacity, int chargerNumber, char type) {
        int emtyPos = getEmtyPosition();
        batteries[emtyPos] = new RechargeableBattery(name, voltage, cost, capacity, chargerNumber ,type);
        
    }
    
    private int getEmtyPosition() {
        int pos = -1;
        for (int i = 0; i < MAX_BATTERIES && pos == -1; i++) {
            if (batteries[i] == null) {
                pos = i;
            }
        }
        return pos;
    }

    public String showTotalBatteries() {
    	
        String out = "";
        int countB = 0;
        int countR = 0;
       
        for(int i = 0; i<MAX_BATTERIES;i++){
            if(batteries[i] instanceof Battery){
                countB += 1;
            }

            if(batteries[i] instanceof RechargeableBattery){
                countR +=1;
            }
        }

        out = "Normal battery:" + countB + "\n Rechargeable battery:" + countR;
        
        return out;
    }
    
    public String showBatteriesInfo() {
    	String str = "";
        for(int i = 0;i<MAX_BATTERIES;i++){
            str += batteries[i].toInfo() + "\n";
        }
    	return str;
    }
    

	public double calculateUsefulPromLifeCost(){
		double out;
        int countR = 0;
        double lifeCost = 0;
        for(int i = 0; i<MAX_BATTERIES;i++){
            if(batteries[i] instanceof RechargeableBattery){
                countR += 1;
                lifeCost=((RechargeableBattery)batteries[i]).calculateUsefulLifeCost();
            }
        }

        out = lifeCost/countR;

        return out;
	}

}
