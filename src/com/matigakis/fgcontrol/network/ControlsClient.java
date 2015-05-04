package com.matigakis.fgcontrol.network;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.matigakis.fgcontrol.fdm.Controls;

/**
 * The ControlsClient class is responsible to transmit the state of an aircraft's
 * controls to Flightgear.
 */
public class ControlsClient {
	private static final Logger LOGGER = LoggerFactory.getLogger(ControlsClient.class);
	
	private ControlsConnection controlsConnection;
	
	public ControlsClient(ControlsConnection controlsConnection){
		this.controlsConnection = controlsConnection;
	}
	
	/**
	 * Open a connection to Flightgear
	 * 
	 * @throws ControlsClientConnectionException
	 */
	public void connect() throws ControlsClientConnectionException{
		if(!isConnected()){
			LOGGER.debug("Opening connection to controls server");
			
			try{
				controlsConnection.connect();
			}catch(ControlsConnectionException e){
				LOGGER.error("Failed to connect to controls port", e);
				
				throw new ControlsClientConnectionException("Failed to connect to controls port", e);
			}
			
			LOGGER.debug("Connected to Flightgear's controls server");
		}else{
			LOGGER.debug("Already connected to Flightgear's controls client");
		}
	}
	
	/**
	 * Close the connection
	 */
	public void disconnect(){
		LOGGER.debug("Closing connection to controls server");
		
		if(isConnected()){
			controlsConnection.disconnect();
			LOGGER.debug("Disconnected from controls server");
		}else{
			LOGGER.debug("Not connected to the controls server");
		}
	}
	
	/**
	 * Transmit the aircraft controls state to Flightgear
	 * 
	 * @param controls the aircraft controls
	 */
	public void transmitControls(Controls controls){
		String controlsString = controls.getElevator() + "\t" + controls.getAileron() + "\t" + controls.getRudder() + "\t" + controls.getThrottle() + "\n";
		
		controlsConnection.writeControls(controlsString);
	}
	
	/**
	 * Check if the client is connected
	 * 
	 * @return true if connected
	 */
	public boolean isConnected(){
		return controlsConnection.isConnected();
	}
}
