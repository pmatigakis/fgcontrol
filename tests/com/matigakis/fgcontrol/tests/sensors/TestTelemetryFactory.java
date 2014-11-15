package com.matigakis.fgcontrol.tests.sensors;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.matigakis.fgcontrol.network.Telemetry;
import com.matigakis.fgcontrol.network.TelemetryFactory;

@RunWith(JUnit4.class)
public class TestTelemetryFactory {	
	@Test
	public void testCreateTelemetryFromString(){
		DummyTelemetry dummyTelemetry = new DummyTelemetry();
		
		String telemetryString = dummyTelemetry.toString(); 
		
		Telemetry sensorData = TelemetryFactory.fromString(telemetryString);
		
		assertEquals(dummyTelemetry.simulationTime, sensorData.simulationTime, 0.0);
		
		assertEquals(dummyTelemetry.latitude, sensorData.latitude, 0.0);
		assertEquals(dummyTelemetry.longitude, sensorData.longitude, 0.0);
		assertEquals(dummyTelemetry.altitude, sensorData.altitude, 0.0);
		assertEquals(dummyTelemetry.altitudeAgl, sensorData.altitudeAgl, 0.0);
		
		assertEquals(dummyTelemetry.roll, sensorData.roll, 0.0);
		assertEquals(dummyTelemetry.pitch, sensorData.pitch, 0.0);
		assertEquals(dummyTelemetry.heading, sensorData.heading, 0.0);
		assertEquals(dummyTelemetry.angleOfAttack, sensorData.angleOfAttack, 0.0);
		assertEquals(dummyTelemetry.sideSlipAngle, sensorData.sideSlipAngle, 0.0);
		
		assertEquals(dummyTelemetry.rollRate, sensorData.rollRate, 0.0);
		assertEquals(dummyTelemetry.pitchRate, sensorData.pitchRate, 0.0);
		assertEquals(dummyTelemetry.yawRate, sensorData.yawRate, 0.0);
		assertEquals(dummyTelemetry.airspeed, sensorData.airspeed, 0.0);
		assertEquals(dummyTelemetry.climbRate, sensorData.climbRate, 0.0);
		assertEquals(dummyTelemetry.northVelocity, sensorData.northVelocity, 0.0);
		assertEquals(dummyTelemetry.eastVelocity, sensorData.eastVelocity, 0.0);
		assertEquals(dummyTelemetry.verticalVelocity, sensorData.verticalVelocity, 0.0);
		assertEquals(dummyTelemetry.u, sensorData.u, 0.0);
		assertEquals(dummyTelemetry.v, sensorData.v, 0.0);
		assertEquals(dummyTelemetry.w, sensorData.w, 0.0);
		
		assertEquals(dummyTelemetry.xAcceleration, sensorData.xAcceleration, 0.0);
		assertEquals(dummyTelemetry.yAcceleration, sensorData.yAcceleration, 0.0);
		assertEquals(dummyTelemetry.zAcceleration, sensorData.zAcceleration, 0.0);
		
		assertEquals(dummyTelemetry.staticPressure, sensorData.staticPressure, 0.0);
		assertEquals(dummyTelemetry.totalPressure, sensorData.totalPressure, 0.0);
		assertEquals(dummyTelemetry.temperature, sensorData.temperature, 0.0);
	}
}
