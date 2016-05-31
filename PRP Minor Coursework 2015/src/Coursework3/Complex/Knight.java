package Coursework3.Complex;
/**
 * @author Martin
 *
 */
public class Knight extends Soldier {
    
    /**
     * @param x
     * @param y
     */
    public Knight ( double x, double y ) {
    	
		super ( x, y ); 
		
		speed = 5.0;
	
    }
    
    public TargetTime time ( Soldier target ) {
    	
    	if ( target instanceof Archer ) {
    		
    		return super.time(target);
    		
    	} else {
    		
    		return new TargetTime();
    		
    	}
    	
    }
	
}