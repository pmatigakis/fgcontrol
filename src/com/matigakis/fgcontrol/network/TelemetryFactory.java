package com.matigakis.fgcontrol.network;

/**
 * The TelemetryFactory is used to convert a telemetry String that was received from
 * flightgear into a Telemetry object.
 */
public class TelemetryFactory {
	
	/**
	 * Create a Telemetry object from a telemetry String.
	 * 
	 * @param data
	 * @return Telemetry object
	 */
	public Telemetry fromString(String data){
		String[] values = data.split("\t");
		
		Telemetry telemetry = new Telemetry();
		
		//GPS data
		telemetry.gpsAirspeed = Double.parseDouble(values[1]);
		telemetry.gpsAltitude = Double.parseDouble(values[0]);
		telemetry.latitude = Double.parseDouble(values[2]);
		telemetry.longitude = Double.parseDouble(values[3]);
		telemetry.gpsHeading = Double.parseDouble(values[4]);
		
		//Accelerometer data
		telemetry.xAcceleration = Double.parseDouble(values[5]);
		telemetry.yAcceleration = Double.parseDouble(values[6]);
		telemetry.zAcceleration = Double.parseDouble(values[7]);
		
		//Gyroscope data
		telemetry.xRotation = Double.parseDouble(values[8]);
		telemetry.yRotation = Double.parseDouble(values[9]);
		telemetry.zRotation = Double.parseDouble(values[10]);
		
		//Magnetometer data
		//TODO: add this
		
		//Atmospheric data
		telemetry.dynamicPressure = Double.parseDouble(values[12]);
		telemetry.staticPressure = Double.parseDouble(values[11]);
		telemetry.temperature = Double.parseDouble(values[13]);
		
		//orientation
		telemetry.roll = Double.parseDouble(values[14]);
		telemetry.pitch = Double.parseDouble(values[15]);
		
		//instrumentation
		telemetry.altitude = Double.parseDouble(values[16]);
		telemetry.airspeed = Double.parseDouble(values[17]);
		telemetry.heading = Double.parseDouble(values[18]);
		
		//simulation
		telemetry.simulationTime = Double.parseDouble(values[19]);
		
		//controls
		telemetry.elevator = Double.parseDouble(values[20]);
		telemetry.aileron = Double.parseDouble(values[21]);
		telemetry.rudder = Double.parseDouble(values[22]);
		telemetry.throttle = Double.parseDouble(values[23]);
		
		return telemetry;
	}
}
