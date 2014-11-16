import display.*;

/**
 *
 * @author AirJ
 */

public class FlightManager {
     public static void main(String argsv[]) {         
         if (argsv.length==3) {
            if(argsv[2].equals("swing")==true) {
                    DisplayManager dm=new DisplayManager();
                    dm.displaySearchPage();
            }
            else
            	System.out.println(argsv[2]+" display is not implemented.");
         }
         else if(argsv.length==2) {
             StdDisplayManager sdm=new StdDisplayManager(argsv[0],argsv[1]);
             sdm.displaySearchPage();
         }
         else
             System.out.println("Invalid Entry!");
    }
}
