/**
 *
 * @author AirJ
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.Timer;
import javax.swing.plaf.ColorUIResource;

class SButton implements ActionListener {
    SearchPage obj;
    
    SButton(SearchPage obj) {
        this.obj=obj;
    }
    
    public void updateBar(int percent) {
        obj.pbar.setValue(percent);
        obj.pbar.setStringPainted(true);
        try {
            //Thread.sleep(50);
        }
        catch(Exception error) {
           
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(obj.licenseBox.isSelected()) {
            obj.BSearch.setEnabled(false);
            obj.pbar.setValue(0);
            obj.pbar.setBounds(30,570,570,20);
            obj.pbar.setStringPainted(true);
            obj.timer.start();
        }
        else {
            JOptionPane.showMessageDialog(null, " You need to accept to proceed further!");
        }
    }
}

public class SearchPage extends JFrame{
    
    static final int max=10;
    static final int min=1,initial=5;
    static final int MY_MINIMUM = 0;
    final static int interval = 50;
    static final int MY_MAXIMUM = 100;
    int i;

    JPanel Psearch=new JPanel(null);
    String[] places = {"MUMBAI", "DELHI", "PUNE"};
    String[] number={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25"};
    JProgressBar pbar;
    
    JButton BSearch;
    JFrame frame;
    Timer timer;
    SearchPage objsearch;
    JComboBox CBPlace,CBDated;
    JSlider SlidePerson;
    JCheckBox licenseBox;
   
    public SearchPage()
    {
        
        //ImageIcon img = new ImageIcon("Images/images.jpg");
        //frame.setIconImage(img.getImage());
        String []month = {"October"};
        String []year = {"2014"};
        
        frame=new JFrame("Search");
        frame.setSize(650, 650);
        //frame.setIconImage(img.getImage());
   
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = (screenSize.height - frame.getHeight()) / 2;
        frame.setLocation(x, y);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       
      
        Icon img1 = new ImageIcon("Images\\index.png");
        JLabel LLogo = new JLabel("<html><i><font face=\"verdana\" size=\"3\" color=\"blue\">The smarter, easier and faster way to fly.</font></i></html>", img1, SwingConstants.LEFT);
        LLogo.setBounds(0, 0, 700, 50);
        LLogo.setVisible(true);
        
        JLabel LHeading=new JLabel("<html><font face=\"Castellar\" size=\"4\" color=\"#B20000\">Fly anywhere with us. Book flights in 3 simple steps.</font></html>");        
        LHeading.setBounds(50, 80, 600, 50);
         
        JPanel fillpane=new JPanel();
    
        JLabel LTo=new JLabel("<html><B><font size=\"4\" >To</font></B></html>");
        JLabel LFrom=new JLabel("<html><B><font size=\"4\">From</font></B></html>");
        Icon imgarrow = new ImageIcon("Images\\arrow.png");   
        JLabel Larrow=new JLabel("",imgarrow,SwingConstants.LEFT);
        JLabel LPlace=new JLabel("<html>SINGAPORE</html>");
        CBPlace=new JComboBox(places);
        
        LTo.setBounds(410, 220, 40, 30);
        LFrom.setBounds(150, 220, 50, 30);
        LPlace.setBounds(410, 260, 170, 20);
        CBPlace.setBounds(150, 260, 100, 20);
        Larrow.setBounds(280, 212, 150, 50); 
       
        
        JLabel LDate=new JLabel("<html><B><font size=\"4\">Departs on</font></B></html>");
        Icon imgdate = new ImageIcon("Images\\date.png");
        JLabel Limgdate = new JLabel("", imgdate, SwingConstants.LEFT);
        
         
        
        CBDated=new JComboBox(number);
        JComboBox CBDatem=new JComboBox(month);
        JComboBox CBDatey=new JComboBox(year);
        
        LDate.setBounds(125, 315, 100, 20);
        Limgdate.setBounds(88,310,30,30);
        CBDated.setBounds(53,360,40,20);
        CBDatem.setBounds(103,360,80,20);
        CBDatey.setBounds(193,360,60,20);  
        
    
        Icon imgpassenger = new ImageIcon("Images\\passenger.png");
        JLabel Limgpassenger = new JLabel("", imgpassenger, SwingConstants.LEFT);
        JLabel LPerson=new JLabel("<html><B><font size=\"4\">No.of passengers</font></B></html>");
        SlidePerson=new JSlider(JSlider.HORIZONTAL,min,max,initial);
        SlidePerson.setMajorTickSpacing(1);
        SlidePerson.setMinorTickSpacing(1);
        SlidePerson.setPaintTicks(true);
        SlidePerson.setPaintLabels(true);
        SlidePerson.setBackground(Color.white);
        
        LPerson.setBounds(450, 310, 130, 30);//berie jachhe to lekata baire
        SlidePerson.setBounds(395, 350, 185, 50);
        Limgpassenger.setBounds(400, 295, 50, 50);  
        
        licenseBox = new JCheckBox("Yes, I agree to the fact that all passengers are between 1 and 70 years of age.");
        licenseBox.setMnemonic(KeyEvent.VK_C);
        licenseBox.setBounds(49, 420, 470, 30);  
        licenseBox.setBackground(Color.white);
          
        fillpane.add(LFrom);
        fillpane.add(LTo);
        fillpane.add(Larrow);
        fillpane.add(LPlace);
        fillpane.add(CBPlace);
        fillpane.add(LDate);
        fillpane.add(CBDated);
        fillpane.add(LPerson);
        fillpane.add(SlidePerson);
        fillpane.add(licenseBox);
        fillpane.setBackground(Color.white);
        
        fillpane.setBounds(20,220,570,180);  
        
        
        final JLabel Lpbar=new JLabel("<html>Getting flight details and availability.....</html>");
        pbar=new JProgressBar();
        pbar.setMinimum(MY_MINIMUM);
        pbar.setMaximum(MY_MAXIMUM);        
        pbar.setForeground(Color.decode("#66A3FF"));
        Lpbar.setBounds(212,520,800,30);
        Lpbar.setVisible(false);
        
        
        JLabel LDummy=new JLabel("<html><B> </B></html>");
        
        BSearch=new JButton("Find Flights");  
        BSearch.setBounds(230,480,180,30);        
              
       
        
        Icon imgone=new ImageIcon("Images\\one.jpg");
        JLabel LOne=new JLabel("", imgone, SwingConstants.LEFT);
        Icon imgline=new ImageIcon("Images\\line_blue.png");
        JLabel Lline1=new JLabel("", imgline, SwingConstants.LEFT);
        JLabel Lline2=new JLabel("", imgline, SwingConstants.LEFT);
        Icon imgThree=new ImageIcon("Images\\3_nc.png");
        JLabel LThree=new JLabel("", imgThree, SwingConstants.LEFT);
        Icon imgTwo=new ImageIcon("Images\\2_nc.png");
        JLabel LTwo=new JLabel("", imgTwo, SwingConstants.LEFT);
        JLabel search=new JLabel("<html><B><font size=\"2\">Search Flight</font></B></html>");
        JLabel display=new JLabel("<html><B><font size=\"2\">Select Flight</font></B></html>");
        JLabel book=new JLabel("<html><B><font size=\"2\">Book Flight</font></B></html>");
        
        LOne.setBounds(40, 105, 70, 100);
        LTwo.setBounds(300, 130, 50, 50);
        LThree.setBounds(550, 130, 50, 50);
        search.setBounds(50, 180, 150, 30);
        display.setBounds(300, 180, 150, 30);
        book.setBounds(530, 180, 150, 30);
        Lline1.setBounds(90,150,200,20);
        Lline2.setBounds(340,150,200,20);
        
        
        frame.add(LOne);
        frame.add(LTwo);
        frame.add(LThree);
        frame.add(Lline1);
        frame.add(Lline2);
        frame.add(search);
        frame.add(display);
        frame.add(book);
        frame.add(LLogo);
        frame.add(LHeading);        
        frame.add(LTo);
        frame.add(Larrow);
        frame.add(LFrom);
        frame.add(LPlace);
        frame.add(CBPlace);              
        frame.add(LDate);        
        frame.add(CBDated);
        frame.add(CBDatem);
        frame.add(CBDatey);
        frame.add(LPerson);
        frame.add(SlidePerson);
        frame.add(Limgpassenger);
        frame.add(Limgdate);
        frame.add(fillpane);        
        frame.add(licenseBox);        
        frame.add(BSearch);        
        frame.add(pbar);
        frame.add(Lpbar);        
        frame.add(LDummy);
       
        frame.getContentPane().setBackground(Color.white);
        frame.setResizable(false);
        
        frame.setVisible(true);
        BSearch.addActionListener(new SButton(this));
        
        objsearch=this;
        
        timer = new Timer(interval, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                i++;
                Lpbar.setVisible(true);
                pbar.setValue(i);
                if (i == 100){
                    Toolkit.getDefaultToolkit().beep();
                    timer.stop();
                    BSearch.setEnabled(true);
                    pbar.setValue(0);
                    pbar.setBounds(0,0,0,0);
                    Lpbar.setVisible(false);
                    i=0;
                    DisplayManager dm=new DisplayManager(objsearch);
                    CombinedFlight cf=null;
                    dm.displayDisplayPage(cf);
                    //new DisplayPage(objsearch);            
                    frame.dispose();            
                }               
            }
        });       
    }
        
}