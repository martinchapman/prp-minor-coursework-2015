package Coursework3.Simple;
/**
 * SimpleBattlefield: One of the simplest, and thus by no means the best,
 * possible solutions to Coursework3.
 * 
 * Spearman specialise Soldier by adding a unique speed value.
 * 
 * @author Martin
 *
 */
public class Spearman extends Soldier {
	
    /**
     * Set speed via protected variable.
     * 
     * @param x
     * @param y
     */
    public Spearman ( double x, double y ) {
    	
		super ( x, y );
		
		// Set spearman speed in protected field
		speed = 4.0;
		
	}
	
}