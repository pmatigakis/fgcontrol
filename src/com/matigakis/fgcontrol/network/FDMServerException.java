package com.matigakis.fgcontrol.network;

public class FDMServerException extends Exception{
	private static final long serialVersionUID = 1L;

	public FDMServerException(String message){
		super(message);
	}
	
	public FDMServerException(String message, Throwable cause){
		super(message, cause);
	}
}
