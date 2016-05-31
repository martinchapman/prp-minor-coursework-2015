package Coursework3;
import java.util.Random;

/**
 * @author Martin
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Battlefield battlefield = new Battlefield();
		
		for ( int battle = 0; battle < 3; battle++ ) {
			
			System.out.println(battlefield.winner());
		
			battlefield.endOfBattle(battlefield.winner());
			
			battlefield.position();
		
		}
		
	}

}
