package Coursework3;
/**
 * @author Martin
 *
 */
public class Archer extends Soldier {
	
	/**
	 * 
	 */
	private final int range = 10;
	
    /**
     * @param x
     * @param y
     */
    public Archer ( double x, double y ) {

		super ( x, y );	
		
		speed = 12.5;
		
	}
	
	/**
	 * @return
	 */
	public double range() {
		
	    return range;
    
	}
	
	/**
	 * @param spearman
	 * @return
	 */
	public boolean inRange(Spearman spearman) {
		
		return spearman.getX() > getX() - range && 
			   spearman.getX() < getX() + range &&  
			   spearman.getY() > getY() - range && 
			   spearman.getY() < getY() + range;
		
	}

}