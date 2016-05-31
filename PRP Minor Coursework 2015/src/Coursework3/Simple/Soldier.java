package Coursework3.Simple;
/**
 * A soldier is an entity with an x, a y position and a speed.
 * 
 * 
 * 
 * @author Martin
 *
 */
public class Soldier {

    /**
     * The soldier's x position
     */
    private double x;
    
	/**
	 * The soldier's y position
	 */
	private double y;
	
	/**
	 * The soldier's speed
	 */
	protected double speed;
	
    /**
     * Every soldier must have an x and a y position
     * 
     * @param x
     * @param y
     */
    public Soldier ( double x, double y ) {
 
		this.x = x;
		
		this.y = y;
		
	}
	
	/**
	 * A suitable getter for the x position (not mandatory)
	 * @return
	 */
	public double getX() {
		
	    return x;
	
	}
	
	/**
	 * A suitable getter for the y position (not mandatory)
	 * @return
	 */
	public double getY() {
		
	    return y;
	
	}
	
	/**
	 * Moves the soldier to a new position.
	 * 
	 * @param x
	 * @param y
	 */
	public void moveTo( double x, double y ) {
		
		this.x = x;
		
		this.y = y;
		
	}
	
	/**
	 * Computes the Euclidean distance between this soldier, and another soldier
	 * (i.e. the distance between two points on a 2D plane).
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public double distance ( Soldier target ) {
		
         return Math.sqrt( Math.pow ( ( target.x - x ) , 2 ) + Math.pow ( ( target.y - y ) , 2 ) ); 
	
	}
	
	/**
	 * Computes the time, in an arbitrary unit, it takes for one soldier
	 * to reach another, based upon the distance between them.
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public double time ( Soldier target ) {
		
		return distance( target ) / speed ;
	
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * 
	 * Return the name of the soldier, and their x and y position.
	 */
	public String toString() {
		
		return getClass().getSimpleName() + " (" + Utils.format(x) + ", " + Utils.format(y) + ") ";
		
	}
	
}