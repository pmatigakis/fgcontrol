package com.matigakis.fgcontrol.console.network;

/**
 * The ConsoleConnectionEventListener must be implemented by any
 * class that has to be notified when a console connection has been
 * established or closed.
 */
public interface ConsoleConnectionEventListener {
	/**
	 * Raised when a connection to flightgear's console has been established
	 * 
	 * @param consoleConnection the ConsoleConnection object
	 */
	public void connectedToConsole(ConsoleConnection consoleConnection);
	
	/**
	 * Raised when a connection to flightgear's console has been closed.
	 * 
	 * @param consoleConnection the ConsoleConnection object
	 */
	public void disconnectedFromConsole(ConsoleConnection consoleConnection);
}
