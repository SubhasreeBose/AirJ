import persistence.FileRead;
import display.*;

/**
 *
 * @author AirJ
 */

public class FlightManager {
     public static void main(String argsv[]) { 
    	 
    	 if((argsv[0].equalsIgnoreCase("spicejet.Schedule.csv")==true && argsv[1].equalsIgnoreCase("silkair.Schedule1.csv")==true)||(argsv[0].equalsIgnoreCase("spicejet.Schedule1.csv")==true && argsv[1].equalsIgnoreCase("silkair.Schedule.csv")==true))
    	 {
    		 System.out.println("Incompatible dates, please check input data");
    	  
    	 }
    	 else
    	 {
         if (argsv.length==3) {
            if(argsv[2].equals("swing")==true) {
            	    
                    DisplayManager dm=new DisplayManager(argsv[0],argsv[1]);
                    dm.displaySearchPage(argsv[0],argsv[1]);
            }
            else
            	System.out.println(argsv[2]+" display is not implemented.");
         }
         else if(argsv.length==2) {
        	 
        	     
        		 StdDisplayManager sdm=new StdDisplayManager(argsv[0],argsv[1]);
                 sdm.displaySearchPage(argsv[0],argsv[1]); 
        	 
         }
         else
             System.out.println("Invalid Entry!");
    	 }
    }
}
