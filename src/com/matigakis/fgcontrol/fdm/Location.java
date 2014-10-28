package com.matigakis.fgcontrol.fdm;

public class Location {
	private double longitude;
	private double latitude;
	private double altitude;
	private double heading;
	private double airspeed;
	
	public Location(){
		longitude = 0.0;
		latitude = 0.0;
		altitude = 0.0;
		heading = 0.0;
		airspeed = 0.0;
	}
	
	public double getLongitude(){
		return longitude;
	}
	
	public double getLatitude(){
		return latitude;
	}
	
	public double getAltitude(){
		return altitude;
	}
	
	public double getHeading(){
		return heading;
	}
	
	public double getAirspeed(){
		return airspeed;
	}
	
	public void setLongitude(double longitude){
		this.longitude = longitude;
	}
	
	public void setLatitude(double latitude){
		this.latitude = latitude;
	}
	
	public void setAltitude(double altitude){
		this.altitude = altitude;
	}
	
	public void setAirspeed(double airspeed){
		this.airspeed = airspeed;
	}
	
	public void setHeading(double heading){
		this.heading = heading;
	}
}
