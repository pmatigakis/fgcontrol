package com.matigakis.fgcontrol.fdm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.matigakis.fgcontrol.network.ControlsClient;
import com.matigakis.fgcontrol.network.FDMDataListener;
import com.matigakis.fgcontrol.network.UDPFDMServer;
import com.matigakis.fgcontrol.network.FDMDataServer;

/**
 * The NetworkFDM class is used to receive data about the aircraft state
 * from Flightgear. It can also be used to modify the state of the aircraft
 * controls.
 */
public class NetworkFDM extends AbstractRemoteFDM implements FDMDataListener{
	private static Logger LOGGER = LoggerFactory.getLogger(NetworkFDM.class);
	
	private FDMDataServer fdmDataServer;
	private ControlsClient controlsClient;
	private boolean connected;
	
	public NetworkFDM(String host, int telemetryPort, int controlsPort){
		super();

		connected = false;
		
		fdmDataServer = new UDPFDMServer(telemetryPort);
		fdmDataServer.addFDMDataListener(this);
		
		controlsClient = new ControlsClient(host, controlsPort);
	}
	
	/**
	 * Connect to FlightGear
	 */
	@Override
	public void connect() throws InterruptedException{
		LOGGER.info("Connecting to the network FDM");
		
		if(!connected){
			fdmDataServer.startServer();
			controlsClient.openConnection();
			
			notifyConnectedToFDM(this);
			
			connected = true;
			
			LOGGER.info("Connected to the network fdm");
		}else{
			LOGGER.debug("Have already connected to the FDM");
		}
	}
	
	/**
	 * Disconnect from flightgear
	 */
	@Override
	public void disconnect(){
		LOGGER.info("Disconnecting from the network FDM");
		
		if(connected){
			fdmDataServer.stopServer();
			controlsClient.closeConnection();
			
			notifyDisconnectedFromFDM(this);
			
			connected = false;
			LOGGER.info("Disconnected from the network FDM");
		}else{
			LOGGER.debug("Already disconnected");
		}
	}
	
	/**
	 * Transmit the controls state to Flightgear
	 * 
	 * @param controls
	 */
	@Override
	public void transmitControls(Controls controls){
		controlsClient.transmitControls(controls);
	}
	
	@Override
	public void handleFDMData(FDMData fdmData) {
		this.fdmData = fdmData;
		
		notifyFDMDataReceived();
	}

	/**
	 * Return true if the NetworkFDM has connected to Flightgear
	 * 
	 * @return the state of the connection
	 */
	public boolean isConnected(){
		return connected;
	}
}
