package com.matigakis.fgcontrol.fdm;

/**
 * Contains the velocities returned by the fdm
 * 
 */
public class Velocities {
	private double rollRate; //phi dot deg/sec
	private double pitchRate; //theta dot deg/sec
	private double yawRate; //psi dot deg/sec
	private double calibratedAirspeed; //vcas
	private double climbRate; //fps
	private double northVelocity; //fps
	private double eastVelocity; //fps
	private double verticalVelocity; //fps
	private double u;
	private double v;
	private double w;
	
	public Velocities(){		
		rollRate = 0.0;
		pitchRate = 0.0;
		yawRate = 0.0;
		calibratedAirspeed = 0.0;
		climbRate = 0.0;
		northVelocity = 0.0;
		eastVelocity = 0.0;
		verticalVelocity = 0.0;
		u = 0.0;
		v = 0.0;
		w = 0.0;
	}
	
	/**
	 * Get roll rate in degrees per second
	 * 
	 * @return
	 */
	public double getRollRate(){
		return rollRate;
	}
	
	/**
	 * Get pitch rate in degrees per second
	 * 
	 * @return
	 */
	public double getPitchRate(){
		return pitchRate;
	}
	
	/**
	 * Get yaw rate in degrees per second
	 * 
	 * @return
	 */
	public double getYawRate(){
		return yawRate;
	}
	
	/**
	 * Get aispeed in knots
	 * 
	 * @return
	 */
	public double getCalibratedAirspeed(){
		return calibratedAirspeed;
	}
	
	/**
	 * Get climb rate in feet per second
	 * 
	 * @return
	 */
	public double getClimbRate(){
		return climbRate;
	}
	
	public double getNorthVelocity(){
		return northVelocity;
	}
	
	public double getEastVelocity(){
		return eastVelocity;
	}
	
	public double getVerticalVelocity(){
		return verticalVelocity;
	}
	
	public double getU(){
		return u;
	}
	
	public double getV(){
		return v;
	}
	
	public double getW(){
		return w;
	}
	
	public void setRollRate(double rollRate){
		this.rollRate = rollRate;
	}
	
	public void setPitchRate(double pitchRate){
		this.pitchRate = pitchRate;
	}
	
	public void setYawRate(double yawRate){
		this.yawRate = yawRate;
	}
	
	public void setCalibratedAirspeed(double calibratedAirspeed){
		this.calibratedAirspeed = calibratedAirspeed;
	}
	
	public void setClimbRate(double climbRate){
		this.climbRate = climbRate;
	}
	
	public void setNorthVelocity(double northVelocity){
		this.northVelocity = northVelocity;
	}
	
	public void setEastVelocity(double eastVelocity){
		this.eastVelocity = eastVelocity;
	}
	
	public void setVerticalVelocity(double verticalVelocity){
		this.verticalVelocity = verticalVelocity;
	}
	
	public void setU(double u){
		this.u = u;
	}
	
	public void setV(double v){
		this.v = v;
	}
	
	public void setW(double w){
		this.w = w;
	}
}
