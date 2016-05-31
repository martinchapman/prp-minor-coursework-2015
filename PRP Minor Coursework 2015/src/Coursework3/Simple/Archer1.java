package Coursework3.Simple;
/**
 * Archers specialise Soldiers by providing a range value, and a test to see
 * if they are in range of their targets (Spearman).
 * 
 * Information about the speed of the Archer is also given.
 * 
 * @author Martin
 *
 */
public class Archer1 extends Soldier {
	
	/**
	 * A constant value representing the archer's range
	 */
	public static final double range = 10;
	
    /**
     * Set the x and the y value in the child constructor,
     * and pass these values to the superclass for assignment
     * to their respective fields.
     * 
     * @param x
     * @param y
     */
    public Archer1 ( double x, double y ) {

		super ( x, y );	
		
		// Set value in protected speed field.
		speed = 12.5;
		
	}
	
	/**
	 * Pass a Spearman and determine whether he is in range of the Archer.
	 * 
	 * @param spearman
	 * @return
	 */
	public boolean inRange(Spearman spearman) {

		return distance(spearman) < range;
		
	}

}