package com.matigakis.fgcontrol;

public class SimulatorControlConnectionException extends Exception{
	private static final long serialVersionUID = 1L;

	public SimulatorControlConnectionException(){
		super();
	}
	
	public SimulatorControlConnectionException(String message){
		super(message);
	}
	
	public SimulatorControlConnectionException(String message, Throwable cause){
		super(message, cause);
	}
}
