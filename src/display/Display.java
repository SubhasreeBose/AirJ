package display;

import data.CombinedFlight;

/**
 *
 * @author AirJ
 */

public interface Display {
    public void displaySearchPage();
    public void displayDisplayPage(CombinedFlight cf);
    public void displayBookingPage(CombinedFlight cf);
    public void displayTicket();
}
