package Coursework3.Complex;
/**
 * @author Martin
 *
 */
public class TargetTime {

	/**
	 * 
	 */
	private Soldier attacker;
	
	/**
	 * 
	 */
	private Soldier attacked;
	
	/**
	 * 
	 */
	private double time;
	
	/**
	 * 
	 */
	private boolean validTarget;
	
	/**
	 * 
	 */
	public TargetTime() {
		
		validTarget = false;
		
	}

	/**
	 * @param time
	 * @param attacker
	 */
	public TargetTime( Soldier attacker, Soldier attacked, double time ) {
		
		this.time = time;
		
		this.attacker = attacker;
		
		this.attacked = attacked;
		
		validTarget = true;
		
	}
	
	/**
	 * @return
	 */
	public Soldier attacker() {
		
		return attacker;
		
	}
	
	/**
	 * @return
	 */
	public Soldier attacked() {
		
		return attacked;
		
	}
	
	/**
	 * @param targetTime
	 * @return
	 */
	public boolean fasterThan( TargetTime targetTime ) {
		
		return !targetTime.validTarget || ( validTarget && time < targetTime.time );
	
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		
		return attacker + " --> " + attacked + " " + time;
		
	}
	
}
