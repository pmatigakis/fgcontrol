package com.matigakis.fgcontrol.fdm;

public class Orientation {
	private double roll;
	private double pitch;
	private double yaw;
	
	public Orientation(){
		roll = 0.0;
		pitch = 0.0;
		yaw = 0.0;
	}
	
	public double getRoll(){
		return roll;
	}
	
	public double getPitch(){
		return pitch;
	}
	
	public double getYaw(){
		return yaw;
	}
	
	public void setRoll(double roll){
		this.roll = roll;
	}
	
	public void setPitch(double pitch){
		this.pitch = pitch;
	}
	
	public void setYaw(double yaw){
		this.yaw = yaw;
	}
}
