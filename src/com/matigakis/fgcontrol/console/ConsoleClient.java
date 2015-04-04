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
	private ConsoleClientHandler consoleClientHandler;
	
	public ConsoleClient(InetSocketAddress address){
		this.address = address;
		consoleClientHandler = new ConsoleClientHandler(this);
	}
	
	/**
	 * Connect to flightgear's telnet console
	 * 
	 * @throws ConsoleConnectionException
	 */
	public void connect() throws ConsoleConnectionException{
		if(!isConnected()){
			LOGGER.debug("Connecting to Flightgear's console");
			
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
				
				throw new ConsoleConnectionException("Failed to connect to Flightgear's console", e);
			}
		}else{
			LOGGER.debug("Already connected to Flightgear's console");
		}
	}
	
	/**
	 * Disconnect from Flightgear's telnet console
	 */
	public void disconnect(){
		if(isConnected()){
			LOGGER.debug("Disconnecting from Flightgear's console");
		
			group.shutdownGracefully();
		
			LOGGER.debug("Disconnected from Flightgear's console");
		}else{
			LOGGER.debug("Not connected to Flightgear's console");
		}
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
	public void run(String command){
		channel.writeAndFlush("run " + command + "\r\n");
	}
	
	/**
	 * Check if the console client is connected to Flightgear
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
	
	public void addConsoleClientEventListener(ConsoleClientEventListener listener){
		consoleClientHandler.addConsoleClientEventListener(listener);
	}
	
	public void removeConsoleClientEventListener(ConsoleClientEventListener listener){
		consoleClientHandler.removeConsoleClientEventListener(listener);
	}
}
