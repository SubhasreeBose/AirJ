/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Subhasree
 */
public class DisplayManager implements Display{

   SearchPage sm,objsearch;
   DisplayPage objdisplay;
   DisplayManager()
   {
       
   }
   DisplayManager(Object obj)
   {
       objsearch=(SearchPage)obj;
   }
   DisplayManager(Object obj1,Object obj2)
   {
       objsearch=(SearchPage)obj2;
       objdisplay=(DisplayPage)obj1;
   }
    @Override
    public void displaySearchPage() {
     sm=new SearchPage(); 
     
    }

    @Override
    public void displayDisplayPage(CombinedFlight cf) {
        
        new DisplayPage(objsearch);
    }

    @Override
    public void displayBookingPage(CombinedFlight cf) {
        new BookingPage(objdisplay,objsearch);
    }

    @Override
    public void displayTicket() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
