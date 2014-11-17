package util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class ValidateDate {
    String day,month,year;
   public ValidateDate(String day,String month,String year) {
	   this.day=day;
	   this.month=month;
	   this.year=year;
   }
   
   public int validateDate() {
	   
	   if(year.equalsIgnoreCase("2014")==true) {
		   if(month.equalsIgnoreCase("Oct")==true || month.equalsIgnoreCase("Dec")==true)
			   return 1;
		   if(month.equalsIgnoreCase("Nov")==true && day.equalsIgnoreCase("31")==false)
			   return 1;
	   }
	   else if(year.equalsIgnoreCase("2015")==true) {
		   if(month.equalsIgnoreCase("Feb")==true || month.equalsIgnoreCase("Mar")==true)
			   if( day.equalsIgnoreCase("31")==false ||day.equalsIgnoreCase("29")==false||day.equalsIgnoreCase("30")==false)
				   return 1;
		   if(month.equalsIgnoreCase("Jan")==true)
			   return 1;
	   }		   
	   return 0;
   }
   public int checkMonth() {
	   if(month.equalsIgnoreCase("Oct")==true )
		   return 10;
	   if(month.equalsIgnoreCase("Nov")==true )
		   return 11;
	   if(month.equalsIgnoreCase("Dec")==true )
		   return 12;
	   if(month.equalsIgnoreCase("Jan")==true )
		   return 1;
	   if(month.equalsIgnoreCase("Feb")==true )
		   return 2;
	   if(month.equalsIgnoreCase("Mar")==true )
		   return 3;	   
	   return -1;
   }
   
   public  int checkDay(int dd,int mm) {
       Date date = (new GregorianCalendar(2014, mm-1, dd)).getTime();
       SimpleDateFormat f = new SimpleDateFormat("EEEE");
       String d = f.format(date);
       if(d.compareTo("Sunday") == 0)
           return 0;
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