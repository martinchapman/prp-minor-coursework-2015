package Coursework4.ProblemA;

/**
 * A special type of packet containing a key.
 * 
 * @author Martin
 *
 */
public class HandshakePacket extends Packet {

	/**
	 * Every handshake packet contains a key
	 */
	private String key;
	
	/**
	 * @param destinationAddress
	 * @param sourceAddress
	 */
	public HandshakePacket( String destinationAddress, String sourceAddress, String key ) {
		
		super( destinationAddress, sourceAddress );
		
		this.key = key;
		
	}
	
	/**
	 * Get this key associated with this packet
	 * 
	 * @return
	 */
	public String getKey() {
		
		return key;
		
	}

}
