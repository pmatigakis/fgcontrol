package com.matigakis.fgcontrol.tests.network;

import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.Mockery;
import org.jmock.Expectations;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.matigakis.fgcontrol.network.ControlsClient;
import com.matigakis.fgcontrol.network.ControlsConnection;

@RunWith(JMock.class)
public class ConsoleClientTests {
	public Mockery context = new JUnit4Mockery();
	public ControlsConnection controlsConnection = context.mock(ControlsConnection.class);
	
	@Test
	public void connectToControlsPort() throws Exception{
		ControlsClient controlsClient = new ControlsClient(controlsConnection);
		
		context.checking(new Expectations(){{
			allowing(controlsConnection).isConnected();
			    will(returnValue(false));
			
			oneOf(controlsConnection).connect();
		}});
		
		controlsClient.connect();
	}
	
	@Test
	public void disconnectFromControlsPort() throws Exception{
		ControlsClient controlsClient = new ControlsClient(controlsConnection);
		
		context.checking(new Expectations(){{
			allowing(controlsConnection).isConnected();
			    will(returnValue(true));
			
			oneOf(controlsConnection).disconnect();
		}});
		
		controlsClient.disconnect();
	}
	
	@Test
	public void dontConnectTwiceToControlsPort() throws Exception{
		ControlsClient controlsClient = new ControlsClient(controlsConnection);
		
		context.checking(new Expectations(){{
			allowing(controlsConnection).isConnected();
			    will(returnValue(true));
			
			never(controlsConnection).connect();
		}});
		
		controlsClient.connect();
	}
	
	@Test
	public void dontDisconnectWhenNotConnectedToControlsPort() throws Exception{
		ControlsClient controlsClient = new ControlsClient(controlsConnection);
		
		context.checking(new Expectations(){{
			allowing(controlsConnection).isConnected();
			    will(returnValue(false));
			
			never(controlsConnection).disconnect();
		}});
		
		controlsClient.disconnect();
	}
}
