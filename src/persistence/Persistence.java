package persistence;
import data.Flight;
import display.*;
import data.*;
import persistence.*;
import util.*;
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
