package com.matigakis.fgcontrol.console;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

public class ConsoleClientHandler extends ChannelInboundHandlerAdapter{
	private static final Logger LOGGER = LoggerFactory.getLogger(ConsoleClientHandler.class);
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		String line = (String) msg;
		
		LOGGER.debug("Received " + msg);
		
		ReferenceCountUtil.release(msg);
	}
}
