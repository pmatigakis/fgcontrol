package com.matigakis.fgcontrol.console;

public interface ConsoleClientEventListener {
	public void connectedToConsole(ConsoleClient consoleClient);
	public void disconnectedFromConsole(ConsoleClient consoleClient);
}
