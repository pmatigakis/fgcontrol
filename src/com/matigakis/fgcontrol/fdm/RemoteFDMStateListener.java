package com.matigakis.fgcontrol.fdm;

/**
 * The RemoteFDMStateListener interface nust be implemented be any object
 * that needs to be notified when an event is raised by a RemoteFDM
 */
public interface RemoteFDMStateListener {
	/**
	 * Connected to the remote FDM
	 * 
	 * @param fdm
	 */
	void connectedToRemoteFDM(RemoteFDM fdm);
	
	/**
	 * Disconnected from FDM
	 * 
	 * @param fdm
	 */
	void disconnectedFromRemoteFDM(RemoteFDM fdm);
	
	/**
	 * FDMData received from the FDM
	 * 
	 * @param fdm
	 * @param fdmData
	 */
	void fdmDataReceived(RemoteFDM fdm, FDMData fdmData);
}
