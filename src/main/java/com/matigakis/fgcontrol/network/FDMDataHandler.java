package com.matigakis.fgcontrol.network;

import java.util.LinkedList;
import java.util.List;

import static io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.matigakis.fgcontrol.fdm.FDMData;

/**
 * The FDMDataHandler object processes the data received from Flightgear
 */
@Sharable
public class FDMDataHandler extends ChannelInboundHandlerAdapter{
	private static final Logger logger = LoggerFactory.getLogger(FDMDataHandler.class);

	private FDMDataServer fdmDataServer;
	private List<FDMDataServerEventListener> fdmDataServerEventListeners;

	public FDMDataHandler(FDMDataServer fdmDataServer){
		super();

		this.fdmDataServer = fdmDataServer;
		fdmDataServerEventListeners = new LinkedList<FDMDataServerEventListener>();
	}

	public void notifyListenersThatServerHasStarted(){
		for(FDMDataServerEventListener listener: fdmDataServerEventListeners){
			listener.FDMDataServerStarted(fdmDataServer);
		}
	}

	public void notifyListenersThatServerHasStopped(){
		for(FDMDataServerEventListener listener: fdmDataServerEventListeners){
			listener.FDMDataServerShutdown(fdmDataServer);
		}
	}

	/**
	 * Handle the fdm data string that was received
	 */
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg){
		try{
			FDMData fdmData = (FDMData) msg;

			sendFDMDataToListeners(fdmData);
		}finally{
			ReferenceCountUtil.release(msg);
		}
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){
		logger.error("Exception raised in FDMDataHandler", cause);
	}

	/**
	 * Add an FDMDataServerEventListener that will be notified when new fdm data
	 * have been received
	 *
	 * @param FDMDataServerEventListener
	 */
	public void addFDMDataServerEventListener(FDMDataServerEventListener serverDataListener){
		fdmDataServerEventListeners.add(serverDataListener);
	}

	/**
	 * Remove an FDMDataServerEventListener
	 *
	 * @param FDMDataServerEventListener
	 */
	public void removeFDMDataServerEventListener(FDMDataServerEventListener serverDataListener){
		fdmDataServerEventListeners.remove(serverDataListener);
	}

	private void sendFDMDataToListeners(FDMData fdmData){
		for(FDMDataServerEventListener fdmDataListener: fdmDataServerEventListeners){
			fdmDataListener.FDMDataReceived(fdmDataServer, fdmData);
		}
	}
}
