package Coursework3.Complex;
/**
 * @author Martin
 *
 */
public class Soldier {

	/**
	 * 
	 */
	private Location location;
	
	/**
	 * 
	 */
	protected double speed;
	
    /**
     * @param x
     * @param y
     */
    public Soldier ( double x, double y ) {
 
		location = new Location(x, y);
		
	}
	
	/**
	 * @return
	 */
	public double getX() {
		
	    return location.x();
	
	}
	
	/**
	 * @return
	 */
	public double getY() {
		
	    return location.y();
	
	}
	
	/**
	 * @param x
	 * @param y
	 */
	public void moveTo ( double x, double y ) {
		
		location.setLocation(x, y);
		
	}
	
	/**
	 * @param x
	 * @param y
	 * @return
	 */
	public double distance ( Soldier target ) {
		
         return Math.sqrt( Math.pow ( ( target.getX() - getX() ) , 2 ) + Math.pow ( ( target.getY() - getY() ) , 2 ) ); 
	
	}
	
	/**
	 * @param x
	 * @param y
	 * @return
	 */
	public TargetTime time ( Soldier target ) {
		
		return new TargetTime( this, target, distance( target ) / speed );
	
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		
		return this.getClass().getSimpleName() + " (" + Utils.format(getX()) + ", " + Utils.format(getY()) + ") ";
		
	}
	
}