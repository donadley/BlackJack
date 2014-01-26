/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JOptionPane;



/**
 *
 * @author Don Adley Jr
 */
public class BlackJackGame {
    private int numberofplayers = 1;
    private ArrayList<Player> players;
    private Deck deck;
   
    private BlackJackPanels panel;
    private Card card;
    private int numberOfHits = 0;
    private BlackJackGame game;
    private int bet;
    // if first time playint
    private boolean auto;
    
    private Image pic;
    
    public BlackJackGame(){
        players = new ArrayList<Player>(2);
            for(int i = 0; i < 2; i++){
                 Player player = new Player();
                 players.add(i, player);
            }
    }

    public void start(BlackJackGame game, BlackJackPanels panel) {
        
        this.game = game;
        this.panel = panel;
        
        game.players.get(1).deductCredits(game.players.get(1).getBet());
        
         // Make deck.size()*num for shoot
        deck = new Deck();
        deck.shuffle();
        
//      Delete the Cards in the Players Hands
        players.get(0).newHand();
        players.get(1).newHand();
             
        
        newGameSetUp();                            
    }
    
    public void newGameSetUp(){

//        ArrayList array = new ArrayList(deck.size());
//        array.add(deck);
        
//        Dealer is Player 0
           
            players.get(0).addCard(deck.deal());        
            card = players.get(0).showCards().get(0);
            
            // Image of Card
            Image_Machine imgD = new Image_Machine("Uploads/Img/Cards/"+card+".png");
            Image image = imgD.getImage();
            setImage(image);
            panel.drawImageDealer();
                    
            System.out.println("Dealer Card: " + card);
            
//        2 Cards to Player            
            for(int p = 0; p < 2; p++){  
                players.get(1).addCard(deck.deal());
                card = players.get(1).getHand().showHand().get(players.get(1).getHand().getSize()-1);
                System.out.println("Player 1 " + card);
                
                //Players Cards
                Image_Machine imgP = new Image_Machine("Uploads/Img/Cards/"+card+".png");
                Image imageP = imgP.getImage();
                game.setImage(imageP);
                panel.drawImagePlayer();
            }
          
        players.get(1).getHand().setValue(loworhigh(1));
        panel.setPlayerScore(players.get(1).getHand().getValue());
            
            
        // Chip Set-up       
        players.get(1).deductCredits(bet);
         

        // Add Dealer Score to JPanel
        players.get(0).getHand().setValue(0);
        players.get(0).getHand().setValue(loworhigh(0));
        panel.setDealerScore(players.get(0).getHand().getValue());

        // Instant Blackjack            
        if(players.get(1).getHand().getValue() == 21){
           players.get(1).getHand().blackjackt();
           stay(1);
        }
    }
    
    public void continuePlaying(){
        players.get(0).newHand();
        players.get(1).newHand();
        game.players.get(1).setBet(0);
        newGameSetUp();
    }
    
    public boolean bankrupt(int player){
          return (players.get(player).getCredits() == 0);
    }
    
    public void hit(int player){
        players.get(player).addCard(deck.deal());
        card = players.get(player).showCards().get(players.get(player).getHand().getSize()-1);
        
        Image_Machine imgD = new Image_Machine("Uploads/Img/Cards/"+card+".png");
        Image image = imgD.getImage();
        numberOfHits++;
        
//      Cards for hits
        setImage(image);
        panel.drawImagePlayer();

//        panel.getGraphics().drawImage(image,(panel.getWidth()/2-30),(500 + ((image.getHeight(null)/3))  + (numberOfHits+1)* image.getHeight(null)/3), image.getWidth(null), image.getHeight(null), null);
        
        System.out.println("Player " + player + ": " + card);
        System.out.println("Player "+ player + " High Value: " + players.get(player).getHand().getHighValue());
        System.out.println("Player "+ player + " Low Value: " + players.get(player).getHand().getLowValue());
        System.out.println("Value Pick: " + loworhigh(player));
        
        players.get(player).getHand().setValue(loworhigh(player));
        panel.setPlayerScore(players.get(1).getHand().getValue());

        if(players.get(player).getHand().getValue()==21){
            panel.setPlayerScore(21);
            players.get(1).getHand().blackjackt();
            stay(player);
        }
        if(players.get(player).getHand().bust()){
            panel.popup();
        }
        
    }
    
    public void stay(int player){
//        Dealing for the Dealer
        int i = 1;
        while(!players.get(0).getHand().bust() && players.get(0).getHand().getValue() < 17){
            
            players.get(0).getHand().addCard(deck.deal());
            
            card = players.get(0).showCards().get(i);
            Image_Machine imgD = new Image_Machine("Uploads/Img/Cards/"+card+".png");
            Image image = imgD.getImage();
            System.out.println(i);
            setImage(image);
            panel.drawImageDealer();

            System.out.println("Dealer Card: " + card);
            System.out.println("Dealer High Value: " + players.get(0).getHand().getHighValue());
            System.out.println("Dealer Low Value: " + players.get(0).getHand().getLowValue());
            System.out.println("Value: " + loworhigh(0));
            players.get(0).getHand().setValue(loworhigh(0));
            System.out.println("Bust?: " + players.get(0).getHand().bust());
            System.out.println("Value: " + players.get(0).getHand().getValue() + " more then 17 " + players.get(0).getHand().getValue());
            System.out.println("Draw Finished");
            System.out.println("Dealer Score " + players.get(0).getHand().getValue());
            panel.setDealerScore(players.get(0).getHand().getValue());

            i++;
            }
        
        checkDealer(player);
        
    }
    
    public void checkDealer(int player){
        if(players.get(player).getHand().getValue() > players.get(0).getHand().getValue() && !players.get(0).getHand().blackjack() && players.get(player).getHand().blackjack()){
            System.out.println("Player: " + player + " Wins with Blackjack");
            JOptionPane.showMessageDialog(panel, "Blackjack!");
            players.get(1).addCredits((int)(players.get(1).getBet()*2.5));
            game.players.get(1).resetBet();
            panel.repaint();
            panel.popup();
        }else if(players.get(player).getHand().getValue() > players.get(0).getHand().getValue() && !players.get(player).getHand().bust()){
            System.out.println("Player: " + player + " Wins");
            JOptionPane.showMessageDialog(panel, "Congrats, you won!");
            players.get(1).addCredits(players.get(1).getBet()*2);
            game.players.get(1).resetBet();
            panel.repaint();
            panel.popup(); 
        }else if(players.get(player).getHand().getValue() < players.get(0).getHand().getValue() && players.get(0).getHand().bust()){
            System.out.println("Player: " + player + " Wins");
            JOptionPane.showMessageDialog(panel, "Congrats, you won!");
            players.get(1).addCredits(players.get(1).getBet()*2);
            game.players.get(1).resetBet();
            panel.repaint();
            panel.popup();
        }else if(players.get(player).getHand().getValue() == players.get(0).getHand().getValue() && !players.get(0).getHand().bust() && !players.get(player).getHand().bust()){
            System.out.println("Player: " + player + " Push");
            JOptionPane.showMessageDialog(panel, "You tied");
            players.get(1).addCredits(players.get(1).getBet());
            game.players.get(1).resetBet();
            panel.repaint();
            panel.popup();         
        }else{
            System.out.println("Player: " + player + " Loses");
            JOptionPane.showMessageDialog(panel, "Luck was not on your side");
            game.players.get(1).resetBet();
            panel.repaint();
            panel.popup();            
        }
    }
    public int loworhigh(int player){
        if(players.get(player).getHand().ifAce() && players.get(player).getHand().getHighValue() <= 21){
            return players.get(player).getHand().getHighValue();
        }else{
            return players.get(player).getHand().getLowValue();
        }     
    }
    
    
   
    public void musicPlayer(){
            
    }
    
    public ArrayList<Player> getPlayers(){
        return players;
    }
    
    public Image getImage(){
        return pic;
    }
    
    public void setImage(Image pic){
        this.pic = pic;
    }
    

}
