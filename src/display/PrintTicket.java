package display;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PrintTicket extends JFrame {
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
               Pframe.dispose();               
           }           
        });
    }
}
