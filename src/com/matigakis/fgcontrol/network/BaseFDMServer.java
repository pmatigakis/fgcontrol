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
	
	private final int port;
	private EventLoopGroup group;
	private Channel channel;
	
	private FDMStringHandler telemetryHandler;
	
	protected abstract Bootstrap createBootstrap(EventLoopGroup group, ChannelHandler channelHandler);
	
	public BaseFDMServer(int port){
		super();
		
		this.port = port;
		
		group = new NioEventLoopGroup();
		
		telemetryHandler = new FDMStringHandler();
	}
	
	@Override
	public void addFDMDataListener(FDMDataListener telemetryListener) {
		telemetryHandler.addTelemetryListener(telemetryListener);
	}

	@Override
	public void removeFDMDataListener(FDMDataListener telemetryListener) {
		telemetryHandler.removeTelemetryListener(telemetryListener);
	}
	
	@Override
	public void startServer() throws FDMServerException{
		if(!isRunning()){
			logger.debug("Starting the FDM server");
			
			Bootstrap bootstrap = createBootstrap(group, telemetryHandler);
			
			try {
				channel = bootstrap.bind(port).sync().channel();
			} catch (InterruptedException e) {
				logger.error("The FDM server has failed to start", e);
				throw new FDMServerException("The FDM server has failed to start");
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
		
			channel.close();
		
			group.shutdownGracefully();
			
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
}
