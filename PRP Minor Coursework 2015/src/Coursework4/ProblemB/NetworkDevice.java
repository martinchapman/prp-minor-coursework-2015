package Coursework4.ProblemB;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * @author Martin
 *
 */
public abstract class NetworkDevice implements Comparable<NetworkDevice> {

	/**
	 * 
	 */
	protected String address;
	
	/**
	 * @return
	 */
	public String getAddress() {
		
		return address;
		
	}
	
	/**
	 * 
	 */
	protected Network network;
	
	/**
	 * 
	 */
	protected Channel channel;
	
	/**
	 * 
	 */
	protected HashFunction hashFunction;
	
	/**
	 * 
	 */
	protected String key;
	
	/**
	 * @return
	 */
	public String getKey() {
		
		return key;
		
	}
	
	/**
	 * @param address
	 * @param network
	 * @param hashFunction
	 * @param password
	 */
	public NetworkDevice( String address, Network network, String key, HashFunction hashFunction ) {
		
		this.address = address;
		
		this.network = network;
		
		this.key = key;
		
		System.out.println( "Creating " + getClass().getSimpleName() + " with address " + address + ". Stored key: " + key );
		
		this.hashFunction = hashFunction;
		
	}
	
	/**
	 * @param packet
	 */
	protected void sendPacket( Packet packet ) {
		
		if ( packet == null ) return;
		
		channel.addPacket( packet );
		
	}
	
	/**
	 * @param packets
	 */
	protected void sendPackets( ArrayList<Packet> packets ) {
		
		if ( packets.size() == 0 ) return;
		
		channel.addPackets( packets );
	}
	
	/**
	 * @return
	 */
	protected List<Packet> getPackets() {
		
		return channel.getTraffic();
		
	}
	
	/**
	 * @param channel
	 */
	public void joinChannel( Channel channel ) {
		
		this.channel = channel;
		
	}
	
	/**
	 * 
	 */
	public void disconnectFromChannel() {
		
		channel = null;
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		
		return getClass().getSimpleName() + "@" + address;
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo( NetworkDevice networkDevice ) {
		
		if ( this instanceof Client && networkDevice instanceof AccessPoint ) {
			
			return -1;
			
		} else if ( this instanceof AccessPoint && networkDevice instanceof Client ) {
			
			return 1;
			
		} else {
			
			return 0;
			
		}
	
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals( Object otherDevice ) {
		
		return address.equals(((NetworkDevice)otherDevice).address);
		
	}
	
	/**
	 * 
	 */
	public abstract void communicate();
	
}