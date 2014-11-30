package com.matigakis.fgcontrol.network;

/**
 * The FDMDataServer interface must be implemented by any class
 * that can receive fdm data that are transmitted by Flghtgear
 */
public interface FDMDataServer {
	/**
	 * Start the server
	 */
	void startServer();
	
	/**
	 * Stop the server
	 */
	void stopServer();
	
	/**
	 * Add an object that will be notified when new fdm data
	 * have been received
	 * 
	 * @param fdmDataListener
	 */
	void addFDMDataListener(FDMDataListener fdmDataListener);
	
	/**
	 * Remove an FDMDataListener
	 * 
	 * @param fdmDataListener
	 */
	void removeFDMDataListener(FDMDataListener fdmDataListener);
}