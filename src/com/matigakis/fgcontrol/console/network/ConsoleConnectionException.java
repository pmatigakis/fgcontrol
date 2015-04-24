package com.matigakis.fgcontrol.console.network;

public class ConsoleConnectionException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public ConsoleConnectionException(){
		super();
	}
	
	public ConsoleConnectionException(String message){
		super(message);
	}
	
	public ConsoleConnectionException(String message, Throwable cause){
		super(message, cause);
	}
}
