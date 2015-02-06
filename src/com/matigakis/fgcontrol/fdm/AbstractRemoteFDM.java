package com.matigakis.fgcontrol.fdm;

import java.util.LinkedList;
import java.util.List;

/**
 * Base class for all RemoteFDM objects 
 */
public abstract class AbstractRemoteFDM implements RemoteFDM{
	protected List<RemoteFDMStateListener> stateListeners;
	
	public AbstractRemoteFDM(){
		stateListeners = new LinkedList<RemoteFDMStateListener>();
	}
	
	@Override
	public void addRemoteFDMStateListener(RemoteFDMStateListener client) {
		stateListeners.add(client);
	}

	@Override
	public void removeRemoteFDMStateListener(RemoteFDMStateListener client) {
		stateListeners.remove(client);
	}
	
	protected void notifyConnectedToFDM(RemoteFDM fdm){
		for(RemoteFDMStateListener stateListener: stateListeners){
			stateListener.connectedToRemoteFDM(this);
		}
	}
	
	protected void notifyDisconnectedFromFDM(RemoteFDM fdm){
		for(RemoteFDMStateListener stateListener: stateListeners){
			stateListener.disconnectedFromRemoteFDM(this);
		}
	}
	
	/**
	 * Notify the FDM listeners that new fdm data have been received
	 */
	protected void notifyFDMDataReceived(FDMData fdmData){
		for(RemoteFDMStateListener stateListener: stateListeners){
			stateListener.fdmDataReceived(this, fdmData);
		}
	}
}