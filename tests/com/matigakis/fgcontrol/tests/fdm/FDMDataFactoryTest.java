package com.matigakis.fgcontrol.tests.fdm;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.matigakis.fgcontrol.network.Telemetry;
import com.matigakis.fgcontrol.tests.network.DummyTelemetry;
import com.matigakis.fgcontrol.fdm.Accelerations;
import com.matigakis.fgcontrol.fdm.Atmosphere;
import com.matigakis.fgcontrol.fdm.Controls;
import com.matigakis.fgcontrol.fdm.FDMDataFactory;
import com.matigakis.fgcontrol.fdm.FDMData;
import com.matigakis.fgcontrol.fdm.Orientation;
import com.matigakis.fgcontrol.fdm.Position;
import com.matigakis.fgcontrol.fdm.Velocities;

public class FDMDataFactoryTest {
	private Telemetry telemetry;
	private FDMData fdmData;
	
	@Before
	public void setUp(){
		telemetry = new DummyTelemetry();
		fdmData = FDMDataFactory.fromTelemetry(telemetry);
	}
	
	@Test
	public void testUpdateAccelerationsFromTelemetry() {
		Accelerations accelerations = fdmData.getAccelerations();
		
		assertEquals(telemetry.xAcceleration, accelerations.getXAcceleration(), 0.0);
		assertEquals(telemetry.yAcceleration, accelerations.getYAcceleration(), 0.0);
		assertEquals(telemetry.zAcceleration, accelerations.getZAcceleration(), 0.0);
	}
	
	@Test 
	public void testUpdateAtmosphereFromTelemetry(){
		Atmosphere atmosphere = fdmData.getAtmosphere();
		
		assertEquals(telemetry.temperature, atmosphere.getTemperature(), 0.0);
		assertEquals(telemetry.totalPressure, atmosphere.getTotalPressure(), 0.0);
		assertEquals(telemetry.staticPressure, atmosphere.getStaticPressure(), 0.0);
	}
	
	@Test
	public void testUpdateControlsFromTelemetry(){
		Controls controls = fdmData.getControls();
		
		assertEquals(telemetry.aileron, controls.getAileron(), 0.0);
		assertEquals(telemetry.elevator, controls.getElevator(), 0.0);
		assertEquals(telemetry.rudder, controls.getRudder(), 0.0);
		assertEquals(telemetry.throttle, controls.getThrottle(), 0.0);
	}
	
	@Test
	public void testUpdateOrientationFromTelemetry(){
		Orientation orientation = fdmData.getOrientation();
		
		assertEquals(telemetry.angleOfAttack, orientation.getAngleOfAttack(), 0.0);
		assertEquals(telemetry.heading, orientation.getHeading(), 0.0);
		assertEquals(telemetry.pitch, orientation.getPitch(), 0.0);
		assertEquals(telemetry.roll, orientation.getRoll(), 0.0);
		assertEquals(telemetry.sideSlipAngle, orientation.getSideSlipAngle(), 0.0);
	}
	
	@Test
	public void testUpdatePositionFromTelemetry(){
		Position position = fdmData.getPosition();
		
		assertEquals(telemetry.altitudeAgl, position.getAGL(), 0.0);
		assertEquals(telemetry.altitude, position.getAltitude(), 0.0);
		assertEquals(telemetry.latitude, position.getLatitude(), 0.0);
		assertEquals(telemetry.longitude, position.getLongitude(), 0.0);
	}
	
	@Test
	public void testUpdateVelocitiesFromTelemetry(){
		Velocities velocities = fdmData.getVelocities();
		
		assertEquals(telemetry.airspeed, velocities.getCalibratedAirspeed(), 0.0);
		assertEquals(telemetry.climbRate, velocities.getClimbRate(), 0.0);
		assertEquals(telemetry.eastVelocity, velocities.getEastVelocity(), 0.0);
		assertEquals(telemetry.northVelocity, velocities.getNorthVelocity(), 0.0);
		assertEquals(telemetry.pitchRate, velocities.getPitchRate(), 0.0);
		assertEquals(telemetry.rollRate, velocities.getRollRate(), 0.0);
		assertEquals(telemetry.u, velocities.getU(), 0.0);
		assertEquals(telemetry.v, velocities.getV(), 0.0);
		assertEquals(telemetry.w, velocities.getW(), 0.0);
		assertEquals(telemetry.verticalVelocity, velocities.getVerticalVelocity(), 0.0);
		assertEquals(telemetry.yawRate, velocities.getYawRate(), 0.0);
	}
	
	@Test
	public void testUpdate(){
		double simulationTime = fdmData.getSimulationTime();
		
		assertEquals(telemetry.simulationTime, simulationTime, 0.0);
	}
}
