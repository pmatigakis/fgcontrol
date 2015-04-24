package com.matigakis.fgcontrol.console.network;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

public class ConsoleConnectionInitializer extends ChannelInitializer<SocketChannel>{
	private ConsoleConnectionHandler consoleClientHandler;
	
	public ConsoleConnectionInitializer(ConsoleConnectionHandler consoleClientHandler) {
		this.consoleClientHandler = consoleClientHandler;
	}
	
	@Override
	protected void initChannel(SocketChannel channel) throws Exception {
		ChannelPipeline pipeline = channel.pipeline();
		
		pipeline.addLast(new StringEncoder(CharsetUtil.US_ASCII));
		pipeline.addLast(consoleClientHandler);
	}
}
