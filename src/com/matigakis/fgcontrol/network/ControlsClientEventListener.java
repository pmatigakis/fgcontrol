package com.matigakis.fgcontrol.network;

public interface ControlsClientEventListener {
	public void connected(ControlsClient controlsClient);
	public void disconnected(ControlsClient controlsClient);
}
