/**
 * Card class to initialize a card for the deck
 * @author Mikael Hinton
 *
 */
public class Card {
	
	private int value; 			// Value 2-14
	private Enum<Name> name;	// Rank enum
	private Enum<Suit> suit;	// Suit enum
	private boolean visible = true; // Used to show or hide the first card dealt
	
	/**
	 * Constructor
	 */
	public Card(int newValue, Suit newSuit, Name newName)
	{
		value = newValue;
		name = newName; 
		suit = newSuit;
	}// End of Contructor
	
	/**
	 * Changes the card to hide by boolean
	 */
	protected void hide()
	{
		visible = false;
	}// End of hide
	
	/**
	 * Changes the card to show by boolean
	 */
	protected void show()
	{
		visible = true;
	}// End of show
	
	/**
	 * Returns the value of the card
	 * @return
	 */
	protected int getCard()
	{
		return value;
	}// End of getCard
	
	/**
	 * To string method
	 */
	public String toString()
	{
		if(visible == false)
		{
			return "Bicycle";
		}
		else
		{
		return name + " of " + suit;
		}
	}// End of toString
}//EOF

