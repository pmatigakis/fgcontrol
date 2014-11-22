package com.matigakis.fgcontrol.fdm;

public interface RemoteFDMStateListener {
	void connectedToRemoteFDM(RemoteFDM fdm);
	void disconnectedFromRemoteFDM(RemoteFDM fdm);
	void fdmDataReceived(RemoteFDM fdm, FDMData fdmData);
}
