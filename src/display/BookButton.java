package display;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class BookButton implements ActionListener {
    BookingPage obj;
    
    BookButton(BookingPage obj) {
        this.obj=obj;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(obj.TxtName.getText().equals(""))
           JOptionPane.showMessageDialog(null,"Sorry! Please, fill up the fields.");
        else if(obj.Txtemail.getText().contains("@")==false)
            JOptionPane.showMessageDialog(null,"Please,Enter a valid Email id.");
        else if(!obj.licenseBox.isSelected())
            JOptionPane.showMessageDialog(null, " You need to accept to proceed further!");
        
        else { 
            int iChoice = JOptionPane.showConfirmDialog(null," Continue booking?");
            if(iChoice == JOptionPane.YES_OPTION) {                
                new PrintTicket(obj);
                //obj.Bframe.dispose();
            }
            else {
            }
        }
    }
}