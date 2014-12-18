package com.matigakis.fgcontrol.network;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;

public class UDPFDMServer extends BaseFDMServer{
	private FDMStringHandler telemetryHandler;
	
	public UDPFDMServer(int port) {
		super(port);
		
		telemetryHandler = new FDMStringHandler();
	}

	@Override
	public void addFDMDataListener(FDMDataListener telemetryListener) {
		telemetryHandler.addTelemetryListener(telemetryListener);
	}

	@Override
	public void removeFDMDataListener(FDMDataListener telemetryListener) {
		telemetryHandler.removeTelemetryListener(telemetryListener);
	}

	@Override
	protected Bootstrap createBootstrap(EventLoopGroup group) {
		Bootstrap bootstrap = new Bootstrap();
		
		bootstrap.group(group)
			.channel(NioDatagramChannel.class)
			//.option(ChannelOption.SO_BROADCAST, true)
			.handler(telemetryHandler);
		
		return bootstrap;
	}
}
