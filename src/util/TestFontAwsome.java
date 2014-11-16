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

public class TestFontAwsome {

    public static void main(String[] args) {
        new TestFontAwsome();
    }

    public TestFontAwsome() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }
           
                FontAwesome font=new FontAwesome();
				

				JLabel label = new JLabel("\uf004");
				label.setFont(font.lg);
				label.setForeground(Color.BLACK);

				JFrame frame = new JFrame("Testing");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLayout(new GridBagLayout());
				frame.add(label);
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
            }
        });
    }

}