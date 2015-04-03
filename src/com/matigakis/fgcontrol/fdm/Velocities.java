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
	
	public Velocities(double rollRate, double pitchRate, double yawRate,
			double calibratedAirspeed, double climbRate,
			double northVelocity, double eastVelocity, double verticalVelocity,
			double u, double v, double w){		
		this.rollRate = rollRate;
		this.pitchRate = pitchRate;
		this.yawRate = yawRate;
		this.calibratedAirspeed = calibratedAirspeed;
		this.climbRate = climbRate;
		this.northVelocity = northVelocity;
		this.eastVelocity = eastVelocity;
		this.verticalVelocity = verticalVelocity;
		this.u = u;
		this.v = v;
		this.w = w;
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
}
