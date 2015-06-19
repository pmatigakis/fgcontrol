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
		
		assertEquals(genericProtocolData.get(GenericProtocolData.X_ACCELERATION), accelerations.getXAcceleration(), 0.0);
		assertEquals(genericProtocolData.get(GenericProtocolData.Y_ACCELERATION), accelerations.getYAcceleration(), 0.0);
		assertEquals(genericProtocolData.get(GenericProtocolData.Z_ACCELERATION), accelerations.getZAcceleration(), 0.0);
	}
	
	@Test 
	public void testUpdateAtmosphereFromTelemetry(){
		Atmosphere atmosphere = fdmData.getAtmosphere();
		
		assertEquals(genericProtocolData.get(GenericProtocolData.TEMPERATURE), atmosphere.getTemperature(), 0.0);
		assertEquals(genericProtocolData.get(GenericProtocolData.TOTAL_PRESSURE), atmosphere.getTotalPressure(), 0.0);
		assertEquals(genericProtocolData.get(GenericProtocolData.STATIC_PRESSURE), atmosphere.getStaticPressure(), 0.0);
	}
	
	@Test
	public void testUpdateControlsFromTelemetry(){
		Controls controls = fdmData.getControls();
		
		assertEquals(genericProtocolData.get(GenericProtocolData.AILERON), controls.getAileron(), 0.0);
		assertEquals(genericProtocolData.get(GenericProtocolData.ELEVATOR), controls.getElevator(), 0.0);
		assertEquals(genericProtocolData.get(GenericProtocolData.RUDDER), controls.getRudder(), 0.0);
		assertEquals(genericProtocolData.get(GenericProtocolData.THROTTLE), controls.getThrottle(), 0.0);
	}
	
	@Test
	public void testUpdateOrientationFromTelemetry(){
		Orientation orientation = fdmData.getOrientation();
		
		assertEquals(genericProtocolData.get(GenericProtocolData.ANGLE_OF_ATTACK), orientation.getAngleOfAttack(), 0.0);
		assertEquals(genericProtocolData.get(GenericProtocolData.HEADING), orientation.getHeading(), 0.0);
		assertEquals(genericProtocolData.get(GenericProtocolData.PITCH), orientation.getPitch(), 0.0);
		assertEquals(genericProtocolData.get(GenericProtocolData.ROLL), orientation.getRoll(), 0.0);
		assertEquals(genericProtocolData.get(GenericProtocolData.SIDESLIP_ANGLE), orientation.getSideSlipAngle(), 0.0);
	}
	
	@Test
	public void testUpdatePositionFromTelemetry(){
		Position position = fdmData.getPosition();
		
		assertEquals(genericProtocolData.get(GenericProtocolData.ALTITUDE_AGL), position.getAGL(), 0.0);
		assertEquals(genericProtocolData.get(GenericProtocolData.ALTITUDE), position.getAltitude(), 0.0);
		assertEquals(genericProtocolData.get(GenericProtocolData.LATITUDE), position.getLatitude(), 0.0);
		assertEquals(genericProtocolData.get(GenericProtocolData.LONGITUDE), position.getLongitude(), 0.0);
	}
	
	@Test
	public void testUpdateVelocitiesFromTelemetry(){
		Velocities velocities = fdmData.getVelocities();
		
		assertEquals(genericProtocolData.get(GenericProtocolData.AIRSPEED), velocities.getCalibratedAirspeed(), 0.0);
		assertEquals(genericProtocolData.get(GenericProtocolData.CLIMB_RATE), velocities.getClimbRate(), 0.0);
		assertEquals(genericProtocolData.get(GenericProtocolData.EAST_VELOCITY), velocities.getEastVelocity(), 0.0);
		assertEquals(genericProtocolData.get(GenericProtocolData.NORTH_VELOCITY), velocities.getNorthVelocity(), 0.0);
		assertEquals(genericProtocolData.get(GenericProtocolData.PITCH_RATE), velocities.getPitchRate(), 0.0);
		assertEquals(genericProtocolData.get(GenericProtocolData.ROLL_RATE), velocities.getRollRate(), 0.0);
		assertEquals(genericProtocolData.get(GenericProtocolData.U), velocities.getU(), 0.0);
		assertEquals(genericProtocolData.get(GenericProtocolData.V), velocities.getV(), 0.0);
		assertEquals(genericProtocolData.get(GenericProtocolData.W), velocities.getW(), 0.0);
		assertEquals(genericProtocolData.get(GenericProtocolData.VERTICAL_VELOCITY), velocities.getVerticalVelocity(), 0.0);
		assertEquals(genericProtocolData.get(GenericProtocolData.YAW_RATE), velocities.getYawRate(), 0.0);
	}
	
	@Test
	public void testUpdate(){
		double simulationTime = fdmData.getSimulationTime();
		
		assertEquals(genericProtocolData.get(GenericProtocolData.SIMULATION_TIME), simulationTime, 0.0);
	}
}
