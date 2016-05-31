package Coursework4.ProblemA;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Martin
 *
 */
public class LAN {

	/**
	 * The network being run
	 */
	private Network network;
	
	/**
	 * 
	 */
	public LAN() {
		
		setupNetwork();
		
		startNetwork();
		
	}
	
	/**
	 * Setup the network
	 */
	private void setupNetwork() {

		/*
		 * Create network and add an access point;
		 */
		network = new Network();
		
		// Create an access point
		AccessPoint AP = new AccessPoint( "a1:22:b3:cd:e4:56", "solo" );
		
		// Add the access point to the network
		network.addAccessPoint( AP );
		
		/*
		 * Create a client - the other handshake participant exploited as a part of the hack -
		 * and connect the client with the access point via a handshake
		 */
		network.handshake( new Client( "f7:88:g9:hi:j1:22", "solo" ), AP );
		
	}
	
	/**
	 * Start the network running
	 * 
	 */
	private void startNetwork() {
		
		while ( true ) {
			
			network.networkActivity();
			
			try {
			
				Thread.sleep(100);
			
			} catch (InterruptedException e) {

				// Would usually do something here to recover, if necessary.
				
			}
			
		}
		
	}
	
	/**
	 * @param args
	 */
	public static void main( String[] args ) {
		
		new LAN();
				
	}

}