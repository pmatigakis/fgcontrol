package com.matigakis.fgcontrol.fdm;

public class Velocities {
	private double airspeed;
	
	public Velocities(){
		airspeed = 0.0;
	}
	
	public double getAirspeed(){
		return airspeed;
	}
	
	public void setAirspeed(double airspeed){
		this.airspeed = airspeed;
	}
}
