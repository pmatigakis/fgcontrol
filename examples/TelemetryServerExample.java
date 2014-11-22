

import com.matigakis.fgcontrol.network.Telemetry;
import com.matigakis.fgcontrol.network.TelemetryListener;
import com.matigakis.fgcontrol.network.TelemetryServer;
import com.matigakis.fgcontrol.network.UDPTelemetryServer;

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
		
		TelemetryServer telemetryServer = new UDPTelemetryServer(telemetryPort);
		
		telemetryServer.addTelemetryListener(telemetryServerExample);
		
		telemetryServer.startServer();
	}
}
