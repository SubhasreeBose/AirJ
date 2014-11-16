package display;
import display.*;
import data.*;
import persistence.*;
import util.*;
import java.awt.event.*;

import javax.swing.*;

import data.CombinedFlight;

class CButton implements ActionListener
{
    DisplayPage obj;
    
    CButton(DisplayPage obj) {
        this.obj=obj;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        CombinedFlight cf=null;
        if(obj.TxtFlight.getText().equals("")) {
            JOptionPane.showMessageDialog(null,"Sorry! Please, select the field.");
        }
        else { 
            int iChoice = JOptionPane.showConfirmDialog(null,"You have selected flights:"
                            + obj.TxtFlight.getText() + " and " + obj.TxtTime.getText()
                            + ".\n Continue?");
            
            if(iChoice == JOptionPane.YES_OPTION) {
                DisplayManager dm=new DisplayManager(obj,obj.objsearch);
                dm.displayBookingPage(cf);
                //new BookingPage(obj,obj.objsearch);
                obj.frame.dispose();
            }
            else {
            }
        }          
    }     
}