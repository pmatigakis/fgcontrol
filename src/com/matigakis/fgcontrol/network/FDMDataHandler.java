package com.matigakis.fgcontrol.network;

import java.util.LinkedList;
import java.util.List;

import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.matigakis.fgcontrol.fdm.FDMData;
import com.matigakis.fgcontrol.fdm.FDMDataFactory;

/**
 * The FDMDataHandler object processes the data received from Flightgear
 */
public class FDMDataHandler extends ChannelInboundHandlerAdapter{
	private static final Logger logger = LoggerFactory.getLogger(FDMDataHandler.class);

	private FDMDataServer fdmDataServer;
	private List<FDMDataServerEventListener> fdmDataListeners;
	
	public FDMDataHandler(FDMDataServer fdmDataServer){
		super();
	
		
		this.fdmDataServer = fdmDataServer;
		fdmDataListeners = new LinkedList<FDMDataServerEventListener>();
	}
	
	/**
	 * Handle the fdm data string that was received
	 */
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg){
		try{
			DatagramPacket packet = (DatagramPacket) msg;
		
			String fdmMessage = packet.content().toString(CharsetUtil.US_ASCII);
		
			GenericProtocolData genericProtocolData = GenericProtocolDataFactory.fromString(fdmMessage);
		
			FDMData fdmData = FDMDataFactory.fromGenericProtocolData(genericProtocolData);
		
			notifyFDMListeners(fdmData);
		}finally{
			ReferenceCountUtil.release(msg);
		}
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){
		logger.error("Exception raised in FDMDataHandler", cause);
		ctx.close();
	}
	
	/**
	 * Add an FDMDataServerEventListener that will be notified when new fdm data
	 * have been received
	 * 
	 * @param FDMDataServerEventListener
	 */
	public void addFDMDataServerEventListener(FDMDataServerEventListener serverDataListener){
		fdmDataListeners.add(serverDataListener);
	}
	
	/**
	 * Remove an FDMDataServerEventListener
	 * 
	 * @param FDMDataServerEventListener
	 */
	public void removeFDMDataServerEventListener(FDMDataServerEventListener serverDataListener){
		fdmDataListeners.remove(serverDataListener);
	}
	
	private void notifyFDMListeners(FDMData fdmData){
		for(FDMDataServerEventListener fdmDataListener: fdmDataListeners){
			fdmDataListener.FDMDataReceived(fdmDataServer, fdmData);
		}
	}
}
