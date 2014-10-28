package com.matigakis.fgcontrol.network;

import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The TelemetryHandler object processes the data received from Flightgear
 */
public class TelemetryStringHandler extends SimpleChannelInboundHandler<DatagramPacket>{
	private static final Logger logger = LoggerFactory.getLogger(TelemetryStringHandler.class);
	private final TelemetryFactory telemetryFactory;
	private TelemetryServer telemetryServer;
	
	public TelemetryStringHandler(TelemetryServer telemetryServer){
		super();
		
		this.telemetryServer = telemetryServer;
		telemetryFactory = new TelemetryFactory();
	}
	
	/**
	 * Handle the telemetry string that was received
	 */
	@Override
	protected void channelRead0(ChannelHandlerContext arg0, DatagramPacket msg){
		//System.out.println(msg.content().toString(CharsetUtil.US_ASCII));
		String data = msg.content().toString(CharsetUtil.US_ASCII);
		
		Telemetry telemetry = telemetryFactory.fromString(data);
		
		telemetryServer.setTelemetry(telemetry);
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){
		logger.error("Exception raised in TelemetryHandler", cause);
		ctx.close();
	}
}
