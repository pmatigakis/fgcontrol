package com.matigakis.fgcontrol.network;

/**
 * The FDMDataServer interface must be implemented by any class
 * that can receive fdm data that are transmitted by Flghtgear
 */
public interface FDMDataServer {
	/**
	 * Start the server
	 */
	void startServer() throws FDMServerException;
	
	/**
	 * Stop the server
	 */
	void stopServer() throws FDMServerException;
	
	/**
	 * Add an object that will be notified when an event from the
	 * fdm server has been raised
	 * 
	 * @param serverEventListener
	 */
	void addFDMDataServerEventListener(FDMDataServerEventListener serverEventListener);
	
	/**
	 * Remove an FDMDataServerEventListener
	 * 
	 * @param serverEventListener
	 */
	void removeFDMDataServerEventListener(FDMDataServerEventListener serverEventListener);
	
	/**
	 * Checks if the fdm server is running
	 * 
	 * @return true if the server is running
	 */
	public boolean isRunning();
}