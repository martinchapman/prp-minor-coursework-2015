package Coursework3;
/**
 * @author Martin
 *
 */
public class Soldier {

    /**
     * 
     */
    private double x;
    
	/**
	 * 
	 */
	private double y;
	
	/**
	 * 
	 */
	protected double speed;
	
    /**
     * @param x
     * @param y
     */
    public Soldier ( double x, double y ) {
 
		this.x = x;
		
		this.y = y;
		
		speed = 1.0;
		
	}
	
	/**
	 * @return
	 */
	public double getX() {
		
	    return x;
	
	}
	
	/**
	 * @return
	 */
	public double getY() {
		
	    return y;
	
	}
	
	/**
	 * @param x
	 * @param y
	 */
	public void moveTo( double x, double y ) {
		
		this.x = x;
		
		this.y = y;
		
	}
	
	/**
	 * @param x
	 * @param y
	 * @return
	 */
	public double distance ( Soldier target ) {
		
         return Math.sqrt( Math.pow ( ( target.x - x ) , 2 ) + Math.pow ( ( target.y - y ) , 2 ) ); 
	
	}
	
	/**
	 * @param x
	 * @param y
	 * @return
	 */
	public double time ( Soldier target ) {
		
		return distance( target ) / speed ;
	
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		
		return this.getClass().getSimpleName() + " (" + Utils.round(x) + ", " + Utils.round(y) + ") " + ": " + Utils.round(timeToTarget());
		
		
	}
	
	/**
	 * Keeping a record of the target is just one 
	 * way to sort the attack times
	 */
	private Soldier target;

	/**
	 * @param target
	 */
	public void setTarget( Soldier target ) {
	    	
		this.target = target;
	    
	}
	
	/**
	 * @return
	 */
	public double timeToTarget() {
		
		return time( target );
		
	}
	
}