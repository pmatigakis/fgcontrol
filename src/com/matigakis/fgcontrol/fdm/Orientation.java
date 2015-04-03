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
	
	public Orientation(double roll, double pitch, double heading, 
					   double angleOfAttack, double sideslipAngle){
		this.roll = roll;
		this.pitch = pitch;
		this.heading = heading;
		this.angleOfAttack = angleOfAttack;
		this.sideSlipAngle = sideslipAngle;
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
}
