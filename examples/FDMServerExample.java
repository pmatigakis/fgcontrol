

import com.matigakis.fgcontrol.fdm.FDMData;
import com.matigakis.fgcontrol.network.FDMDataListener;
import com.matigakis.fgcontrol.network.FDMDataServer;
import com.matigakis.fgcontrol.network.UDPFDMServer;

public class FDMServerExample implements FDMDataListener{
	@Override
	public void handleFDMData(FDMData fdmData) {
		System.out.println("Altitude: " + fdmData.getPosition().getAltitude() + "\t" +
						   "Heading: " + fdmData.getOrientation().getHeading() + "\t" +
				           "Airspeed: " + fdmData.getVelocities().getCalibratedAirspeed());
	}
	
	public static void main(String[] args){
		int telemetryPort = 10500;
		
		FDMServerExample fdmServerExample = new FDMServerExample();
		
		FDMDataServer fdmDataServer = new UDPFDMServer(telemetryPort);
		
		fdmDataServer.addFDMDataListener(fdmServerExample);
		
		fdmDataServer.startServer();
	}
}
