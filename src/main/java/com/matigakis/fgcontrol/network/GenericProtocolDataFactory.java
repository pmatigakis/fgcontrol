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
		genericProtocolData.set(GenericProtocolData.SIMULATION_TIME, Double.parseDouble(values[GenericProtocolData.SIMULATION_TIME]));
				
		//position data
		genericProtocolData.set(GenericProtocolData.LATITUDE, Double.parseDouble(values[GenericProtocolData.LATITUDE]));
		genericProtocolData.set(GenericProtocolData.LONGITUDE, Double.parseDouble(values[GenericProtocolData.LONGITUDE]));
		genericProtocolData.set(GenericProtocolData.ALTITUDE, Double.parseDouble(values[GenericProtocolData.ALTITUDE]));
		genericProtocolData.set(GenericProtocolData.ALTITUDE_AGL, Double.parseDouble(values[GenericProtocolData.ALTITUDE_AGL]));
		
		//orientation
		genericProtocolData.set(GenericProtocolData.ROLL, Double.parseDouble(values[GenericProtocolData.ROLL]));
		genericProtocolData.set(GenericProtocolData.PITCH, Double.parseDouble(values[GenericProtocolData.PITCH]));
		genericProtocolData.set(GenericProtocolData.HEADING, Double.parseDouble(values[GenericProtocolData.HEADING]));
		genericProtocolData.set(GenericProtocolData.ANGLE_OF_ATTACK, Double.parseDouble(values[GenericProtocolData.ANGLE_OF_ATTACK]));
		genericProtocolData.set(GenericProtocolData.SIDESLIP_ANGLE, Double.parseDouble(values[GenericProtocolData.SIDESLIP_ANGLE]));
		
		//velocities
		genericProtocolData.set(GenericProtocolData.ROLL_RATE, Double.parseDouble(values[GenericProtocolData.ROLL_RATE]));
		genericProtocolData.set(GenericProtocolData.PITCH_RATE, Double.parseDouble(values[GenericProtocolData.PITCH_RATE]));
		genericProtocolData.set(GenericProtocolData.YAW_RATE, Double.parseDouble(values[GenericProtocolData.YAW_RATE]));
		genericProtocolData.set(GenericProtocolData.AIRSPEED, Double.parseDouble(values[GenericProtocolData.AIRSPEED]));
		genericProtocolData.set(GenericProtocolData.CLIMB_RATE, Double.parseDouble(values[GenericProtocolData.CLIMB_RATE]));
		genericProtocolData.set(GenericProtocolData.NORTH_VELOCITY, Double.parseDouble(values[GenericProtocolData.NORTH_VELOCITY]));
		genericProtocolData.set(GenericProtocolData.EAST_VELOCITY, Double.parseDouble(values[GenericProtocolData.EAST_VELOCITY]));
		genericProtocolData.set(GenericProtocolData.VERTICAL_VELOCITY, Double.parseDouble(values[GenericProtocolData.VERTICAL_VELOCITY]));
		genericProtocolData.set(GenericProtocolData.U, Double.parseDouble(values[GenericProtocolData.U]));
		genericProtocolData.set(GenericProtocolData.V, Double.parseDouble(values[GenericProtocolData.V]));
		genericProtocolData.set(GenericProtocolData.W, Double.parseDouble(values[GenericProtocolData.W]));
		
		//Accelerations
		genericProtocolData.set(GenericProtocolData.X_ACCELERATION, Double.parseDouble(values[GenericProtocolData.X_ACCELERATION]));
		genericProtocolData.set(GenericProtocolData.Y_ACCELERATION, Double.parseDouble(values[GenericProtocolData.Y_ACCELERATION]));
		genericProtocolData.set(GenericProtocolData.Z_ACCELERATION, Double.parseDouble(values[GenericProtocolData.Z_ACCELERATION]));
		
		//Atmospheric data
		genericProtocolData.set(GenericProtocolData.STATIC_PRESSURE, Double.parseDouble(values[GenericProtocolData.STATIC_PRESSURE]));
		genericProtocolData.set(GenericProtocolData.TOTAL_PRESSURE, Double.parseDouble(values[GenericProtocolData.TOTAL_PRESSURE]));
		genericProtocolData.set(GenericProtocolData.TEMPERATURE, Double.parseDouble(values[GenericProtocolData.TEMPERATURE]));
		
		//controls
		genericProtocolData.set(GenericProtocolData.ELEVATOR, Double.parseDouble(values[GenericProtocolData.ELEVATOR]));
		genericProtocolData.set(GenericProtocolData.AILERON, Double.parseDouble(values[GenericProtocolData.AILERON]));
		genericProtocolData.set(GenericProtocolData.RUDDER, Double.parseDouble(values[GenericProtocolData.RUDDER]));
		genericProtocolData.set(GenericProtocolData.THROTTLE, Double.parseDouble(values[GenericProtocolData.THROTTLE]));
		
		return genericProtocolData;
	}
}
