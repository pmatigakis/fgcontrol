package com.matigakis.fgcontrol.console.commands;

public class Command {
	private String command;
	
	public Command(String command){
		this.command = command;
	}
	
	public String asCommandString(){
		return "run " + command + "\r\n";
	}
}
