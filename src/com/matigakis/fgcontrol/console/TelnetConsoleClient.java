package com.matigakis.fgcontrol.console;

import java.net.InetSocketAddress;

import com.matigakis.fgcontrol.console.commands.Command;
import com.matigakis.fgcontrol.console.commands.SetPropertyCommand;
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
public class TelnetConsoleClient implements ConsoleClient {
	private static Logger LOGGER = LoggerFactory.getLogger(TelnetConsoleClient.class);
	
	private InetSocketAddress address;
	private Channel channel;
	private EventLoopGroup group;
	private ConsoleClientHandler consoleClientHandler;
	
	public TelnetConsoleClient(InetSocketAddress address){
		this.address = address;
		consoleClientHandler = new ConsoleClientHandler(this);
	}
	
	/* (non-Javadoc)
	 * @see com.matigakis.fgcontrol.console.ConsoleClient#connect()
	 */
	@Override
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
			LOGGER.error("Already connected to Flightgear's console");
			
			throw new ConsoleConnectionException("Already connected to Flightgear's console");
		}
	}
	
	/* (non-Javadoc)
	 * @see com.matigakis.fgcontrol.console.ConsoleClient#disconnect()
	 */
	@Override
	public void disconnect(){
		if(isConnected()){
			LOGGER.debug("Disconnecting from Flightgear's console");
		
			group.shutdownGracefully();
		
			LOGGER.debug("Disconnected from Flightgear's console");
		}else{
			LOGGER.debug("Not connected to Flightgear's console");
		}
	}
	
	/* (non-Javadoc)
	 * @see com.matigakis.fgcontrol.console.ConsoleClient#setProperty(com.matigakis.fgcontrol.flightgear.Property)
	 */
	@Override
	public void setProperty(Property property){
		SetPropertyCommand command = new SetPropertyCommand(property);
		
		channel.writeAndFlush(command.asCommandString());
	}
	
	/* (non-Javadoc)
	 * @see com.matigakis.fgcontrol.console.ConsoleClient#run(com.matigakis.fgcontrol.console.commands.Command)
	 */
	@Override
	public void run(Command command){
		channel.writeAndFlush(command.asCommandString());
	}
	
	/* (non-Javadoc)
	 * @see com.matigakis.fgcontrol.console.ConsoleClient#isConnected()
	 */
	@Override
	public boolean isConnected(){
		if(channel == null){
			return false;
		}else{
			return channel.isActive();
		}
	}
	
	/* (non-Javadoc)
	 * @see com.matigakis.fgcontrol.console.ConsoleClient#addConsoleClientEventListener(com.matigakis.fgcontrol.console.ConsoleClientEventListener)
	 */
	@Override
	public void addConsoleClientEventListener(ConsoleClientEventListener listener){
		consoleClientHandler.addConsoleClientEventListener(listener);
	}
	
	/* (non-Javadoc)
	 * @see com.matigakis.fgcontrol.console.ConsoleClient#removeConsoleClientEventListener(com.matigakis.fgcontrol.console.ConsoleClientEventListener)
	 */
	@Override
	public void removeConsoleClientEventListener(ConsoleClientEventListener listener){
		consoleClientHandler.removeConsoleClientEventListener(listener);
	}
}
