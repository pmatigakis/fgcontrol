package com.matigakis.fgcontrol.network;

import java.util.LinkedList;
import java.util.List;

import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.matigakis.fgcontrol.fdm.FDMData;
import com.matigakis.fgcontrol.fdm.FDMDataFactory;

/**
 * The FDMDataHandler object processes the data received from Flightgear
 */
public class FDMDataHandler extends ChannelInboundHandlerAdapter{
	private static final Logger logger = LoggerFactory.getLogger(FDMDataHandler.class);

	private List<FDMDataListener> fdmListeners;
	
	public FDMDataHandler(){
		super();
	
		fdmListeners = new LinkedList<FDMDataListener>();
	}
	
	/**
	 * Handle the telemetry string that was received
	 */
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg){
		DatagramPacket packet = (DatagramPacket) msg;
		
		String fdmMessage = packet.content().toString(CharsetUtil.US_ASCII);
		
		GenericProtocolData genericProtocolData = GenericProtocolDataFactory.fromString(fdmMessage);
		
		FDMData fdmData = FDMDataFactory.fromGenericProtocolData(genericProtocolData);
		
		notifyFDMListeners(fdmData);
		
		packet.release();
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){
		logger.error("Exception raised in FDMDataHandler", cause);
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
