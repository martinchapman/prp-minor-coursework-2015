package Coursework4.ProblemB;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Martin
 *
 */
public class Hacker {

	/**
	 * The network targeted by the hacker
	 */
	private Network network;
	
	/**
	 * The access point being targeted
	 */
	private AccessPoint targetAP;
	
	/**
	 * The existing, authorised client being target
	 */
	private Client targetSTA;
	
	/**
	 * The current number of handshake packets observed
	 */
	private int handshakes;
	
	/**
	 * The stored hash function
	 */
	private HashFunction hashFunction;
	
	/**
	 * A record of one of the captured handshake packets
	 */
	private HandshakePacket capturedHandshake;
	
	/**
	 * Set to true once the Hacker has succeeded in hacking the access point
	 */
	private boolean accessPointHacked;
	
	/**
	 * All hackers are associated with a network, a target access point and a 
	 * target client, and a hash function.
	 * 
	 * @param network
	 * @param targetAP
	 * @param targetSTA
	 * @param hashFunction
	 */
	public Hacker( Network network, AccessPoint targetAP, Client targetSTA, HashFunction hashFunction ) {
		
		this.network = network;
		
		this.targetAP = targetAP;
		
		this.targetSTA = targetSTA;
		
		handshakes = 0;
		
		this.hashFunction = hashFunction;
		
	}
	
	/**
	 * Hackers keep listening for two handshake packets until
	 * they receive them, otherwise they try and crack these packets.
	 * 
	 * @throws FileNotFoundException 
	 * 
	 */
	public boolean hackerActivity() throws FileNotFoundException {
		
		if ( handshakes < 2 ) {
			
			listenForHandshakes();
			
			return true;
			
		} else {
			
			System.out.println("Hacker captures handshake!");
			
			return crackHandshake();
			
		}
		
	}
	
	/**
	 * Listening for a handshake involves examining all channels
	 * for handshake packets sent from the targetAP to the targetSTA, or
	 * vice-versa.
	 */
	private void listenForHandshakes() {
		
		// Look through all of the network's channels
		for ( Channel channel : network.channels() ) {
			
			// Look through the traffic in each channel 
			for ( Packet packet : channel.getTraffic() ) {
				
				// If the packet is a Handshake Packet AND
				if ( packet instanceof HandshakePacket && ( 
					 // It is sent from the AP to the STA OR
					 packet.getDestinationAddress().equals(targetAP.getAddress()) && packet.getSourceAddress().equals(targetSTA.getAddress()) || 
					 // It is sent from the STA to the AP
					 packet.getDestinationAddress().equals(targetSTA.getAddress()) && packet.getSourceAddress().equals(targetAP.getAddress())	) ) {
					
					    // Increment the number of observed handshakes
						handshakes++;
					
						// If at any point the number of perceived handshakes is two
						if ( handshakes == 2 ) {
						
							// Capture the most recent handshake packet
							capturedHandshake = (HandshakePacket)packet;
						
							// And exit.
							return;
						
						}
					
				}
				
			}
			
		}
		
	}
	
	/**
	 * Cracks a handshake by hashing all potential keys and
	 * seeing if they match the key contained within the handshake packet
	 * 
	 * @throws FileNotFoundException
	 */
	private boolean crackHandshake() throws FileNotFoundException {
		
		// Read in the keys from file
		Scanner scanner = new Scanner( new File("keys.txt") );
		
		while ( scanner.hasNextLine() ) {
			
			String key = scanner.nextLine();
			
			// If a hash of the currently read key matches the key in the packet
			if ( hashFunction.hash( key ) == capturedHandshake.getPasswordHash() ) {
				
				// Notify that the crack has occurred 
				System.out.println( "Cracked handshake, password for " + targetAP + " is " + key + "!" );
				
				// Create a new client (the hacker's laptop)
				Client laptop = new Client( "e1:22:v3:il:h4:55", network, key, hashFunction );
				
				// Connect that laptop to the AP 
				network.handshake( laptop, targetAP );
				
				scanner.close();
				
				return false;
				
			}
			
		}
		
		scanner.close();
		
		return false;
		
	}

}
