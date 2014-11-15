package com.matigakis.fgcontrol.network;

import org.apache.commons.lang3.StringUtils;

/**
 * The Telemetry object holds the data that were received from the
 * flight dynamics model.
 */
public class Telemetry {
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
	
	public Telemetry(){
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
	}
	
	public void copyTo(Telemetry telemetry){
		telemetry.simulationTime = simulationTime;
		
		telemetry.latitude = latitude;
		telemetry.longitude = longitude;
		telemetry.altitude = altitude;
		telemetry.altitudeAgl = altitudeAgl;
		
		telemetry.roll = roll;
		telemetry.pitch = pitch;
		telemetry.heading = heading;
		telemetry.angleOfAttack = angleOfAttack;
		telemetry.sideSlipAngle = sideSlipAngle;
		
		telemetry.rollRate = rollRate;
		telemetry.pitchRate = pitchRate;
		telemetry.yawRate = yawRate;
		telemetry.airspeed = airspeed; 
		telemetry.climbRate = climbRate;
		telemetry.northVelocity = northVelocity;
		telemetry.eastVelocity = eastVelocity;
		telemetry.verticalVelocity = verticalVelocity;
		telemetry.u = u;
		telemetry.v = v;
		telemetry.w = w;
		
		telemetry.xAcceleration = xAcceleration;
		telemetry.yAcceleration = yAcceleration;
		telemetry.zAcceleration = zAcceleration;
		
		telemetry.staticPressure = staticPressure;
		telemetry.totalPressure = totalPressure;
		telemetry.temperature = temperature;
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
		};
		
		return fdmData;
	}
	
	public String toString() {
		double[] fdmData = toArray();
		
		return StringUtils.join(fdmData, '\t');
	}
}
