package com.matigakis.fgcontrol.tests.network;

import org.apache.log4j.BasicConfigurator;
import org.jmock.integration.junit4.JMock;
import org.jmock.Mockery;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.matigakis.fgcontrol.network.FDMDataServerEventListener;
import com.matigakis.fgcontrol.network.FDMServerException;
import com.matigakis.fgcontrol.network.UDPFDMServer;

@RunWith(JMock.class)
public class UDPFDMServerTests {
	public static final int FDM_DATA_SERVER_PORT = 10500;
	public UDPFDMServer fdmDataServer;
	
	public Mockery context = new JUnit4Mockery();
	
	public UDPFDMServerTests(){
		BasicConfigurator.configure();
	}
	
	@Before
	public void setUp(){
		fdmDataServer = new UDPFDMServer(FDM_DATA_SERVER_PORT);
	}
	
	@After
	public void tearDown(){
		if(fdmDataServer.isRunning()){
			try {
				fdmDataServer.stopServer();
			} catch (FDMServerException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test(expected=FDMServerException.class)
	public void raiseExceptionWhenTheServerIsStartedMoreThanOnce() throws FDMServerException {
		fdmDataServer.startServer();
		fdmDataServer.startServer();
	}
	
	@Test(expected=FDMServerException.class)
	public void raiseExceptionWhenTheServerIsStoppedWhenNotRunning() throws FDMServerException {
		fdmDataServer.stopServer();
	}
	
	@Test
	public void notifyServerListenersWhenConnected() throws FDMServerException{
		final FDMDataServerEventListener listener1 = context.mock(FDMDataServerEventListener.class, "listener1");
		final FDMDataServerEventListener listener2 = context.mock(FDMDataServerEventListener.class, "listener2");
		
		fdmDataServer.addFDMDataServerEventListener(listener1);
		fdmDataServer.addFDMDataServerEventListener(listener2);
		
		context.checking(new Expectations(){{
			ignoring(listener1).FDMDataServerShutdown(fdmDataServer);
			ignoring(listener2).FDMDataServerShutdown(fdmDataServer);
			
			oneOf(listener1).FDMDataServerStarted(fdmDataServer);
			oneOf(listener2).FDMDataServerStarted(fdmDataServer);
		}});
		
		fdmDataServer.startServer();
	}
	
	@Test
	public void notifyServerListenersWhenDisconnected() throws FDMServerException{
		final FDMDataServerEventListener listener1 = context.mock(FDMDataServerEventListener.class, "listener1");
		final FDMDataServerEventListener listener2 = context.mock(FDMDataServerEventListener.class, "listener2");
		
		fdmDataServer.addFDMDataServerEventListener(listener1);
		fdmDataServer.addFDMDataServerEventListener(listener2);
		
		context.checking(new Expectations(){{
			ignoring(listener1).FDMDataServerStarted(fdmDataServer);
			ignoring(listener2).FDMDataServerStarted(fdmDataServer);
			
			oneOf(listener1).FDMDataServerShutdown(fdmDataServer);
			oneOf(listener2).FDMDataServerShutdown(fdmDataServer);
		}});
		
		fdmDataServer.startServer();
		
		fdmDataServer.stopServer();
	}
}
