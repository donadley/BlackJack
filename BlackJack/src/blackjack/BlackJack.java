/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.awt.BorderLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

/**
 *
 * @author Don Adley Jr
 */
public class BlackJack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {      
        
        JFrame frame = new MainScreen("Blackjack Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new BlackJackPanels();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}


// Problems 

//Instant blackjack adds hit and stay buttons
//doesn't implement split