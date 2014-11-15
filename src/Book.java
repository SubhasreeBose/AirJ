

import java.io.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Subhasree
 */
public class Book {
    private String date,flightNo,capacity;
    Book(String date,String flightNo,String capacity)
    {
        this.date=date;
        this.flightNo=flightNo;
        this.capacity=capacity;
    }
    public void book() 
    {
        FileWriter fw;
        BufferedWriter bw;
        try
        {
            fw=new FileWriter("Files/book.csv");
            bw=new BufferedWriter(fw);
        }
        catch(Exception e)
        {
            
        }
        try
        {
            fw=new FileWriter("Files/book.csv");
            bw=new BufferedWriter(fw);
            bw.append(date+","+flightNo+","+capacity+"\n");
            bw.close();
            fw.close();
        }
        catch(Exception e)
        {
            
        }
        
    }
}
