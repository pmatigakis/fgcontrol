package com.matigakis.fgcontrol.network;

import com.matigakis.fgcontrol.fdm.FDMData;

public class FDMDataServerEventListenerAdapter implements FDMDataServerEventListener{
	@Override
	public void FDMDataServerStarted(FDMDataServer fdmDataServer) {}

	@Override
	public void FDMDataServerShutdown(FDMDataServer fdmDataServer) {}

	@Override
	public void FDMDataReceived(FDMDataServer fdmDataServer, FDMData fdmData) {}
}
