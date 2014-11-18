package com.matigakis.fgcontrol.network;

import java.util.LinkedList;
import java.util.List;

import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The TelemetryHandler object processes the data received from Flightgear
 */
public class UDPTelemetryStringHandler extends SimpleChannelInboundHandler<DatagramPacket>{
	private static final Logger logger = LoggerFactory.getLogger(UDPTelemetryStringHandler.class);

	private List<TelemetryListener> telemetryListeners;
	
	public UDPTelemetryStringHandler(){
		super();
	
		telemetryListeners = new LinkedList<TelemetryListener>();
	}
	
	/**
	 * Handle the telemetry string that was received
	 */
	@Override
	protected void channelRead0(ChannelHandlerContext arg0, DatagramPacket msg){
		String data = msg.content().toString(CharsetUtil.US_ASCII);
		
		Telemetry telemetry = TelemetryFactory.fromString(data);
		
		notifyTelemetryListeners(telemetry);
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){
		logger.error("Exception raised in TelemetryHandler", cause);
		ctx.close();
	}
	
	public void addTelemetryListener(TelemetryListener telemetryListener){
		telemetryListeners.add(telemetryListener);
	}
	
	public void removeTelemetryListener(TelemetryListener telemetryListener){
		telemetryListeners.remove(telemetryListener);
	}
	
	private void notifyTelemetryListeners(Telemetry telemetry){
		for(TelemetryListener telemetryListener: telemetryListeners){
			telemetryListener.handleTelemetry(telemetry);
		}
	}
}
