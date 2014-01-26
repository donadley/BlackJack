/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**h
 *
 * @author Don Adley Jr
 */
public class BlackJackPanels extends JPanel{    
    private Image image = new Image_Machine("Uploads/Img/board.jpg").getImage();
    
    private BlackJackPanels panel = this;
    private BlackJackGame game;
    
    private JButton start_button = new JButton("Start");
    private JButton hitButton = new JButton("Hit");
    private JButton stayButton = new JButton("Stay");
    private JButton Button1 = new JButton();
    private JButton Button2 = new JButton();
    private JButton Button3 = new JButton();
    private JButton Button4 = new JButton();
    private JButton Button5 = new JButton();
    private JButton Button6 = new JButton();
    private JButton Button7 = new JButton();
    
    private ArrayList<Player> players;    
    private ArrayList<Image> imgDArray = new ArrayList<Image>(11);
    private ArrayList<Image> imgPArray = new ArrayList<Image>(11);

    private int playerScore, dealerScore;
    
    
    public BlackJackPanels(){
                   
        hitButton.setBounds((image.getWidth(null)/2-100), 10, 100, 25);
        stayButton.setBounds((image.getWidth(null)/2), 10, 100, 25);
        start_button.setBounds((image.getWidth(null)/2-50), 10, 100, 25);   
        hitButton.setVisible(false);
        stayButton.setVisible(false);

        setLayout(null);
       
       
        //Setting Up Game
        game = new BlackJackGame();


        //Start Button
        start_button.setVisible(true);
        add(start_button);
        addButtons();  
        
        
        panel.add(hitButton);
        panel.add(stayButton);

        start_button.addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
                try{
                    if(getBet() == 0){
                        System.out.println(getBet());
                        throw new IndexOutOfBoundsException();
                    }else{
                        if(getBet() > 0){
                            System.out.println(getBet());
                            start_button.setVisible(false);
                            game.start(game, panel);

                            removeButtons();
                       
                            hitButton.setVisible(true);
                            stayButton.setVisible(true);
                        }
                        else{
                            throw new IndexOutOfBoundsException();
                        }
                    }
                }catch(IndexOutOfBoundsException ex){
                        System.out.println("Bet has not been placed");
                        JOptionPane.showMessageDialog(panel, "Please place a bet");
                }
            }                

             @Override
             public void mousePressed(MouseEvent e) {
             }

             @Override
             public void mouseReleased(MouseEvent e) {
             }

             @Override
             public void mouseEntered(MouseEvent e) {
             }

             @Override
             public void mouseExited(MouseEvent e) {
             }
         });

         // Hit Button    

         hitButton.addMouseListener(new MouseListener(){

             @Override
             public void mouseClicked(MouseEvent e) {
                  game.hit(1);
             }

             @Override
             public void mousePressed(MouseEvent e) {
             }

             @Override
             public void mouseReleased(MouseEvent e) {
             }

             @Override
             public void mouseEntered(MouseEvent e) {
             }

             @Override
             public void mouseExited(MouseEvent e) {
             }
         });

         //Stay Button

         stayButton.addMouseListener(new MouseListener(){

             @Override
             public void mouseClicked(MouseEvent e) {
                 game.stay(1);
             }

             @Override
             public void mousePressed(MouseEvent e) {
             }

             @Override
             public void mouseReleased(MouseEvent e) {
             }

             @Override
             public void mouseEntered(MouseEvent e) {
             }

             @Override
             public void mouseExited(MouseEvent e) {
             }
         });  

         Button1.addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
                if (game.getPlayers().get(1).setBet(1)){
                    System.out.println("Bet has been set");
                }else{
                    JOptionPane.showMessageDialog(panel, "Please dont over bet!");
                }
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }      
         });

         Button2.addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
               if (game.getPlayers().get(1).setBet(5)){
                }else{
                    JOptionPane.showMessageDialog(panel, "Please dont over bet!");
                }
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }      
         });

         Button3.addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
                if (game.getPlayers().get(1).setBet(10)){
                    
                }else{
                    JOptionPane.showMessageDialog(panel, "Please dont over bet!");
                }
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }      
         });

         Button4.addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
                if (game.getPlayers().get(1).setBet(50)){
                }else{
                    JOptionPane.showMessageDialog(panel, "Please dont over bet!");
                }
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }      
         });

         Button5.addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
                 if (game.getPlayers().get(1).setBet(100)){
                }else{
                    JOptionPane.showMessageDialog(panel, "Please dont over bet!");
                }
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }      
         });

         Button6.addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
                if (game.getPlayers().get(1).setBet(1000)){
                }else{
                    JOptionPane.showMessageDialog(panel, "Please dont over bet!");
                }
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }      
         });
     
}
   
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.drawImage(image, 0, 0, image.getWidth(null), image.getHeight(null), null);
        
        g.setColor(Color.black);
        g.fillRoundRect(image.getWidth(null)-245, image.getHeight(null)-450, 230, 415, 10, 10);

        g.setColor(Color.white);
        g.fillRoundRect(image.getWidth(null)-240, image.getHeight(null)-445, 220, 405, 10, 10);
        
        g.setColor(new Color (01,153, 17));
        g.fillRect(image.getWidth(null)-230, image.getHeight(null)-430, 200, 75);
        
        g.fillRect(image.getWidth(null)-230, image.getHeight(null)-330, 200, 75);
        
        g.fillRect(image.getWidth(null)-230, image.getHeight(null)-230, 200, 75);
        
        g.fillRect(image.getWidth(null)-230, image.getHeight(null)-130, 200, 75);
        
        g.setColor(Color.white);
        g.setFont(new Font("Serif", Font.BOLD, 15));
        g.setColor(Color.black);
        g.drawString("Bet", image.getWidth(null)-145, image.getHeight(null)-410);       
        g.setFont(new Font("Serif", Font.BOLD, 30));
        g.drawString("" + getBet(), image.getWidth(null)-140, image.getHeight(null)-375);
        
        g.setFont(new Font("Serif", Font.BOLD, 15));
        g.setColor(Color.black);
        g.drawString("Credits", image.getWidth(null)-155, image.getHeight(null)-310);       
        g.setFont(new Font("Serif", Font.BOLD, 30));
        g.drawString("" + getCredits(), image.getWidth(null)-140, image.getHeight(null)-275);
        
        g.setFont(new Font("Serif", Font.BOLD, 15));
        g.setColor(Color.black);
        g.drawString("Dealer", image.getWidth(null)-155, image.getHeight(null)-210);       
        g.setFont(new Font("Serif", Font.BOLD, 30));
        g.drawString("" + dealerScore, image.getWidth(null)-140, image.getHeight(null)-175);
        
        g.setFont(new Font("Serif", Font.BOLD, 15));
        g.setColor(Color.black);
        g.drawString("Player", image.getWidth(null)-150, image.getHeight(null)-110);       
        g.setFont(new Font("Serif", Font.BOLD, 30));
        g.drawString("" + playerScore, image.getWidth(null)-140, image.getHeight(null)-75);
        
        g.setColor(new Color (01,153, 17));
        g.fillArc(0, 510, 75, 75, 0, 360);        
        g.fillArc(0, 590, 75, 75, 0, 360);
        g.fillArc(80, 590, 75, 75, 0, 360);
        g.fillArc(0, 670, 75, 75, 0, 360);
        g.fillArc(80, 670, 75, 75, 0, 360);
        g.fillArc(160, 670, 75, 75, 0, 360);
        
        g.setColor(Color.black);
        g.drawString("1", 30, 555);
        g.drawString("5", 30, 635);
        g.drawString("10", 100, 635);
        g.drawString("50", 20, 715);
        g.drawString("100", 95, 715);
        g.drawString("1000", 167, 715);
        
        
       
        
        // Dealer Array
        if (!imgDArray.isEmpty()){
            for (int i = 0; i < imgDArray.size();i++){        
                g.drawImage(imgDArray.get(i), (panel.getWidth()/2 - 100) + imgDArray.get(i).getWidth(null)* (i+1), 50, imgDArray.get(i).getWidth(null), imgDArray.get(i).getHeight(null), null);
            }
        } 
        // Player Array
        if (!imgPArray.isEmpty()){
            for (int i = 0; i < imgPArray.size();i++){  
                g.drawImage(imgPArray.get(i), (panel.getWidth()/2) - 30, 500 + (imgPArray.get(i).getHeight(null)/3) * (i+1), imgPArray.get(i).getWidth(null), imgPArray.get(i).getHeight(null), null);
            }    
        } 
                
    }
    
    public int getCredits(){
        return game.getPlayers().get(1).getCredits();
    }
    
    public int getBet(){
        return game.getPlayers().get(1).getBet();
    }
    
    public void setPlayerScore(int playerScore){
        this.playerScore = playerScore;
        repaint();
    }
    public void setDealerScore(int dealerScore){
        this.dealerScore = dealerScore;
        repaint();
    }
    public void removeButtons(){
        panel.remove(Button1);
        panel.remove(Button2);
        panel.remove(Button3);
        panel.remove(Button4);
        panel.remove(Button5);
        panel.remove(Button6);
        repaint();
    }
    public void drawImageDealer(){
        
        imgDArray.add(game.getImage());
        repaint();
                
    }
    
    public void drawImagePlayer(){
        imgPArray.add(game.getImage());
        repaint();
    }
    
     public void popup(){
         if(game.bankrupt(1)){
            JOptionPane.showMessageDialog(panel, "Game Over, you are out of creidts");
            clearBoard();
            game = new BlackJackGame();
            addStartButton();
            addButtons();
            repaint();
            
         }else{
    Object[] options = {"Yes!",
                    "No"};
            int answer = JOptionPane.showOptionDialog(panel,
                "Would you like to contiue playing?",
                "Play Again",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,     
                options,  
                options[0]);
            switch(answer){
                case 0:
                    clearBoard();
                    addStartButton();
                     try{
                        if(getBet() == 0){
                            System.out.println(getBet());
                            throw new IndexOutOfBoundsException();
                        }else{

                            start_button.setVisible(false);
                            game.continuePlaying();
                            repaint();

                            removeButtons();
                            System.out.println("hit and stay");
                            hitButton.setVisible(true);
                            stayButton.setVisible(true);

                        }
                }catch(IndexOutOfBoundsException ex){
                        System.out.println("Bet has not been placed");
                        JOptionPane.showMessageDialog(panel, "Please place a bet");
                }
                    
                break;
                    
                case 1:
                    clearBoard();
                    game = new BlackJackGame();
                    addStartButton();
                    repaint();
                break;
            }
         }
    }
     
    public void addButtons(){
        Button1.setBounds(0, 510, 75, 75);
        Button1.setOpaque(false);
        Button1.setContentAreaFilled(false);
        Button1.setBorderPainted(false);
        add(Button1);
        Button2.setBounds(0, 590, 75, 75);
        Button2.setOpaque(false);
        Button2.setContentAreaFilled(false);
        Button2.setBorderPainted(false);
        add(Button2);
        Button3.setBounds(80, 590, 75, 75);
        Button3.setOpaque(false);
        Button3.setContentAreaFilled(false);
        Button3.setBorderPainted(false);
        add(Button3);
        Button4.setBounds(0, 670, 75, 75);
        Button4.setOpaque(false);
        Button4.setContentAreaFilled(false);
        Button4.setBorderPainted(false);
        add(Button4);
        Button5.setBounds(80, 670, 75, 75);
        Button5.setOpaque(false);
        Button5.setContentAreaFilled(false);
        Button5.setBorderPainted(false);
        add(Button5);
        Button6.setBounds(160, 670, 75, 75);
        Button6.setOpaque(false);
        Button6.setContentAreaFilled(false);
        Button6.setBorderPainted(false);
        add(Button6);
    }
        
     public void clearBoard(){
         imgDArray = new ArrayList<Image>();
         imgPArray = new ArrayList<Image>();
         playerScore = 0;
         dealerScore = 0;
         repaint();
     }
    public void addStartButton(){
         hitButton.setVisible(false);
         stayButton.setVisible(false);
         start_button.setVisible(true);
         addButtons();
         repaint();
    }
}  
    
    

