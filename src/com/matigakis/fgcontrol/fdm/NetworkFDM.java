package com.matigakis.fgcontrol.fdm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.matigakis.fgcontrol.network.ControlsClient;
import com.matigakis.fgcontrol.network.ControlsClientConnectionException;
import com.matigakis.fgcontrol.network.FDMDataListener;
import com.matigakis.fgcontrol.network.FDMServerException;
import com.matigakis.fgcontrol.network.UDPFDMServer;
import com.matigakis.fgcontrol.network.FDMDataServer;

/**
 * The NetworkFDM class is used to receive data about the aircraft state
 * from Flightgear. It can also be used to modify the state of the aircraft
 * controls.
 */
public class NetworkFDM extends AbstractRemoteFDM{
	private static Logger LOGGER = LoggerFactory.getLogger(NetworkFDM.class);
	
	private FDMDataServer fdmDataServer;
	private ControlsClient controlsClient;
	private boolean connected;
	
	public NetworkFDM(String host, int telemetryPort, int controlsPort){
		super();

		connected = false;
		
		fdmDataServer = new UDPFDMServer(telemetryPort);
		fdmDataServer.addFDMDataListener(new FDMDataListener() {
			
			@Override
			public void handleFDMData(FDMData fdmData) {
				setFDMData(fdmData);
			}
		});
		
		controlsClient = new ControlsClient(host, controlsPort);
	}
	
	/**
	 * Connect to FlightGear
	 */
	@Override
	public void connect() throws RemoteFDMConnectionException{
		if(!isConnected()){
			LOGGER.debug("Connecting to the network FDM");
			try{
				fdmDataServer.startServer();
				controlsClient.connect();
			}catch(FDMServerException e){
				LOGGER.error("Failed to connect to the FDM server", e);
				throw new RemoteFDMConnectionException("Failed to connect to the FDM server", e);
			} catch (ControlsClientConnectionException e) {
				LOGGER.error("Failed to connect to the controls server", e);
				throw new RemoteFDMConnectionException("Failed to connect to the controls server", e);
			}
			
			notifyConnectedToFDM(this);
			
			connected = true;
			
			LOGGER.debug("Connected to the network fdm");
		}else{
			LOGGER.debug("Have already connected to the FDM");
		}
	}
	
	/**
	 * Disconnect from flightgear
	 */
	@Override
	public void disconnect(){
		if(isConnected()){
			LOGGER.debug("Disconnecting from the network FDM");
			
			fdmDataServer.stopServer();
			controlsClient.disconnect();
			
			notifyDisconnectedFromFDM(this);
			
			connected = false;
			LOGGER.debug("Disconnected from the network FDM");
		}else{
			LOGGER.debug("Not connected");
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
	
	private void setFDMData(FDMData fdmData) {
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
