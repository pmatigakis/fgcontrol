package com.matigakis.fgcontrol.fdm;

import com.matigakis.fgcontrol.network.GenericProtocolData;

public class FDMDataFactory {
	public static FDMData fromGenericProtocolData(GenericProtocolData genericProtocolData){
		Position position = new Position(genericProtocolData.get(GenericProtocolData.LONGITUDE),
				genericProtocolData.get(GenericProtocolData.LATITUDE),
				genericProtocolData.get(GenericProtocolData.ALTITUDE),
				genericProtocolData.get(GenericProtocolData.ALTITUDE_AGL));

		Orientation orientation = new Orientation(genericProtocolData.get(GenericProtocolData.ROLL),
				genericProtocolData.get(GenericProtocolData.PITCH),
				genericProtocolData.get(GenericProtocolData.HEADING),
				genericProtocolData.get(GenericProtocolData.ANGLE_OF_ATTACK),
				genericProtocolData.get(GenericProtocolData.SIDESLIP_ANGLE));

		Velocities velocities = new Velocities(genericProtocolData.get(GenericProtocolData.ROLL_RATE),
				genericProtocolData.get(GenericProtocolData.PITCH_RATE),
				genericProtocolData.get(GenericProtocolData.YAW_RATE),
				genericProtocolData.get(GenericProtocolData.AIRSPEED),
				genericProtocolData.get(GenericProtocolData.CLIMB_RATE),
				genericProtocolData.get(GenericProtocolData.NORTH_VELOCITY),
				genericProtocolData.get(GenericProtocolData.EAST_VELOCITY),
				genericProtocolData.get(GenericProtocolData.VERTICAL_VELOCITY),
				genericProtocolData.get(GenericProtocolData.U),
				genericProtocolData.get(GenericProtocolData.V),
				genericProtocolData.get(GenericProtocolData.W));
		
		Accelerations accelerations = new Accelerations(
				genericProtocolData.get(GenericProtocolData.X_ACCELERATION),
				genericProtocolData.get(GenericProtocolData.Y_ACCELERATION),
				genericProtocolData.get(GenericProtocolData.Z_ACCELERATION));
		
		Atmosphere atmosphere = new Atmosphere(
				genericProtocolData.get(GenericProtocolData.STATIC_PRESSURE),
				genericProtocolData.get(GenericProtocolData.TOTAL_PRESSURE),
				genericProtocolData.get(GenericProtocolData.TEMPERATURE));
		
		Controls controls = new Controls(genericProtocolData.get(GenericProtocolData.AILERON),
				genericProtocolData.get(GenericProtocolData.ELEVATOR),
				genericProtocolData.get(GenericProtocolData.RUDDER),
				genericProtocolData.get(GenericProtocolData.THROTTLE));
		
		FDMData fdmData = new FDMData(genericProtocolData.get(GenericProtocolData.SIMULATION_TIME), 
				accelerations, velocities, position, orientation, atmosphere,
				controls);
		
		return fdmData;
	}
}
