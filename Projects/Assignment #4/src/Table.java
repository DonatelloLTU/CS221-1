/**
 * Table class that plays the game
 */
import java.util.ArrayList;

public class Table {

	Player gamePlayers[] = new Player[2];	// Initializes 2 players at the table
	
	/**
	 * Constructor for the table class
	 * @param p1
	 * @param p2
	 */
	public Table(Player p1, Player p2)
	{
		gamePlayers[0] = p1;
		gamePlayers[1] = p2;
	}// End of Constructor
	
	public String toString()
	{
		return "Player1: " + gamePlayers[0] + "\nPlayer2: " + gamePlayers[1];
	}

	/**
	 * Play method that actually plays the game
	 */
	protected void play()
	{
		Player player1 = gamePlayers[0];	// Initializes player 1 
		Player player2 = gamePlayers[1];	// Initializes player 2
		
		/*
		 * Adds 26 cards to each player
		 */
		for(int i = 0; i < 26; i++) 
		{
			player1.addToPlayer(player1);
			player2.addToPlayer(player2);
		}
		
		int counter = 0;
		int counterWar = 0;
		/*
		 * Checks to makes sure each person has more than 0 cards
		 */
		while(player1.getDeckSize() > 0 || player2.getDeckSize() > 0)
		{
			Card p1Card = player1.getCard(0);	// gets the first card for player 1
			Card p2Card = player2.getCard(0);	// gets the first card for player 2
			
			System.out.println(player1.getName() + "'s card: " + p1Card);
			System.out.println(player2.getName() + "'s card: " + p2Card);
			
			/*
			 * If players 1 card value is greater than players 2
			 * 		removes both cards from the players and then adds 
			 * 		then all back to player 1
			 */
			if(p1Card.getCard() > p2Card.getCard())
			{
				
				player2.takeCardfromDeck(p2Card);
				player1.takeCardfromDeck(p1Card);
				player1.addCardToDeck(p2Card);
				player1.addCardToDeck(p1Card);
						
				System.out.println(player1.getName() + " wins!\n");
			}
			
			/*
			 * If players 2 card value is greater than players 1
			 * 		removes both cards from the players and then adds 
			 * 		then all back to player 2
			 */
			else if(p1Card.getCard() < p2Card.getCard())
			{
				player1.takeCardfromDeck(p1Card);
				player2.takeCardfromDeck(p2Card);
				player2.addCardToDeck(p1Card);
				player2.addCardToDeck(p2Card);
				System.out.println( player2.getName() + " wins!\n");
			}
			
			/*
			 * If both cards value are the same war begins 
			 */
			else if(p1Card.getCard() == p2Card.getCard())
			{
				System.out.println("\n\n|+++++++++++++++++++++++++++|");
				System.out.println("|        War Begins         |");
				System.out.println("|+++++++++++++++++++++++++++|\n\n");
				
				ArrayList<Card> war1 = new ArrayList<Card>();	// Creates the deck for war for player 1
				ArrayList<Card> war2 = new ArrayList<Card>();	// Creates the deck for war for player 2
				
				/*
				 * Gives each player 5 cards from the full deck
				 */
				for(int i = 0; i <= 4; i++)
				{
					// If player 1 or player 2 doesnt have any cards the war breaks
					if(player1.getDeckSize() == 0 || player2.getDeckSize() == 0)
					{
						break;
					} 
					// if either player has less than 5 cards then it only adds the last card in the deck to be used for war
					if(player1.getDeckSize() <= 5 || player2.getDeckSize() <= 5)
					{
						war1.add(player1.getCard(player1.getDeckSize() - 1));
						war2.add(player2.getCard(player2.getDeckSize() - 1));
					}
					// Adds 5 cards to the war hand to be dealt
					else
					{
					war1.add(player1.getCard(i));
					war2.add(player2.getCard(i));
					}
	 
				}
				int size1 = war1.size() - 1;	// Size of player1 war hand size
	            int size2 = war2.size() - 1;	// Size of player1 war hand size
				
					System.out.println("War card for " + player1.getName() + ": " + war1.get(size1).toString());
	                System.out.println("War card for " + player2.getName() + ": " + war2.get(size2).toString());
	                
	                // Compares the 2 cards
	                if(war1.get(size1).getCard() > war2.get(size2).getCard())
	                {
	                	
	                	player1.addToDeck(war1);
	                	player2.removeFromDeck(war2);
	                	player1.addToDeck(war2);
	                	player1.takeCardfromDeck(p1Card);
	                	player1.addCardToDeck(p1Card);
	                	
	                	System.out.println(player1.getName() + " wins war!\n");
	                	
	                }
	                else
	                {
	                	player2.addToDeck(war2);
	                	player1.removeFromDeck(war1);
	                	player2.addToDeck(war1);
	                	player2.takeCardfromDeck(p2Card);
	                	player2.addCardToDeck(p2Card);
	                	
	                	System.out.println("\n" + player2.getName() + " wins war!\n");
	                }
	                
	                System.out.println("\n|+++++++++++++++++++++++++++|");
					System.out.println("|        War Ends           |");
					System.out.println("|+++++++++++++++++++++++++++|\n\n");
					counterWar++;
			}
			counter++;
			/*
			 * If player 1 deck size is 0 player 2 wins
			 */
			if(player1.getDeckSize() == 0)
			{
				System.out.println("\n|+++++++++++++++++++++++++++++++++++++++++++|");
				System.out.println("         CONGRATULATIONS " + player2.getName().toUpperCase() + " WINS!        ");
				System.out.println("|+++++++++++++++++++++++++++++++++++++++++++|\n\n");
				System.out.println("Rounds in game: " + counter);
				System.out.println("Wars in game: " + counterWar);
				break;
			}
			/*
			 * If player 2 deck size is 0 player 1 wins
			 */
			else if(player2.getDeckSize() == 0)
			{
				System.out.println("\n|+++++++++++++++++++++++++++++++++++++++++++++|");
				System.out.println("         CONGRATULATIONS " + player1.getName().toUpperCase() + " WINS!        ");
				System.out.println("|+++++++++++++++++++++++++++++++++++++++++++++|\n\n");
				System.out.println("Rounds in game: " + counter);
				System.out.println("Wars in game: " + counterWar);
				break;
			}
		}// End of While	
	}// End of Play
}//EOF
