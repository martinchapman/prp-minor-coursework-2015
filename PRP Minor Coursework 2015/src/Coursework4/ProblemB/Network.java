package Coursework4.ProblemB;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Martin
 *
 */
public class Network {

	/**
	 * Channels in use by devices.
	 * 
	 * Also serves to authenticate devices.
	 * 
	 */
	private Map< NetworkDevice, Channel > deviceChannel;
	
	/**
	 * Record of number of channels
	 */
	private int channels;
	
	/**
	 * Maps each Client to the AccessPoint they were last connected to
	 */
	private Map< Client, AccessPoint > accessPointHistory;
	
	/**
	 * @param channel
	 */
	public Network() {
		
		deviceChannel = new HashMap< NetworkDevice, Channel >();
		
		channels = 0;
		
		accessPointHistory = new HashMap< Client, AccessPoint >();
		
	}
	
	/**
	 * @param accessPoint
	 * @param channel
	 */
	public void addAccessPoint( AccessPoint accessPoint ) {
		
		Channel newChannel = new Channel( channels++ );
		
		accessPoint.joinChannel( newChannel );
		
		deviceChannel.put( accessPoint, newChannel );
		
	}
	
	/**
	 * Performs a handshake between a client and an access point
	 * 
	 * @param client
	 * @param accessPoint
	 * @return
	 */
	public boolean handshake( Client client, AccessPoint accessPoint ) {
		
		System.out.println( "Handshaking " + client + " " + accessPoint );
		
		client.joinChannel( deviceChannel.get(accessPoint) );
		
		client.sendHandshakePacket( accessPoint );
			
		accessPoint.readPacketsFromChannel();
			
		if ( client.retrieveHandshakeResponse( accessPoint ) ) {
		
			if ( accessPointHistory.containsKey( client ) ) {
				
				System.out.println( "Handshake success " + client + " reconnects to " + accessPoint );
				
			} else {
				
				System.out.println( "Handshake success " + client + " connects to " + accessPoint );
				
				deviceChannel.put( client, deviceChannel.get(accessPoint) );
				
			}

			// Record the last access point connected to by the client 
			accessPointHistory.put( client , accessPoint );
			
			return true;
			
		}
		
		return false;
		
	}
	
	/**
	 * @return
	 */
	public List<Channel> channels() {
		
		return new ArrayList<Channel>(deviceChannel.values());
		
	}
	
	/**
	 * 
	 */
	public void clearChannels() {
		
		for ( Channel channel : deviceChannel.values() ) {
			
			channel.clearChannel();
			
		}

	}
	
	/**
	 * 
	 */
	public boolean networkActivity() {
		
		System.out.println("Network Activity");
		
		clearChannels();
		
		ArrayList<NetworkDevice> devices = new ArrayList<NetworkDevice>( deviceChannel.keySet() );
		
		Collections.sort( devices );
		
		for ( NetworkDevice networkDevice : devices ) {
			
			// If a client is not connected...
			if ( networkDevice instanceof Client && !((Client)networkDevice).connectedToAccessPoint() ) {
				
				deviceChannel.remove( networkDevice );
				
				// ..perform another handshake to automatically reconnect the devices
				handshake( (Client)networkDevice, accessPointHistory.get(networkDevice) );
				
			} else {
				
				networkDevice.communicate();
				
			}
			
		}
		
		return true;
		
	}

}