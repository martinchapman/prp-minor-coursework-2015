package Coursework2;
public class Fight {

	/**
	 * THE MAIN METHOD SHOULD BE IN A SEPARATE CLASS CALLED FIGHT.
	 * For brevity I've put it in here.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Note that each student will have a randomly assigned pair of superheroes.
		
		/* Create a new Superhero. Use the name of the object to establish the identity of the hero,
		 * as well as passing the name of the hero to the constructor. Students are not told to
		 * supply a strength value for the first hero, so should use the first constructor.
		 */
		Superhero ironMan = new Superhero("Iron Man");
		
		/* Create a second Superhero. Students are told to supply an initial strength here, so should
		 * provide some way to do this. Best way is through a second constructor.
		 */
		Superhero captainAmerica = new Superhero("Captain America", 50);
		
		/* Print the result of the fight by invoking the fight method, and directly printing 
		 * the result (which is a 'printable' Superhero object with a toString() method).
		 */
		System.out.println(ironMan + " fights " + captainAmerica + ", " + ironMan.fight(captainAmerica) + " wins.");
		
		// Power up the superhero, by updating the superhero's strength value
		ironMan.powerUp(100);
		
		// Run the fight again.
		System.out.println(ironMan + " fights " + captainAmerica + ", " + ironMan.fight(captainAmerica) + " wins.");
		
	}

}
