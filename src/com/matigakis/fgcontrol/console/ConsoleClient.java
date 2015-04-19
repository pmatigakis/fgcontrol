package com.matigakis.fgcontrol.console;

import com.matigakis.fgcontrol.console.commands.Command;
import com.matigakis.fgcontrol.flightgear.Property;

public interface ConsoleClient {

	/**
	 * Connect to flightgear's telnet console
	 * 
	 * @throws ConsoleConnectionException
	 */
	public void connect() throws ConsoleConnectionException;

	/**
	 * Disconnect from Flightgear's telnet console
	 */
	public void disconnect();

	/**
	 * Set the value of a property on Flightgear's property tree
	 * 
	 * @param property
	 */
	public void setProperty(Property property);

	/**
	 * Run a command on Flighrgear's console 
	 * 
	 * @param command
	 */
	public void run(Command command);

	/**
	 * Check if the console client is connected to Flightgear
	 * 
	 * @return true if connected
	 */
	public abstract boolean isConnected();

	public void addConsoleClientEventListener(ConsoleClientEventListener listener);

	public void removeConsoleClientEventListener(ConsoleClientEventListener listener);

}