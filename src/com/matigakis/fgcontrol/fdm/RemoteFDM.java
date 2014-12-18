package com.matigakis.fgcontrol.fdm;

/**
 * The intefrace that must be implemented by any class that can be used
 * to connect to a remote flight dynamics model. (for example via sockets etc.)
 */
public interface RemoteFDM {
	/**
	 * Connect to the FDM
	 * 
	 * @throws InterruptedException
	 */
	void connect() throws RemoteFDMConnectionException;
	
	/**
	 * Disconnect from the FDM
	 */
	void disconnect();
	
	/**
	 * Send to the FDM the new control values
	 * 
	 * @param controls
	 */
	void transmitControls(Controls controls);
	
	/**
	 * Add an object that will be notified when new data have been
	 * received
	 * 
	 * @param listener
	 */
	void addRemoteFDMStateListener(RemoteFDMStateListener listener);
	
	/**
	 * Remove a state listener
	 * 
	 * @param listener
	 */
	void removeRemoteFDMStateListener(RemoteFDMStateListener listener);
	
	/**
	 * Get tha latest FDM data received
	 * @return
	 */
	FDMData getFDMData();
}
