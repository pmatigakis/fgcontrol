package com.matigakis.fgcontrol.examples;

import com.matigakis.fgcontrol.fdm.Controls;
import com.matigakis.fgcontrol.fdm.FDMData;
import com.matigakis.fgcontrol.fdm.NetworkFDM;
import com.matigakis.fgcontrol.fdm.RemoteFDM;
import com.matigakis.fgcontrol.fdm.RemoteFDMStateListener;

public class NetworkFDMExample implements RemoteFDMStateListener{
	private Controls controls;
	
	public NetworkFDMExample() {
		controls = new Controls();
	}
	
	@Override
	public void fdmUpdated(RemoteFDM fdm, FDMData fdmData) {
		System.out.println("Altitude: " + fdmData.getPosition().getAltitude() + "\t" +
				   		   "Heading: " + fdmData.getOrientation().getHeading() + "\t" +
		                   "Airspeed: " + fdmData.getVelocities().getCalibratedAirspeed());
		
		controls.setThrottle(1.0);
		
		fdm.transmitControls(controls);
	}
	
	public static void main(String[] args) throws Exception{
		String flightgearHost = "localhost";
		int telemetryPort = 10500;
		int controlsPort = 10501;
		
		NetworkFDMExample networkFDMExample = new NetworkFDMExample();
		
		NetworkFDM networkFDM = new NetworkFDM(flightgearHost, telemetryPort, controlsPort);

		networkFDM.addRemoteFDMStateListener(networkFDMExample);
		
		networkFDM.connect();
	}
}
