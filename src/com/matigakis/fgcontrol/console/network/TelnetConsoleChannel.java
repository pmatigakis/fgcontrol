package com.matigakis.fgcontrol.console.network;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.matigakis.fgcontrol.console.ConsoleClientHandler;
import com.matigakis.fgcontrol.console.ConsoleClientInitializer;
import com.matigakis.fgcontrol.console.TelnetConsoleClient;

public class TelnetConsoleChannel implements ConsoleChannel{
	private static Logger LOGGER = LoggerFactory.getLogger(TelnetConsoleClient.class);
	
	private InetSocketAddress address;
	private ConsoleClientHandler consoleClientHandler;
	private Channel channel;
	private EventLoopGroup group;
	
	public TelnetConsoleChannel(InetSocketAddress address, ConsoleClientHandler consoleClientHandler){
		this.address = address;
		this.consoleClientHandler = consoleClientHandler;
	}
	
	@Override
	public void connect() throws ConsoleChannelConnectionException {
		group = new NioEventLoopGroup();
		
		Bootstrap bootstrap = new Bootstrap();
		
		bootstrap.group(group)
			.channel(NioSocketChannel.class)
			.handler(new ConsoleClientInitializer(consoleClientHandler));
		
		try{	
			channel = bootstrap.connect(address).sync().channel();
			
			LOGGER.debug("Connected to Flightgear's console");
		} catch (Exception e) {
			LOGGER.error("Failed to connect to Flightgear's console", e);
			
			group.shutdownGracefully();
			
			throw new ConsoleChannelConnectionException("Failed to connect to Flightgear's console", e);
		}
		
	}

	@Override
	public void disconnect() {
		group.shutdownGracefully();
		
	}

	@Override
	public void send(String message) {
		channel.writeAndFlush(message);		
	}

	@Override
	public boolean isConnected() {
		if(channel == null){
			return false;
		}else{
			return channel.isActive();
		}
	}
}
