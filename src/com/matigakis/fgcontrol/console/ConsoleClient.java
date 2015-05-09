package com.matigakis.fgcontrol.console;

import com.matigakis.fgcontrol.console.commands.Command;
import com.matigakis.fgcontrol.console.commands.SetPropertyCommand;
import com.matigakis.fgcontrol.console.network.ConsoleConnection;
import com.matigakis.fgcontrol.console.network.ConsoleConnectionException;
import com.matigakis.fgcontrol.flightgear.Property;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The ConsoleClient class is used to execute commands on Flightgear's
 * console
 */
public class ConsoleClient{
	private static Logger LOGGER = LoggerFactory.getLogger(ConsoleClient.class);
	
	private ConsoleConnection consoleConnection;
	
	public ConsoleClient(ConsoleConnection consoleConnection){
		this.consoleConnection = consoleConnection;
	}
	
	/**
	 * Connect to Flightgear's console
	 * 
	 * @throws ConsoleClientConnectionException
	 */
	public void connect() throws ConsoleClientConnectionException{
		LOGGER.debug("Connecting to Flightgear's console");
		
		if(!isConnected()){
			try{
				consoleConnection.connect();
				
				LOGGER.debug("Connected to Flightgear's console");
			}catch(ConsoleConnectionException e){
				LOGGER.error("Failed to connect to Flightgear's console", e);
				throw new ConsoleClientConnectionException("Failed to connect to Flightgear's console", e);
			}
		}else{
			LOGGER.debug("Already connected to flightgear's console");
		}
	}
	
	/**
	 * Disconnect from Flightgear's console
	 */
	public void disconnect(){
		LOGGER.debug("Disconnecting from Flightgear's console");
		
		if(isConnected()){
			consoleConnection.disconnect();
			
			LOGGER.debug("Disconnected from Flightgear's console");
		}else{
			LOGGER.debug("Already disconnected from Flightgear's console");
		}
	}
	
	/**
	 * Set a property using Flightgear's console.
	 * 
	 * @param property the property to set
	 */
	public void setProperty(Property property){
		SetPropertyCommand command = new SetPropertyCommand(property);
		
		consoleConnection.send(command.asCommandString());
	}
	
	/**
	 * Run a command on the console.
	 * 
	 * @param command the command to run
	 */
	public void run(Command command){
		consoleConnection.send(command.asCommandString());
	}
	
	/**
	 * Check if we are connected to Flightgear's console
	 */
	public boolean isConnected(){
		return consoleConnection.isConnected();
	}
}
