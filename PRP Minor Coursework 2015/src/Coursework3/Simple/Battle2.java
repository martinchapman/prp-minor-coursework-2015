package Coursework3.Simple;
/**
 * @author Martin
 *
 */
public class Battle2 {
	
	/**
	 * 
	 */
	private Spearman spearman;
	
	/**
	 * 
	 */
	private Knight knight;
	
	/**
	 * 
	 */
	private Archer1 archer;
	
	/**
	 * 
	 */
	public Battle2() {

		position();
		
	}
	
	/**
	 * 
	 */
	public void position() {
		
		spearman = new Spearman ( Math.random() * 100, Math.random() * 100 );
		
		knight = new Knight( Math.random() * 100, Math.random() * 100 );
		
		archer =  new Archer1( Math.random() * 100, Math.random() * 100 );
		
	}
	
	/**
	 * @return
	 */
	public Soldier winner() {
				
		if ( archer.time(spearman) < knight.time(archer) && archer.time(spearman) < spearman.time(knight) && archer.inRange(spearman) ) {
			
			// Nested IF here is fine.
			
			return archer;
			
		} else if ( spearman.time(knight) < knight.time(archer) ) {
			
			return spearman;
			
		} else {
			
			return knight;
			
		}
		
	}
	
	/**
	 * @return
	 */
	public Soldier winnerSort() {
		
		int x = 1;
		
		int y = 2;
		
		int z = 3;
		
		int[] threeNumbers = new int[3];
		
		threeNumbers[0] = 1;
		
		threeNumbers[1] = 2;
		
		threeNumbers[2] = 3;
		
		for ( int index = 0; index < threeNumbers.length; index++ ) {
			
			System.out.println(threeNumbers[index]);
			
		}
		
		int[] threeNumbersTwo = { 1, 2, 3 };
		
		
		Soldier[] soldiers = new Soldier[]{ knight, archer, spearman }; 
		
		if ( soldiers[0].time(archer) > soldiers[1].time(spearman) ) Utils2.swap( soldiers, 0, 1 );
			   
		if ( soldiers[1].time(spearman) > soldiers[2].time(knight) ) Utils2.swap( soldiers, 1, 2 );
		
		if ( soldiers[0].time(archer) > soldiers[1].time(spearman) ) Utils2.swap( soldiers, 0, 1 );
		
		if ( soldiers[0] instanceof Archer && !((Archer1)soldiers[0]).inRange(spearman) ) {
		
			return soldiers[1];
			
		} else {
			
			return soldiers[0];
			
		}
		
	}
	
	/**
	 * @param winner
	 */
	public void endOfBattle( Soldier winner ) {
		
		if ( winner instanceof Archer ) {
			
			spearman.moveTo(-1.0, -1.0);
			
		} else if ( winner instanceof Knight ) {
			
			knight.moveTo(archer.getX(), archer.getY());
			
			archer.moveTo(-1.0, -1.0);
			
		} else {
			
			spearman.moveTo(knight.getX(), knight.getY());
			
		}
		
	}
	
}