package util;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridBagLayout;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
public class FontAwesome {
	Font lg;
	Font sm;
	
	public FontAwesome(){
		
		try (InputStream is = TestFontAwsome.class.getResourceAsStream("fontawesome-webfont.ttf")) {
        	lg = Font.createFont(Font.TRUETYPE_FONT, is);
            lg = lg.deriveFont(Font.PLAIN, 48f);

            sm = lg.deriveFont(Font.PLAIN, 24f);
            
        } catch (IOException | FontFormatException exp) {
            exp.printStackTrace();
        }
	}
	
}
