package com.matigakis.fgcontrol.fdm;

/**
 * Contains position information
 */
public class Position {
	private double longitude;
	private double latitude;
	private double altitude;
	private double agl;
	
	public Position(){
		longitude = 0.0;
		latitude = 0.0;
		altitude = 0.0;
		agl = 0.0;
	}
	
	/**
	 * Get longitude in degrees
	 * @return longitude
	 */
	public double getLongitude(){
		return longitude;
	}
	
	/**
	 * Get latitude in degrees
	 * 
	 * @return latitude
	 */
	public double getLatitude(){
		return latitude;
	}
	
	/**
	 * Get altitude in feet
	 * 
	 * @return altitude
	 */
	public double getAltitude(){
		return altitude;
	}
	
	/**
	 * Get altitude above ground in feet
	 * 
	 * @return altitude above ground
	 */
	public double getAGL(){
		return agl;
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
	
	public void setAGL(double agl){
		this.agl = agl;
	}
}
