package com.matigakis.fgcontrol.network;

import java.util.LinkedList;
import java.util.List;

import static io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

@Sharable
public class ControlsHandler extends ChannelInboundHandlerAdapter{
	private List<ControlsConnentionEventListener> controlsConnectionEventListeners;
	private ControlsConnection controlsConnection;

	public ControlsHandler(ControlsConnection controlsConnection) {
		super();

		this.controlsConnection = controlsConnection;

		controlsConnectionEventListeners = new LinkedList<ControlsConnentionEventListener>();
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		for(ControlsConnentionEventListener listener: controlsConnectionEventListeners){
			listener.connected(controlsConnection);
		}
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		for(ControlsConnentionEventListener listener: controlsConnectionEventListeners){
			listener.disconnected(controlsConnection);
		}
	}

	public void addControlsClientEventListener(ControlsConnentionEventListener listener){
		controlsConnectionEventListeners.add(listener);
	}

	public void removeControlsClientEventListener(ControlsConnentionEventListener listener){
		controlsConnectionEventListeners.remove(listener);
	}
}
