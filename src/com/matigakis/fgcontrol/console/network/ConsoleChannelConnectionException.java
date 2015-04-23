package com.matigakis.fgcontrol.console.network;

public class ConsoleChannelConnectionException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public ConsoleChannelConnectionException(){
		super();
	}
	
	public ConsoleChannelConnectionException(String message){
		super(message);
	}
	
	public ConsoleChannelConnectionException(String message, Throwable cause){
		super(message, cause);
	}
}
