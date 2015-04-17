package com.matigakis.fgcontrol;

import java.net.InetSocketAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.matigakis.fgcontrol.console.ConsoleClient;
import com.matigakis.fgcontrol.console.ConsoleClientEventListener;
import com.matigakis.fgcontrol.console.ConsoleConnectionException;
import com.matigakis.fgcontrol.console.commands.Pause;
import com.matigakis.fgcontrol.console.commands.Reset;

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
		if(isConnected()){
			LOGGER.debug("Disconnecting from Flightgear's console");
			
			consoleClient.disconnect();
			
			LOGGER.debug("Disconnected from Flightgear's console");
		}else{
			LOGGER.debug("Not connected to Flightgear's console");	
		}
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
	
	public void addConsoleClientEventListener(ConsoleClientEventListener listener){
		consoleClient.addConsoleClientEventListener(listener);
	}
	
	public void removeConsoleClientEventListener(ConsoleClientEventListener listener){
		consoleClient.removeConsoleClientEventListener(listener);
	}
}
