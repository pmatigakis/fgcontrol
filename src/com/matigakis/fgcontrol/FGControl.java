package com.matigakis.fgcontrol;

import java.net.InetSocketAddress;

import org.apache.log4j.BasicConfigurator;

import com.matigakis.fgcontrol.console.ConsoleClient;

/**
 * The FGControl class is used to control Flightgear remotely.
 * 
 * At the moment it can only pause and reset Flightgear
 */
public class FGControl {
	private ConsoleClient consoleClient;
	
	public FGControl(InetSocketAddress address){
		consoleClient = new ConsoleClient(address);
	}
	
	/**
	 * Connect to Flightgear
	 * 
	 * @throws InterruptedException
	 */
	public void connect() throws InterruptedException{
		consoleClient.connect();
	}
	
	/**
	 * Disconnect from Flightgear
	 */
	public void disconnect(){
		consoleClient.disconnect();
	}
	
	/**
	 * Pause/unpause Flightgear
	 */
	public void pause(){
		consoleClient.runCommand("pause");
	}
	
	/**
	 * Reset Flightgear
	 */
	public void reset(){
		consoleClient.runCommand("reset");
	}
}
