package com.matigakis.fgcontrol.console.network;

import java.util.List;
import java.util.LinkedList;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

public class ConsoleConnectionHandler extends ChannelInboundHandlerAdapter{
	private List<ConsoleConnectionEventListener> consoleClientEventListeners;
	private ConsoleConnection consoleConnection;
	
	public ConsoleConnectionHandler(ConsoleConnection consoleConnection){
		this.consoleConnection = consoleConnection;
		
		consoleClientEventListeners =  new LinkedList<ConsoleConnectionEventListener>();
	}
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		ReferenceCountUtil.release(msg);
	}
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		for(ConsoleConnectionEventListener listener: consoleClientEventListeners){
			listener.connectedToConsole(consoleConnection);
		}
	}
	
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		for(ConsoleConnectionEventListener listener: consoleClientEventListeners){
			listener.disconnectedFromConsole(consoleConnection);
		}
	}
	
	public void addConsoleConnectionEventListener(ConsoleConnectionEventListener listener){
		consoleClientEventListeners.add(listener);
	}
	
	public void removeConsoleConnectionEventListener(ConsoleConnectionEventListener listener){
		consoleClientEventListeners.remove(listener);
	}
}
