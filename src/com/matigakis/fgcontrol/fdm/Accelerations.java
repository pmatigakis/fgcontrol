package com.matigakis.fgcontrol.fdm;

public class Accelerations {
	private double xAcc;
	private double yAcc;
	private double zAcc;
	
	private double xRot;
	private double yRot;
	private double zRot;
	
	public Accelerations(){
		xAcc = 0.0;
		yAcc = 0.0;
		zAcc = 0.0;
		
		xRot = 0.0;
		yRot = 0.0;
		zRot = 0.0;
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
	
	public double getRollRate(){
		return xRot;
	}
	
	public double getPitchRate(){
		return yRot;
	}
	
	public double getYawRate(){
		return zRot;
	}
	
	public void setRollRate(double rollRate){
		xRot = rollRate;
	}
	
	public void setPitchRate(double pitchRate){
		yRot = pitchRate;
	}
	
	public void setYawRate(double yawRate){
		zRot = yawRate;
	}
}
