package com.matigakis.fgcontrol.console.network;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The TelnetConsoleConnection is used to make to a connection to Flightgear's
 * telnet console.
 */
public class TelnetConsoleConnection implements ConsoleConnection{
	private static Logger LOGGER = LoggerFactory.getLogger(TelnetConsoleConnection.class);
	
	private InetSocketAddress address;
	private ConsoleConnectionHandler consoleConnectionHandler;
	private Channel channel;
	private EventLoopGroup group;
	
	public TelnetConsoleConnection(InetSocketAddress address){
		this.address = address;
		this.consoleConnectionHandler = new ConsoleConnectionHandler(this);
	}
	
	/**
	 * Connect to Flightgear's telnet console
	 * 
	 * @throws ConsoleConnectionException
	 */
	@Override
	public void connect() throws ConsoleConnectionException {
		LOGGER.debug("Connecting to flightgears' console");
		
		group = new NioEventLoopGroup();
		
		Bootstrap bootstrap = new Bootstrap();
		
		bootstrap.group(group)
			.channel(NioSocketChannel.class)
			.handler(new ConsoleConnectionInitializer(consoleConnectionHandler));
		
		try{	
			channel = bootstrap.connect(address).sync().channel();
		} catch (Exception e) {
			LOGGER.error("Failed to connect to Flightgear's console", e);
			
			group.shutdownGracefully();
			
			throw new ConsoleConnectionException("Failed to connect to Flightgear's console", e);
		}
		
		LOGGER.debug("Connected to Flightgear's console");
	}

	/**
	 * Disconnect from Flightgear's telnet console
	 */
	@Override
	public void disconnect() {
		LOGGER.debug("Disconnecting from flightgear's console");
		
		group.shutdownGracefully();
		
		LOGGER.debug("Disconnected from flightgear's console");
	}

	/**
	 * Send a command to Flightgear's console.
	 * 
	 * @param command the command to send
	 */
	@Override
	public void send(String command) {
		channel.writeAndFlush(command);		
	}

	/**
	 * Are we connected to Flightgear's console
	 * 
	 * @return true if connected otherwise false
	 */
	@Override
	public boolean isConnected() {
		if(channel == null){
			return false;
		}else{
			return channel.isActive();
		}
	}

	/**
	 * Add a ConsoleConnectionEventListener
	 * 
	 * @param listener the listener to add
	 */
	@Override
	public void addConsoleConnectionEventListener(ConsoleConnectionEventListener listener) {
		consoleConnectionHandler.addConsoleConnectionEventListener(listener);
	}

	/**
	 * Remove a ConsoleConnectionEventListener
	 * 
	 * @param listener the listener to remove
	 */

	@Override
	public void removeConsoleConnectionEventListener(ConsoleConnectionEventListener listener) {
		consoleConnectionHandler.removeConsoleConnectionEventListener(listener);
	}
}
