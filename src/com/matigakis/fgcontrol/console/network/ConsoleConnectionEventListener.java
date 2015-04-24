package com.matigakis.fgcontrol.console.network;

public interface ConsoleConnectionEventListener {
	public void connectedToConsole(ConsoleConnection consoleConnection);
	public void disconnectedFromConsole(ConsoleConnection consoleConnection);
}
