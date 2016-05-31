package Coursework4.ProblemA;

/**
 * @author Martin
 *
 */
public class Client extends NetworkDevice {
	
	/**
	 * The access point to which the client is currently connected
	 */
	private AccessPoint accessPoint;
	
	/**
	 * @param address
	 * @param network
	 * @param key
	 */
	public Client( String address, String key ) {
		
		super( address, key );
		
	}
	
	/**
	 * Send a handshake packet to a access point via their channel
	 * 
	 * @param accessPoint
	 * @return
	 */
	public void sendHandshakePacket( AccessPoint accessPoint ) {
		
		 sendPacket( new HandshakePacket( accessPoint.getAddress(), address, key ) );
		
	}
	
	/**
	 * Check if a handshake response packet exists in an access point's channel. 
	 * 
	 * @param accessPoint
	 * @return
	 */
	public boolean retrieveHandshakeResponse( AccessPoint accessPoint ) {
		
		// Looking through each packet in the access points channel
		for ( Packet packet : getPackets() ) {
		
			// If that packet is addressed for this client
			if ( packet.getDestinationAddress().equals( address ) &&		
				 
				 // and the packet is a handshake packet
				 packet instanceof HandshakePacket &&
			
				 // and the key in the packet matches the key held by the client
				 key.equals(((HandshakePacket)packet).getKey()) ) {

				        // Set the access point
						this.accessPoint = accessPoint;
						
						// Confirm handshake response
						return true;
			
			}
		
		}
		
		return false;
		
	}

	/**
	 * Normal communication adds packets to the current channel, which should
	 * be shared by the access point.
	 */
	public void sendPacketToChannel() {
		
		if ( accessPoint != null ) {
		
			sendPacket( new Packet( accessPoint.getAddress(), address ) );
		
		}

	}
	
}