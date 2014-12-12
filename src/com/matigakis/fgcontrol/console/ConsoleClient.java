package com.matigakis.fgcontrol.console;

import java.net.InetSocketAddress;

import com.matigakis.fgcontrol.flightgear.Property;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * The ConsoleClient class is used to execute commands on Flightgear's
 * telnet console
 */
public class ConsoleClient {
	private static Logger LOGGER = LoggerFactory.getLogger(ConsoleClient.class);
	
	private InetSocketAddress address;
	private Channel channel;
	private EventLoopGroup group;
	
	public ConsoleClient(InetSocketAddress address){
		this.address = address;
	}
	
	/**
	 * Connect to flightgear's telnet console
	 * 
	 * @throws InterruptedException
	 */
	public void connect() throws InterruptedException{
		LOGGER.info("Connecting to Flightgear's console");
		
		group = new NioEventLoopGroup();
		
		Bootstrap bootstrap = new Bootstrap();
		
		bootstrap.group(group)
			.channel(NioSocketChannel.class)
			.handler(new ConsoleClientInitializer());
		
		try{
			channel = bootstrap.connect(address).sync().channel();
			
			LOGGER.info("Connected to Flightgear's console");
		} catch (InterruptedException e) {
			LOGGER.error("Failed to connect to Flightgear's console", e);
			throw e;
		}
	}
	
	/**
	 * Disconnect from Flightgear's telnet console
	 */
	public void disconnect(){
		LOGGER.info("Disconnecting from Flightgear's console");
		
		group.shutdownGracefully();
		
		LOGGER.info("Disconnected from Flightgear's console");
	}
	
	protected String createSetPropertyMessage(Property property){
		return "set " + property.getName() + " " + property.getValue() + "\r\n";
	}
	
	/**
	 * Set the value of a property on Flightgear's property tree
	 * 
	 * @param property
	 */
	public void setProperty(Property property){
		String setPropertyMessage = createSetPropertyMessage(property);
		
		channel.writeAndFlush(setPropertyMessage);
	}
	
	/**
	 * Run a command on Flighrgear's console 
	 * 
	 * @param command
	 */
	public void runCommand(String command){
		channel.writeAndFlush("run " + command + "\r\n");
	}
}
