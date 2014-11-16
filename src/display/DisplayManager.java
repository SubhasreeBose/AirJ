package display;

import data.CombinedFlight;

/**
 *
 * @author AirJ
 */

public class DisplayManager implements Display{

    SearchPage sm,objsearch;
    DisplayPage objdisplay;
   
    public DisplayManager() {
        
    }
    public DisplayManager(Object obj) {
        objsearch=(SearchPage)obj;
    }
   DisplayManager(Object obj1,Object obj2) {
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
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
