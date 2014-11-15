package com.matigakis.fgcontrol.fdm;

public class FDMData{
	private double simulationTime;
	private Accelerations accelerations;
	private Velocities velocities;
	private Position position;
	private Orientation orientation;
	private Atmosphere atmosphere;
	
	public FDMData(){
		simulationTime = 0.0;
		accelerations = new Accelerations();
		velocities = new Velocities();
		position = new Position();
		orientation = new Orientation();
		atmosphere = new Atmosphere();
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
	
	public void setSimulationTime(double simulationTime){
		this.simulationTime = simulationTime;
	}
}
