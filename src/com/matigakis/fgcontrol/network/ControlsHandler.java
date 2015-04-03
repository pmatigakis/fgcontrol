package com.matigakis.fgcontrol.network;

import java.util.LinkedList;
import java.util.List;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ControlsHandler extends ChannelInboundHandlerAdapter{
	private List<ControlsClientEventListener> controlsClientEventListeners;
	private ControlsClient controlsClient;
	
	public ControlsHandler(ControlsClient controlsClient) {
		super();
		
		this.controlsClient = controlsClient;
		
		controlsClientEventListeners = new LinkedList<ControlsClientEventListener>();
	}
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		for(ControlsClientEventListener listener: controlsClientEventListeners){
			listener.connected(controlsClient);
		}
	}
	
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		for(ControlsClientEventListener listener: controlsClientEventListeners){
			listener.disconnected(controlsClient);
		}
	}
	
	/*
	@Override
	public void connect(ChannelHandlerContext ctx, SocketAddress remoteAddress,
			SocketAddress localAddress, ChannelPromise promise)
			throws Exception {
		for(ControlsClientEventListener listener: controlsClientEventListeners){
			listener.connected(controlsClient);
		}
	}
	
	@Override
	public void disconnect(ChannelHandlerContext ctx, ChannelPromise promise)
			throws Exception {
		for(ControlsClientEventListener listener: controlsClientEventListeners){
			listener.disconnected(controlsClient);
		}
	}
	*/
	
	public void addControlsClientEventListener(ControlsClientEventListener listener){
		controlsClientEventListeners.add(listener);
	}
	
	public void removeControlsClientEventListener(ControlsClientEventListener listener){
		controlsClientEventListeners.remove(listener);
	}
}
