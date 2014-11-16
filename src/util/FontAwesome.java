package util;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class FontAwesome {
	public Font lg;
	public Font sm,m,med;
	
	public FontAwesome(){
		
		try (InputStream is = TestFontAwsome.class.getResourceAsStream("fontawesome-webfont.ttf")) {
        	lg = Font.createFont(Font.TRUETYPE_FONT, is);
            lg = lg.deriveFont(Font.PLAIN, 48f);
            med=lg.deriveFont(Font.PLAIN, 34f);
            sm = lg.deriveFont(Font.PLAIN, 24f);
            m= lg.deriveFont(Font.PLAIN, 12f);
            
        } catch (IOException | FontFormatException exp) {
            exp.printStackTrace();
        }
	}
	
}
