/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author Don Adley Jr
 */
public class Card {
    // Constants
        //Rank
        public static final int ACE = 1;
	public static final int JACK = 11;
	public static final int QUEEN = 12;
	public static final int KING = 13;
        // Suit
	public static final int SPADES = 0;
	public static final int HEARTS = 1;
	public static final int DIAMONDS = 2;
	public static final int CLUBS = 3;
	
	
	
	// Data Members
	private int rank;
	private int suit;
	
	// Constructor
	public Card(int rank, int suit) {
		this.rank = rank;
		this.suit = suit;
	}
	
	// Other methods
	
	public int getRank(){
		return rank;
	}
	
	public int getSuit(){
		return suit;
	}
	
        @Override
	public String toString() {
		return "" + "-A23456789TJQK".charAt(rank) + "SHDC".charAt(suit);
	}
}
