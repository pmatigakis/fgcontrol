package com.matigakis.fgcontrol.fdm;

/**
 * Contains position information
 */
public class Position {
	private double longitude;
	private double latitude;
	private double altitude;
	private double agl;
	
	public Position(double longitude, double latitude, double altitude, double agl){
		this.longitude = longitude;
		this.latitude = latitude;
		this.altitude = altitude;
		this.agl = agl;
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
}
