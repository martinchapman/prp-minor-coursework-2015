package Coursework3.Complex;
/**
 * @author Martin
 *
 */
public class Archer extends Soldier {
	
	/**
	 * 
	 */
	private final double range = 10;
	
    /**
     * @param x
     * @param y
     */
    public Archer ( double x, double y ) {

		super ( x, y );	
		
		speed = 12.5;
		
	}
	
    /* (non-Javadoc)
     * @see Soldier#time(Soldier)
     */
    @Override
    public TargetTime time ( Soldier target ) {
    	
    	if ( target instanceof Spearman && distance(target) < range ) {
    		
    		return super.time(target);
    		
    	} else {
    		
    		return new TargetTime();
    		
    	}
    	
    }
	
}