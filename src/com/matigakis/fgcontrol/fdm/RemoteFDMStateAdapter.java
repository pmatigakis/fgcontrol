package com.matigakis.fgcontrol.fdm;

public abstract class RemoteFDMStateAdapter implements RemoteFDMStateListener{
	@Override
	public void connectedToRemoteFDM(RemoteFDM fdm) {}
	
	@Override
	public void disconnectedFromRemoteFDM(RemoteFDM fdm) {}
	
	@Override
	public void fdmDataReceived(RemoteFDM fdm, FDMData fdmData) {}
}
