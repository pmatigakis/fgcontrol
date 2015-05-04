package com.matigakis.fgcontrol.network;

public class ControlsConnectionException extends Exception{
	private static final long serialVersionUID = 1L;

	public ControlsConnectionException(){
		super();
	}
	
	public ControlsConnectionException(String message){
		super(message);
	}
	
	public ControlsConnectionException(String message, Throwable cause){
		super(message, cause);
	}
}
