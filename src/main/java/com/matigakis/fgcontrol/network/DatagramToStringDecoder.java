package com.matigakis.fgcontrol.network;

import java.util.List;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.util.CharsetUtil;

public class DatagramToStringDecoder extends MessageToMessageDecoder<DatagramPacket>{
	@Override
	protected void decode(ChannelHandlerContext ctx, DatagramPacket datagramPacket, List<Object> out) throws Exception {
		String genericProtocolMessage = datagramPacket.content().toString(CharsetUtil.US_ASCII);

		out.add(genericProtocolMessage);
	}
}
