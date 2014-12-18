import org.apache.log4j.BasicConfigurator;

import com.matigakis.fgcontrol.fdm.FDMData;
import com.matigakis.fgcontrol.network.FDMDataListener;
import com.matigakis.fgcontrol.network.FDMDataServer;
import com.matigakis.fgcontrol.network.UDPFDMServer;

public class FDMServerExample{
	public static void main(String[] args) throws Exception{
		BasicConfigurator.configure();
		
		int telemetryPort = 10500;
		
		final FDMDataServer fdmDataServer = new UDPFDMServer(telemetryPort);
		
		fdmDataServer.addFDMDataListener(new FDMDataListener() {
			
			@Override
			public void handleFDMData(FDMData fdmData) {
				System.out.println(
						"Altitude: " + fdmData.getPosition().getAltitude() + "\t" +
						"Heading: " + fdmData.getOrientation().getHeading() + "\t" +
						"Airspeed: " + fdmData.getVelocities().getCalibratedAirspeed());			
			}
		});
		
		fdmDataServer.startServer();
		
		Runtime.getRuntime().addShutdownHook(new Thread(){
			@Override
			public void run() {
				fdmDataServer.stopServer();
			}
		});
	}
}
