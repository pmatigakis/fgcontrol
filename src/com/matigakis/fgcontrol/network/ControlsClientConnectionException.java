package com.matigakis.fgcontrol.network;

public class ControlsClientConnectionException extends Exception{
	private static final long serialVersionUID = 1L;

	public ControlsClientConnectionException(String message){
		super(message);
	}
	
	public ControlsClientConnectionException(String message, Throwable cause){
		super(message, cause);
	}
}
