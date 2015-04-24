package com.matigakis.fgcontrol;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.matigakis.fgcontrol.console.ConsoleClient;
import com.matigakis.fgcontrol.console.ConsoleClientConnectionException;
import com.matigakis.fgcontrol.console.commands.Pause;
import com.matigakis.fgcontrol.console.commands.Reset;

/**
 * The SimulatorControl class is used to control Flightgear remotely.
 * 
 * At the moment it can only pause and reset Flightgear
 */
public class SimulatorControl {
	private static final Logger LOGGER = LoggerFactory.getLogger(SimulatorControl.class);
	
	private ConsoleClient consoleClient;
	
	public SimulatorControl(ConsoleClient consoleClient){
		this.consoleClient = consoleClient;
	}
	
	/**
	 * Connect to Flightgear
	 * 
	 * @throws ConsoleClientConnectionException
	 */
	public void connect() throws SimulatorControlConnectionException{
		LOGGER.debug("Connecting to Flightgear's console");
		
		try{
		consoleClient.connect();
		
		LOGGER.debug("Connected to Flightgear's console");
		}catch(ConsoleClientConnectionException e){
			LOGGER.error("Failled to connect to Flightgear's console", e);
			throw new SimulatorControlConnectionException("Failled to connect to Flightgear's console", e);
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
		
		consoleClient.run(new Pause());
	}
	
	/**
	 * Reset Flightgear
	 */
	public void reset(){
		LOGGER.debug("Reseting Flightgear");
		
		consoleClient.run(new Reset());
	}
	
	/**
	 * Checks if we are connected to Flightgear's console
	 * 
	 * @return true if connected else return false
	 */
	public boolean isConnected(){
		return consoleClient.isConnected();
	}
}
