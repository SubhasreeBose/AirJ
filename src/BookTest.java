
import java.util.Scanner;

import persistence.FileRead;
import data.CombinedFlight;

public class BookTest {
    public static void main(String args[]) {
        System.out.println("Enter source:");
        Scanner sc = new Scanner(System.in);
        String source = sc.next();
        System.out.println("Enter day:");        
        int day = sc.nextInt();
        System.out.println("Enter Passengers:");
        int passCount = sc.nextInt();
        
        CombinedFlight cf1 = new CombinedFlight(source, day, day, passCount);
        CombinedFlight[] cf2 = cf1.combine(source, day, day, passCount);
        
        Book book1;
        for(int i=0; i<cf1.flightCount; i++){
            book1 = new Book("Oct",cf2[i].getSpiceFlightNo(),10);
            System.out.println("Flight1:"+cf2[i].getSpiceFlightNo()+"\tFlight2:"+cf2[i].getSilkFlightNo());
        }
        FileRead fr = new FileRead();
        fr.saveBooking(cf2[1], "4/11", passCount);
    } 
}