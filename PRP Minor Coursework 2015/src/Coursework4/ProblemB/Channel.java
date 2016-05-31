package Coursework4.ProblemB;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Martin
 *
 */
public class Channel {

	/**
	 * 
	 */
	private int channelNumber;
	
	/**
	 * 
	 */
	private List<Packet> traffic;
	
	/**
	 * 
	 */
	public Channel( int channelNumber ) {
		
		this.channelNumber = channelNumber;
		
		traffic = new ArrayList<Packet>();
		
	}
	
	/**
	 * @param packet
	 */
	public void addPacket( Packet packet ) {
		
		if ( packet!= null ) { 
			
			traffic.add( packet );
			
			System.out.println( "Packet added to channel " + channelNumber + ": " + packet );
			
		}
		
	}
	
	/**
	 * @param packets
	 */
	public void addPackets( ArrayList<Packet> packets ) {
		
		if ( packets == null || packets.size() == 0 ) return;
		
		if ( packets.size() > 1 ) { 
			
			traffic.addAll(packets);
			
			System.out.println( "Packets added to channel " + channelNumber + ": " + packets );
			
		} else { 
			
			addPacket( packets.get(0) );
			
		}
		
	}
	
	/**
	 * @return
	 */
	public List<Packet> getTraffic() {
		
		return traffic;
		
	}
	
	/**
	 * 
	 */
	public void clearChannel() {
		
		traffic.clear();
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals( Object otherChannel ) {
		
		return channelNumber == ((Channel)otherChannel).channelNumber;
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		
		return "Channel " + channelNumber + " traffic: " + traffic;
		
	}

}
