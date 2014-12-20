package com.matigakis.fgcontrol.fdm;

public class RemoteFDMConnectionException extends Exception{
	private static final long serialVersionUID = 1L;

	public RemoteFDMConnectionException(String message){
		super(message);
	}

	public RemoteFDMConnectionException(String message, Throwable cause){
		super(message, cause);
	}
}
