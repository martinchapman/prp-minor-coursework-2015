package Coursework3.Complex;
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
	private int numberOfSoldiers;
	
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
	public Battlefield(int soldiers) {
		
		this.soldiers = new Soldier[soldiers];
		
		numberOfSoldiers = 0;
		
	}
	
	/**
	 * @param soldier
	 */
	public void addSoldier(Soldier soldier) {
		
		soldiers[numberOfSoldiers++] = soldier;
		
	}
	
	/**
	 * @return
	 */
	public TargetTime fastestTargetTime() {
		
		TargetTime fastestTargetTime = new TargetTime();
		
		for ( Soldier firstSoldier : soldiers ) {
			
			for ( Soldier secondSoldier : soldiers ) {
			
				if ( firstSoldier.time(secondSoldier).fasterThan(fastestTargetTime) ) {
					
					fastestTargetTime = firstSoldier.time(secondSoldier);
					
				}
				
			}
			
		}
		
		return fastestTargetTime;
		
	}
	
	/**
	 * @param winner
	 */
	public void endOfBattle( Soldier attacker, Soldier attacked ) {
		
		if ( attacker instanceof Archer ) {
			
			attacked.moveTo(-1.0, -1.0);
			
		} else if ( attacker instanceof Knight ) {
			
			attacker.moveTo(attacked.getX(), attacked.getY());
			
			attacker.moveTo(-1.0, -1.0);
			
		} else {
			
			attacker.moveTo(attacked.getX(), attacked.getY());
			
		}
		
		/* Could take this further and provide a series of overridden methods 
		 * for each soldier, that uniquely identifies how they act at the
		 * end of a fight.
		 */
		
	}
	
	/**
	 * 
	 */
	public void reposition() {
		
		for ( Soldier soldier : soldiers ) {
			
			soldier.moveTo( Math.random() * 100,  Math.random() * 100 );
			
		}
		
	}
	
}