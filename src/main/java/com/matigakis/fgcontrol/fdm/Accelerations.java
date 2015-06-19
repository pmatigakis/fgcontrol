package com.matigakis.fgcontrol.fdm;

/**
 * Contains the accelerations measured by the fdm.
 * 
 * All accelerations are in feet/sec^2
 */
public class Accelerations {
	private double xAcc;
	private double yAcc;
	private double zAcc;
	
	public Accelerations(double xAcc, double yAcc, double zAcc){
		this.xAcc = xAcc;
		this.yAcc = yAcc;
		this.zAcc = zAcc;
	}
	
	public double getXAcceleration(){
		return xAcc;
	}
	
	public double getYAcceleration(){
		return yAcc;
	}
	
	public double getZAcceleration(){
		return zAcc;
	}
}
