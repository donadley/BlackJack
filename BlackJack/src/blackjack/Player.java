/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.ArrayList;

/**
 *
 * @author Don Adley Jr
 */
public class Player {
    
    private int credits = 100;
    private Hand hand;
    private int bet = 0;
    
    public Player(){
       hand = new Hand();
    }
    
    public void newHand(){
        this.hand = new Hand();
    }
    
    public void resetBet(){
        this.bet = 0;
    }
    
    public int getBet(){
        return bet;
    }
    
    public boolean setBet(int bet){
        if (credits >= (bet + this.bet)){
                 this.bet += bet;
                 return true;
        }else{
            System.out.println("Dont over bet!");
            return false;
        }
    }
 
    public void addCard(Card card){
        hand.addCard(card);
    }
    
    public void addCredits(int credits){
        this.credits += credits;
    }
    
    public void deductCredits(int credits){
        this.credits -= credits; 
    }
    
    public int getCredits(){
        return credits;
    }
    public void setCredits(int credits){
        this.credits = credits;
    }
    public ArrayList<Card> showCards(){
       return hand.showHand();
    }
    
    public Hand getHand(){
        return hand;
    }
    
    public void clearHand(){
        hand.clearHand();
    }
}
