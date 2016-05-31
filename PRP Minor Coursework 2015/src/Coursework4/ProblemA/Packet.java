package Coursework4.ProblemA;

/**
 * @author Martin
 *
 */
public class Packet {

	/**
	 * For which device the packet is intended
	 */
	private String destinationAddress;
	
	/**
	 * Which device sent the packet
	 */
	private String sourceAddress;
	
	/**
	 * @param destiantionAddress
	 * @param sourceAddress
	 */
	public Packet( String destinationAddress, String sourceAddress ) {
		
		this.destinationAddress = destinationAddress;
		
		this.sourceAddress = sourceAddress;
		
	}
	
	/**
	 * @return
	 */
	public String getDestinationAddress() {
		
		return destinationAddress;
		
	}
	
	/**
	 * @return
	 */
	public String getSourceAddress() {
		
		return sourceAddress;
		
	}
	
	public boolean equals( Object otherPacket ) {
		
		return this.sourceAddress.equals(((Packet)otherPacket).sourceAddress) && this.destinationAddress.equals(((Packet)otherPacket).destinationAddress);
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		
		return getClass().getSimpleName() + " (Source: " + sourceAddress + " Destination: " + destinationAddress + ")"; 
		
	}

}
