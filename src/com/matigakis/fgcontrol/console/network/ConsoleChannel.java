package com.matigakis.fgcontrol.console.network;

public interface ConsoleChannel {
	public void connect() throws ConsoleChannelConnectionException;
	public void disconnect();
	public void send(String message);
	public boolean isConnected();
}
