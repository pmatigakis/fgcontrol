package com.matigakis.fgcontrol;

import java.net.InetSocketAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.matigakis.fgcontrol.console.ConsoleClient;
import com.matigakis.fgcontrol.console.ConsoleConnectionException;

/**
 * The FGControl class is used to control Flightgear remotely.
 * 
 * At the moment it can only pause and reset Flightgear
 */
public class FGControl {
	private static final Logger LOGGER = LoggerFactory.getLogger(FGControl.class);
	private ConsoleClient consoleClient;
	
	public FGControl(InetSocketAddress address){
		consoleClient = new ConsoleClient(address);
	}
	
	/**
	 * Connect to Flightgear
	 * 
	 * @throws ConsoleConnectionException
	 */
	public void connect() throws ConsoleConnectionException{
		if(!isConnected()){
			LOGGER.debug("Connecting to Flightgear's console");
			
			consoleClient.connect();
		
			LOGGER.debug("Connected to Flightgear's console");
		}else{
			LOGGER.warn("Already connected to Flightgear's console");
		}
	}
	
	/**
	 * Disconnect from Flightgear
	 */
	public void disconnect(){
		LOGGER.debug("Disconnecting from Flightgear's console");
		
		consoleClient.disconnect();
			
		LOGGER.debug("Disconnected from Flightgear's console");
	}
	
	/**
	 * Pause/unpause Flightgear
	 */
	public void pause(){
		LOGGER.debug("Pausing/unpausing Flightgear");
		
		consoleClient.runCommand("pause");
	}
	
	/**
	 * Reset Flightgear
	 */
	public void reset(){
		LOGGER.debug("Reseting Flightgear");
		
		consoleClient.runCommand("reset");
	}
	
	public boolean isConnected(){
		return consoleClient.isConnected();
	}
}
