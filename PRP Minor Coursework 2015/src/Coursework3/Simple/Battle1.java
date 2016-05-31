package Coursework3.Simple;
/**
 * @author Martin
 *
 */
public class Battle1 {
	
	/**
	 * The Spearman involved in the battle
	 */
	private Spearman spearman;
	
	/**
	 * The Knight involved in the battle
	 */
	private Knight knight;
	
	/**
	 * The archer involved in the battle
	 */
	private Archer1 archer;
	
	/**
	 * Every battle starts with a positioning of the soldiers involved
	 */
	public Battle1() {

		position();
		
	}
	
	/**
	 * Position the soldiers in a battle at random locations on a conceptual
	 * battlefield that is 100 units wide by 100 units high
	 */
	public void position() {
		
		spearman = new Spearman ( Math.random() * 100, Math.random() * 100 );
		
		knight = new Knight( Math.random() * 100, Math.random() * 100 );
		
		archer =  new Archer1( Math.random() * 100, Math.random() * 100 );
		
	}
	
	/**
	 * Determine who the winner of the battle is based upon the relative position
	 * of the units, their distance to each other, and thus the time it would take
	 * each unit to reach a specific target.
	 * 
	 * Notable check for whether an archer is in range included here.
	 * 
	 * @return The winning Soldier object.
	 */
	public Soldier winner() {
		
		// If the Archer's time is less than the Knight's and the Spearman's, and he is in range.
		if ( archer.time(spearman) < knight.time(archer) && archer.time(spearman) < spearman.time(knight) && archer.inRange(spearman) ) {
			
			return archer;
		
		// If the Spearman's time is less than the Knight's (we already know the archer can't win, so no need to make this comparison)
		} else if ( spearman.time(knight) < knight.time(archer) ) {
			
			return spearman;
		
		// In any other case the Knight wins.
		} else {
			
			return knight;
			
		}
		
	}
	
	/**
	 * Given a winner of a battle, determines how this affects
	 * the state of the battle, and the battlefield.
	 * 
	 * @param winner
	 */
	public void endOfBattle( Soldier winner ) {
		
		// If the Archer wins, move the Spearman off the field
		if ( winner instanceof Archer ) {
			
			spearman.moveTo(-1.0, -1.0);
		
		/* If the Knight wins, move the Knight to the location of the archer
		 * and move the Archer off the field
		 */
		} else if ( winner instanceof Knight ) {
			
			knight.moveTo(archer.getX(), archer.getY());
			
			archer.moveTo(-1.0, -1.0);
		
		/* Otherwise (the Spearman wins) move the Spearman to the Knight's position.
		 * The Knight stays on the field.
		 */
		} else {
			
			spearman.moveTo(knight.getX(), knight.getY());
			
		}
		
	}
	
}