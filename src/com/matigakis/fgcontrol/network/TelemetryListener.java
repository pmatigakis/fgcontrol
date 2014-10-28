package com.matigakis.fgcontrol.network;


/**
 * Every object that needs to be informed when new telemetry data have
 * been received, needs to implement this interface.
 */
public interface TelemetryListener {
	void handleTelemetry(Telemetry telemetry); 
}
