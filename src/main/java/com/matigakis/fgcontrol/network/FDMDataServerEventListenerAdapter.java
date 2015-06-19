package com.matigakis.fgcontrol.network;

import com.matigakis.fgcontrol.fdm.FDMData;

/**
 * The FDMDataServerEventListenerAdapter is used to provide a simpler interface
 * to the FDMDataServer since it is not necessary to implement every method of
 * the FDMDataServerEventListener interface.
 */
public class FDMDataServerEventListenerAdapter implements FDMDataServerEventListener{
	@Override
	public void FDMDataServerStarted(FDMDataServer fdmDataServer) {}

	@Override
	public void FDMDataServerShutdown(FDMDataServer fdmDataServer) {}

	@Override
	public void FDMDataReceived(FDMDataServer fdmDataServer, FDMData fdmData) {}
}
