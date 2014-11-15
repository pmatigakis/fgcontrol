package com.matigakis.fgcontrol.tests.sensors;

import com.matigakis.fgcontrol.network.Telemetry;

public class DummyTelemetry extends Telemetry{
	public DummyTelemetry(){
		super();
		simulationTime = 120.67;

		latitude = 37.937056;
		longitude = 23.94667;
		altitude = 1000.0;
		altitudeAgl = 800.0;
		
		roll = 10.5;
		pitch = 12.5;
		heading = 172.1;
		angleOfAttack = 5.5;
		sideSlipAngle = 0.1;
		
		rollRate = 2.0;
		pitchRate = 1.5;
		yawRate = 1.0;
		airspeed = 65.4;
		climbRate = 10.4;
		northVelocity = 37.6;
		eastVelocity = 12.2;
		verticalVelocity = -3.6;
		u = 9.6;
		v = 3.6;
		w = 7.8;
		
		xAcceleration = 0.5; 
		yAcceleration = 0.3;
		zAcceleration = 30.0;
		
		staticPressure = 29.8;
		totalPressure = 31.5;
		temperature = 26.5;
	}
}
