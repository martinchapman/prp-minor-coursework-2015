package Coursework3.Complex;
/**
 * @author Martin
 *
 */
public class Spearman extends Soldier {
	
    /**
     * @param x
     * @param y
     */
    public Spearman ( double x, double y ) {
    	
		super ( x, y );
		
		speed = 4.0;
		
	}
    
    /* (non-Javadoc)
     * @see Soldier#time(Soldier)
     */
    public TargetTime time ( Soldier target ) {
    	
    	if ( target instanceof Knight ) {
    		
    		return super.time(target);
    		
    	} else {
    		
    		return new TargetTime();
    		
    	}
    	
    }
	
}