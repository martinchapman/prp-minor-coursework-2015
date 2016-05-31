package Coursework4.ProblemB;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Martin
 *
 */
public class AccessPoint extends NetworkDevice {

	/**
	 * 
	 */
	List<String> authorisedClientAddresses;
	
	/**
	 * @param address
	 * @param network
	 * @param channel
	 * @param key
	 * @param hashFunction AccessPoint knows hash function
	 */
	public AccessPoint( String address, Network network, String key, HashFunction hashFunction ) {
		
		super( address, network, key, hashFunction );
		
		authorisedClientAddresses = new ArrayList<String>();
		
	}

	/**
	 * 
	 */
	public void readPacketsFromChannel() {
		
		ArrayList<Packet> returnPackets = new ArrayList<Packet>();
		
		for ( Packet packet : channel.getTraffic() ) {
			
			if ( packet.getDestinationAddress().equals( address ) ) {		
				
				if ( packet instanceof HandshakePacket ) {

					HandshakePacket handshakePacket = new HandshakePacket( packet.getSourceAddress(), address, ((HandshakePacket)packet).getPasswordHash() );
					
					if ( hashFunction.hash( key ) == ((HandshakePacket)packet).getPasswordHash() && Collections.frequency( channel.getTraffic(), handshakePacket ) == 0 ) {
					
						returnPackets.add( handshakePacket );
						
					}
					
					authorisedClientAddresses.add( packet.getSourceAddress() );
				
				} else if ( authorisedClientAddresses.contains( packet.getSourceAddress() ) ) {
					
					returnPackets.add( new Packet( packet.getSourceAddress(), address ) );
					
				}
				
			}
			
		}
		
		channel.addPackets( returnPackets );
		
	}
	
	/**
	 * 
	 */
	public void communicate() {
		
		readPacketsFromChannel();
		
	}

}