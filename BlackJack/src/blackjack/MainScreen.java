/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Don Adley Jr
 */
public class MainScreen extends JFrame {
    public MainScreen(String title)
    {
    super(title);
    
//    ImageIcon image = new ImageIcon(getClass().getResource("Uploads/Img/board.jpg"));
    
    Image_Machine image = new Image_Machine("Uploads/Img/board.jpg");
    Dimension dim = new Dimension(image.getDimension());
    getContentPane().setPreferredSize(dim);
    pack();
    setResizable(false);

  }
}
