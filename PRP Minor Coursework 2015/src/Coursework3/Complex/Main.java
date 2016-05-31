package Coursework3.Complex;
/**
 * @author Martin
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Battlefield battlefield = new Battlefield(3);

		battlefield.addSoldier( new Spearman ( Math.random() * 100, Math.random() * 100 ) );
		
		battlefield.addSoldier( new Knight ( Math.random() * 100, Math.random() * 100 ) );
		
		battlefield.addSoldier( new Archer ( Math.random() * 100, Math.random() * 100 ) );
		
		for ( int battle = 0; battle < 3; battle++ ) {
			
			System.out.println( battlefield.fastestTargetTime().attacker() );
		
			battlefield.endOfBattle( battlefield.fastestTargetTime().attacker(), battlefield.fastestTargetTime().attacked() );
			
			battlefield.reposition();
			
		}
	
	}

}
