/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Don Adley Jr
 */
public class Deck {
    // Data members
	private ArrayList<Card> cards;
		
	
	private void addCardtoDeck(){
            cards = new ArrayList<Card>();
                    for (int suit = Card.SPADES; suit <= Card.CLUBS; suit++) {
                            for (int rank = Card.ACE; rank <= Card.KING; rank++) {
                                    cards.add(new Card(rank, suit));                                    
                            }
                    }
        }
       
	// Constructor
	public Deck() {
              addCardtoDeck();  
	}
                
	
	// Other methods
	public boolean isEmpty() {
		return cards.isEmpty();
	}

	public int size() {
		return cards.size();
	}
	
	public Card deal() {
                Card card = cards.get(cards.size()-1);
                cards.remove(cards.size()-1);
		return card;
                
	}
	public void shuffle() {
            Collections.shuffle(cards);
	}
}
