package com.matigakis.fgcontrol.network;

import java.net.InetSocketAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.channel.Channel;
import io.netty.channel.socket.DatagramPacket;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;

import com.matigakis.fgcontrol.fdm.Controls;

/**
 * The ControlsClient class is responsible to transmit the state of an aircraft's
 * controls to Flightgear.
 */
public class ControlsClient {
	private static final Logger LOGGER = LoggerFactory.getLogger(ControlsClient.class);
	private InetSocketAddress address;
	private EventLoopGroup group;
	private Channel channel;
	
	public ControlsClient(String host, int port){
		address = new InetSocketAddress(host, port);
	}
	
	public String getHost(){
		return address.getHostString();
	}
	
	public int getPort(){
		return address.getPort();
	}
	
	/**
	 * Open a UDP connection to Flightgear
	 * 
	 * @throws InterruptedException
	 */
	public void connect() throws ControlsClientConnectionException{
		if(!isConnected()){
			LOGGER.debug("Opening connection to controls server");
			
			group = new NioEventLoopGroup();
			
			Bootstrap bootstrap = new Bootstrap();
			
			bootstrap.group(group)
			.channel(NioDatagramChannel.class)
			.option(ChannelOption.SO_BROADCAST, true)
			.handler(new ControlsHandler());
			
			try{
				channel = bootstrap.bind(0).sync().channel();
			}catch(InterruptedException e){
				LOGGER.error("Failed to connect to flightgear's controls port", e);
				group.shutdownGracefully();
				throw new ControlsClientConnectionException("Failed to connect to flightgear's controls port", e);
			}
			
			LOGGER.debug("Connected to Flightgear's controls server");
		}else{
			LOGGER.debug("Already connected to Flightgear's controls client");
		}
	}
	
	/**
	 * Close the connection
	 */
	public void disconnect(){
		LOGGER.debug("Closing connection to controls server");
		
		group.shutdownGracefully();
		
		LOGGER.debug("Disconnected from controls server");
	}
	
	/**
	 * Transmit the aircraft controls state to Flightgear
	 * 
	 * @param controls the aircraft controls
	 */
	public void transmitControls(Controls controls){
		String controlsString = controls.getElevator() + "\t" + controls.getAileron() + "\t" + controls.getRudder() + "\t" + controls.getThrottle() + "\n";
		
		DatagramPacket packet = new DatagramPacket(Unpooled.copiedBuffer(controlsString, CharsetUtil.US_ASCII), address);
		
		channel.writeAndFlush(packet);
	}
	
	/**
	 * Check if the client is connected
	 * 
	 * @return true if connected
	 */
	public boolean isConnected(){
		if(channel == null){
			return false;
		}else{
			return channel.isActive();
		}
	}
}
