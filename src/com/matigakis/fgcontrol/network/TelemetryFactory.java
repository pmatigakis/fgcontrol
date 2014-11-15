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
	public static Telemetry fromString(String data){
		String[] values = data.split("\t");
		
		Telemetry telemetry = new Telemetry();
		
		//simulation
		telemetry.simulationTime = Double.parseDouble(values[0]);
				
		//position data
		telemetry.latitude = Double.parseDouble(values[1]);
		telemetry.longitude = Double.parseDouble(values[2]);
		telemetry.altitude = Double.parseDouble(values[3]);
		telemetry.altitudeAgl = Double.parseDouble(values[4]);
		
		//orientation
		telemetry.roll = Double.parseDouble(values[5]);
		telemetry.pitch = Double.parseDouble(values[6]);
		telemetry.heading = Double.parseDouble(values[7]);
		telemetry.angleOfAttack = Double.parseDouble(values[8]);
		telemetry.sideSlipAngle = Double.parseDouble(values[9]);
		
		//velocities
		telemetry.rollRate = Double.parseDouble(values[10]);
		telemetry.pitchRate = Double.parseDouble(values[11]);
		telemetry.yawRate = Double.parseDouble(values[12]);
		telemetry.airspeed = Double.parseDouble(values[13]);
		telemetry.climbRate = Double.parseDouble(values[14]);
		telemetry.northVelocity = Double.parseDouble(values[15]);
		telemetry.eastVelocity = Double.parseDouble(values[16]);
		telemetry.verticalVelocity = Double.parseDouble(values[17]);
		telemetry.u = Double.parseDouble(values[18]);
		telemetry.v = Double.parseDouble(values[19]);
		telemetry.w = Double.parseDouble(values[20]);
		
		//Accelerations
		telemetry.xAcceleration = Double.parseDouble(values[21]);
		telemetry.yAcceleration = Double.parseDouble(values[22]);
		telemetry.zAcceleration = Double.parseDouble(values[23]);
		
		//Atmospheric data
		telemetry.staticPressure = Double.parseDouble(values[24]);
		telemetry.totalPressure = Double.parseDouble(values[25]);
		telemetry.temperature = Double.parseDouble(values[26]);
		
		return telemetry;
	}
}
