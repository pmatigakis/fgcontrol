package com.matigakis.fgcontrol.fdm;

public class RemoteFDMConnectionException extends Exception{
	public RemoteFDMConnectionException(String message){
		super(message);
	}

	public RemoteFDMConnectionException(String message, Throwable cause){
		super(message, cause);
	}
}
