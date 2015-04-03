import org.apache.log4j.BasicConfigurator;

import com.matigakis.fgcontrol.fdm.FDMData;
import com.matigakis.fgcontrol.network.FDMDataServer;
import com.matigakis.fgcontrol.network.FDMDataServerEventListener;
import com.matigakis.fgcontrol.network.UDPFDMServer;

public class FDMServerExample{
	public static void main(String[] args) throws Exception{
		BasicConfigurator.configure();
		
		int telemetryPort = 10500;
		
		final FDMDataServer fdmDataServer = new UDPFDMServer(telemetryPort);
		
		fdmDataServer.addFDMDataServerEventListener(new FDMDataServerEventListener() {
			@Override
			public void FDMDataReceived(FDMDataServer fdmDataServer, FDMData fdmData) {
				System.out.println(
						"Altitude: " + fdmData.getPosition().getAltitude() + "\t" +
						"Heading: " + fdmData.getOrientation().getHeading() + "\t" +
						"Airspeed: " + fdmData.getVelocities().getCalibratedAirspeed());	
			}

			@Override
			public void FDMDataServerStarted(FDMDataServer fdmDataServer) {
				System.out.println("The FDM data server has started");
				
			}

			@Override
			public void FDMDataServerShutdown(FDMDataServer fdmDataServer) {
				System.out.println("The FDM data server is shutting down");
			}
		});
		
		fdmDataServer.startServer();
		Thread.sleep(5000);
		fdmDataServer.stopServer();
	}
}
