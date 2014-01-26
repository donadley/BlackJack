/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Don Adley Jr
 */
public class Image_Machine {
     
    private ImageIcon image = null;
    private Dimension dim = null;
    
    public Image_Machine(String src){
        //    http://www.oddedge.com/bg_bj.jpg
        this.image = new ImageIcon(getClass().getResource(src));
        this.dim = new Dimension(image.getIconWidth(),image.getIconHeight());
    }
    public Dimension getDimension(){
        return dim;
    }
    public Image getImage(){
        return image.getImage();
    }
}
