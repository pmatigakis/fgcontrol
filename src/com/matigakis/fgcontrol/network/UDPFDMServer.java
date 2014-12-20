package com.matigakis.fgcontrol.network;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;

/**
 * The UDPFDMServer is used to connect to Flightgear's generic protocol server using
 * an UDP connection.
 */
public class UDPFDMServer extends BaseFDMServer{
	public UDPFDMServer(int port) {
		super(port);
	}

	@Override
	protected Bootstrap createBootstrap(EventLoopGroup group, ChannelHandler channelHandler) {
		Bootstrap bootstrap = new Bootstrap();
		
		bootstrap.group(group)
			.channel(NioDatagramChannel.class)
			.option(ChannelOption.SO_BROADCAST, true)
			.handler(channelHandler);
			
		return bootstrap;
	}
}
