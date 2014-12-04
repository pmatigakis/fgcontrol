package com.matigakis.fgcontrol.flightgear;

public class Property {
	protected String name;
	protected Object value;
	
	public Property(String name, Object value){
		this.name = name;
		this.value = value;
	}
	
	public String getName(){
		return name;
	}
	
	public Object getValue(){
		return value;
	}
	
	public void setValue(Object value){
		this.value = value;
	}
	
	@Override
	public String toString() {
		return name + " " + value.toString();
	}
}
