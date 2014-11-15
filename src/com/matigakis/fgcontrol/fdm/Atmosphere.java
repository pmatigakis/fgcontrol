package com.matigakis.fgcontrol.fdm;

public class Atmosphere {
	private double staticPressure;
	private double totalPressure;
	private double temperature;
	
	public Atmosphere(){
		staticPressure = 0.0;
		totalPressure = 0.0;
		temperature = 0.0;
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
	
	public void setStaticPressure(double staticPressure){
		this.staticPressure = staticPressure;
	}
	
	public void setTotalPressure(double totalPressure){
		this.totalPressure = totalPressure;
	}
	
	public void setTemperature(double temperature){
		this.temperature = temperature;
	}
}
