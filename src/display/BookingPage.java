package display;
/**
 *
 * @author AirJ
 */
import display.*;
import data.*;
import persistence.*;
import util.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class PrintTicket extends JFrame {
    JFrame Pframe;
    
    PrintTicket(BookingPage obj) {
        Pframe=new JFrame("Ticket");
        Pframe.setSize(300,420);
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - Pframe.getWidth()) / 2;
        int y = (screenSize.height - Pframe.getHeight()) / 2;
        Pframe.setLocation(x, y);
        Pframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        
        JLabel LHeading=new JLabel("<html><font size=\"3\"color=\"#B20000\">Thanks for booking with us.Happy Journey!</font></html>");
        JLabel LName=new JLabel("<html><B><font size=\"2\"color=\"blue\">"+obj.TxtName.getText()+"</font> </B></html>");
       
        JButton BBook=new JButton("OK");
        JLabel LDummy=new JLabel("<html><B> </B></html>");
        JLabel LDate=new JLabel("<html><B><font size=\"2\"color=\"blue\">"+obj.objsearch.CBDated.getSelectedItem().toString()+" Oct 2014</font></B></html>");
        JLabel LPerson=new JLabel("<html><B><font size=\"2\"color=\"blue\">No.of passengers :"+obj.objsearch.SlidePerson.getValue()+ "</font></B></html>");
        JLabel LFlight1=new JLabel("<html><B><font size=\"2\"color=\"blue\">"+obj.flight1+" Flight from "+obj.objsearch.CBPlace.getSelectedItem().toString()+" to "+obj.inter+" .</font></B></html>");
        JLabel LFlight2=new JLabel("<html><B><font size=\"2\"color=\"blue\">"+obj.flight2+" Flight from "+obj.inter+" to SINGAPORE .</font></B></html>");
        JLabel LTime=new JLabel("<html><B><font size=\"2\"color=\"blue\">Time</font></B></html>");
        JTextField TxtName=new JTextField();        
        
        LFlight1.setBounds(30,200,250,30);
        LHeading.setBounds(20,10,250,30);
        LFlight2.setBounds(30,240,250,30);
        LTime.setBounds(30,160,70,30);
        BBook.setBounds(105,300,80,30);
        TxtName.setBounds(130, 50, 100, 30);
        LDate.setBounds(30, 90, 240, 30);
        LName.setBounds(30, 50, 240, 30);
        LPerson.setBounds(30, 120, 100, 30);      
        
        Pframe.add(LHeading);
        Pframe.add(LTime);
        Pframe.add(LName);
        Pframe.add(BBook);
        Pframe.add(LFlight1);
        Pframe.add(LFlight2);
        Pframe.add(LDate);
        Pframe.add(LPerson);    
        Pframe.add(LDummy);
        Pframe.setVisible(true);
        
        BBook.addActionListener(new ActionListener() {
           @Override
            public void actionPerformed(ActionEvent e) {
               JOptionPane.showMessageDialog(null, "Thank You!\nYour booking has been confirmed.\nHave a safe journey.");
            } 
        });
    }
}

class BookButton implements ActionListener {
    BookingPage obj;
    
    BookButton(BookingPage obj) {
        this.obj=obj;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(obj.TxtName.getText().equals(""))
           JOptionPane.showMessageDialog(null,"Sorry! Please, fill up the fields.");
        else if(obj.Txtemail.getText().contains("@")==false)
        {
            JOptionPane.showMessageDialog(null,"Please,Enter a valid Email id.");
        }
        else if(!obj.licenseBox.isSelected())
        {
            JOptionPane.showMessageDialog(null, " You need to accept to proceed further!");
        }
        else { 
            int iChoice = JOptionPane.showConfirmDialog(null," Continue booking?");
            if(iChoice == JOptionPane.YES_OPTION) {
                
                new PrintTicket(obj);
                obj.Bframe.dispose();
            }
            else {
            }
        }
    }
}

public class BookingPage extends JFrame{
    JFrame Bframe;
    JLabel search,display;
    JButton BBook;
    JTextField TxtName,Txtemail;
    SearchPage objsearch;
    DisplayPage objdisplay;
    JCheckBox licenseBox;
    String flight1,flight2,inter;
    
    BookingPage(DisplayPage objdisplay,SearchPage objsearch)
    {
        this.objdisplay=objdisplay;
        this.objsearch=objsearch;
        
        Bframe=new JFrame("Confirm Booking");
        Bframe.setSize(650,650);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - Bframe.getWidth()) / 2;
        int y = (screenSize.height - Bframe.getHeight()) / 2;
        Bframe.setLocation(x, y);
        Bframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       
                
                
        Icon img1 = new ImageIcon("Images\\index.png");
        JLabel LLogo = new JLabel("<html><i><font face=\"verdana\" size=\"3\" color=\"blue\">The smarter,easier and faster way to book flights.</font></i></html>", img1, SwingConstants.LEFT);
   
        Icon imgedit=new ImageIcon("Images/Edit.gif");
        
           
        
        JLabel LName=new JLabel("<html><B> Name: </B></html>");
        TxtName=new JTextField();
        JLabel LEmail=new JLabel("<html><B> Email ID: </B></html>");
        Txtemail=new JTextField();
        JLabel info=new JLabel("<html><font color=red size=1> * Details of your booking will be e-mailed to you</font></html>");
        
        Icon imglogo1 = new ImageIcon("Images\\silkair.png");
        Icon imglogo2 = new ImageIcon("Images\\spicejet.png");
        JLabel Limglogo1 = new JLabel("", imglogo1, SwingConstants.LEFT);
        JLabel Limglogo2 = new JLabel("", imglogo2, SwingConstants.LEFT);  
        JLabel Lflightno1=new JLabel();
        flight1=(String) objdisplay.TFlight.getModel().getValueAt(objdisplay.selRow, 1);
        Lflightno1.setText(flight1);
        JLabel Lflightno2=new JLabel();
        flight2=(String) objdisplay.TFlight.getModel().getValueAt(objdisplay.selRow, 6);
        Lflightno2.setText(flight2);
        JLabel Larr1=new JLabel();
        Larr1.setText((String) objdisplay.TFlight.getModel().getValueAt(objdisplay.selRow, 0));
        JLabel Ldept1=new JLabel();
        Ldept1.setText((String) objdisplay.TFlight.getModel().getValueAt(objdisplay.selRow, 2));
        JLabel Larr2=new JLabel();
        Larr2.setText((String) objdisplay.TFlight.getModel().getValueAt(objdisplay.selRow, 7));
        JLabel Ldept2=new JLabel();
        Ldept2.setText((String) objdisplay.TFlight.getModel().getValueAt(objdisplay.selRow, 5));
        
        
        JLabel LDate=new JLabel("<html><B>Date</B></html>");
        JLabel LFlightS1=new JLabel("<html><B></B></html>");
        LFlightS1.setText(objsearch.CBPlace.getSelectedItem().toString());
        JLabel LFlightS2=new JLabel("<html><B></B></html>");
        inter=(String) objdisplay.TFlight.getModel().getValueAt(objdisplay.selRow, 3);
        LFlightS2.setText(inter);
        JLabel LFlightD1=new JLabel("<html><B></B></html>");
        LFlightD1.setText(inter);
        JLabel LFlightD2=new JLabel("<html><B>SINGAPORE</B></html>");
        Icon imgarrow1 = new ImageIcon("Images\\arrowplane.jpg");
        JLabel Limgarrow1 = new JLabel("", imgarrow1, SwingConstants.LEFT);
        JLabel Limgarrow2 = new JLabel("", imgarrow1, SwingConstants.LEFT);
        
        Icon imgtime = new ImageIcon("Images\\time.jpg");
        JLabel LTime=new JLabel("<html><B>Total Time Duration : "+(String) objdisplay.TFlight.getModel().getValueAt(objdisplay.selRow, 8)+"</B></html>",imgtime,SwingConstants.LEFT);
        
        licenseBox = new JCheckBox(" I agree that flight schedule is subject to change under certain conditions.");
        licenseBox.setMnemonic(KeyEvent.VK_C); //
        BBook=new JButton("Book");        
        
        JLabel LDummy=new JLabel("<html><B> </B></html>");   
        JLabel selection=new JLabel("Your selection ");
        
        LLogo.setBounds(0, 0, 700, 50);    
        
        selection.setBounds(50,180,170,50);
         
        Limglogo1.setBounds(50,240,50,50);
        Limglogo2.setBounds(50,340,50,50);
        LFlightS1.setBounds(120,250,300,30);
        LFlightD1.setBounds(520,250,300,30);
        LFlightS2.setBounds(120,350,300,30);
        LFlightD2.setBounds(520,350,250,30);
        Limgarrow1.setBounds(180,220,300,50);
        Limgarrow2.setBounds(180,320,300,50);
        LTime.setBounds(50,420,300,30);        
        TxtName.setBounds(110, 480, 180, 20);
        LName.setBounds(50, 480, 40, 20);
        Txtemail.setBounds(420, 480, 180, 20);
        info.setBounds(370, 520, 250, 20);
        LEmail.setBounds(350, 480, 60, 20);        
        BBook.setBounds(500,570,100,30);
        licenseBox.setBounds(30,570,450,30);
        licenseBox.setBackground(Color.white);
        
        
        Lflightno1.setBounds(50,260,50,50);
        Larr1.setBounds(250,260,250,50);
        Ldept1.setBounds(370,260,250,50);
        Lflightno2.setBounds(50,360,50,50);
        Larr2.setBounds(250,360,250,50);
        Ldept2.setBounds(370,360,250,50);
        
        
        Icon imgone=new ImageIcon("Images\\1.jpg");
        JLabel LOne=new JLabel("", imgone, SwingConstants.LEFT);
        Icon imgThree=new ImageIcon("Images\\three.jpg");
        JLabel LThree=new JLabel("", imgThree, SwingConstants.LEFT);
        Icon imgTwo=new ImageIcon("Images\\2_n.png");
        JLabel LTwo=new JLabel("", imgTwo, SwingConstants.LEFT);
        search=new JLabel("<html><B><font size=\"2\">Search Flight</font></B></html>",imgedit,SwingConstants.LEFT);
        display=new JLabel("<html><B><font size=\"2\">Select Flight</font></B></html>",imgedit,SwingConstants.LEFT);
        JLabel book=new JLabel("<html><B><font size=\"2\">Book Flight</font></B></html>");
        
        LOne.setBounds(50, 100, 50, 50);
        LTwo.setBounds(300, 100, 50, 50);
        LThree.setBounds(550, 75, 70, 100);
        search.setBounds(50, 140, 150, 30);
        display.setBounds(300, 140, 150, 30);
        book.setBounds(530, 140, 150, 30);
        
        Icon imgline=new ImageIcon("Images\\red.jpg");
        
        JLabel Lline1=new JLabel("", imgline, SwingConstants.LEFT);
        JLabel Lline2=new JLabel("", imgline, SwingConstants.LEFT);
        
        Lline1.setBounds(90,110,200,20);
        Lline2.setBounds(340,110,200,20);
        Bframe.add(Lline1);
        Bframe.add(Lline2);
        Bframe.add(LOne);
        Bframe.add(LTwo);
        Bframe.add(LThree);
        Bframe.add(search);
        Bframe.add(display);
        Bframe.add(book);
        Bframe.add(LLogo);
        Bframe.add(TxtName);
        Bframe.add(LName);
        Bframe.add(Txtemail);
        Bframe.add(LEmail);
        Bframe.add(LTime);        
        Bframe.add(BBook);
        Bframe.add(licenseBox);
        Bframe.add(Limglogo1);
        Bframe.add(Limglogo1);
        Bframe.add(Limglogo2);
        Bframe.add(LFlightS1);
        Bframe.add(LFlightS2);
        Bframe.add(LFlightD1);
        Bframe.add(LFlightD2);
        Bframe.add(Limgarrow1);
        Bframe.add(Limgarrow2);
        Bframe.add(LDate);      
        Bframe.add(selection);
        Bframe.add(Lflightno1);
        Bframe.add(Lflightno2);
        Bframe.add(Larr1);
        Bframe.add(Ldept2);
        Bframe.add(Ldept1);
        Bframe.add(info);
        Bframe.add(Larr2);
        Bframe.add(LDummy);
        Bframe.setVisible(true);
        Bframe.setResizable(false);
        Bframe.getContentPane().setBackground(Color.white);
        
        BBook.addActionListener(new BookButton(this));
        search.addMouseListener(new ESMouse(this,true));
        display.addMouseListener(new EDMouse(this,true));         
    }    
}

