package com.matigakis.fgcontrol.network;

public interface TelemetryServer {
	void startServer();
	void stopServer();
	void addTelemetryListener(TelemetryListener telemetryListener);
	void removeTelemetryListener(TelemetryListener telemetryListener);
}