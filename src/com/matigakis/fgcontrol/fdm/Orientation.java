package com.matigakis.fgcontrol.fdm;

/**
 * Contains the orientations returned by the fdm
 * 
 * All attributes are in degrees
 */
public class Orientation {
	private double roll; //phi
	private double pitch; //theta
	private double heading; // yaw psi
	private double angleOfAttack; //alpha
	private double sideSlipAngle; // beta
	
	public Orientation(){
		roll = 0.0;
		pitch = 0.0;
		heading = 0.0;
	}
	
	public double getRoll(){
		return roll;
	}
	
	public double getPitch(){
		return pitch;
	}
	
	public double getAngleOfAttack(){
		return angleOfAttack;
	}
	
	public double getSideSlipAngle(){
		return sideSlipAngle;
	}
	
	public double getHeading(){
		return heading;
	}
	
	public void setHeading(double heading){
		this.heading = heading;
	}
	
	public void setRoll(double roll){
		this.roll = roll;
	}
	
	public void setPitch(double pitch){
		this.pitch = pitch;
	}
	
	public void setAngleOfAttach(double angleOfAttack){
		this.angleOfAttack = angleOfAttack;
	}
	
	public void setSideSlipAngle(double sideSlipAngle){
		this.sideSlipAngle = sideSlipAngle;
	}
}
