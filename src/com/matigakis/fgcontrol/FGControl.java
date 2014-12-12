package com.matigakis.fgcontrol;

import java.net.InetSocketAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.matigakis.fgcontrol.console.ConsoleClient;

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
	 * @throws InterruptedException
	 */
	public void connect() throws InterruptedException{
		LOGGER.info("Connecting to Flightgear's console");
		
		if(!isConnected()){
			consoleClient.connect();
		
			LOGGER.info("Connected to Flightgear's console");
		}else{
			LOGGER.warn("Already connected to Flightgear's console");
		}
	}
	
	/**
	 * Disconnect from Flightgear
	 */
	public void disconnect(){
		LOGGER.info("Disconnecting from Flightgear's console");
		
		if(isConnected()){
			consoleClient.disconnect();
			
			LOGGER.info("Disconnected from Flightgear's console");
		}else{
			LOGGER.warn("Not connected to Flightgear's console");
		}
	}
	
	/**
	 * Pause/unpause Flightgear
	 */
	public void pause(){
		LOGGER.info("Pausing/unpausing Flightgear");
		
		consoleClient.runCommand("pause");
	}
	
	/**
	 * Reset Flightgear
	 */
	public void reset(){
		LOGGER.info("Reseting Flightgear");
		
		consoleClient.runCommand("reset");
	}
	
	public boolean isConnected(){
		return consoleClient.isConnected();
	}
}
