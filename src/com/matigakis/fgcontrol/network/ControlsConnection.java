package com.matigakis.fgcontrol.network;

/**
 * The ControlsConnection interface must be implemented by
 * any object that can be used to transmit control surface data
 * to Flightgear.
 */
public interface ControlsConnection {
	public void connect() throws ControlsConnectionException;
	public void disconnect();
	public void addControlsConnectionEventListener(ControlsConnentionEventListener listener);
	public void removeControlsConnectionEventListener(ControlsConnentionEventListener listener);
	public boolean isConnected();
	public void writeControls(String controls);
}
