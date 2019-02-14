/**
 * Player class that gets the name of the player and deals with the players cards
 * @author Mikael Hinton
 */
import java.util.*;

public class Player {	

	private String name; // String that holds players name
	
	private ArrayList<Card> hand = new ArrayList<Card>();	// The players hand (Half of the deck)
	private Deck deck = new Deck();	// Deck of cards shuffled
	
	
	/**
	 * Default Constructor
	 */
	public Player() 
	{
		name = "Unknown";
	}// End of Constructor
	
	/**
	 * Constructor
	 * @param newName
	 */
	public Player(String newName)
	{
		name = newName;
	}// End of Player
	
	/**
	 * Getter for name
	 * @return
	 */
	protected String getName()
	{
		return name;
	}// End of getName
	
	/**
	 * Returns the size of the players deck
	 * @return
	 */
	protected int getDeckSize()
	{
		return hand.size();
	}// End of getDeckSize
	
	/**
	 * Gets the card
	 * @param i
	 * @return
	 */
	protected Card getCard(int i)
	{
		return hand.get(i);
	}// End of getCard
	
	/**
	 * Adds a card to the deck
	 * @param i
	 */
	protected void addCardToDeck(Card cardToDeck)
	{
		hand.add(cardToDeck);
	}// End of addCardToDeck
	
	/**
	 * Adds cards to deck
	 * @param add
	 */
	protected void addToDeck(ArrayList<Card> add)
	{
		hand.addAll(add);  
	}// End of addToDeck
	
	/**
	 * Removes the cards from the deck
	 * @param remove
	 */
	protected void removeFromDeck(ArrayList<Card> remove)
	{
		hand.removeAll(remove);
	}// End of removefromDeck
	
	/**
	 * Shows deck
	 */ 
	protected void showDeck()
	{
		for(Card card : hand)
		{
			System.out.println(card);
		}
	}// End of showDeck
	
	/**
	 * Removes a card from the deck
	 * @param takeCard
	 */
	protected void takeCardfromDeck(Card takeCard)
	{
		hand.remove(takeCard);
	}// End of takeCardFromDeck
	
	/**
	 * Adds the cards to the player
	 * @param player
	 */
	protected void addToPlayer(Player player)
	{
		Card card = deck.deal();
		player.addCardToDeck(card);
	}// End of addToPlayer
	
	/**
	 * toString method
	 */
	public String toString()
	{
		return name;
	}// End of toString
}//EOF

	