package com.matigakis.fgcontrol.network;

import com.matigakis.fgcontrol.fdm.FDMData;

public interface FDMDataServerEventListener{
	public void FDMDataServerStarted(FDMDataServer fdmDataServer);
	public void FDMDataServerShutdown(FDMDataServer fdmDataServer);
	public void FDMDataReceived(FDMDataServer fdmDataServer, FDMData fdmData);
}
