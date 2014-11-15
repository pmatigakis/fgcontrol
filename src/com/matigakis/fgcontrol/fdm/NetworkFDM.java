package com.matigakis.fgcontrol.fdm;

import java.util.LinkedList;
import java.util.List;

import com.matigakis.fgcontrol.network.ControlsClient;
import com.matigakis.fgcontrol.network.Telemetry;
import com.matigakis.fgcontrol.network.TelemetryListener;
import com.matigakis.fgcontrol.network.TelemetryServer;

public class NetworkFDM implements RemoteFDM, TelemetryListener{
	private List<RemoteFDMStateListener> stateListeners;
	private TelemetryServer telemetryServer;
	private ControlsClient controlsClient;
	
	public NetworkFDM(String host, int telemetryPort, int controlsPort){
		stateListeners = new LinkedList<RemoteFDMStateListener>();
		
		telemetryServer = new TelemetryServer(telemetryPort);
		telemetryServer.addTelemetryListener(this);
		
		controlsClient = new ControlsClient(host, controlsPort);
	}
	
	@Override
	public void addRemoteFDMStateListener(RemoteFDMStateListener client){
		stateListeners.add(client);
	}
	
	@Override
	public void removeRemoteFDMStateListener(RemoteFDMStateListener client){
		stateListeners.remove(client);
	}
	
	@Override
	public void connect() throws InterruptedException{
		telemetryServer.startServer();
		controlsClient.openConnection();
	}
	
	@Override
	public void disconnect(){
		telemetryServer.stopServer();
		controlsClient.closeConnection();
	}
	
	@Override
	public void transmitControls(Controls controls){
		controlsClient.transmitControls(controls);
	}
	
	private void notifyFDMStateListeners(FDMData fdmData){
		for(RemoteFDMStateListener stateListener: stateListeners){
			stateListener.fdmUpdated(this, fdmData);
		}
	}

	@Override
	public void handleTelemetry(Telemetry telemetry) {
		FDMData fdmData = FDMDataFactory.fromTelemetry(telemetry);
		
		notifyFDMStateListeners(fdmData);
	}
}
