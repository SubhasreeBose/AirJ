/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Subhasree
 */
public interface Display {
    public void displaySearchPage();
    public void displayDisplayPage(SearchPage objSearch);
    public void displayBookingPage(DisplayPage objdisplay,SearchPage objsearch);
    public void displayTicket();
}
