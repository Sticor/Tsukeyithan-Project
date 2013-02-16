package Tsukeyithan.Manager;


public class TKHEntityManager{

    public static String entitySexe;
    public static int powerCD;
    public static int maxPowerCD;
    public static boolean stuned;
    public String entityType;
    
    public TKHEntityManager()
    {    	
    	stuned = false;
    	this.entityType = "";
    	this.entitySexe = "";
    	powerCD = maxPowerCD = 1;
    }
    
    public void onUpdate(){
    	if(powerCD < 600)
    		powerCD++;
    }
}
