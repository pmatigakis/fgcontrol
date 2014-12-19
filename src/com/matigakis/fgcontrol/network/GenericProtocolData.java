package com.matigakis.fgcontrol.network;

import org.apache.commons.lang3.StringUtils;

/**
 * The GenericProtocolData object holds the data that were received from the
 * flight dynamics model.
 */
public class GenericProtocolData {
	public double simulationTime;
	
	public double longitude;
	public double latitude;
	public double altitude;
	public double altitudeAgl;
	
	public double roll;
	public double pitch;
	public double heading;
	public double angleOfAttack;
	public double sideSlipAngle;
	
	public double rollRate;
	public double pitchRate;
	public double yawRate;
	public double airspeed; 
	public double climbRate;
	public double northVelocity;
	public double eastVelocity;
	public double verticalVelocity;
	public double u;
	public double v;
	public double w;
	
	public double xAcceleration;
	public double yAcceleration;
	public double zAcceleration;
	
	public double staticPressure;
	public double totalPressure;
	public double temperature;
	
	public double elevator;
	public double aileron;
	public double rudder;
	public double throttle;
	
	public GenericProtocolData(){
		simulationTime = 0.0;
		
		latitude = 0.0;
		longitude = 0.0;
		altitude = 0.0;
		altitudeAgl = 0.0;
		
		roll = 0.0;
		pitch = 0.0;
		heading = 0.0;
		angleOfAttack = 0.0;
		sideSlipAngle = 0.0;
		
		rollRate = 0.0;
		pitchRate = 0.0;
		yawRate = 0.0;
		airspeed = 0.0; 
		climbRate = 0.0;
		northVelocity = 0.0;
		eastVelocity = 0.0;
		verticalVelocity = 0.0;
		u = 0.0;
		v = 0.0;
		w = 0.0;
		
		xAcceleration = 0.0;
		yAcceleration = 0.0;
		zAcceleration = 0.0;
		
		staticPressure = 0.0;
		totalPressure = 0.0;
		temperature = 0.0;
		
		elevator = 0.0;
		aileron = 0.0;
		rudder = 0.0;
		throttle = 0.0;
	}
	
	public void copyTo(GenericProtocolData genericProtocolData){
		genericProtocolData.simulationTime = simulationTime;
		
		genericProtocolData.latitude = latitude;
		genericProtocolData.longitude = longitude;
		genericProtocolData.altitude = altitude;
		genericProtocolData.altitudeAgl = altitudeAgl;
		
		genericProtocolData.roll = roll;
		genericProtocolData.pitch = pitch;
		genericProtocolData.heading = heading;
		genericProtocolData.angleOfAttack = angleOfAttack;
		genericProtocolData.sideSlipAngle = sideSlipAngle;
		
		genericProtocolData.rollRate = rollRate;
		genericProtocolData.pitchRate = pitchRate;
		genericProtocolData.yawRate = yawRate;
		genericProtocolData.airspeed = airspeed; 
		genericProtocolData.climbRate = climbRate;
		genericProtocolData.northVelocity = northVelocity;
		genericProtocolData.eastVelocity = eastVelocity;
		genericProtocolData.verticalVelocity = verticalVelocity;
		genericProtocolData.u = u;
		genericProtocolData.v = v;
		genericProtocolData.w = w;
		
		genericProtocolData.xAcceleration = xAcceleration;
		genericProtocolData.yAcceleration = yAcceleration;
		genericProtocolData.zAcceleration = zAcceleration;
		
		genericProtocolData.staticPressure = staticPressure;
		genericProtocolData.totalPressure = totalPressure;
		genericProtocolData.temperature = temperature;
	}
	
	public double[] toArray(){
		double[] fdmData = {
				simulationTime,
				latitude,
				longitude,
				altitude,
				altitudeAgl,
				roll,
				pitch,
				heading,
				angleOfAttack,
				sideSlipAngle,
				rollRate,
				pitchRate,
				yawRate,
				airspeed, 
				climbRate,
				northVelocity,
				eastVelocity,
				verticalVelocity,
				u,
				v,
				w,
				xAcceleration,
				yAcceleration,
				zAcceleration,
				staticPressure,
				totalPressure,
				temperature,
				elevator,
				aileron,
				rudder,
				throttle
		};
		
		return fdmData;
	}
	
	public String toString() {
		double[] fdmData = toArray();
		
		return StringUtils.join(fdmData, '\t');
	}
}
