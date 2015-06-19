package com.matigakis.fgcontrol.console.commands;

import com.matigakis.fgcontrol.flightgear.Property;

public class SetPropertyCommand {
	private Property property;
	
	public SetPropertyCommand(Property property){
		this.property = property;
	}
	
	public String asCommandString(){
		return "set " + property.getName() + " " + property.getValue() + "\r\n";
	}
}
