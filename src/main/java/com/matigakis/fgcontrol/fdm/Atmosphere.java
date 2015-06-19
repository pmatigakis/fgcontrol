package com.matigakis.fgcontrol.fdm;

public class Atmosphere {
	private double staticPressure;
	private double totalPressure;
	private double temperature;
	
	public Atmosphere(double staticPressure, double totalPressure, double temperature){
		this.staticPressure = staticPressure;
		this.totalPressure =totalPressure;
		this.temperature = temperature;
	}
	
	/**
	 * Get static pressure in inhg
	 * 
	 * @return
	 */
	public double getStaticPressure(){
		return staticPressure;
	}

	/**
	 * Get total pressure in inhg
	 * 
	 * @return
	 */
	public double getTotalPressure(){
		return totalPressure;
	}
	
	/**
	 * Get temperature in celsius
	 * 
	 * @return
	 */
	public double getTemperature(){
		return temperature;
	}
}
