package com.matigakis.fgcontrol;

import com.matigakis.fgcontrol.fdm.NetworkFDM;

public final class FgControl {	
	public static NetworkFDM createNetworkFDM(String host, int telemetryPort, int controlsPort){
		return new NetworkFDM(host, telemetryPort, controlsPort);
	}
}
