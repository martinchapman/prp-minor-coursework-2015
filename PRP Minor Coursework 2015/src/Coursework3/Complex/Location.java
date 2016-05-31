package Coursework3.Complex;
/**
 * @author Martin
 *
 */
public class Location {

	/**
	 * 
	 */
	private double x;
	
	/**
	 * @return
	 */
	public double x() {
		
		return x;
		
	}
	
	/**
	 * 
	 */
	private double y;
	
	/**
	 * @return
	 */
	public double y() {
		
		return y;
		
	}
	
	/**
	 * @param x
	 * @param y
	 */
	public Location( double x, double y ) {
		
		setLocation(x, y);
		
	}
	
	/**
	 * @param x
	 * @param y
	 */
	public void setLocation( double x, double y ) {
		
		this.x = x;
		
		this.y = y;
		
	}

}
