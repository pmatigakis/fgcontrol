package com.matigakis.fgcontrol.network;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.socket.nio.NioDatagramChannel;

public class UDPTelemetryServer extends BaseTelemetryServer{
	private UDPTelemetryStringHandler telemetryHandler;
	
	public UDPTelemetryServer(int port) {
		super(port);
		
		telemetryHandler = new UDPTelemetryStringHandler();
	}

	@Override
	protected void setupBootstrap(Bootstrap bootstrap) {
		bootstrap.channel(NioDatagramChannel.class)
		         .option(ChannelOption.SO_BROADCAST, true)
		         .handler(telemetryHandler);
	}

	@Override
	public void addTelemetryListener(TelemetryListener telemetryListener) {
		telemetryHandler.addTelemetryListener(telemetryListener);
	}

	@Override
	public void removeTelemetryListener(TelemetryListener telemetryListener) {
		telemetryHandler.removeTelemetryListener(telemetryListener);
	}
}
