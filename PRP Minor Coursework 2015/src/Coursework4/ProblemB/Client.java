package Coursework4.ProblemB;

/**
 * @author Martin
 *
 */
public class Client extends NetworkDevice {
	
	/**
	 * 
	 */
	private AccessPoint accessPoint;
	
	/**
	 * @param address
	 * @param network
	 * @param hashFunction - client knows hash function
	 * @param password
	 */
	public Client( String address, Network network, String key, HashFunction hashFunction ) {
		
		super( address, network, key, hashFunction );
		
	}
	
	/**
	 * @return
	 */
	public boolean connectedToAccessPoint() {
		
		return accessPoint != null;
		
	}
	
	/**
	 * Disconnects the client from am access point by 
	 * setting the record for the access point to null
	 */
	private void disconnectFromAccessPoint() {
		
		accessPoint = null;
		
	}
	
	/**
	 * Send a handshake packet to a accessPoint via their channel
	 * 
	 * @param accessPoint
	 * @return
	 */
	public boolean sendHandshakePacket( AccessPoint accessPoint ) {
		
		// This time hash the key, for security
		int keyHash = hashFunction.hash( key );
		
		// If the hash is accepted, send the packet
		if ( keyHash >= 0 ) {
			
			sendPacket( new HandshakePacket( accessPoint.getAddress(), address, keyHash ) );
			
			return true;
			
		}
		
		return false;
		
	}
	
	/**
	 * 
	 * @param accessPoint
	 * @return
	 */
	public boolean retrieveHandshakeResponse( AccessPoint accessPoint ) {
		
		for ( Packet packet : getPackets() ) {
		
			if ( packet.getDestinationAddress().equals( address ) && 
					
				 packet instanceof HandshakePacket && 
				 
				 hashFunction.hash( key ) == ((HandshakePacket)packet).getPasswordHash() ) {

						this.accessPoint = accessPoint;
						
						return true;
			
			}
		
		}
		
		return false;
		
	}
	

	/**
	 * In Problem B, 10% of the time, this client will disconnect rather
	 * than communicate, when asked to do so.
	 */
	public void communicate() {
		
		if ( Math.random() < 0.1 ) {
			
			System.out.println( this + " disconnects from access point." );
			
			disconnectFromAccessPoint();
		
		}
		
		if ( !connectedToAccessPoint() ) return;
		
		channel.addPacket( new Packet( accessPoint.getAddress(), address ) );

	}
	
}