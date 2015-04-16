package com.matigakis.fgcontrol.tests.network;

import com.matigakis.fgcontrol.network.GenericProtocolData;

public class DummyGenericProtocolData extends GenericProtocolData{
	public DummyGenericProtocolData(){
		super();
		
		set(SIMULATION_TIME, 120.67);

		set(LATITUDE, 37.937056);
		set(LONGITUDE, 23.94667);
		set(ALTITUDE, 1000.0);
		set(ALTITUDE_AGL, 800.0);
		
		set(ROLL, 10.5);
		set(PITCH, 12.5);
		set(HEADING, 172.1);
		set(ANGLE_OF_ATTACK, 5.5);
		set(SIDESLIP_ANGLE, 0.1);
		
		set(ROLL_RATE, 2.0);
		set(PITCH_RATE, 1.5);
		set(YAW_RATE, 1.0);
		set(AIRSPEED, 65.4);
		set(CLIMB_RATE, 10.4);
		set(NORTH_VELOCITY, 37.6);
		set(EAST_VELOCITY, 12.2);
		set(VERTICAL_VELOCITY, 3.6);
		set(U, 9.6);
		set(V, 3.6);
		set(W, 7.8);
		
		set(X_ACCELERATION, 0.5); 
		set(Y_ACCELERATION, 0.3);
		set(Z_ACCELERATION, 30.0);
		
		set(STATIC_PRESSURE, 29.8);
		set(TOTAL_PRESSURE, 31.5);
		set(TEMPERATURE, 26.5);
		
		set(ELEVATOR, 0.6);
		set(AILERON, 0.3);
		set(RUDDER, 0.01);
		set(THROTTLE, 0.9);
	}
}
