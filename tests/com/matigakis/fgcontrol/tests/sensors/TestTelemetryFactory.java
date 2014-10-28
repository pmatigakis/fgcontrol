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
		
		String telemetryString =  
				dummyTelemetry.gpsAltitude + "\t" +
				dummyTelemetry.gpsAirspeed + "\t" +
				dummyTelemetry.latitude + "\t" +
				dummyTelemetry.longitude + "\t" +
				dummyTelemetry.gpsHeading + "\t" +
				dummyTelemetry.xAcceleration + "\t" +
				dummyTelemetry.yAcceleration + "\t" +
				dummyTelemetry.zAcceleration + "\t" +
				dummyTelemetry.xRotation + "\t" +
				dummyTelemetry.yRotation + "\t" +
				dummyTelemetry.zRotation + "\t" +
				dummyTelemetry.staticPressure + "\t" +
				dummyTelemetry.dynamicPressure + "\t" +
				dummyTelemetry.temperature + "\t" +
				dummyTelemetry.roll + "\t" + 
				dummyTelemetry.pitch + "\t" +
				dummyTelemetry.altitude + "\t" +
				dummyTelemetry.airspeed + "\t" +
				dummyTelemetry.heading + "\t" +
				dummyTelemetry.simulationTime + "\t" +
				dummyTelemetry.elevator + "\t" + 
				dummyTelemetry.aileron + "\t" +
				dummyTelemetry.rudder + "\t" +
				dummyTelemetry.throttle;
		
		TelemetryFactory telemetryFactory = new TelemetryFactory();
		
		Telemetry sensorData = telemetryFactory.fromString(telemetryString);
		
		assertEquals(dummyTelemetry.gpsAltitude, sensorData.gpsAltitude, 0.0);
		assertEquals(dummyTelemetry.gpsAirspeed, sensorData.gpsAirspeed, 0.0);
		assertEquals(dummyTelemetry.latitude, sensorData.latitude, 0.0);
		assertEquals(dummyTelemetry.longitude, sensorData.longitude, 0.0);
		assertEquals(dummyTelemetry.gpsHeading, sensorData.gpsHeading, 0.0);
		assertEquals(dummyTelemetry.xAcceleration, sensorData.xAcceleration, 0.0);
		assertEquals(dummyTelemetry.yAcceleration, sensorData.yAcceleration, 0.0);
		assertEquals(dummyTelemetry.zAcceleration, sensorData.zAcceleration, 0.0);
		assertEquals(dummyTelemetry.xRotation, sensorData.xRotation, 0.0);
		assertEquals(dummyTelemetry.yRotation, sensorData.yRotation, 0.0);
		assertEquals(dummyTelemetry.zRotation, sensorData.zRotation, 0.0);
		assertEquals(dummyTelemetry.staticPressure, sensorData.staticPressure, 0.0);
		assertEquals(dummyTelemetry.dynamicPressure, sensorData.dynamicPressure, 0.0);
		assertEquals(dummyTelemetry.temperature, sensorData.temperature, 0.0);
		assertEquals(dummyTelemetry.roll, sensorData.roll, 0.0);
		assertEquals(dummyTelemetry.pitch, sensorData.pitch, 0.0);
		assertEquals(dummyTelemetry.altitude, sensorData.altitude, 0.0);
		assertEquals(dummyTelemetry.airspeed, sensorData.airspeed, 0.0);
		assertEquals(dummyTelemetry.heading, sensorData.heading, 0.0);
		assertEquals(dummyTelemetry.simulationTime, sensorData.simulationTime, 0.0);
		assertEquals(dummyTelemetry.elevator, sensorData.elevator, 0.0);
		assertEquals(dummyTelemetry.aileron, sensorData.aileron, 0.0);
		assertEquals(dummyTelemetry.rudder, sensorData.rudder, 0.0);
		assertEquals(dummyTelemetry.throttle, sensorData.throttle, 0.0);
	}
}
