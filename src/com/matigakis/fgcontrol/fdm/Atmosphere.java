package com.matigakis.fgcontrol.fdm;

public class Atmosphere {
	private double staticPressure;
	private double pitotTubePressure;
	private double temperature;
	
	public Atmosphere(){
		staticPressure = 0.0;
		pitotTubePressure = 0.0;
		temperature = 0.0;
	}
	
	public double getStaticPressure(){
		return staticPressure;
	}
	
	public double getPitotTubePressure(){
		return pitotTubePressure;
	}
	
	public double getTemperature(){
		return temperature;
	}
	
	public void setStaticPressure(double staticPressure){
		this.staticPressure = staticPressure;
	}
	
	public void setPitotTubePressure(double pitotTubePressure){
		this.pitotTubePressure = pitotTubePressure;
	}
	
	public void setTemperature(double temperature){
		this.temperature = temperature;
	}
}
