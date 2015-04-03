package com.matigakis.fgcontrol.network;

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
	
	private FDMDataHandler telemetryHandler;
	
	protected abstract Bootstrap createBootstrap(EventLoopGroup group, ChannelHandler channelHandler);
	
	public BaseFDMServer(int port){
		this.port = port;
		
		telemetryHandler = new FDMDataHandler(this);
	}
	
	public int getPort(){
		return port;
	}
	
	@Override
	public void startServer() throws FDMServerException{
		if(!isRunning()){
			logger.debug("Starting the FDM server on port " + getPort());
			
			group = new NioEventLoopGroup();
			
			Bootstrap bootstrap = createBootstrap(group, telemetryHandler);
			
			try {
				channel = bootstrap.bind(port).sync().channel();
			} catch (InterruptedException e) {
				logger.error("The FDM server has failed to start on port " + getPort(), e);
				
				group.shutdownGracefully();
				
				throw new FDMServerException("The FDM server has failed to start on port " + getPort(), e);
			}
			
			logger.debug("The FDM server has started successfully on port " + getPort());
		}else{
			logger.debug("The FDM server is already running on port " + getPort());	
		}
	}
	
	@Override
	public void stopServer(){
		if (isRunning()){
			logger.debug("Shutting down the FDM server");
		
			group.shutdownGracefully();
			
			logger.debug("The FDM server has stopped");
		}else{
			logger.debug("The FDM server is not running");
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
		telemetryHandler.addFDMDataServerEventListener(serverEventListener);
	}
	
	@Override
	public void removeFDMDataServerEventListener(FDMDataServerEventListener serverEventListener){
		telemetryHandler.removeFDMDataServerEventListener(serverEventListener);
	}
}
