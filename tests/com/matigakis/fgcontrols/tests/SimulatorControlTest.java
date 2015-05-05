package com.matigakis.fgcontrols.tests;

import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.matigakis.fgcontrol.SimulatorControl;
import com.matigakis.fgcontrol.console.ConsoleClient;

import com.matigakis.fgcontrol.console.network.ConsoleConnection;

@RunWith(JMock.class)
public class SimulatorControlTest {
	public Mockery context = new JUnit4Mockery();
	
	public ConsoleConnection consoleConnection = context.mock(ConsoleConnection.class);
	public ConsoleClient consoleClient = new ConsoleClient(consoleConnection);
	
	@Test
	public void resetSimulatorCommand() {
		SimulatorControl simulatorControl = new SimulatorControl(consoleClient);
		
		context.checking(new Expectations(){{
			oneOf(consoleConnection).send("run reset\r\n");
		}});
		
		simulatorControl.reset();
	}

	@Test
	public void pauseSimulatorCommand() {
		SimulatorControl simulatorControl = new SimulatorControl(consoleClient);
		
		context.checking(new Expectations(){{
			oneOf(consoleConnection).send("run pause\r\n");
		}});
		
		simulatorControl.pause();
	}
	
	@Test
	public void connectToConsoleClient() throws Exception {
		SimulatorControl simulatorControl = new SimulatorControl(consoleClient);
		
		context.checking(new Expectations(){{
			allowing(consoleConnection).isConnected();
			    with(returnValue(false));
			
			oneOf(consoleConnection).connect();
		}});
		
		simulatorControl.connect();
	}

	@Test
	public void doNotconnectTwiceToConsoleClient() throws Exception {
		SimulatorControl simulatorControl = new SimulatorControl(consoleClient);
		
		context.checking(new Expectations(){{
			allowing(consoleConnection).isConnected();
		        will(returnValue(true));
			
			never(consoleConnection).connect();
		}});
		
		simulatorControl.connect();
	}

	@Test
	public void disconnectFromConsoleClient() throws Exception {
		SimulatorControl simulatorControl = new SimulatorControl(consoleClient);
		
		context.checking(new Expectations(){{
			allowing(consoleConnection).isConnected();
			    will(returnValue(true));
			
			oneOf(consoleConnection).disconnect();
		}});
		
		simulatorControl.disconnect();
	}
	
	@Test
	public void doNotdisconnectTwiceFromConsoleClient() throws Exception {
		SimulatorControl simulatorControl = new SimulatorControl(consoleClient);
		
		context.checking(new Expectations(){{
			allowing(consoleConnection).isConnected();
			    will(returnValue(false));
			    
			never(consoleConnection).disconnect();
		}});
		
		simulatorControl.disconnect();
	}
}
