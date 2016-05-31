package Coursework2;
/**
 * `Model' solution for second coursework exercise.
 * 
 * @author Martin
 *
 */
public class Superhero {

	/**
	 * A String field to hold the name of the superhero.
	 * Fields must be private.
	 */
	private String name;
	
	/**
	 * An integer field to hold the strength of the superhero.
	 * Fields must be private.
	 */
	private int strength;
	
	/**
	 * Constructor 1. Note that both constructors contain name,
	 * but only one contains strength, making the strength
	 * parameter optional upon instantiation.
	 * 
	 * @param name
	 */
	public Superhero( String name ) {
		
		// Assign the given name to the name field
		this.name = name;
		
		// Set the strength value to 10 as instructed by the coursework
		strength = 10;
		
		// Cool alternative: this(name, 10);, but this is not expected
		
	}
	
	/**
	 * Constructor 2. Also allows a hero to be created with a strength.
	 * 
	 * @param name
	 * @param strength
	 */
	public Superhero( String name, int strength ) {
		
		// Assign the given name to the name field
		this.name = name;
		
		// Assign the given strength to the strength field
		this.strength = strength;
		
	}
	
	/**
	 * @param strengthIncrease
	 */
	public void powerUp( int strengthIncrease ) {
		
		// Important that this INCREMENTS the strength, does not replace it.
		strength += strengthIncrease;
		
	}
	
	/**
	 * Probably the method that encompasses the most complexity in the question.
	 * 
	 * Student's have to understand the concept of referring to a class type
	 * inside that class itself, and that a class type can be used anywhere a normal
	 * variable type is used.
	 * 
	 * @param opponent the opponent object
	 * @return Returns the winning superhero object
	 */
	public Superhero fight( Superhero opponent ) {
		
		// If the strength of the current superhero is GREATER than the strength of the opponent
		if ( strength > opponent.strength ) {
			
			// Return the current superhero object
			return this;
			
		} else {
			
			// Otherwise return the opponent object (opponent wins when the fight is drawn)
			return opponent;
			
		}
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		
		// Print a superhero's name every time a superhero object is printed
		return name;
		
	}
	
	
	
}