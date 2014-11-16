package persistence;
/**
 *
 * @author AirJ
 */
import display.*;
import data.*;
import persistence.*;
import util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import data.Flight;

public class FileRead implements Persistence {
    
    Flight flights[];
    int size;
    
    public Flight[] readSilkAirFile() {
        FileReader reader = null;
        BufferedReader br = null;
        String str; 
        int i = 0;
        try {
           reader = new FileReader("Files/silkair.Schedule.csv");
           br = new BufferedReader(reader);
        }
        catch(FileNotFoundException e) {
            System.out.println("File is not found");
        }
        try{
            str = br.readLine();
            while(str != null) {
                i++;
                str = br.readLine();
            }
            br.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

        flights = new Flight[i-3];
        for(int j=0;j<i-3;j++)
                flights[j]=new Flight();

        str = null;
        i = 0;    

        try {
            reader = new FileReader("Files/silkair.Schedule.csv");
            br = new BufferedReader(reader);
            while(i<3) {
                str = br.readLine();
                i++;
            }

            str = br.readLine();
            i=0;
            String strPart1 = "", strPart2 = "", strPart3 = "";
            while(str != null) {
                StringTokenizer data = new StringTokenizer(str,"\"");
                strPart1 = data.nextToken();
                strPart2 = data.nextToken();
                strPart3 = data.nextToken();
                if(strPart1 != null) {
                    StringTokenizer dataPart = new StringTokenizer(strPart1, ",");
                   flights[i].setSource(dataPart.nextToken().trim());
                }
                String tmp = "";
                if(strPart2 != null){
                    StringTokenizer dataPart = new StringTokenizer(strPart2, ",");
                    int j = dataPart.countTokens();
                    while(--j >= 0) {
                        tmp = dataPart.nextToken();
                        if(tmp.compareTo("Sun") == 0) {
                            flights[i].setFrequency(0,true);
                            flights[i].setFrequency(7,true);
                        }
                        else if(tmp.compareTo("Mon") == 0)
                            flights[i].setFrequency(1,true); 
                        else if(tmp.compareTo("Tue") == 0)
                            flights[i].setFrequency(2,true);
                        else if(tmp.compareTo("Wed") == 0)
                            flights[i].setFrequency(3,true);
                        else if(tmp.compareTo("Thu") == 0)
                            flights[i].setFrequency(4,true);
                        else if(tmp.compareTo("Fri") == 0)
                            flights[i].setFrequency(5,true);
                        else if(tmp.compareTo("Sat") == 0)
                            flights[i].setFrequency(6,true);
                    }
                }
                if(strPart3 != null) {
                    StringTokenizer dataPart3 = new StringTokenizer(strPart3, ",");
                    flights[i].setFlightNo(dataPart3.nextToken());
                    String strPart4 = dataPart3.nextToken();
                    StringTokenizer dataPart4 = new StringTokenizer(strPart4, "/");
                    flights[i].setDepTime(dataPart4.nextToken());
                    flights[i].setArrTime(dataPart4.nextToken());
                }

                i++;
                strPart1 = null;
                strPart2 = null;
                strPart3 = null;
                str = br.readLine();
            }
            br.close();
        }
        catch (IOException e) {
           System.out.println("Cannot read the file");
        }
        finally {
           if(reader != null) {
               try {
                   br.close();
               }
               catch (IOException e) {
                   System.out.println("Error in closing the file");
               }
           }
        }
        return flights;
    }
    
    int silkSize() {
        FileReader reader = null;
        BufferedReader br = null;
        String str = ""; 
        int i = 0;
        try {
           reader = new FileReader("Files/silkair.Schedule.csv");
           br = new BufferedReader(reader);
        }
        catch(FileNotFoundException e) {
            System.out.println("File is not found");
        }
        try{
            str = br.readLine();
            while(str != null) {
                i++;
                str = br.readLine();
            }
            br.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return i-3;
    }
    
    public Flight[] readSpiceJetFile() {
        FileReader reader = null;
        BufferedReader br = null;
        boolean b1;
        String eff_from[], eff_till[];
        String strPart1 = "", strPart2 = "", strPart3 = "";
        String str = "", temp = "";
        int i = 0;
        try {
           reader = new FileReader("Files/spicejet.Schedule.csv");
           br = new BufferedReader(reader);
        }
        catch(FileNotFoundException e) {
            System.out.println("File is not found");
        }
        try{
            str = br.readLine();
            while(str != null) {
                i++;
                str = br.readLine();
            }
            br.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        size = i-1;
        flights = new Flight[i-1];
        for(int j=0;j<i-1;j++)
            flights[j]=new Flight();
        eff_from = new String[i-1];
        eff_till = new String[i-1];
        i=0;
        
        try {
            reader = new FileReader("Files/spicejet.Schedule.csv");
            br = new BufferedReader(reader);            
            str = br.readLine();            
            str = br.readLine();
            
            while(str != null) {
                b1 = str.contains("\"");
                if(b1){
                    StringTokenizer data = new StringTokenizer(str,"\"");
                    strPart1 = data.nextToken();
                    strPart2 = data.nextToken();
                    strPart3 = data.nextToken();
                    if(strPart1 != null){
                        StringTokenizer dataPart = new StringTokenizer(strPart1, ",");
                        flights[i].setSource(dataPart.nextToken());
                        flights[i].setDestination(dataPart.nextToken());
                    }
                    String tmp = "";
                    if(strPart2 != null){
                        StringTokenizer dataPart = new StringTokenizer(strPart2, ",");
                        int j = dataPart.countTokens();
                        while(j-- > 0) {
                            tmp = dataPart.nextToken();
                            tmp = tmp.trim();
                            if(tmp.compareTo("Sunday") == 0){
                                flights[i].setFrequency(0,true);
                                flights[i].setFrequency(7,true);
                            }
                            else if(tmp.compareTo("Monday") == 0)
                            	flights[i].setFrequency(1,true); 
                            else if(tmp.compareTo("Tueday") == 0)
                            	flights[i].setFrequency(2,true);
                            else if(tmp.compareTo("Wednesday") == 0)
                                flights[i].setFrequency(3,true);
                            else if(tmp.compareTo("Thursday") == 0)
                                flights[i].setFrequency(4,true);
                            else if(tmp.compareTo("Friday") == 0)
                                flights[i].setFrequency(5,true);
                            else if(tmp.compareTo("Saturday") == 0)
                                flights[i].setFrequency(6,true);
                        }
                        
                    }
                    if(strPart3 != null){
                        StringTokenizer dataPart3 = new StringTokenizer(strPart3, ",");
                        flights[i].setFlightNo(dataPart3.nextToken());
                        flights[i].setDepTime(dataPart3.nextToken());
                        flights[i].setArrTime(dataPart3.nextToken());
                        flights[i].setVia(dataPart3.nextToken());
                        eff_from[i] = dataPart3.nextToken();
                        temp = dataPart3.nextToken();
                        if(temp.contains("Oct"))
                            eff_till[i] = temp;
                        else {
                        	i--;
                        	size--;
                        }
                    }
                }
                else{
                    StringTokenizer data = new StringTokenizer(str,",");
                    flights[i].setSource(data.nextToken().trim());
                    flights[i].setDestination(data.nextToken().trim());
                    temp = data.nextToken();
                    
                    if(temp.compareTo("Daily") == 0){
                        for(int x=0; x<=7; x++)
                            flights[i].setFrequency(x, true);
                    }
                    else
                        flights[i].setFrequency(7, true);
                    
                    flights[i].setFlightNo(data.nextToken());
                    flights[i].setDepTime(data.nextToken());
                    flights[i].setArrTime(data.nextToken());
                    flights[i].setVia(data.nextToken());
                    eff_from[i] = data.nextToken();
                    temp = data.nextToken();
                    if(temp.contains("Oct"))
                        eff_till[i] = temp;
                    else {
                        i--;
                        size--;
                    }
                }
                i++;
                strPart1 = null;
                strPart2 = null;
                strPart3 = null;
                str = br.readLine();
            }
            br.close();      
        }
        catch (IOException e) {
           System.out.println("Cannot read the file");
        }
        finally {
            if(reader != null) {
                try {
                   br.close();
                }
                catch (IOException e) {
                   System.out.println("Error in closing the file");
                }
            }
        }
        return flights;
    }
    
    int spiceSize() {
        return size;
    }
    
    public void readBooking() {
        
    }
    
    public void saveBooking() {
        
    }
}
