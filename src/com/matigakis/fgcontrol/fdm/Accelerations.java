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
	
	public Accelerations(){
		xAcc = 0.0;
		yAcc = 0.0;
		zAcc = 0.0;
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
	
	public void setXAcceleration(double acceleration){
		xAcc = acceleration;
	}
	
	public void setYAcceleration(double acceleration){
		yAcc = acceleration;
	}
	
	public void setZAcceleration(double acceleration){
		zAcc = acceleration;
	}
}
