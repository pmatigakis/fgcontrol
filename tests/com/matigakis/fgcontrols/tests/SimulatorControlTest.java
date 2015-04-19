package com.matigakis.fgcontrols.tests;

import static org.junit.Assert.*;

import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.matigakis.fgcontrol.SimulatorControl;
import com.matigakis.fgcontrol.console.ConsoleClient;
import com.matigakis.fgcontrol.console.commands.Command;
import com.matigakis.fgcontrol.console.commands.Pause;
import com.matigakis.fgcontrol.console.commands.Reset;

@RunWith(JMock.class)
public class SimulatorControlTest {
	public Mockery context = new JUnit4Mockery();
	
	public ConsoleClient consoleClient = context.mock(ConsoleClient.class);
	
	@Test
	public void resetSimulatorCommand() {
		SimulatorControl simulatorControl = new SimulatorControl(consoleClient);
		
		context.checking(new Expectations(){{
			oneOf(consoleClient).run((Command) with(a(Reset.class)));
		}});
		
		simulatorControl.reset();
	}

	@Test
	public void pauseSimulatorCommand() {
		SimulatorControl simulatorControl = new SimulatorControl(consoleClient);
		
		context.checking(new Expectations(){{
			oneOf(consoleClient).run((Command) with(a(Pause.class)));
		}});
		
		simulatorControl.pause();
	}
	
	@Test
	public void connectToConsoleClient() throws Exception {
		SimulatorControl simulatorControl = new SimulatorControl(consoleClient);
		
		context.checking(new Expectations(){{
			ignoring(consoleClient).isConnected();
			
			oneOf(consoleClient).connect();
		}});
		
		simulatorControl.connect();
	}
	
	@Test
	public void disconnectFromConsoleClient() throws Exception {
		SimulatorControl simulatorControl = new SimulatorControl(consoleClient);
		
		context.checking(new Expectations(){{
			oneOf(consoleClient).disconnect();
		}});
		
		simulatorControl.disconnect();
	}
}
