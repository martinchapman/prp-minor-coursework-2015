package Coursework4.ProblemA;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * @author Martin
 *
 */
public class NetworkDevice {

	/**
	 * Every network device has an address
	 */
	protected String address;
	
	/**
	 * Network devices can be in a channel
	 */
	protected Channel channel;
	
	/**
	 * Every network device has a key
	 */
	protected String key;
	
	/**
	 * @param address
	 * @param network
	 * @param key
	 */
	public NetworkDevice( String address, String key ) {
		
		this.address = address;
		
		this.key = key;
		
		// Print some information when a network device is created
		System.out.println( "Creating " + getClass().getSimpleName() + " with address " + address + ". Stored key: " + key );
		
	}
	
	/**
	 * Get the address of this device
	 * 
	 * @return
	 */
	public String getAddress() {
		
		return address;
		
	}
	
	/**
	 * Add this device to a channel
	 * 
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
	
	/**
	 * Get the key stored by this device
	 * 
	 * @return
	 */
	public String getKey() {
		
		return key;
		
	}
	
	/**
	 * @param packet
	 */
	protected void sendPacket( Packet packet ) {
		
		if ( packet != null ) {
		
			channel.addPacket( packet );
		
		}
		
	}
	
	/**
	 * @return
	 */
	protected List<Packet> getPackets() {
		
		return channel.getTraffic();
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * 
	 * Print some information about this device
	 */
	public String toString() {
		
		return getClass().getSimpleName() + "@" + address;
		
	}
	
}