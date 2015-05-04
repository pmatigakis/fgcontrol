package com.matigakis.fgcontrol.network;

public interface ControlsConnentionEventListener {
	public void connected(ControlsConnection controlsConnection);
	public void disconnected(ControlsConnection controlsConnection);
}
