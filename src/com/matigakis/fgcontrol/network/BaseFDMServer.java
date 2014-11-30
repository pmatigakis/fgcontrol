package com.matigakis.fgcontrol.network;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;

/**
 * The BaseFDMServer object is the base object for all servers that can
 * connect to flightgear and receive telemetry data
 */
public abstract class BaseFDMServer extends Thread implements FDMDataServer{
	private static final Logger logger = LoggerFactory.getLogger(BaseFDMServer.class);
	
	private final int port;
	private EventLoopGroup group;
	
	protected abstract void setupBootstrap(Bootstrap bootstrap);
	
	public BaseFDMServer(int port){
		super();
		
		this.port = port;
	}
	
	public void run(){
		logger.info("Starting the sensor server");
		
		group = new NioEventLoopGroup();
		
		Bootstrap bootstrap = new Bootstrap();
		bootstrap.group(group);
		
		setupBootstrap(bootstrap);
		
		try{
			ChannelFuture channelFuture = bootstrap.bind(port).sync();
			
			logger.info("The sensor server has started successfully");
			
			channelFuture.channel().closeFuture().await();
		}catch(InterruptedException e){
			logger.error("The sensor server has encoutered an error", e); 
		}
		
		logger.info("The sensor server has stopped");
	}
	
	@Override
	public void startServer(){
		start();
	}
	
	@Override
	public void stopServer(){
		logger.info("Shutting down the sensor server");
		
		group.shutdownGracefully();
	}
}
