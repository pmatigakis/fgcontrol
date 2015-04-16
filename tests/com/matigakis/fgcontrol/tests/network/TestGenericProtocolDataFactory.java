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
		
		assertEquals(dummyGenericProtocolData.get(GenericProtocolData.SIMULATION_TIME), 
				sensorData.get(GenericProtocolData.SIMULATION_TIME), 
				0.0);
		
		assertEquals(dummyGenericProtocolData.get(GenericProtocolData.LATITUDE), 
				sensorData.get(GenericProtocolData.LATITUDE), 
				0.0);
		
		assertEquals(dummyGenericProtocolData.get(GenericProtocolData.LONGITUDE),
				sensorData.get(GenericProtocolData.LONGITUDE),
				0.0);
		
		assertEquals(dummyGenericProtocolData.get(GenericProtocolData.ALTITUDE),
				sensorData.get(GenericProtocolData.ALTITUDE),
				0.0);
		
		assertEquals(dummyGenericProtocolData.get(GenericProtocolData.ALTITUDE_AGL),
				sensorData.get(GenericProtocolData.ALTITUDE_AGL),
				0.0);
		
		assertEquals(dummyGenericProtocolData.get(GenericProtocolData.ROLL),
				sensorData.get(GenericProtocolData.ROLL),
				0.0);
		
		assertEquals(dummyGenericProtocolData.get(GenericProtocolData.PITCH),
				sensorData.get(GenericProtocolData.PITCH),
				0.0);
		
		assertEquals(dummyGenericProtocolData.get(GenericProtocolData.HEADING),
				sensorData.get(GenericProtocolData.HEADING),
				0.0);
		
		assertEquals(dummyGenericProtocolData.get(GenericProtocolData.ANGLE_OF_ATTACK),
				sensorData.get(GenericProtocolData.ANGLE_OF_ATTACK),
				0.0);
		
		assertEquals(dummyGenericProtocolData.get(GenericProtocolData.SIDESLIP_ANGLE),
				sensorData.get(GenericProtocolData.SIDESLIP_ANGLE),
				0.0);
		
		assertEquals(dummyGenericProtocolData.get(GenericProtocolData.ROLL_RATE),
				sensorData.get(GenericProtocolData.ROLL_RATE),
				0.0);
		
		assertEquals(dummyGenericProtocolData.get(GenericProtocolData.PITCH_RATE),
				sensorData.get(GenericProtocolData.PITCH_RATE),
				0.0);
		
		assertEquals(dummyGenericProtocolData.get(GenericProtocolData.YAW_RATE),
				sensorData.get(GenericProtocolData.YAW_RATE),
				0.0);
		
		assertEquals(dummyGenericProtocolData.get(GenericProtocolData.AIRSPEED),
				sensorData.get(GenericProtocolData.AIRSPEED),
				0.0);
		
		assertEquals(dummyGenericProtocolData.get(GenericProtocolData.CLIMB_RATE),
				sensorData.get(GenericProtocolData.CLIMB_RATE),
				0.0);
		
		assertEquals(dummyGenericProtocolData.get(GenericProtocolData.NORTH_VELOCITY),
				sensorData.get(GenericProtocolData.NORTH_VELOCITY),
				0.0);
		
		assertEquals(dummyGenericProtocolData.get(GenericProtocolData.EAST_VELOCITY),
				sensorData.get(GenericProtocolData.EAST_VELOCITY),
				0.0);
		
		assertEquals(dummyGenericProtocolData.get(GenericProtocolData.VERTICAL_VELOCITY),
				sensorData.get(GenericProtocolData.VERTICAL_VELOCITY),
				0.0);
		
		assertEquals(dummyGenericProtocolData.get(GenericProtocolData.U),
				sensorData.get(GenericProtocolData.U),
				0.0);
		
		assertEquals(dummyGenericProtocolData.get(GenericProtocolData.V),
				sensorData.get(GenericProtocolData.V),
				0.0);
		
		assertEquals(dummyGenericProtocolData.get(GenericProtocolData.W),
				sensorData.get(GenericProtocolData.W),
				0.0);
		
		assertEquals(dummyGenericProtocolData.get(GenericProtocolData.X_ACCELERATION),
				sensorData.get(GenericProtocolData.X_ACCELERATION),
				0.0);
		
		assertEquals(dummyGenericProtocolData.get(GenericProtocolData.Y_ACCELERATION),
				sensorData.get(GenericProtocolData.Y_ACCELERATION),
				0.0);
		
		assertEquals(dummyGenericProtocolData.get(GenericProtocolData.Z_ACCELERATION),
				sensorData.get(GenericProtocolData.Z_ACCELERATION),
				0.0);
		
		assertEquals(dummyGenericProtocolData.get(GenericProtocolData.STATIC_PRESSURE),
				sensorData.get(GenericProtocolData.STATIC_PRESSURE),
				0.0);
		
		assertEquals(dummyGenericProtocolData.get(GenericProtocolData.TOTAL_PRESSURE),
				sensorData.get(GenericProtocolData.TOTAL_PRESSURE),
				0.0);
		
		assertEquals(dummyGenericProtocolData.get(GenericProtocolData.TEMPERATURE),
				sensorData.get(GenericProtocolData.TEMPERATURE),
				0.0);
		
		assertEquals(dummyGenericProtocolData.get(GenericProtocolData.ELEVATOR),
				sensorData.get(GenericProtocolData.ELEVATOR),
				0.0);
		
		assertEquals(dummyGenericProtocolData.get(GenericProtocolData.AILERON),
				sensorData.get(GenericProtocolData.AILERON),
				0.0);
		
		assertEquals(dummyGenericProtocolData.get(GenericProtocolData.RUDDER),
				sensorData.get(GenericProtocolData.RUDDER),
				0.0);
		
		assertEquals(dummyGenericProtocolData.get(GenericProtocolData.THROTTLE),
				sensorData.get(GenericProtocolData.THROTTLE),
				0.0);
	}
}
