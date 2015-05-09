package com.matigakis.fgcontrol.network;

/**
 * The ControlsConnection interface must be implemented by
 * any object that can be used to transmit control surface data
 * to Flightgear.
 */
public interface ControlsConnection {
	/**
	 * Connect to Flightgear's controls port
	 * 
	 * @throws ControlsConnectionException
	 */
	public void connect() throws ControlsConnectionException;
	
	/**
	 * Disconnect from Flightgear's controls port
	 */
	public void disconnect();
	
	/**
	 * Add an event listener
	 * 
	 * @param listener the event listener to add
	 */
	public void addControlsConnectionEventListener(ControlsConnentionEventListener listener);
	
	/**
	 * Remove an event listener
	 * 
	 * @param listener the event listener to remove
	 */
	public void removeControlsConnectionEventListener(ControlsConnentionEventListener listener);
	
	/**
	 * Check if a connection to Flightgear's console port has
	 * been established
	 * 
	 * @return true if connected
	 */
	public boolean isConnected();
	
	/**
	 * Send a string that contains the controls state
	 * 
	 * @param controls the string with the controls values
	 */
	public void writeControls(String controls);
}
