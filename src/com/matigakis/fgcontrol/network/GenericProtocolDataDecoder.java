package com.matigakis.fgcontrol.network;

import java.util.List;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

/**
 * The GenericProtocolDataDecoder converts the string that was received in the
 * previous stage of the channel pipeline to a GenericProtocolData object
 */
public class GenericProtocolDataDecoder extends MessageToMessageDecoder<String>{
	@Override
	protected void decode(ChannelHandlerContext ctx, String genericProtocolMessage, List<Object> out) throws Exception {
		GenericProtocolData genericProtocolData = GenericProtocolDataFactory.fromString(genericProtocolMessage);
		
		out.add(genericProtocolData);
	}
}
