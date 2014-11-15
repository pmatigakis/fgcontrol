package com.matigakis.fgcontrol.fdm;

public interface RemoteFDMStateListener {
	void fdmUpdated(RemoteFDM fdm, FDMData fdmData);
}
