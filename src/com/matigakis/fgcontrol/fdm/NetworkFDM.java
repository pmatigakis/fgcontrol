package com.matigakis.fgcontrol.fdm;

import java.util.LinkedList;
import java.util.List;

import com.matigakis.fgcontrol.network.ControlsClient;
import com.matigakis.fgcontrol.network.Telemetry;
import com.matigakis.fgcontrol.network.TelemetryListener;
import com.matigakis.fgcontrol.network.TelemetryServer;

public class NetworkFDM implements TelemetryListener{
	private FDMData fdmData;
	private List<NetworkFDMStateListener> stateListeners;
	private TelemetryServer telemetryServer;
	private ControlsClient controlsClient;
	
	public NetworkFDM(String host, int telemetryPort, int controlsPort){
		fdmData = new FDMData();
		
		stateListeners = new LinkedList<NetworkFDMStateListener>();
		
		telemetryServer = new TelemetryServer(telemetryPort);
		telemetryServer.addTelemetryListener(this);
		
		controlsClient = new ControlsClient(host, controlsPort);
	}
	
	public void addFDMStateListener(NetworkFDMStateListener client){
		stateListeners.add(client);
	}
	
	public void removeFDMStateListener(NetworkFDMStateListener client){
		stateListeners.remove(client);
	}
	
	public void connect() throws InterruptedException{
		telemetryServer.startServer();
		controlsClient.openConnection();
	}
	
	public void disconnect(){
		telemetryServer.stopServer();
		controlsClient.closeConnection();
	}
	
	public void transmitControls(Controls controls){
		controlsClient.transmitControls(controls);
	}
	
	private void notifyFDMStateListeners(){
		for(NetworkFDMStateListener stateListener: stateListeners){
			stateListener.FDMStateUpdated(this, fdmData);
		}
	}

	private void updateAccelerations(double xAcceleration, double yAcceleration, double zAcceleration,
			double rollRate, double pitchRate, double yawRate){
		Accelerations accelerations = fdmData.getAccelerations();
		
		accelerations.setXAcceleration(xAcceleration);
		accelerations.setYAcceleration(yAcceleration);
		accelerations.setZAcceleration(zAcceleration);
		
		accelerations.setRollRate(rollRate);
		accelerations.setPitchRate(pitchRate);
		accelerations.setYawRate(yawRate);
	}
	
	private void updateOrientation(double roll, double pitch, double yaw){
		Orientation orientation = fdmData.getOrientation();
		
		orientation.setRoll(roll);
		orientation.setPitch(pitch);
		orientation.setYaw(yaw);
	}
	
	private void updateVelocities(double airspeed){
		Velocities velocities = fdmData.getVelocities();
		
		velocities.setAirspeed(airspeed);
	}
	
	private void updateLocation(double latitude, double longitude, double altitude, double airspeed, double heading){
		Location location = fdmData.getLocation();
		
		location.setLatitude(latitude);
		location.setLongitude(longitude);
		location.setAltitude(altitude);
		location.setAirspeed(airspeed);
		location.setHeading(heading);
	}
	
	protected void updateAtmosphere(double staticPressure, double pitotTubePressure, double temperature){
		Atmosphere atmosphere = fdmData.getAtmosphere();
		
		atmosphere.setStaticPressure(staticPressure);
		atmosphere.setPitotTubePressure(pitotTubePressure);
		atmosphere.setTemperature(temperature);
	}
	
	protected void updateControls(double aileron, double elevator, double rudder, double throttle){
		Controls controls = fdmData.getControls();
		
		controls.setAileron(aileron);
		controls.setElevator(elevator);
		controls.setRudder(rudder);
		controls.setThrottle(throttle);
	}
	
	@Override
	public void handleTelemetry(Telemetry telemetry) {
		fdmData.setSimulationTime(telemetry.simulationTime);
		
		updateAccelerations(telemetry.xAcceleration, telemetry.yAcceleration, telemetry.zAcceleration,
							telemetry.xRotation, telemetry.yRotation, telemetry.zRotation);
		
		 //TODO: should yaw be added?
		updateOrientation(telemetry.roll, telemetry.pitch, 0.0);
		
		updateVelocities(telemetry.airspeed);
		
		updateLocation(telemetry.latitude, telemetry.longitude, telemetry.gpsAltitude, telemetry.gpsAirspeed, telemetry.gpsHeading);
		
		//TODO: make sure that dynamic pressure and pitot tube pressure is the same thing
		updateAtmosphere(telemetry.staticPressure, telemetry.dynamicPressure, telemetry.temperature);
		
		updateControls(telemetry.aileron, telemetry.elevator, telemetry.rudder, telemetry.throttle);
		
		notifyFDMStateListeners();
	}
}
