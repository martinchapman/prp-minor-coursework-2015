package Coursework4.ProblemA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Martin
 *
 */
public class AccessPoint extends NetworkDevice {

	/**
	 * List of client addresses permitted to communicate with this AP
	 */
	private List<String> authorisedClientAddresses;
	
	/**
	 * @param address
	 * @param channel
	 * @param key
	 */
	public AccessPoint( String address, String key ) {
		
		super( address, key );
		
		authorisedClientAddresses = new ArrayList<String>();
		
	}
	
	/**
	 * Checks for handshake packets addressed to the access point (from
	 * a specific client) and responds accordingly.
	 * 
	 * @return
	 */
	public boolean retrieveHandshakePackets() {
		
		// For each packet in the channel
		for ( Packet packet : getPackets() ) {
			
			// If the packet is addressed to the access point
			if ( packet.getDestinationAddress().equals( address ) ) { 
			// Optional condition that requires client as parameters: && packet.getSourceAddress().equals(client.getAddress()) ) {		
				
				// If it is a handshake packet
				if ( packet instanceof HandshakePacket ) {

					// Check that the (presumably) client key matches the key of the access point
					if ( key.equals( ((HandshakePacket)packet).getKey() ) ) {
					
						// Send a packet back
						sendPacket( new HandshakePacket( packet.getSourceAddress(), address, ((HandshakePacket)packet).getKey() ) );
					
						// Authorise this client
						authorisedClientAddresses.add( packet.getSourceAddress() );
						
						return true;
					
					}
					
				}
				
			}
				
		}
			
		return false;
		
	}
		
	/**
	 * Check if any packets in the access point channel are addressed to it,
	 * and respond accordingly.
	 */
	public void readPacketsFromChannel() {
		
		// For each packet in the channel
		for ( Packet packet : getPackets() ) {
			
			// If the packet is addressed to the access point
			if ( packet.getDestinationAddress().equals( address ) ) {		
				
				if ( authorisedClientAddresses.contains( packet.getSourceAddress() ) ) {
					
					// Respond to a normal packet
					sendPacket( new Packet( packet.getSourceAddress(), address ) );
					
				}
				
			}
			
		}
		
	}

}