package com.matigakis.fgcontrols.tests.console.network;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.Expectations;
import org.jmock.Mockery;

import io.netty.channel.ChannelHandlerContext;

import com.matigakis.fgcontrol.console.network.ConsoleConnection;
import com.matigakis.fgcontrol.console.network.ConsoleConnectionEventListener;
import com.matigakis.fgcontrol.console.network.ConsoleConnectionHandler;

@RunWith(JMock.class)
public class ConsoleConnectionHandlerTest {
	public Mockery context = new JUnit4Mockery();
	
	public ConsoleConnection consoleConnection = context.mock(ConsoleConnection.class);
	
	public ConsoleConnectionHandler consoleClienHandler = new ConsoleConnectionHandler(consoleConnection);
	
	@Test
	public void notiftEventListenersWhenConnected() throws Exception {
		final ConsoleConnectionEventListener listener1 = context.mock(ConsoleConnectionEventListener.class, "listener1");
		final ConsoleConnectionEventListener listener2 = context.mock(ConsoleConnectionEventListener.class, "listener2");
		final ChannelHandlerContext ctx = context.mock(ChannelHandlerContext.class, "ctx");
		
		consoleClienHandler.addConsoleConnectionEventListener(listener1);
		consoleClienHandler.addConsoleConnectionEventListener(listener2);
		
		context.checking(new Expectations(){{
			oneOf(listener1).connectedToConsole(consoleConnection);
			oneOf(listener2).connectedToConsole(consoleConnection);
		}});
		
		consoleClienHandler.channelActive(ctx);;
	}

	@Test
	public void notiftEventListenersWhenDisconnected() throws Exception {
		final ConsoleConnectionEventListener listener1 = context.mock(ConsoleConnectionEventListener.class, "listener1");
		final ConsoleConnectionEventListener listener2 = context.mock(ConsoleConnectionEventListener.class, "listener2");
		final ChannelHandlerContext ctx = context.mock(ChannelHandlerContext.class, "ctx");
		
		consoleClienHandler.addConsoleConnectionEventListener(listener1);
		consoleClienHandler.addConsoleConnectionEventListener(listener2);
		
		context.checking(new Expectations(){{
			oneOf(listener1).disconnectedFromConsole(consoleConnection);
			oneOf(listener2).disconnectedFromConsole(consoleConnection);
		}});
		
		consoleClienHandler.channelInactive(ctx);;
	}
}
