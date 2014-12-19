package com.matigakis.fgcontrol.network;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelHandler;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;

public class UDPFDMServer extends BaseFDMServer{
	public UDPFDMServer(int port) {
		super(port);
	}

	@Override
	protected Bootstrap createBootstrap(EventLoopGroup group, ChannelHandler channelHandler) {
		Bootstrap bootstrap = new Bootstrap();
		
		bootstrap.group(group)
			.channel(NioDatagramChannel.class)
			.handler(channelHandler);
			
		return bootstrap;
	}
}
