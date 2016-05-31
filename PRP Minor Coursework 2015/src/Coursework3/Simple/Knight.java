package Coursework3.Simple;
/**
 * Knights specialise Soldier by adding a unique speed value
 * 
 * @author Martin
 *
 */
public class Knight extends Soldier {
    
    /**
     * Set speed via protected variable.
     * 
     * @param x
     * @param y
     */
    public Knight ( double x, double y ) {
    	
		super ( x, y ); 
		
		// Set speed in protected field
		speed = 5.0;
	
    }
	
}