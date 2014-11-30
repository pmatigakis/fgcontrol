package com.matigakis.fgcontrol.network;

import java.util.LinkedList;
import java.util.List;

import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.matigakis.fgcontrol.fdm.FDMData;
import com.matigakis.fgcontrol.fdm.FDMDataFactory;

/**
 * The FDMStringHandler object processes the data received from Flightgear
 */
public class FDMStringHandler extends SimpleChannelInboundHandler<DatagramPacket>{
	private static final Logger logger = LoggerFactory.getLogger(FDMStringHandler.class);

	private List<FDMDataListener> fdmListeners;
	
	public FDMStringHandler(){
		super();
	
		fdmListeners = new LinkedList<FDMDataListener>();
	}
	
	/**
	 * Handle the telemetry string that was received
	 */
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket msg){
		String data = msg.content().toString(CharsetUtil.US_ASCII);
		
		Telemetry telemetry = TelemetryFactory.fromString(data);
		
		FDMData fdmData = FDMDataFactory.fromTelemetry(telemetry);
		
		notifyFDMListeners(fdmData);
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){
		logger.error("Exception raised in TelemetryHandler", cause);
		ctx.close();
	}
	
	/**
	 * Add an FDMDataListener that will be notified when new fdm data
	 * have been received
	 * 
	 * @param fdmDataListener
	 */
	public void addTelemetryListener(FDMDataListener fdmDataListener){
		fdmListeners.add(fdmDataListener);
	}
	
	/**
	 * Remove an FDMDataListener
	 * 
	 * @param fdmDataListener
	 */
	public void removeTelemetryListener(FDMDataListener fdmDataListener){
		fdmListeners.remove(fdmDataListener);
	}
	
	private void notifyFDMListeners(FDMData fdmData){
		for(FDMDataListener fdmListener: fdmListeners){
			fdmListener.handleFDMData(fdmData);
		}
	}
}
