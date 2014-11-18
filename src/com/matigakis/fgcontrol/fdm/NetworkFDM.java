package com.matigakis.fgcontrol.fdm;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.matigakis.fgcontrol.network.ControlsClient;
import com.matigakis.fgcontrol.network.Telemetry;
import com.matigakis.fgcontrol.network.TelemetryListener;
import com.matigakis.fgcontrol.network.UDPTelemetryServer;
import com.matigakis.fgcontrol.network.TelemetryServer;

/**
 * The NetworkFDM class is used to receive data about the aircraft state
 * from Flightgear. It can also be used to modify the state of the aircraft
 * controls.
 */
public class NetworkFDM implements RemoteFDM, TelemetryListener{
	private static Logger LOGGER = LoggerFactory.getLogger(NetworkFDM.class);
	
	private FDMData fdmData;
	private List<RemoteFDMStateListener> stateListeners;
	private TelemetryServer telemetryServer;
	private ControlsClient controlsClient;
	private boolean connected;
	
	public NetworkFDM(String host, int telemetryPort, int controlsPort){
		fdmData = new FDMData();
		connected = false;
		
		stateListeners = new LinkedList<RemoteFDMStateListener>();
		
		telemetryServer = new UDPTelemetryServer(telemetryPort);
		telemetryServer.addTelemetryListener(this);
		
		controlsClient = new ControlsClient(host, controlsPort);
	}
	
	@Override
	public void addRemoteFDMStateListener(RemoteFDMStateListener client){
		stateListeners.add(client);
	}
	
	@Override
	public void removeRemoteFDMStateListener(RemoteFDMStateListener client){
		stateListeners.remove(client);
	}
	
	/**
	 * Connect to FlightGear
	 */
	@Override
	public void connect() throws InterruptedException{
		LOGGER.info("Connecting to the network FDM");
		
		if(!connected){
			telemetryServer.startServer();
			controlsClient.openConnection();
			
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
			telemetryServer.stopServer();
			controlsClient.closeConnection();
			
			connected = false;
			LOGGER.info("Disconnected from the network FDM");
		}else{
			LOGGER.debug("Already disconnected");
		}
	}
	
	@Override
	public void transmitControls(Controls controls){
		controlsClient.transmitControls(controls);
	}
	
	/**
	 * Notify the FDM listeners
	 */
	private void notifyFDMStateListeners(){
		for(RemoteFDMStateListener stateListener: stateListeners){
			stateListener.fdmUpdated(this, fdmData);
		}
	}

	@Override
	public void handleTelemetry(Telemetry telemetry) {
		fdmData = FDMDataFactory.fromTelemetry(telemetry);
		
		notifyFDMStateListeners();
	}

	@Override
	public FDMData getFDMData() {
		return fdmData;
	}
	
	/**
	 * Return true is the NetworkFDM has connected to Flightgear
	 * 
	 * @return the state of the connection
	 */
	public boolean isConnected(){
		return connected;
	}
}
