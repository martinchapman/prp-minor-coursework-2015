package Coursework4.ProblemA;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Martin
 *
 */
public class Channel {

	/**
	 * Every channel has a number
	 */
	private int channelNumber;
	
	/**
	 * Channels contain a list of packets (traffic)
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
	 * Add a packet to a channel
	 * 
	 * @param packet
	 */
	public void addPacket( Packet packet ) {
		
		if ( packet != null ) { 
			
			traffic.add( packet );
			
			System.out.println( "Packet added to channel " + channelNumber + ": " + packet );
			
		}
		
	}
	
	/**
	 * Return the traffic currently in this channel
	 * 
	 * @return
	 */
	public List<Packet> getTraffic() {
		
		return new ArrayList<Packet>(traffic);
		
	}
	
	/**
	 * Clear the channel of all traffic
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
