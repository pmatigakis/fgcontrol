package com.matigakis.fgcontrol.network;

import java.util.List;

import com.matigakis.fgcontrol.fdm.FDMData;
import com.matigakis.fgcontrol.fdm.FDMDataFactory;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

/**
 * The FDMDataDecoder converts the GenericProtocolData that was received from the
 * previous stage of the pipeline, to an FDMData object
 */
public class FDMDataDecoder extends MessageToMessageDecoder<GenericProtocolData>{
	@Override
	protected void decode(ChannelHandlerContext ctx, GenericProtocolData genericProtocolData, List<Object> out) throws Exception {
		FDMData fdmData = FDMDataFactory.fromGenericProtocolData(genericProtocolData);
		
		out.add(fdmData);
	}
}
