/**
 * Game client for the war game
 * @author Mikael Hinton
 *
 */
public class PlayWar {

	public static void main(String[] args) {

		System.out.println("|++++++++++++++++++++++++++++++++++++++++|");
		System.out.println("|            WELCOME TO WAR              |");
		System.out.println("|++++++++++++++++++++++++++++++++++++++++|");
		System.out.println();

		Player p1 = new Player("Michael");
		Player p2 = new Player("Bryan");
		Table table = new Table(p1, p2);
		table.play();	
	}//EOM
}//EOF
