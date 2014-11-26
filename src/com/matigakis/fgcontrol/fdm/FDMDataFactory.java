package com.matigakis.fgcontrol.fdm;

import com.matigakis.fgcontrol.network.Telemetry;

public class FDMDataFactory {
	public static FDMData fromTelemetry(Telemetry telemetry){
		FDMData fdmData = new FDMData();
		
		fdmData.setSimulationTime(telemetry.simulationTime);
		
		Position position = fdmData.getPosition();
		position.setLongitude(telemetry.longitude);
		position.setLatitude(telemetry.latitude);
		position.setAltitude(telemetry.altitude);
		position.setAGL(telemetry.altitudeAgl);

		Orientation orientation = fdmData.getOrientation();
		orientation.setRoll(telemetry.roll);
		orientation.setPitch(telemetry.pitch);
		orientation.setHeading(telemetry.heading);
		orientation.setAngleOfAttach(telemetry.angleOfAttack);
		orientation.setSideSlipAngle(telemetry.sideSlipAngle);

		Velocities velocities = fdmData.getVelocities();
		velocities.setRollRate(telemetry.rollRate);
		velocities.setPitchRate(telemetry.pitchRate);
		velocities.setYawRate(telemetry.yawRate);
		velocities.setCalibratedAirspeed(telemetry.airspeed);
		velocities.setClimbRate(telemetry.climbRate);
		velocities.setNorthVelocity(telemetry.northVelocity);
		velocities.setEastVelocity(telemetry.eastVelocity);
		velocities.setVerticalVelocity(telemetry.verticalVelocity);
		velocities.setU(telemetry.u);
		velocities.setV(telemetry.v);
		velocities.setW(telemetry.w);
		
		Accelerations accelerations = fdmData.getAccelerations();
		accelerations.setXAcceleration(telemetry.xAcceleration);
		accelerations.setYAcceleration(telemetry.yAcceleration);
		accelerations.setZAcceleration(telemetry.zAcceleration);
		
		Atmosphere atmosphere = fdmData.getAtmosphere();
		atmosphere.setStaticPressure(telemetry.staticPressure);
		atmosphere.setTotalPressure(telemetry.totalPressure);
		atmosphere.setTemperature(telemetry.temperature);
		
		Controls controls = fdmData.getControls();
		controls.setElevator(telemetry.elevator);
		controls.setAileron(telemetry.aileron);
		controls.setRudder(telemetry.rudder);
		controls.setThrottle(telemetry.throttle);
		
		return fdmData;
	}
}
