/**
 *
 * @author AirJ
 */

public interface Persistence {
    public Flight[] readSilkAirFile();
    public Flight[] readSpiceJetFile();
    public void readBooking();
    public void saveBooking();
}
