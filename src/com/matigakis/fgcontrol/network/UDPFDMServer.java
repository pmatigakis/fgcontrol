package com.matigakis.fgcontrol.network;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.socket.nio.NioDatagramChannel;

public class UDPFDMServer extends BaseFDMServer{
	private FDMStringHandler telemetryHandler;
	
	public UDPFDMServer(int port) {
		super(port);
		
		telemetryHandler = new FDMStringHandler();
	}

	@Override
	protected void setupBootstrap(Bootstrap bootstrap) {
		bootstrap.channel(NioDatagramChannel.class)
		         .option(ChannelOption.SO_BROADCAST, true)
		         .handler(telemetryHandler);
	}

	@Override
	public void addFDMDataListener(FDMDataListener telemetryListener) {
		telemetryHandler.addTelemetryListener(telemetryListener);
	}

	@Override
	public void removeFDMDataListener(FDMDataListener telemetryListener) {
		telemetryHandler.removeTelemetryListener(telemetryListener);
	}
}
