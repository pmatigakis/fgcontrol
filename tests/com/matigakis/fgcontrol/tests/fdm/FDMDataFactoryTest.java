package com.matigakis.fgcontrol.tests.fdm;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.matigakis.fgcontrol.network.GenericProtocolData;
import com.matigakis.fgcontrol.tests.network.DummyGenericProtocolData;
import com.matigakis.fgcontrol.fdm.Accelerations;
import com.matigakis.fgcontrol.fdm.Atmosphere;
import com.matigakis.fgcontrol.fdm.Controls;
import com.matigakis.fgcontrol.fdm.FDMDataFactory;
import com.matigakis.fgcontrol.fdm.FDMData;
import com.matigakis.fgcontrol.fdm.Orientation;
import com.matigakis.fgcontrol.fdm.Position;
import com.matigakis.fgcontrol.fdm.Velocities;

public class FDMDataFactoryTest {
	private GenericProtocolData genericProtocolData;
	private FDMData fdmData;
	
	@Before
	public void setUp(){
		genericProtocolData = new DummyGenericProtocolData();
		fdmData = FDMDataFactory.fromGenericProtocolData(genericProtocolData);
	}
	
	@Test
	public void testUpdateAccelerationsFromTelemetry() {
		Accelerations accelerations = fdmData.getAccelerations();
		
		assertEquals(genericProtocolData.xAcceleration, accelerations.getXAcceleration(), 0.0);
		assertEquals(genericProtocolData.yAcceleration, accelerations.getYAcceleration(), 0.0);
		assertEquals(genericProtocolData.zAcceleration, accelerations.getZAcceleration(), 0.0);
	}
	
	@Test 
	public void testUpdateAtmosphereFromTelemetry(){
		Atmosphere atmosphere = fdmData.getAtmosphere();
		
		assertEquals(genericProtocolData.temperature, atmosphere.getTemperature(), 0.0);
		assertEquals(genericProtocolData.totalPressure, atmosphere.getTotalPressure(), 0.0);
		assertEquals(genericProtocolData.staticPressure, atmosphere.getStaticPressure(), 0.0);
	}
	
	@Test
	public void testUpdateControlsFromTelemetry(){
		Controls controls = fdmData.getControls();
		
		assertEquals(genericProtocolData.aileron, controls.getAileron(), 0.0);
		assertEquals(genericProtocolData.elevator, controls.getElevator(), 0.0);
		assertEquals(genericProtocolData.rudder, controls.getRudder(), 0.0);
		assertEquals(genericProtocolData.throttle, controls.getThrottle(), 0.0);
	}
	
	@Test
	public void testUpdateOrientationFromTelemetry(){
		Orientation orientation = fdmData.getOrientation();
		
		assertEquals(genericProtocolData.angleOfAttack, orientation.getAngleOfAttack(), 0.0);
		assertEquals(genericProtocolData.heading, orientation.getHeading(), 0.0);
		assertEquals(genericProtocolData.pitch, orientation.getPitch(), 0.0);
		assertEquals(genericProtocolData.roll, orientation.getRoll(), 0.0);
		assertEquals(genericProtocolData.sideSlipAngle, orientation.getSideSlipAngle(), 0.0);
	}
	
	@Test
	public void testUpdatePositionFromTelemetry(){
		Position position = fdmData.getPosition();
		
		assertEquals(genericProtocolData.altitudeAgl, position.getAGL(), 0.0);
		assertEquals(genericProtocolData.altitude, position.getAltitude(), 0.0);
		assertEquals(genericProtocolData.latitude, position.getLatitude(), 0.0);
		assertEquals(genericProtocolData.longitude, position.getLongitude(), 0.0);
	}
	
	@Test
	public void testUpdateVelocitiesFromTelemetry(){
		Velocities velocities = fdmData.getVelocities();
		
		assertEquals(genericProtocolData.airspeed, velocities.getCalibratedAirspeed(), 0.0);
		assertEquals(genericProtocolData.climbRate, velocities.getClimbRate(), 0.0);
		assertEquals(genericProtocolData.eastVelocity, velocities.getEastVelocity(), 0.0);
		assertEquals(genericProtocolData.northVelocity, velocities.getNorthVelocity(), 0.0);
		assertEquals(genericProtocolData.pitchRate, velocities.getPitchRate(), 0.0);
		assertEquals(genericProtocolData.rollRate, velocities.getRollRate(), 0.0);
		assertEquals(genericProtocolData.u, velocities.getU(), 0.0);
		assertEquals(genericProtocolData.v, velocities.getV(), 0.0);
		assertEquals(genericProtocolData.w, velocities.getW(), 0.0);
		assertEquals(genericProtocolData.verticalVelocity, velocities.getVerticalVelocity(), 0.0);
		assertEquals(genericProtocolData.yawRate, velocities.getYawRate(), 0.0);
	}
	
	@Test
	public void testUpdate(){
		double simulationTime = fdmData.getSimulationTime();
		
		assertEquals(genericProtocolData.simulationTime, simulationTime, 0.0);
	}
}
