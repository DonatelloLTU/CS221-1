/**
 * Deck class that makes a full deck of cards
 * @author Mikael Hinton
 */
import java.util.*;

public class Deck {

	/**
	 * ArrayList of all 52 cards
	 */
	private static ArrayList<Card> deck = new ArrayList<Card>();
	
	/**
	 * All 52 cards in a deck
	 */
	public Deck()
	{	
		// Clubs
		deck.add(new Card(2, Suit.Clubs, Name.Two));
		deck.add(new Card(3, Suit.Clubs, Name.Three));
		deck.add(new Card(4, Suit.Clubs, Name.Four));
		deck.add(new Card(5, Suit.Clubs, Name.Five));
		deck.add(new Card(6, Suit.Clubs, Name.Six));
		deck.add(new Card(7, Suit.Clubs, Name.Seven));
		deck.add(new Card(8, Suit.Clubs, Name.Eight));
		deck.add(new Card(9, Suit.Clubs, Name.Nine));
		deck.add(new Card(10, Suit.Clubs, Name.Ten));
		deck.add(new Card(11, Suit.Clubs, Name.Jack));
		deck.add(new Card(12, Suit.Clubs, Name.Queen));
		deck.add(new Card(13, Suit.Clubs, Name.King));
		deck.add(new Card(14, Suit.Clubs, Name.Ace));
		// Diamonds
		deck.add(new Card(2, Suit.Diamonds, Name.Two));
		deck.add(new Card(3, Suit.Diamonds, Name.Three));
		deck.add(new Card(4, Suit.Diamonds, Name.Four));
		deck.add(new Card(5, Suit.Diamonds, Name.Five));
		deck.add(new Card(6, Suit.Diamonds, Name.Six));
		deck.add(new Card(7, Suit.Diamonds, Name.Seven));
		deck.add(new Card(8, Suit.Diamonds, Name.Eight));
		deck.add(new Card(9, Suit.Diamonds, Name.Nine));
		deck.add(new Card(10, Suit.Diamonds, Name.Ten));
		deck.add(new Card(11, Suit.Diamonds, Name.Jack));
		deck.add(new Card(12, Suit.Diamonds, Name.Queen));
		deck.add(new Card(13, Suit.Diamonds, Name.King));
		deck.add(new Card(14, Suit.Diamonds, Name.Ace));
		// Hearts
		deck.add(new Card(2, Suit.Hearts, Name.Two));
		deck.add(new Card(3, Suit.Hearts, Name.Three));
		deck.add(new Card(4, Suit.Hearts, Name.Four));
		deck.add(new Card(5, Suit.Hearts, Name.Five));
		deck.add(new Card(6, Suit.Hearts, Name.Six));
		deck.add(new Card(7, Suit.Hearts, Name.Seven));
		deck.add(new Card(8, Suit.Hearts, Name.Eight));
		deck.add(new Card(9, Suit.Hearts, Name.Nine));
		deck.add(new Card(10, Suit.Hearts, Name.Ten));
		deck.add(new Card(11, Suit.Hearts, Name.Jack));
		deck.add(new Card(12, Suit.Hearts, Name.Queen));
		deck.add(new Card(13, Suit.Hearts, Name.King));
		deck.add(new Card(14, Suit.Hearts, Name.Ace));
		// Spades
		deck.add(new Card(2, Suit.Spades, Name.Two));
		deck.add(new Card(3, Suit.Spades, Name.Three));
		deck.add(new Card(4, Suit.Spades, Name.Four));
		deck.add(new Card(5, Suit.Spades, Name.Five));
		deck.add(new Card(6, Suit.Spades, Name.Six));
		deck.add(new Card(7, Suit.Spades, Name.Seven));
		deck.add(new Card(8, Suit.Spades, Name.Eight));
		deck.add(new Card(9, Suit.Spades, Name.Nine));
		deck.add(new Card(10, Suit.Spades, Name.Ten));
		deck.add(new Card(11, Suit.Spades, Name.Jack));
		deck.add(new Card(12, Suit.Spades, Name.Queen));
		deck.add(new Card(13, Suit.Spades, Name.King));
		deck.add(new Card(14, Suit.Spades, Name.Ace));	
		
	shuffle();
	shuffle();
	shuffle();
	shuffle();
	}//End of deck
	
	/**
	 * Shuffles the deck of cards
	 */
	protected void shuffle()
	{
		Collections.shuffle(deck);
	}// End of shuffle

	/**
	 * Deals the cards to the players
	 * @return
	 */
	protected Card deal()
	{
		Card temp = deck.remove(0);
		return temp;
	}// end of deal
	
	/**
	 * Represents the card. It should output the name and 
	 * suit of the card.
	 */
	public String toString()
	{
		return "" + deck;
	}// end of toString
}//EOF
