import java.util.*;
import java.text.*;
import persistence.SilkAirSchedule;
import persistence.SpiceJetSchedule;
   
public class AirJFileReader {
    public static void main() {
	   
        SilkAirSchedule silkAir = new SilkAirSchedule();
        SpiceJetSchedule spiceJet = new SpiceJetSchedule();
        //silkAir.display();
        //spiceJet.display();

        System.out.println("Enter starting point:");
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();

        System.out.println("Enter day");
        int dd=sc.nextInt(); 
        int spiceDay = check(dd);
        int silkDay = check(dd);
        int totalTime;

        int i,j,p=0;
        for(i=0;i<spiceJet.size;i++) {
            if(spiceJet.flights[i].getSource().compareTo(str) == 0 && spiceJet.flights[i].getFrequency(spiceDay)) { 
                for(j=0;j<silkAir.size;j++) {  //total no of silkAir flights
                    String silkSource=silkAir.flights[j].getSource(); //source of each silkAir flight
                    int depTimeHr = silkAir.getHr(j, 0);
                    int depTimeMin = silkAir.getMin(j, 0);
                    //destination of spiceJet = source of silkAir = intermediate
                    String spiceDest = spiceJet.flights[i].getDestination();
                    spiceDest = spiceDest.trim();

                    int arrTimeHr = spiceJet.getHr(i, 1);
                    int arrTimeMin = spiceJet.getMin(i, 1);

                    if(spiceDest.compareTo(silkSource.substring(0,silkSource.lastIndexOf("(")-1).toUpperCase().trim())==0) {
                        if(silkAir.flights[j].getFrequency(silkDay)) {
                            int time = timediff(arrTimeHr, arrTimeMin, depTimeHr, depTimeMin); 
                            if(time >= 120 && time <= 360) {
                                totalTime = timediff(spiceJet.getHr(i, 0), spiceJet.getMin(i, 0), silkAir.getHr(j, 1), silkAir.getMin(j, 1));
                                System.out.print("SpiceJet: " + spiceJet.flights[i].getFlightNo() + " at: " + arrTimeHr + ":" + arrTimeMin + "\tTo: " + spiceDest);
                                if(spiceJet.flights[i].isHopping())
                                    System.out.print("\tVia: " + spiceJet.flights[i].getVia() + "\t");
                                System.out.println("\tSilk Air: " + silkAir.flights[j].getFlightNo() + " at: " + depTimeHr + ":" + depTimeMin + "\tTo: Singapore" + "\tTotal Time: " + totalTime + "mins");
                            
                            }
                            
                        }
                    }
                }			   
            }
        }
       
    }
    

    public static int timediff(int start_hr, int start_min, int end_hr, int end_min) {
        int diff;
        if(end_hr<start_hr)
            diff=((end_hr+24)-start_hr)*60;
        else
            diff=(end_hr-start_hr)*60;
        return(diff+(end_min-start_min));
    }

    public static int check(int dd){
        Date date = (new GregorianCalendar(2014, 9, dd)).getTime();
        SimpleDateFormat f = new SimpleDateFormat("EEEE");
        String d = f.format(date);
        if(d.compareTo("Sunday") == 0){
            if((dd>=1 && dd<=7) ||(dd>=15 && dd<=21))
                return 7;
            return 0;
        }
        else if(d.compareTo("Monday") == 0)
            return 1;
        else if(d.compareTo("Tuesday") == 0)
            return 2;
        else if(d.compareTo("Wednesday") == 0)
            return 3;
        else if(d.compareTo("Thursday") == 0)
            return 4;
        else if(d.compareTo("Friday") == 0)
            return 5;
        else
            return 6;
    }
}