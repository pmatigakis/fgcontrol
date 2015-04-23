package com.matigakis.fgcontrol.console;

import java.net.InetSocketAddress;

import com.matigakis.fgcontrol.console.commands.Command;
import com.matigakis.fgcontrol.console.commands.SetPropertyCommand;
import com.matigakis.fgcontrol.console.network.ConsoleChannel;
import com.matigakis.fgcontrol.console.network.ConsoleChannelConnectionException;
import com.matigakis.fgcontrol.console.network.TelnetConsoleChannel;
import com.matigakis.fgcontrol.flightgear.Property;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The ConsoleClient class is used to execute commands on Flightgear's
 * telnet console
 */
public class TelnetConsoleClient implements ConsoleClient {
	private static Logger LOGGER = LoggerFactory.getLogger(TelnetConsoleClient.class);
	
	private ConsoleClientHandler consoleClientHandler;
	private ConsoleChannel consoleChannel;
	
	public TelnetConsoleClient(InetSocketAddress address){
		consoleClientHandler = new ConsoleClientHandler(this);
		consoleChannel = new TelnetConsoleChannel(address, consoleClientHandler);
	}
	
	/**
	 * Connect via telnet to Flightgear's console
	 */
	@Override
	public void connect() throws ConsoleConnectionException{
		LOGGER.debug("Connection to Flightgear's console");
		
		try{
			consoleChannel.connect();
			
			LOGGER.debug("Connected to Flightgear's console");
		}catch(ConsoleChannelConnectionException e){
			LOGGER.error("Failed to connect to Flightgear's console", e);
			throw new ConsoleConnectionException("Failed to connect to Flightgear's console", e);
		}
	}
	
	/**
	 * Disconnect from Flightgear's telnet console
	 */
	@Override
	public void disconnect(){
		LOGGER.debug("Disconnecting from Flightgear's console");
		
		consoleChannel.disconnect();
		
		LOGGER.debug("Disconnected from Flightgear's console");
	}
	
	/**
	 * Set a property usin Flightgear's telnet console.
	 * 
	 * @param property the property to set
	 */
	@Override
	public void setProperty(Property property){
		SetPropertyCommand command = new SetPropertyCommand(property);
		
		consoleChannel.send(command.asCommandString());
	}
	
	/**
	 * Run a command on the console.
	 * 
	 * @param command the command to run
	 */
	@Override
	public void run(Command command){
		consoleChannel.send(command.asCommandString());
	}
	
	/**
	 * Check if we are connected to Flightgear's telnet console
	 */
	@Override
	public boolean isConnected(){
		return consoleChannel.isConnected();
	}
	
	/**
	 * Add an event listener for the events raised by the ConsoleCLient.
	 * 
	 * @param listener the event listener to add
	 */
	@Override
	public void addConsoleClientEventListener(ConsoleClientEventListener listener){
		consoleClientHandler.addConsoleClientEventListener(listener);
	}
	
	/**
	 * Remove an event listener.
	 * 
	 * @param listener the event listener to remove
	 */
	@Override
	public void removeConsoleClientEventListener(ConsoleClientEventListener listener){
		consoleClientHandler.removeConsoleClientEventListener(listener);
	}
}
