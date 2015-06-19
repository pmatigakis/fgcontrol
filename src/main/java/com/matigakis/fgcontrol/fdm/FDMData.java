package com.matigakis.fgcontrol.fdm;

public class FDMData{
	private double simulationTime;
	private Accelerations accelerations;
	private Velocities velocities;
	private Position position;
	private Orientation orientation;
	private Atmosphere atmosphere;
	private Controls controls;
	
	public FDMData(double simulationTime, Accelerations accelerations,
			       Velocities velocities, Position position,
			       Orientation orientation, Atmosphere atmosphere,
			       Controls controls){
		this.simulationTime = simulationTime;
		this.accelerations = accelerations;
		this.velocities = velocities;
		this.position = position;
		this.orientation = orientation;
		this.atmosphere = atmosphere;
		this.controls = controls;
	}
	
	public Accelerations getAccelerations(){
		return accelerations;
	}
	
	public Velocities getVelocities(){
		return velocities;
	}
	
	public Position getPosition(){
		return position;
	}
	
	public Orientation getOrientation(){
		return orientation;
	}
	
	public Atmosphere getAtmosphere(){
		return atmosphere;
	}
	
	public double getSimulationTime(){
		return simulationTime;
	}
	
	public Controls getControls(){
		return controls;
	}
}
