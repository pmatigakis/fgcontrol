package com.matigakis.fgcontrols.tests.console;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.Expectations;
import org.jmock.Mockery;

import io.netty.channel.ChannelHandlerContext;
import com.matigakis.fgcontrol.console.ConsoleClient;
import com.matigakis.fgcontrol.console.ConsoleClientHandler;
import com.matigakis.fgcontrol.console.ConsoleClientEventListener;

@RunWith(JMock.class)
public class ConsoleClientHandlerTest {
	public Mockery context = new JUnit4Mockery();
	
	public ConsoleClient consoleClient = context.mock(ConsoleClient.class);
	
	public ConsoleClientHandler consoleClienHandler = new ConsoleClientHandler(consoleClient);
	
	@Test
	public void notiftEventListenersWhenConnected() throws Exception {
		final ConsoleClientEventListener listener1 = context.mock(ConsoleClientEventListener.class, "listener1");
		final ConsoleClientEventListener listener2 = context.mock(ConsoleClientEventListener.class, "listener2");
		final ChannelHandlerContext ctx = context.mock(ChannelHandlerContext.class, "ctx");
		
		consoleClienHandler.addConsoleClientEventListener(listener1);
		consoleClienHandler.addConsoleClientEventListener(listener2);
		
		context.checking(new Expectations(){{
			oneOf(listener1).connectedToConsole(consoleClient);
			oneOf(listener2).connectedToConsole(consoleClient);
		}});
		
		consoleClienHandler.channelActive(ctx);;
	}

	@Test
	public void notiftEventListenersWhenDisconnected() throws Exception {
		final ConsoleClientEventListener listener1 = context.mock(ConsoleClientEventListener.class, "listener1");
		final ConsoleClientEventListener listener2 = context.mock(ConsoleClientEventListener.class, "listener2");
		final ChannelHandlerContext ctx = context.mock(ChannelHandlerContext.class, "ctx");
		
		consoleClienHandler.addConsoleClientEventListener(listener1);
		consoleClienHandler.addConsoleClientEventListener(listener2);
		
		context.checking(new Expectations(){{
			oneOf(listener1).disconnectedFromConsole(consoleClient);
			oneOf(listener2).disconnectedFromConsole(consoleClient);
		}});
		
		consoleClienHandler.channelInactive(ctx);;
	}
}
