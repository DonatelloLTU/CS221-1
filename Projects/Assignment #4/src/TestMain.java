/**
 * Testing all of the methods in the war game
 * @author Mikael Hinton
 */
import java.util.ArrayList;

/**
 * Main method
 *
 */
public class TestMain {

	public static void main(String[] args) {
		
		System.out.println("\tTesting for War Game");
		System.out.println("\t____________________\n");
		testingCard();
		testingDeck();
		testingPlayer();
		testingTable();
		
	}//EOM
	
	private static void testingTable()
	{
		System.out.println("\n\tTesting Table class\n");
		Player p1 = new Player("BOB");
		Player p2 = new Player("TIM");
		Table table = new Table(p1, p2);
		System.out.println("*Players at the table*");
		System.out.println(table);
		
		System.out.println("\n*Playing the game*");
		table.play();
	}
	
	private static void testingCard()
	{
		System.out.println("\tTesting Card Class\n");
		Card card1 = new Card(2, Suit.Diamonds, Name.Two);
		card1.hide();
		System.out.println("*Hiding a card*");
		System.out.println("Expected: Bicycle");
		System.out.println("Actual:   " + card1);
		
		System.out.println("\n*Showing a card*");
		card1.show();
		System.out.println("Expected: Two of Diamonds");
		System.out.println("Actual:   " + card1 + "\n");
		
		System.out.println("*Getting the value for the card*");
		System.out.println("Expected: 2");
		System.out.println("Actual:   " + card1.getCard());
		System.out.println();	
	}// End of testingCard
	
	
	/**
	 * TESTING DECK CLASS
	 */
	private static void testingDeck()
	{
		System.out.println("\tTesting Deck Class\n");
		Deck deck = new Deck();
		
		System.out.println("*Full deck of cards*");
		System.out.println("Deck: " + deck);
		System.out.println();
		
		System.out.println("*Dealing a single card*");
		System.out.println("Dealt: " + deck.deal());
		System.out.println();
		
		System.out.println("*Shuffling the deck*");
		deck.shuffle();
		System.out.println("Shuffled: " + deck);
		System.out.println();
	}// End of testingDeck
	
	/**
	 * TESTING PLAYER
	 */
	private static void testingPlayer()
	{
		System.out.println("\tTesting Player Class\n");
		System.out.println("*Default Constructor*");
		Player player = new Player();
		System.out.println("Expected: Unknown");
		System.out.println("Actual:   " + player + "\n");
		
		System.out.println("*Adding name to player*");
		Player player1 = new Player("Mikael");
		System.out.println("Expected: Mikael");
		System.out.println("Actual:   " + player1 + "\n");
		
		System.out.println("*Getting the name*");
		System.out.println("Expected: Mikael");
		System.out.println("Actual:   " + player1.getName());
		
		System.out.println("\n*Getting cards from player*");
		Card card1 = new Card(2, Suit.Diamonds, Name.Two);
		Card card2 = new Card(3, Suit.Diamonds, Name.Three);
		Card card3 = new Card(5, Suit.Diamonds, Name.Five);
		Card card4 = new Card(6, Suit.Diamonds, Name.Six);
		Card card5 = new Card(7, Suit.Diamonds, Name.Seven);
		System.out.println("Expected:\nTwo of Diamonds\r\n" + 
				"Three of Diamonds\r\n" + 
				"Five of Diamonds\r\n" + 
				"Six of Diamonds\r\n" + 
				"Seven of Diamonds");
		System.out.println("\nActual:");
		player.addCardToDeck(card1);
		player.addCardToDeck(card2);
		player.addCardToDeck(card3); 
		player.addCardToDeck(card4);
		player.addCardToDeck(card5);
		player.showDeck();
		System.out.println();
		
		System.out.println("*Deck size*");
		System.out.println("Expected: 5");
		System.out.println("Actual:   " + player.getDeckSize() + "\n");
		
		System.out.println("*Taking cards from player*");
		player.takeCardfromDeck(card5);
		player.takeCardfromDeck(card4);
		player.showDeck();
		System.out.println();
		
		System.out.println("*Deck size*");
		System.out.println("Expected: 3");
		System.out.println("Actual:   " + player.getDeckSize() + "\n");
		
		System.out.println("*Add card to the deck*");
		System.out.println("Deck: \nTwo of Diamonds\r\n" + 
				"Three of Diamonds\r\n" + 
				"Five of Diamonds\r\n" +  
				"");
		ArrayList<Card> add = new ArrayList<Card>();
		add.add(card1);
		player.addToDeck(add);
		System.out.println("Added last card to deck:");
		player.showDeck();
		
		System.out.println("\n*Removing cards from deck*");
		System.out.println("Deck with Two of Diamonds:");
		player.showDeck();
		player.removeFromDeck(add); 
		System.out.println("\nDeck with Two of Diamonds removed:");
		player.showDeck();
		
		System.out.println("\n*Adding card to player*");
		System.out.println("Players Deck: \nEmpty");
		player1.showDeck();
		System.out.println("Players deck after:");
		player.addToPlayer(player1);
		player1.showDeck();
		
		System.out.println("\n*Getting a card*");
		System.out.println("Expected: Three of Diamonds");
		System.out.println("Actual:   " + player.getCard(0));
	}// End of testingPlayer
}
