package com.matigakis.fgcontrol.fdm;

import com.matigakis.fgcontrol.network.GenericProtocolData;

public class FDMDataFactory {
	public static FDMData fromGenericProtocolData(GenericProtocolData genericProtocolData){
		FDMData fdmData = new FDMData();
		
		fdmData.setSimulationTime(genericProtocolData.simulationTime);
		
		Position position = fdmData.getPosition();
		position.setLongitude(genericProtocolData.longitude);
		position.setLatitude(genericProtocolData.latitude);
		position.setAltitude(genericProtocolData.altitude);
		position.setAGL(genericProtocolData.altitudeAgl);

		Orientation orientation = fdmData.getOrientation();
		orientation.setRoll(genericProtocolData.roll);
		orientation.setPitch(genericProtocolData.pitch);
		orientation.setHeading(genericProtocolData.heading);
		orientation.setAngleOfAttach(genericProtocolData.angleOfAttack);
		orientation.setSideSlipAngle(genericProtocolData.sideSlipAngle);

		Velocities velocities = fdmData.getVelocities();
		velocities.setRollRate(genericProtocolData.rollRate);
		velocities.setPitchRate(genericProtocolData.pitchRate);
		velocities.setYawRate(genericProtocolData.yawRate);
		velocities.setCalibratedAirspeed(genericProtocolData.airspeed);
		velocities.setClimbRate(genericProtocolData.climbRate);
		velocities.setNorthVelocity(genericProtocolData.northVelocity);
		velocities.setEastVelocity(genericProtocolData.eastVelocity);
		velocities.setVerticalVelocity(genericProtocolData.verticalVelocity);
		velocities.setU(genericProtocolData.u);
		velocities.setV(genericProtocolData.v);
		velocities.setW(genericProtocolData.w);
		
		Accelerations accelerations = fdmData.getAccelerations();
		accelerations.setXAcceleration(genericProtocolData.xAcceleration);
		accelerations.setYAcceleration(genericProtocolData.yAcceleration);
		accelerations.setZAcceleration(genericProtocolData.zAcceleration);
		
		Atmosphere atmosphere = fdmData.getAtmosphere();
		atmosphere.setStaticPressure(genericProtocolData.staticPressure);
		atmosphere.setTotalPressure(genericProtocolData.totalPressure);
		atmosphere.setTemperature(genericProtocolData.temperature);
		
		Controls controls = fdmData.getControls();
		controls.setElevator(genericProtocolData.elevator);
		controls.setAileron(genericProtocolData.aileron);
		controls.setRudder(genericProtocolData.rudder);
		controls.setThrottle(genericProtocolData.throttle);
		
		return fdmData;
	}
}
