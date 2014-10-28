package com.matigakis.fgcontrol.examples;

import com.matigakis.fgcontrol.fdm.Controls;
import com.matigakis.fgcontrol.fdm.FDMData;
import com.matigakis.fgcontrol.fdm.NetworkFDM;
import com.matigakis.fgcontrol.fdm.NetworkFDMStateListener;

public class NetworkFDMExample implements NetworkFDMStateListener{
	private Controls controls;
	
	public NetworkFDMExample() {
		controls = new Controls();
	}
	
	@Override
	public void FDMStateUpdated(NetworkFDM fdm, FDMData fdmData) {
		System.out.println("Altitude: " + fdmData.getLocation().getAltitude() + "\t" +
				   		   "Heading: " + fdmData.getLocation().getHeading() + "\t" +
		                   "Airspeed: " + fdmData.getLocation().getAirspeed());
		
		controls.setThrottle(1.0);
		
		fdm.transmitControls(controls);
	}
	
	public static void main(String[] args) throws Exception{
		String flightgearHost = "localhost";
		int telemetryPort = 10500;
		int controlsPort = 10501;
		
		NetworkFDMExample networkFDMExample = new NetworkFDMExample();
		
		NetworkFDM networkFDM = new NetworkFDM(flightgearHost, telemetryPort, controlsPort);

		networkFDM.addFDMStateListener(networkFDMExample);
		
		networkFDM.connect();
	}
}
