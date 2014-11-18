package com.matigakis.fgcontrol.fdm;

public interface RemoteFDM {
	void connect() throws InterruptedException;
	void disconnect();
	void transmitControls(Controls controls);
	void addRemoteFDMStateListener(RemoteFDMStateListener listener);
	void removeRemoteFDMStateListener(RemoteFDMStateListener listener);
	FDMData getFDMData();
}
