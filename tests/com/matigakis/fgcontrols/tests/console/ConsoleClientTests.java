package com.matigakis.fgcontrols.tests.console;

import com.matigakis.fgcontrol.console.ConsoleClient;
import com.matigakis.fgcontrol.console.network.ConsoleConnection;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;

@RunWith(JMock.class)
public class ConsoleClientTests {
	public Mockery context = new JUnit4Mockery();
	
	public ConsoleConnection consoleConnection = context.mock(ConsoleConnection.class);
	
	@Test
	public void connectToFlightgearsConsole() throws Exception{
		ConsoleClient consoleClient = new ConsoleClient(consoleConnection);
		
		context.checking(new Expectations(){{
			allowing(consoleConnection).isConnected();
			    will(returnValue(false));
			    
			oneOf(consoleConnection).connect();
		}});
		
		consoleClient.connect();
	}

	@Test
	public void doNotconnectTwiceToFlightgearsConsole() throws Exception{
		ConsoleClient consoleClient = new ConsoleClient(consoleConnection);
		
		context.checking(new Expectations(){{
			allowing(consoleConnection).isConnected();
			    will(returnValue(true));
			    
			never(consoleConnection).connect();
		}});
		
		consoleClient.connect();
	}
	
	@Test
	public void disconnectFromFlightgearsConsole() throws Exception{
		ConsoleClient consoleClient = new ConsoleClient(consoleConnection);
		
		context.checking(new Expectations(){{
			allowing(consoleConnection).isConnected();
			    will(returnValue(true));
			    
			oneOf(consoleConnection).disconnect();
		}});
		
		consoleClient.disconnect();
	}

	@Test
	public void doNotdisconnectTwiceFromFlightgearsConsole() throws Exception{
		ConsoleClient consoleClient = new ConsoleClient(consoleConnection);
		
		context.checking(new Expectations(){{
			allowing(consoleConnection).isConnected();
			    will(returnValue(false));
			    
			never(consoleConnection).disconnect();
		}});
		
		consoleClient.disconnect();
	}
}
