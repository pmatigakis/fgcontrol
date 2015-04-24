package com.matigakis.fgcontrol.console.network;

public interface ConsoleConnection {
	public void connect() throws ConsoleConnectionException;
	public void disconnect();
	public void send(String message);
	public boolean isConnected();
	public void addConsoleConnectionEventListener(ConsoleConnectionEventListener listener);
	public void removeConsoleConnectionEventListener(ConsoleConnectionEventListener listener);
}
