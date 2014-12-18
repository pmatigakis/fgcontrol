

import org.apache.log4j.BasicConfigurator;

import com.matigakis.fgcontrol.fdm.Controls;
import com.matigakis.fgcontrol.fdm.FDMData;
import com.matigakis.fgcontrol.fdm.NetworkFDM;
import com.matigakis.fgcontrol.fdm.RemoteFDM;
import com.matigakis.fgcontrol.fdm.RemoteFDMStateAdapter;

public class NetworkFDMExample{
	public static void main(String[] args) throws Exception{
		BasicConfigurator.configure();
		
		String flightgearHost = "localhost";
		int telemetryPort = 10500;
		int controlsPort = 10501;
		
		NetworkFDM networkFDM = new NetworkFDM(flightgearHost, telemetryPort, controlsPort);

		networkFDM.addRemoteFDMStateListener(new RemoteFDMStateAdapter() {
			@Override
			public void fdmDataReceived(RemoteFDM fdm, FDMData fdmData) {
				System.out.println(
						"Altitude: " + fdmData.getPosition().getAltitude() + "\t" +
						"Heading: " + fdmData.getOrientation().getHeading() + "\t" +
						"Airspeed: " + fdmData.getVelocities().getCalibratedAirspeed());
		
				Controls controls = new Controls();
				controls.setThrottle(1.0);
		
				fdm.transmitControls(controls);
			}
		});
		
		networkFDM.connect();
	}
}
