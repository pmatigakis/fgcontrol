package com.matigakis.fgcontrol.network;

/**
 * The GenericProtocolDataFactory is used to convert a generic protocol String 
 * that was received from flightgear into a GenericProtocolData object.
 */
public class GenericProtocolDataFactory {
	
	/**
	 * Create a GenericProtocolData object from a generic protocol String.
	 * 
	 * @param data
	 * @return GenericProtocolData object
	 */
	public static GenericProtocolData fromString(String data){
		String[] values = data.split("\t");
		
		GenericProtocolData genericProtocolData = new GenericProtocolData();
		
		//simulation
		genericProtocolData.simulationTime = Double.parseDouble(values[0]);
				
		//position data
		genericProtocolData.latitude = Double.parseDouble(values[1]);
		genericProtocolData.longitude = Double.parseDouble(values[2]);
		genericProtocolData.altitude = Double.parseDouble(values[3]);
		genericProtocolData.altitudeAgl = Double.parseDouble(values[4]);
		
		//orientation
		genericProtocolData.roll = Double.parseDouble(values[5]);
		genericProtocolData.pitch = Double.parseDouble(values[6]);
		genericProtocolData.heading = Double.parseDouble(values[7]);
		genericProtocolData.angleOfAttack = Double.parseDouble(values[8]);
		genericProtocolData.sideSlipAngle = Double.parseDouble(values[9]);
		
		//velocities
		genericProtocolData.rollRate = Double.parseDouble(values[10]);
		genericProtocolData.pitchRate = Double.parseDouble(values[11]);
		genericProtocolData.yawRate = Double.parseDouble(values[12]);
		genericProtocolData.airspeed = Double.parseDouble(values[13]);
		genericProtocolData.climbRate = Double.parseDouble(values[14]);
		genericProtocolData.northVelocity = Double.parseDouble(values[15]);
		genericProtocolData.eastVelocity = Double.parseDouble(values[16]);
		genericProtocolData.verticalVelocity = Double.parseDouble(values[17]);
		genericProtocolData.u = Double.parseDouble(values[18]);
		genericProtocolData.v = Double.parseDouble(values[19]);
		genericProtocolData.w = Double.parseDouble(values[20]);
		
		//Accelerations
		genericProtocolData.xAcceleration = Double.parseDouble(values[21]);
		genericProtocolData.yAcceleration = Double.parseDouble(values[22]);
		genericProtocolData.zAcceleration = Double.parseDouble(values[23]);
		
		//Atmospheric data
		genericProtocolData.staticPressure = Double.parseDouble(values[24]);
		genericProtocolData.totalPressure = Double.parseDouble(values[25]);
		genericProtocolData.temperature = Double.parseDouble(values[26]);
		
		//controls
		genericProtocolData.elevator = Double.parseDouble(values[27]);
		genericProtocolData.aileron= Double.parseDouble(values[28]);
		genericProtocolData.rudder = Double.parseDouble(values[29]);
		genericProtocolData.throttle = Double.parseDouble(values[30]);
		
		return genericProtocolData;
	}
}
