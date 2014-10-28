package com.matigakis.fgcontrol.network;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelFuture;

/**
 * The SensorServer object is used to receive telemetry data from Flightgear
 */
public class TelemetryServer extends Thread{
	private static final Logger logger = LoggerFactory.getLogger(TelemetryServer.class);
	private final int port;
	private EventLoopGroup group;
	private final TelemetryStringHandler telemetryHandler;
	private Telemetry telemetry;
	private List<TelemetryListener> telemetryListeners;
	
	public TelemetryServer(int port){
		super();
		
		this.port = port;
		this.telemetryHandler = new TelemetryStringHandler(this);
		
		telemetryListeners = new LinkedList<TelemetryListener>();
	}
	
	public void run(){
		logger.info("Starting the sensor server");
		
		//EventLoopGroup group = new NioEventLoopGroup();
		group = new NioEventLoopGroup();
		
		Bootstrap bootstrap = new Bootstrap();
		bootstrap.group(group)
		.channel(NioDatagramChannel.class)
		.option(ChannelOption.SO_BROADCAST, true)
		.handler(telemetryHandler);
		
		try{
			ChannelFuture channelFuture = bootstrap.bind(port).sync();
			
			logger.info("The sensor server has started successfully");
			
			channelFuture.channel().closeFuture().await();
		}catch(InterruptedException e){
			logger.error("The sensor server has encoutered an error", e); 
		}
		
		logger.info("The sensor server has stopped");
	}
	
	public void startServer(){
		start();
	}
	
	public void stopServer(){
		logger.info("Shutting down the sensor server");
		
		group.shutdownGracefully();
	}
	
	public void addTelemetryListener(TelemetryListener telemetryListener){
		telemetryListeners.add(telemetryListener);
	}
	
	public void removeTelemetryListener(TelemetryListener telemetryListener){
		telemetryListeners.remove(telemetryListener);
	}
	
	public void setTelemetry(Telemetry telemetry){
		this.telemetry = telemetry;
		
		notifyTelemetryListeners();
	}
	
	private void notifyTelemetryListeners(){
		for(TelemetryListener telemetryListener: telemetryListeners){
			telemetryListener.handleTelemetry(telemetry);
		}
	}
}
