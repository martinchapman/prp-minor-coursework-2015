package Coursework3.Simple;
/**
 * SimpleBattlefield: One of the simplest, and thus by no means the best,
 * possible solutions to Coursework3.
 * 
 * Archers specialise Soldiers by providing a range value, and a test to see
 * if they are in range of their targets (Spearman).
 * 
 * Information about the speed of the Archer is also given.
 * 
 * @author Martin
 *
 */
public class Archer extends Soldier {
	
	/**
	 * A constant value representing the archer's range
	 */
	private double range;
	
    /**
     * Set the x and the y value in the child constructor,
     * and pass these values to the superclass for assignment
     * to their respective fields.
     * 
     * @param x
     * @param y
     */
    public Archer ( double x, double y ) {

		super ( x, y );	
		
		// Set value in protected speed field.
		speed = 12.5;
		
		range = 10;
		
	}
    
    public double getRange() {
    	
    	return range;
    	
    }
    
}