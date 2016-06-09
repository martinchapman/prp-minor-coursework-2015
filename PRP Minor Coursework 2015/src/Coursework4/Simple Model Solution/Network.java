import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Network encapsulates a list of channels, controls handshaking
 * and simulates network activity by making all devices communicate.
 * 
 * @author Martin
 *
 */
public class Network {
	
	/**
	 * Channels in use by devices.
	 * 
	 * Also serves to authenticate clients.
	 * 
	 */
	private Map< NetworkDevice, Channel > deviceChannel;
	
	/**
	 * Record of number of channels
	 */
	private int channels;
	
	/**
	 * List of access points (this information could be
	 * derived from the deviceChannel map)
	 */
	private ArrayList<AccessPoint> accessPoints;
	
	/**
	 * List of clients (this information could be
	 * derived from the deviceChannel map)
	 */
	private ArrayList<Client> clients;
	
	/**
	 * @param channel
	 */
	public Network() {
		
		deviceChannel = new HashMap< NetworkDevice, Channel >();
		
		channels = 0;
		
		accessPoints = new ArrayList<AccessPoint>();
		
		clients = new ArrayList<Client>();
		
	}
	
	/**
	 * @param accessPoint
	 * @param channel
	 */
	public void addAccessPoint( AccessPoint accessPoint ) {
		
		Channel newChannel = new Channel( channels++ );
		
		accessPoint.joinChannel( newChannel );
		
		accessPoints.add( accessPoint );
		
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
		
		// 0. Join the client to the access point's channel (temporarily)
		client.joinChannel( deviceChannel.get(accessPoint) );
		
		// 1. Client sends handshake packet to access point
		client.sendHandshakePacket( accessPoint );
			
		// 2. Access point receives and sends back another handshake packet
		// 3. If send and receive complies add client to network and confirm handshake
		if ( accessPoint.retrieveHandshakePacket( client ) && client.retrieveHandshakeResponse( accessPoint ) ) {
			
			deviceChannel.put( client, deviceChannel.get(accessPoint) );
			
			clients.add(client);
			
			System.out.println( "Handshake success " + client + " connects to " + accessPoint );
			
			return true;
			
		} else {
		
			client.disconnectFromChannel();
			
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
	 * Clear all the channels
	 */
	public void clearChannels() {
		
		for ( Channel channel : deviceChannel.values() ) {
			
			channel.clearChannel();
			
		}

	}
	
	/**
	 * One 'burst' of network activity, within which each device
	 * is asked to communicate.
	 */
	public void networkActivity() {
		
		System.out.println("Activity burst:");
		
		// Burst of activity always starts with clearing all channels
		clearChannels();
		
		// All clients communicate
		for ( Client client : clients ) {
			
			client.sendPacketToChannel();
			
		}
		
		// All access points respond
		for ( AccessPoint accessPoint : accessPoints ) {
			
			accessPoint.retrievePackets();
			
		}
		
	}

}