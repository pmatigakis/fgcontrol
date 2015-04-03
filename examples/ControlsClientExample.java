import org.apache.log4j.BasicConfigurator;

import com.matigakis.fgcontrol.fdm.Controls;
import com.matigakis.fgcontrol.network.ControlsClient;
import com.matigakis.fgcontrol.network.ControlsClientEventListener;

public class ControlsClientExample {
	public static void main(String[] args) throws Exception {
		BasicConfigurator.configure();
		
		ControlsClient controlsClient = new ControlsClient("localhost", 10501);
		
		controlsClient.addControlsClientEventListener(new ControlsClientEventListener() {
			@Override
			public void disconnected(ControlsClient controlsClient) {
				System.out.println("Disconnected from flightgear's controls server");
				
			}
			
			@Override
			public void connected(ControlsClient controlsClient) {
				System.out.println("Connected to flightgear's controls server");
				
			}
		});
		
		controlsClient.connect();
		
		controlsClient.transmitControls(new Controls(0.0, 0.0, 0.0, 1.0));
		
		Thread.sleep(2000);
		
		controlsClient.disconnect();
	}
}
