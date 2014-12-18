package com.matigakis.fgcontrol.console;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class ConsoleClientHandler extends ChannelHandlerAdapter{
	private static final Logger LOGGER = LoggerFactory.getLogger(ConsoleClientHandler.class);
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		LOGGER.error("Exception raised in Flightgear's telnet console", cause);
		ctx.close();
	}
}
