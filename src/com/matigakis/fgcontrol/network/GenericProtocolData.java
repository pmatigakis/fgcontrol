package com.matigakis.fgcontrol.network;

import org.apache.commons.lang3.StringUtils;

/**
 * The GenericProtocolData object holds the data that were received from the
 * flight dynamics model.
 */
public class GenericProtocolData {
	public static final int PROTOCOL_DATA_SIZE = 31;
	
	public static final int SIMULATION_TIME = 0;
	public static final int LATITUDE = 1;
	public static final int LONGITUDE = 2;
	public static final int ALTITUDE = 3;
	public static final int ALTITUDE_AGL = 4;
	public static final int ROLL = 5;
	public static final int PITCH = 6;
	public static final int HEADING = 7;
	public static final int ANGLE_OF_ATTACK = 8;
	public static final int SIDESLIP_ANGLE = 9;
	public static final int ROLL_RATE = 10;
	public static final int PITCH_RATE = 11;
	public static final int YAW_RATE = 12;
	public static final int AIRSPEED = 13;
	public static final int CLIMB_RATE = 14;
	public static final int NORTH_VELOCITY = 15;
	public static final int EAST_VELOCITY = 16;
	public static final int VERTICAL_VELOCITY = 17;
	public static final int U = 18;
	public static final int V = 19;
	public static final int W = 20;
	public static final int X_ACCELERATION = 21;
	public static final int Y_ACCELERATION = 22;
	public static final int Z_ACCELERATION = 23;
	public static final int STATIC_PRESSURE = 24;
	public static final int TOTAL_PRESSURE = 25;
	public static final int TEMPERATURE = 26;
	public static final int ELEVATOR = 27;
	public static final int AILERON = 28;
	public static final int RUDDER = 29;
	public static final int THROTTLE = 30;
	
	private double[] protocolData;
	
	public GenericProtocolData(){
		protocolData = new double[PROTOCOL_DATA_SIZE];
	}
	
	/**
	 * Get the value of the item at the given index
	 * 
	 * @param protocolDataIndex the index of the item
	 * @return the value of the item
	 */
	public double get(int protocolDataIndex){
		return protocolData[protocolDataIndex];
	}
	
	/**
	 * Set the value of the item at the given index
	 * 
	 * @param protocolDataIndex the index of the item
	 * @param value the value of the item
	 */
	public void set(int protocolDataIndex, double value){
		protocolData[protocolDataIndex] = value;
	}
	
	public void copyTo(GenericProtocolData genericProtocolData){
		for (int i = 0; i < PROTOCOL_DATA_SIZE; i++){
			genericProtocolData.set(i, get(i));
		}
	}
	
	public double[] toArray(){
		double[] fdmData = new double[PROTOCOL_DATA_SIZE];
		
		for (int i = 0; i < PROTOCOL_DATA_SIZE; i++){
			fdmData[i] = get(i);
		}
		
		return fdmData;
	}
	
	public String toString() {
		return StringUtils.join(protocolData, '\t');
	}
}
