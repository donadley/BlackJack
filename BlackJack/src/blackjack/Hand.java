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
public class Hand {
    
    private ArrayList<Card> CardArray = new ArrayList(11);
    private int High_Value = 0;
    private int Low_Value = 0;
    private boolean ace = false;
    private boolean bust = false;
    private boolean blackjack = false;
    private int value = 0;
    
       
    private void count(Card card){
        if(card.getRank() == 1){
            ace = true;
        }
        if(card.getRank() > 10){
            High_Value += 10;
            Low_Value += 10;
        }else{  
            High_Value += card.getRank();
            Low_Value += card.getRank();
        }
    }
    
    public void blackjackt(){
        blackjack = true;
    }
    
    private void ifBust(int value){
        if(value > 21)
            bust = true;
        }
    
    private void Blackjack(int value){
        if(value == 21 || value == 21)
            blackjack = true;
        }
    
    public void addCard(Card card){
        CardArray.add(card); 
        count(card);
        ifBust(value);
        Blackjack(value);
        }
    
    public int getHighValue(){
        return (High_Value + 10);
    }
    
    public int getLowValue(){
        return Low_Value;
    }
    
    public boolean ifAce(){
        return ace;
    }
    
    public void clearHand(){
        CardArray.clear();
    }
            
   public int getSize(){
       return CardArray.size();
   }
    
    public ArrayList<Card> showHand(){
        return CardArray;
    }
       
    public boolean blackjack(){
        return blackjack;
    }
    
    public boolean bust(){
        return bust;
    }
    
    public void setValue(int value){
        this.value = value;
        ifBust(value);
//        Blackjack(value);
    }
    
    public int getValue(){
        return value;
    }
}