package com.matigakis.fgcontrol.console;

import java.net.InetSocketAddress;

import com.matigakis.fgcontrol.flightgear.Property;

/**
 * The ConsoleProxy object is used to connect to Flightgear's telnet console
 */
public class ConsoleProxy {
	private InetSocketAddress address;
	
	public ConsoleProxy(InetSocketAddress address){
		this.address = address;
	}
	
	public void connect(){
		
	}
	
	public void disconnect(){
		
	}
	
	public void setProperty(Property property){
		
	}
	
	public Property getProperty(){
		return null;
	}
}
