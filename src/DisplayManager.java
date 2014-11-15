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

   
    @Override
    public void displaySearchPage() {
     new SearchPage(); 
     
    }

    @Override
    public void displayDisplayPage(SearchPage objSearch) {
        new DisplayPage(objSearch);
    }

    @Override
    public void displayBookingPage(DisplayPage objdisplay,SearchPage objsearch) {
        new BookingPage(objdisplay,objsearch);
    }

    @Override
    public void displayTicket() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
