package persistence;

import data.*;
/**
 *
 * @author AirJ
 */

public interface Persistence {
    public Flight[] readSilkAirFile();
    public Flight[] readSpiceJetFile();
    public Flight[] readBooking(Flight[] flights, int size, String date, int passCount);
    public void saveBooking(CombinedFlight cf, String date, int passCount);
}
