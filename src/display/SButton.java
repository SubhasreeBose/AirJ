package display;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class SButton implements ActionListener {
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
            obj.pbar.setBounds(30,590,570,20);
            obj.pbar.setStringPainted(true);
            obj.timer.start();
        }
        else {
            JOptionPane.showMessageDialog(null, " You need to accept to proceed further!");
        }
    }
}