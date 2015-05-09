package com.matigakis.fgcontrol.console.network;

/**
 * The ConsoleConnection interface contains methods that must be
 * implemented by any object that can connect to Flightgear's
 * telnet console.
 */
public interface ConsoleConnection {
	/**
	 * Connect to Flightgear's console
	 * 
	 * @throws ConsoleConnectionException
	 */
	public void connect() throws ConsoleConnectionException;
	
	/**
	 * Disconnect from Flightgear's console
	 */
	public void disconnect();
	
	/**
	 * Send a command to Flightgear's console
	 * 
	 * @param message the command to send
	 */
	public void send(String message);
	
	/**
	 * Check if a connection to Flightgear's telnet console has been
	 * established
	 * 
	 * @return true if connected
	 */
	public boolean isConnected();
	
	/**
	 * Add an event listener
	 * 
	 * @param listener the event listener to add
	 */
	public void addConsoleConnectionEventListener(ConsoleConnectionEventListener listener);
	
	/**
	 * Remove an event listener
	 * 
	 * @param listener the event listener to remove
	 */
	public void removeConsoleConnectionEventListener(ConsoleConnectionEventListener listener);
}
