package com.matigakis.fgcontrol.fdm;

//import com.matigakis.fgcontrol.sensors.SensorData;

/**
 * The Controls object holds the state of the aircraft's controls.
 */
public class Controls {
	protected double aileron;
	protected double elevator;
	protected double rudder;
	protected double throttle;
	
	public Controls(double aileron, double elevator, double rudder, double throttle){
		this.aileron = aileron;
		this.elevator = elevator;
		this.rudder = rudder;
		this.throttle = throttle;
	}
	
	/**
	 * Get the aileron state. 
	 * 
	 * 1.0 and -1.0 means full deflection where 0.0 means no deflection.  
	 * 
	 * @return aileron state
	 */
	public double getAileron(){
		return aileron;
	}
	
	/**
	 * Get the elevator state. 
	 * 
	 * 1.0 means full upward elevator and -1.0 means full downward elevator.
	 * 
	 * @return elevator state
	 */
	public double getElevator(){
		return elevator;
	}
	
	/**
	 * Get the rudder state. 
	 * 
	 * 1.0 means full rudder right and -1.0 means full rudder left.
	 * 
	 * @return rudder state
	 */
	public double getRudder(){
		return rudder;
	}
	
	/**
	 * Get the throttle state. 
	 * 
	 * 0.0 means throttle closed and 1.0 means full throttle.
	 * 
	 * @return
	 */
	public double getThrottle(){
		return throttle;
	}
}
