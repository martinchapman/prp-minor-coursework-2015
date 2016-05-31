package Coursework4.ProblemB;

/**
 * @author Martin
 *
 */
public class Packet {

	/**
	 * 
	 */
	private String destinationAddress;
	
	/**
	 * 
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
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 * 
	 * Equals shown here as an example -- not necessarily intuitive functionality
	 */
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
