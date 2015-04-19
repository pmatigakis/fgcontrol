package com.matigakis.fgcontrol;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.matigakis.fgcontrol.console.ConsoleClient;
import com.matigakis.fgcontrol.console.ConsoleConnectionException;
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
	 * @throws ConsoleConnectionException
	 */
	public void connect() throws ConsoleConnectionException{
		LOGGER.debug("Connecting to Flightgear's console");
			
		consoleClient.connect();
		
		LOGGER.debug("Connected to Flightgear's console");
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
	
	public boolean isConnected(){
		return consoleClient.isConnected();
	}
}
