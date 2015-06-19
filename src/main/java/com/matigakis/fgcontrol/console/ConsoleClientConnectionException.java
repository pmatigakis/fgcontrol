package com.matigakis.fgcontrol.console;

public class ConsoleClientConnectionException extends Exception{
	private static final long serialVersionUID = 1L;

	public ConsoleClientConnectionException(String message) {
		super(message);
	}
	
	public ConsoleClientConnectionException(String message, Throwable cause) {
		super(message, cause);
	}
}
