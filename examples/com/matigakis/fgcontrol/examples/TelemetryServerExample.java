package com.matigakis.fgcontrol.examples;

import com.matigakis.fgcontrol.network.Telemetry;
import com.matigakis.fgcontrol.network.TelemetryServer;
import com.matigakis.fgcontrol.network.TelemetryListener;

public class TelemetryServerExample implements TelemetryListener{
	@Override
	public void handleTelemetry(Telemetry telemetry) {
		System.out.println("Altitude: " + telemetry.altitude + "\t" +
						   "Heading: " + telemetry.heading + "\t" +
				           "Airspeed: " + telemetry.airspeed);
	}
	
	public static void main(String[] args){
		int telemetryPort = 10500;
		
		TelemetryServerExample telemetryServerExample = new TelemetryServerExample();
		
		TelemetryServer telemetryServer = new TelemetryServer(telemetryPort);
		
		telemetryServer.addTelemetryListener(telemetryServerExample);
		
		telemetryServer.startServer();
	}
}
