package com.matigakis.fgcontrol.fdm;

public class FDMData{
	private double simulationTime;
	private Accelerations accelerations;
	private Orientation orientation;
	private Velocities velocities;
	private Location location;
	private Atmosphere atmosphere;
	private Controls controls;
	
	public FDMData(){
		simulationTime = 0.0;
		accelerations = new Accelerations();
		orientation = new Orientation();
		velocities = new Velocities();
		location = new Location();
		atmosphere = new Atmosphere();
		controls = new Controls();
	}
	
	public Accelerations getAccelerations(){
		return accelerations;
	}
	
	public Orientation getOrientation(){
		return orientation;
	}
	
	public Velocities getVelocities(){
		return velocities;
	}
	
	public Location getLocation(){
		return location;
	}
	
	public Atmosphere getAtmosphere(){
		return atmosphere;
	}
	
	public Controls getControls(){
		return controls;
	}
	
	public double getSimulationTime(){
		return simulationTime;
	}
	
	public void setSimulationTime(double simulationTime){
		this.simulationTime = simulationTime;
	}
}
