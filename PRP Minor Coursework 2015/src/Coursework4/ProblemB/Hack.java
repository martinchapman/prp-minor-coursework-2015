package Coursework4.ProblemB;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Martin
 *
 */
public class Hack {

	/**
	 */
	private Network network;
	
	/**
	 * The hacker associated with this hack
	 */
	private Hacker hacker;
	
	/**
	 * The hash function shared by the hacker and the devices
	 */
	private HashFunction hashFunction;
	
	/**
	 * @throws FileNotFoundException
	 */
	public Hack() throws FileNotFoundException {
		
		setupNetwork();
		
		startNetwork();
		
	}
	
	/**
	 * @throws FileNotFoundException
	 */
	private void setupNetwork() throws FileNotFoundException {
		
		/*
		 * Setup Hash Function
		 */
		Scanner scanner = new Scanner( new File("keys.txt") );
		
		hashFunction = new HashFunction( scanner.nextLine() );
		
		while ( scanner.hasNextLine() ) {
			
			hashFunction.addHash( scanner.nextLine() );
			
		}
		
		scanner.close();
		
		network = new Network();
		
		AccessPoint AP = new AccessPoint( "a1:22:b3:cd:e4:56", network, "solo", hashFunction );
		
		network.addAccessPoint( AP );
				
		Client STA = new Client( "f7:88:g9:hi:j1:22", network, "solo", hashFunction );
		
		network.handshake( STA, AP );
		
		/*
		 * Create hacker
		 */
		hacker = new Hacker( network, AP, STA, hashFunction );
		
	}
	
	/**
	 * @throws FileNotFoundException 
	 * 
	 */
	private void startNetwork() throws FileNotFoundException {
		
		/* Clear the initial handshake for security.
		 * To avoid this, could reformat loop below so 
		 * first burst happens before first hacker activity.
		 */
		network.clearChannels();
		
		/* Now we loop while the hacker is still doing something
		 * e.g. listening or cracking
		 */
		while ( hacker.hackerActivity() ) {
			
			network.networkActivity();
			
			try {
			
				Thread.sleep(100);
			
			} catch (InterruptedException e) {

				e.printStackTrace();

			}
			
		}
		
	}
	
	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main( String[] args ) throws FileNotFoundException {
		
		new Hack();
				
	}

}