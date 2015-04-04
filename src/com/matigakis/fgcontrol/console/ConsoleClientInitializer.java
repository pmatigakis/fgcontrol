package com.matigakis.fgcontrol.console;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

public class ConsoleClientInitializer extends ChannelInitializer<SocketChannel>{
	private ConsoleClientHandler consoleClientHandler;
	
	public ConsoleClientInitializer(ConsoleClientHandler consoleClientHandler) {
		this.consoleClientHandler = consoleClientHandler;
	}
	
	@Override
	protected void initChannel(SocketChannel channel) throws Exception {
		ChannelPipeline pipeline = channel.pipeline();
		
		pipeline.addLast(new StringEncoder(CharsetUtil.US_ASCII));
		pipeline.addLast(consoleClientHandler);
	}
}
