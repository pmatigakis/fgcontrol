import java.net.InetSocketAddress;

import org.apache.log4j.BasicConfigurator;

import com.matigakis.fgcontrol.fdm.Controls;
import com.matigakis.fgcontrol.network.ControlsClient;
import com.matigakis.fgcontrol.network.ControlsConnection;
import com.matigakis.fgcontrol.network.ControlsConnentionEventListener;
import com.matigakis.fgcontrol.network.UDPControlsConnection;

public class ControlsClientExample {
	public static void main(String[] args) throws Exception {
		BasicConfigurator.configure();
		
		InetSocketAddress address = new InetSocketAddress("localhost", 10501);
		
		ControlsConnection controlsConnection = new UDPControlsConnection(address);
		
		ControlsClient controlsClient = new ControlsClient(controlsConnection);
		
		controlsConnection.addControlsConnectionEventListener(new ControlsConnentionEventListener() {
			@Override
			public void disconnected(ControlsConnection controlsConnection) {
				System.out.println("Disconnected from flightgear's controls server");
				
			}
			
			@Override
			public void connected(ControlsConnection controlsConnection) {
				System.out.println("Connected to flightgear's controls server");
				
			}
		});
		
		controlsClient.connect();
		
		controlsClient.transmitControls(new Controls(0.0, 0.0, 0.0, 1.0));
		
		Thread.sleep(2000);
		
		controlsClient.disconnect();
	}
}
