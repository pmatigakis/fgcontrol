package com.matigakis.fgcontrol.network;

import java.net.InetSocketAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.util.CharsetUtil;

/**
 * The UDPControlsConnection clas is used to open a UDP connection to Flightgear's
 * controls port.
 */
public class UDPControlsConnection implements ControlsConnection{
	private static final Logger LOGGER = LoggerFactory.getLogger(UDPControlsConnection.class);

	private EventLoopGroup group;
	private ControlsHandler controlsHandler;
	private Channel channel;
	private InetSocketAddress address;
	private boolean connected;
	
	public UDPControlsConnection(InetSocketAddress address){
		this.address = address;
		
		controlsHandler = new ControlsHandler(this);
		
		connected = false;
	}
	
	@Override
	public void connect() throws ControlsConnectionException {
		LOGGER.debug("Connecting to FLightgear's controls port");
		
		group = new NioEventLoopGroup();
		
		Bootstrap bootstrap = new Bootstrap();
		
		bootstrap.group(group)
		.channel(NioDatagramChannel.class)
		.option(ChannelOption.SO_BROADCAST, true)
		.handler(controlsHandler);
		
		try{
			channel = bootstrap.bind(0).sync().channel();
		}catch(InterruptedException e){
			LOGGER.error("Failed to connect to flightgear's controls port", e);
			group.shutdownGracefully();
			throw new ControlsConnectionException("Failed to connect to flightgear's controls port", e);
		}
	
		connected = true;
		
		LOGGER.debug("Connected to FLightgear's controls port");
	}

	@Override
	public void disconnect() {
		group.shutdownGracefully();
		
		connected = false;
	}

	@Override
	public void addControlsConnectionEventListener(ControlsConnentionEventListener listener) {
		controlsHandler.addControlsClientEventListener(listener);
	}

	@Override
	public void removeControlsConnectionEventListener(ControlsConnentionEventListener listener) {
		controlsHandler.removeControlsClientEventListener(listener);
	}

	@Override
	public boolean isConnected() {
		return connected;
	}

	@Override
	public void writeControls(String controls) {
		DatagramPacket packet = new DatagramPacket(Unpooled.copiedBuffer(controls, CharsetUtil.US_ASCII), address);
		
		channel.writeAndFlush(packet);	
	}
}
