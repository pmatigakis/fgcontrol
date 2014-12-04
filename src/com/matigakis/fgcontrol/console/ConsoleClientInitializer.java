package com.matigakis.fgcontrol.console;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

public class ConsoleClientInitializer extends ChannelInitializer<SocketChannel>{
	private ConsoleClientHandler handler;
	
	public ConsoleClientInitializer(ConsoleClientHandler handler){
		this.handler = handler;
	}
	
	@Override
	protected void initChannel(SocketChannel channel) throws Exception {
		ChannelPipeline pipeline = channel.pipeline();
		
		pipeline.addLast(new LineBasedFrameDecoder(1024));
		pipeline.addLast(new StringDecoder(CharsetUtil.US_ASCII));
		pipeline.addLast(new StringEncoder(CharsetUtil.US_ASCII));
		pipeline.addLast(handler);
	}
}
