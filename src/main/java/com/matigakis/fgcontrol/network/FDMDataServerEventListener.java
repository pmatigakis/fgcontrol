package com.matigakis.fgcontrol.network;

import com.matigakis.fgcontrol.fdm.FDMData;

/**
 * The FDMDataServerEventListener interface must be implemented by
 * every object that has to be able to receive fdm data and events
 * from the fdm data servers.
 */
public interface FDMDataServerEventListener{
	/**
	 * The FDMDataServerStarted method is called when the fdm data server
	 * if started.
	 * 
	 * @param fdmDataServer the FDMDataServer that was started
	 */
	public void FDMDataServerStarted(FDMDataServer fdmDataServer);
	
	/**
	 * The FDMDataServerShutdown is called when the fdm data server is
	 * stopped.
	 * 
	 * @param fdmDataServer the FDMDataServer that was stopped
	 */
	public void FDMDataServerShutdown(FDMDataServer fdmDataServer);
	
	/**
	 * The FDMDataReceived method is called when new fdm data have been
	 * received.
	 * 
	 * @param fdmDataServer the FDMDataServer that received the data
	 * @param fdmData the FDMData that were received
	 */
	public void FDMDataReceived(FDMDataServer fdmDataServer, FDMData fdmData);
}
