package Coursework4.ProblemB;
import java.util.HashMap;
import java.util.Map;

/**
 * To avoid the `complexity' of implementing an actual hash
 * function with a low collision rate, implement a table
 * to store plaintext:hash mappings, and enforce that these mappings
 * must be unique.
 * 
 * @author Martin
 *
 */
public class HashFunction {
	
	/**
	 * All currently stored hashes
	 */
	private Map<String, Integer> hashes;
	
	/**
	 * To make hashes unique, rely on a static field
	 */
	private static int hashIndex;
	
	/**
	 * @param plaintext
	 * @throws HashException
	 */
	public HashFunction( String plaintext ) {
		
		hashes = new HashMap<String, Integer>();
		
		addHash( plaintext );
		
	}
	
	/**
	 * Add a hash to the list of hashes that can be converted by
	 * this 'algorithm'
	 * 
	 * @param plaintext
	 */
	public void addHash( String plaintext ) {
		
		if ( !hashes.containsKey( plaintext ) ) {
			
			System.out.println( "Hashing " + plaintext + " as " + hashIndex );
			
			hashes.put( plaintext, hashIndex++ );
			
		} else {
			
			System.out.println( "Hash already exists." );
			
		}
		
	}
	
	/**
	 * Hash a String by finding the mapping to a
	 * pre-stored hash.
	 * 
	 * @param plaintext
	 * @return
	 */
	public int hash( String plaintext ) {
		
		if ( !hashes.containsKey(plaintext) ) {
			
			System.out.println("No hash found.");
			
			return -1;
			
		} else {
		
			return hashes.get( plaintext );
			
		}
				
	}

}