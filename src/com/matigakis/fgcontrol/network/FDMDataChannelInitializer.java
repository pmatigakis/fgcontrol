package com.matigakis.fgcontrol.network;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.DatagramChannel;

/**
 * The FDMDataChannelInitializer create a channel pipeline that processes FDM data
 * received from an UDP connection
 */
public class FDMDataChannelInitializer extends ChannelInitializer<DatagramChannel>{
	private FDMDataHandler fdmDataHandler;
	
	public FDMDataChannelInitializer(FDMDataHandler fdmDataHandler){
		this.fdmDataHandler = fdmDataHandler;
	}
	
	@Override
	protected void initChannel(DatagramChannel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();
		
		pipeline.addLast(
				new DatagramToStringDecoder(),
				new GenericProtocolDataDecoder(),
				new FDMDataDecoder(),
				fdmDataHandler
		);
	}
}
