package Coursework3;
import java.util.Scanner;

/**
 * @author Martin
 *
 */
public class Battlefield {

	/**
	 * 
	 */
	private Soldier[] soldiers;
	
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
	private Archer archer;
	
	/**
	 * 
	 */
	public Battlefield() {

		position();
		
	}
	
	/**
	 * 
	 */
	public void position() {
		
		spearman = new Spearman ( Math.random() * 100, Math.random() * 100 );
		
		knight = new Knight( Math.random() * 100, Math.random() * 100 );
		
		archer =  new Archer( Math.random() * 100, Math.random() * 100 );
		
		soldiers = new Soldier[]{ knight, archer, spearman }; 
		
		soldiers[0].setTarget(soldiers[1]);
		
		soldiers[1].setTarget(soldiers[2]);
		
		soldiers[2].setTarget(soldiers[0]);
		
	}
	
	/**
	 * @return
	 */
	public Soldier winner() {
		
		if ( soldiers[0].timeToTarget() > soldiers[1].timeToTarget() ) Utils.swap( soldiers, 0, 1 );
			   
		if ( soldiers[1].timeToTarget() > soldiers[2].timeToTarget() ) Utils.swap( soldiers, 1, 2 );
		
		if ( soldiers[0].timeToTarget() > soldiers[1].timeToTarget() ) Utils.swap( soldiers, 0, 1 );
		
		if ( soldiers[0] instanceof Archer && !((Archer)soldiers[0]).inRange(spearman) ) {
		
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