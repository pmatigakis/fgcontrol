package com.matigakis.fgcontrol.tests.controls;

import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.Mockery;
import org.jmock.Expectations;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.matigakis.fgcontrol.controls.ControlsClient;
import com.matigakis.fgcontrol.fdm.Controls;
import com.matigakis.fgcontrol.network.ControlsConnection;

@RunWith(JMock.class)
public class ControlsClientTests {
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

	@Test
	public void transmitControls(){
		ControlsClient controlsClients = new ControlsClient(controlsConnection);

		context.checking(new Expectations(){{
			oneOf(controlsConnection).writeControls("0.2\t0.5\t0.1\t0.8\r\n");
		}});

		Controls controls = new Controls(0.5, 0.2, 0.1, 0.8);

		controlsClients.transmitControls(controls);
	}
}
