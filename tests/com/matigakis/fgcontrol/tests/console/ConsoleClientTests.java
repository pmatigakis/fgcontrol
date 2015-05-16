package com.matigakis.fgcontrol.tests.console;

import com.matigakis.fgcontrol.console.ConsoleClient;
import com.matigakis.fgcontrol.console.commands.Reset;
import com.matigakis.fgcontrol.console.network.ConsoleConnection;
import com.matigakis.fgcontrol.flightgear.Property;

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

	@Test
	public void runCommand(){
		ConsoleClient consoleClient = new ConsoleClient(consoleConnection);

		context.checking(new Expectations(){{
			oneOf(consoleConnection).send("run reset\r\n");
		}});

		Reset reset = new Reset();

		consoleClient.run(reset);
	}

	@Test
	public void setProperty(){
		ConsoleClient consoleClient = new ConsoleClient(consoleConnection);

		context.checking(new Expectations(){{
			oneOf(consoleConnection).send("set test/value 12.3\r\n");
		}});

		Property property = new Property("test/value", 12.3);

		consoleClient.setProperty(property);
	}
}
