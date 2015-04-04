package com.matigakis.fgcontrol.console;

import java.util.List;
import java.util.LinkedList;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

public class ConsoleClientHandler extends ChannelInboundHandlerAdapter{
	private List<ConsoleClientEventListener> consoleClientEventListeners;
	private ConsoleClient consoleClient;
	
	public ConsoleClientHandler(ConsoleClient consoleClient){
		this.consoleClient = consoleClient;
		
		consoleClientEventListeners =  new LinkedList<ConsoleClientEventListener>();
	}
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		ReferenceCountUtil.release(msg);
	}
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		for(ConsoleClientEventListener listener: consoleClientEventListeners){
			listener.connectedToConsole(consoleClient);
		}
	}
	
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		for(ConsoleClientEventListener listener: consoleClientEventListeners){
			listener.disconnectedFromConsole(consoleClient);
		}
	}
	
	public void addConsoleClientEventListener(ConsoleClientEventListener listener){
		consoleClientEventListeners.add(listener);
	}
	
	public void removeConsoleClientEventListener(ConsoleClientEventListener listener){
		consoleClientEventListeners.remove(listener);
	}
}
