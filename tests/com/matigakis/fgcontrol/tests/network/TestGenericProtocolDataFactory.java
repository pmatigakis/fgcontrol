package com.matigakis.fgcontrol.tests.network;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.matigakis.fgcontrol.network.GenericProtocolData;
import com.matigakis.fgcontrol.network.GenericProtocolDataFactory;

@RunWith(JUnit4.class)
public class TestGenericProtocolDataFactory {	
	@Test
	public void testCreateTelemetryFromString(){
		DummyGenericProtocolData dummyGenericProtocolData = new DummyGenericProtocolData();
		
		String telemetryString = dummyGenericProtocolData.toString(); 
		
		GenericProtocolData sensorData = GenericProtocolDataFactory.fromString(telemetryString);
		
		assertEquals(dummyGenericProtocolData.simulationTime, sensorData.simulationTime, 0.0);
		
		assertEquals(dummyGenericProtocolData.latitude, sensorData.latitude, 0.0);
		assertEquals(dummyGenericProtocolData.longitude, sensorData.longitude, 0.0);
		assertEquals(dummyGenericProtocolData.altitude, sensorData.altitude, 0.0);
		assertEquals(dummyGenericProtocolData.altitudeAgl, sensorData.altitudeAgl, 0.0);
		
		assertEquals(dummyGenericProtocolData.roll, sensorData.roll, 0.0);
		assertEquals(dummyGenericProtocolData.pitch, sensorData.pitch, 0.0);
		assertEquals(dummyGenericProtocolData.heading, sensorData.heading, 0.0);
		assertEquals(dummyGenericProtocolData.angleOfAttack, sensorData.angleOfAttack, 0.0);
		assertEquals(dummyGenericProtocolData.sideSlipAngle, sensorData.sideSlipAngle, 0.0);
		
		assertEquals(dummyGenericProtocolData.rollRate, sensorData.rollRate, 0.0);
		assertEquals(dummyGenericProtocolData.pitchRate, sensorData.pitchRate, 0.0);
		assertEquals(dummyGenericProtocolData.yawRate, sensorData.yawRate, 0.0);
		assertEquals(dummyGenericProtocolData.airspeed, sensorData.airspeed, 0.0);
		assertEquals(dummyGenericProtocolData.climbRate, sensorData.climbRate, 0.0);
		assertEquals(dummyGenericProtocolData.northVelocity, sensorData.northVelocity, 0.0);
		assertEquals(dummyGenericProtocolData.eastVelocity, sensorData.eastVelocity, 0.0);
		assertEquals(dummyGenericProtocolData.verticalVelocity, sensorData.verticalVelocity, 0.0);
		assertEquals(dummyGenericProtocolData.u, sensorData.u, 0.0);
		assertEquals(dummyGenericProtocolData.v, sensorData.v, 0.0);
		assertEquals(dummyGenericProtocolData.w, sensorData.w, 0.0);
		
		assertEquals(dummyGenericProtocolData.xAcceleration, sensorData.xAcceleration, 0.0);
		assertEquals(dummyGenericProtocolData.yAcceleration, sensorData.yAcceleration, 0.0);
		assertEquals(dummyGenericProtocolData.zAcceleration, sensorData.zAcceleration, 0.0);
		
		assertEquals(dummyGenericProtocolData.staticPressure, sensorData.staticPressure, 0.0);
		assertEquals(dummyGenericProtocolData.totalPressure, sensorData.totalPressure, 0.0);
		assertEquals(dummyGenericProtocolData.temperature, sensorData.temperature, 0.0);
		
		assertEquals(dummyGenericProtocolData.elevator, sensorData.elevator, 0.0);
		assertEquals(dummyGenericProtocolData.aileron, sensorData.aileron, 0.0);
		assertEquals(dummyGenericProtocolData.rudder, sensorData.rudder, 0.0);
		assertEquals(dummyGenericProtocolData.throttle, sensorData.throttle, 0.0);
	}
}
