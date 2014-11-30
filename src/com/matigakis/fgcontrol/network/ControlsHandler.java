package com.matigakis.fgcontrol.network;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;

public class ControlsHandler extends SimpleChannelInboundHandler<DatagramPacket>{
	@Override
	protected void channelRead0(ChannelHandlerContext arg0, DatagramPacket arg1)
			throws Exception {
		
	}
}
