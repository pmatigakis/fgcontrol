package com.matigakis.fgcontrol.examples;

import com.matigakis.fgcontrol.ControlsClient;
import com.matigakis.fgcontrol.SensorServer;
import com.matigakis.fgcontrol.SensorDataListener;
import com.matigakis.fgcontrol.controls.Controls;
import com.matigakis.fgcontrol.sensors.SensorData;

public class Example {
	public static void main(String[] args) throws Exception{
		System.out.println("fgcontrol example");
		
		int sensorPort = Integer.parseInt(args[0]);
		String controlsHost = args[1];
		int controlsPort = Integer.parseInt(args[2]);
		
		SensorServer server = new SensorServer(sensorPort);
		
		server.addSensorDataListener(new SensorDataListener() {
			@Override
			public void handleSensorData(SensorData sensorData) {
				System.out.println("Altitude: " + sensorData.altitude +
						" Airspeed: " + sensorData.airspeed +
						" Heading: " + sensorData.heading);
			}
		});
		
		server.start();
		
		ControlsClient client = new ControlsClient(controlsHost, controlsPort);
		
		client.openConnection();
		
		Controls controls = new Controls();
		controls.setThrottle(1.0);
		
		client.transmitControls(controls);
		
		client.closeConnection();
	}
}
