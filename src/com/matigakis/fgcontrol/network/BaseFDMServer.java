package com.matigakis.fgcontrol.network;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.bootstrap.Bootstrap;

/**
 * The BaseFDMServer object is the base object for all servers that can
 * connect to flightgear and receive FDM data
 */
public abstract class BaseFDMServer implements FDMDataServer{
	private static final Logger logger = LoggerFactory.getLogger(BaseFDMServer.class);
	
	private int port;
	private EventLoopGroup group;
	private Channel channel;
	
	private List<FDMDataServerEventListener> serverEventListeners;
	
	private FDMDataHandler telemetryHandler;
	
	protected abstract Bootstrap createBootstrap(EventLoopGroup group, ChannelHandler channelHandler);
	
	public BaseFDMServer(int port){
		this.port = port;
		
		serverEventListeners = new LinkedList<FDMDataServerEventListener>();
		
		telemetryHandler = new FDMDataHandler(this);
	}
	
	@Override
	public void startServer() throws FDMServerException{
		if(!isRunning()){
			logger.debug("Starting the FDM server");
			
			group = new NioEventLoopGroup();
			
			Bootstrap bootstrap = createBootstrap(group, telemetryHandler);
			
			try {
				channel = bootstrap.bind(port).sync().channel();
			} catch (InterruptedException e) {
				logger.error("The FDM server has failed to start", e);
				
				group.shutdownGracefully();
				
				throw new FDMServerException("The FDM server has failed to start", e);
			}
			
			for(FDMDataServerEventListener serverDataListener: serverEventListeners){
				serverDataListener.FDMDataServerStarted(this);
			}
			
			logger.debug("The FDM server has started successfully");
		}else{
			logger.debug("The FDM server is already running");	
		}
	}
	
	@Override
	public void stopServer(){
		if (isRunning()){
			logger.debug("Shutting down the FDM server");
		
			group.shutdownGracefully();
			
			for(FDMDataServerEventListener serverDataListener: serverEventListeners){
				serverDataListener.FDMDataServerShutdown(this);
			}
			
			logger.debug("The FDM server has stopped");
		}else{
			logger.debug("The FDM server if not running");
		}
	}
	
	public boolean isRunning(){
		if(channel == null){
			return false;
		}else{
			return channel.isActive();
		}
	}
	
	@Override
	public void addFDMDataServerEventListener(FDMDataServerEventListener serverEventListener){
		serverEventListeners.add(serverEventListener);
		telemetryHandler.addFDMDataServerEventListener(serverEventListener);
	}
	
	@Override
	public void removeFDMDataServerEventListener(FDMDataServerEventListener serverEventListener){
		serverEventListeners.remove(serverEventListener);
		telemetryHandler.removeFDMDataServerEventListener(serverEventListener);
	}
}
