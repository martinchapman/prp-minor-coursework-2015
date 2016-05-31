package Coursework4.ProblemB;

/**
 * @author Martin
 *
 */
public class HandshakePacket extends Packet {

	/**
	 * 
	 */
	private int passwordHash;
	
	/**
	 * @param destinationAddress
	 * @param sourceAddress
	 * @param passwordHash
	 */
	public HandshakePacket( String destinationAddress, String sourceAddress, int passwordHash ) {
		
		super( destinationAddress, sourceAddress );
		
		this.passwordHash = passwordHash;
		
	}
	
	/**
	 * @return
	 */
	public int getPasswordHash() {
		
		return passwordHash;
		
	}

}
