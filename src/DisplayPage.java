/**
 *
 * @author AirJ
 */

import java.awt.event.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.*;

public class DisplayPage extends JFrame {
    
    final String[] col ={"Departure","SpiceJet","Arrival","Intermediate","Via","Departure","SilkAir","Arrival" ,"Duration"};
    final String[][] row;
    JFrame frame;
    JTextField TxtFlight,TxtTime;
    JTable TFlight;
    SearchPage objsearch;
    JLabel search,LOne;
    int selRow;
    
    public DisplayPage(SearchPage objsearch) {

        String source=objsearch.CBPlace.getSelectedItem().toString();
        int spiceDay=check(Integer.parseInt(objsearch.CBDated.getSelectedItem().toString()));
        int silkDay = check(Integer.parseInt(objsearch.CBDated.getSelectedItem().toString()));       
        
        CombinedFlight cf = new  CombinedFlight(source,spiceDay,silkDay);
        CombinedFlight filteredFlight[]=new CombinedFlight[cf.flightCount];
        filteredFlight=cf.combine(source,spiceDay,silkDay);
        row=new String[cf.flightCount][9];
        
        int i;
        for(i=0;i<cf.flightCount;i++)
        {
            row[i][0]=filteredFlight[i].getDeptSpice();
            row[i][1]=filteredFlight[i].getSpiceFlightNo();
            row[i][2]=filteredFlight[i].getArrSpice();
            row[i][3]=filteredFlight[i].getIntermediate();
            row[i][4]=filteredFlight[i].getVia();
            row[i][5]=filteredFlight[i].getDeptSilk();
            row[i][6]=filteredFlight[i].getSilkFlightNo();
            row[i][7]=filteredFlight[i].getArrSilk();
            row[i][8]=filteredFlight[i].getDuration();
                        
        }
       
        
        frame=new JFrame("Display");
        frame.setSize(650, 650);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = (screenSize.height - frame.getHeight()) / 2;
        frame.setLocation(x, y);
       
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        this.objsearch=objsearch;
        
        JButton BConfirm=new JButton("Confirm");
        BConfirm.setBounds(460,520,140,40);
        
        JLabel LDummy=new JLabel("<html><B> </B></html>");
        JLabel LFlight1=new JLabel("<html><B>First Flight  </B></html>");
        JLabel LFlight2=new JLabel("<html><B> Second Flight </B></html>");
        TxtFlight=new JTextField();
        TxtTime=new JTextField();
        TxtFlight.setBounds(120,500,100,30);
        TxtTime.setBounds(120,540,100,30);
        LFlight1.setBounds(30,500,120,30);
        LFlight2.setBounds(30,540,120,30);
        TxtFlight.setEditable(false);
        TxtTime.setEditable(false);
        
        Icon img1 = new ImageIcon("Images/index.png");
        JLabel LLogo = new JLabel("<html><i><font face=\"verdana\" size=\"3\" color=\"blue\">The smarter,easier and faster way to book flights.</font></i></html>", img1, SwingConstants.LEFT);
        LLogo.setBounds(0, 0, 700, 50);
     
        
        JLabel LResult=new JLabel("Total no.of available flights : "+cf.flightCount+"");
        LResult.setBounds(30,230,650,30);
        
        TFlight = new JTable(row, col);
        TFlight.getColumnModel().getColumn(0).setPreferredWidth(45);
        TFlight.getColumnModel().getColumn(1).setPreferredWidth(45);
        TFlight.getColumnModel().getColumn(2).setPreferredWidth(45);
        TFlight.getColumnModel().getColumn(5).setPreferredWidth(45);
        TFlight.getColumnModel().getColumn(6).setPreferredWidth(45);
        TFlight.getColumnModel().getColumn(7).setPreferredWidth(45);
        TFlight.getTableHeader().setBackground(Color.decode("#E0FFFF"));
           
        for (int c = 0; c < TFlight.getColumnCount(); c++) {
            Class<?> col_class = TFlight.getColumnClass(c);
            TFlight.setDefaultEditor(col_class, null);
        }
      
        TFlight.setFillsViewportHeight(true);
        
        JScrollPane JSP1 = new JScrollPane(TFlight, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JSP1.setBounds(0, 270,650, 200);
        JSP1.setBackground(Color.white);
        
        JSP1.setVisible(true);
        
        JLabel selection=new JLabel();
        String str1="Flight result for : To SINGAPORE from "+objsearch.CBPlace.getSelectedItem().toString()+ " on " +objsearch.CBDated.getSelectedItem().toString() +" October 2014 for " + objsearch.SlidePerson.getValue()+" pasengers";
        selection.setText(str1);
        selection.setBounds(30,170,570,50);
        
        Icon imgedit=new ImageIcon("Images\\Edit.gif");
        
        Icon imgone=new ImageIcon("Images\\1.jpg");
        LOne=new JLabel("", imgone, SwingConstants.LEFT);
        Icon imgThree=new ImageIcon("Images\\3_nc.png");
        JLabel LThree=new JLabel("", imgThree, SwingConstants.LEFT);
        Icon imgTwo=new ImageIcon("Images\\two.jpg");
        JLabel LTwo=new JLabel("", imgTwo, SwingConstants.LEFT);
        search=new JLabel("<html><B><font size=\"2\">Search Flight</font></B></html>",imgedit,SwingConstants.LEFT);
        JLabel display=new JLabel("<html><B><font size=\"2\">Select Flight</font></B></html>");
        JLabel book=new JLabel("<html><B><font size=\"2\">Book Flight</font></B></html>");
        
        LOne.setBounds(50, 90, 50, 50);
        LTwo.setBounds(300, 75, 70, 90);
        LThree.setBounds(550, 90, 50, 50);
        search.setBounds(50, 140, 150, 30);
        display.setBounds(300, 140, 150, 30);
        book.setBounds(530, 140, 150, 30);
        
       
        
        Icon imgline1=new ImageIcon("Images\\line_blue.png");
        Icon imgline2=new ImageIcon("Images\\red.jpg");
        JLabel Lline1=new JLabel("", imgline2, SwingConstants.LEFT);
        JLabel Lline2=new JLabel("", imgline1, SwingConstants.LEFT);
        Lline1.setBounds(90,100,200,20);
        Lline2.setBounds(350,110,200,20);
        TFlight.setShowVerticalLines(false);
        TFlight.setRowHeight(30);
        frame.add(Lline1);
        frame.add(Lline2);
        frame.add(LOne);
        
        frame.add(LTwo);
        frame.add(LThree);
        frame.add(search);
        frame.add(display);
        frame.add(book);      
        frame.add(JSP1);
        frame.add(TxtFlight);
        frame.add(TxtTime);
        frame.add(LFlight2);
        frame.add(LFlight1);
        frame.add(BConfirm);
        frame.add(LLogo);
        frame.add(selection);
        frame.add(LResult);
        frame.add(LDummy);
        frame.setBackground(Color.white);
        frame.setVisible(true);
         
        TFlight.addMouseListener(new MouseAdapter() {  
            public void mouseClicked(MouseEvent evt) {  
                try {
                    int selRow = TFlight.getSelectedRow();  
                    TxtFlight.setText((String)TFlight.getModel().getValueAt(selRow, 1)); 
                    TxtTime.setText((String)TFlight.getModel().getValueAt(selRow, 6));
                }
                catch(Exception e) {

                }
            }  
        });
    
        BConfirm.addActionListener(new CButton(this));
        search.addMouseListener(new EMouse(this,true));
    }

   
    
    public static int check(int dd) {
        Date date = (new GregorianCalendar(2014, 9, dd)).getTime();
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
