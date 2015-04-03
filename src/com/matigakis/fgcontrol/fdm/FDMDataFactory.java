package com.matigakis.fgcontrol.fdm;

import com.matigakis.fgcontrol.network.GenericProtocolData;

public class FDMDataFactory {
	public static FDMData fromGenericProtocolData(GenericProtocolData genericProtocolData){
		Position position = new Position(genericProtocolData.longitude,
				genericProtocolData.latitude,
				genericProtocolData.altitude,
				genericProtocolData.altitudeAgl);

		Orientation orientation = new Orientation(genericProtocolData.roll,
				genericProtocolData.pitch,
				genericProtocolData.heading,
				genericProtocolData.angleOfAttack,
				genericProtocolData.sideSlipAngle);

		Velocities velocities = new Velocities(genericProtocolData.rollRate,
				genericProtocolData.pitchRate,
				genericProtocolData.yawRate,
				genericProtocolData.airspeed,
				genericProtocolData.climbRate,
				genericProtocolData.northVelocity,
				genericProtocolData.eastVelocity,
				genericProtocolData.verticalVelocity,
				genericProtocolData.u,
				genericProtocolData.v,
				genericProtocolData.w);
		
		Accelerations accelerations = new Accelerations(
				genericProtocolData.xAcceleration,
				genericProtocolData.yAcceleration,
				genericProtocolData.zAcceleration);
		
		Atmosphere atmosphere = new Atmosphere(
				genericProtocolData.staticPressure,
				genericProtocolData.totalPressure,
				genericProtocolData.temperature);
		
		Controls controls = new Controls(genericProtocolData.aileron,
				genericProtocolData.elevator,
				genericProtocolData.rudder,
				genericProtocolData.throttle);
		
		FDMData fdmData = new FDMData(genericProtocolData.simulationTime, 
				accelerations, velocities, position, orientation, atmosphere,
				controls);
		
		return fdmData;
	}
}
