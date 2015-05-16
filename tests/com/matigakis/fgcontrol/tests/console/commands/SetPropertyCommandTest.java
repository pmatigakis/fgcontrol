package com.matigakis.fgcontrol.tests.console.commands;

import static org.junit.Assert.*;

import org.junit.Test;

import com.matigakis.fgcontrol.console.commands.SetPropertyCommand;
import com.matigakis.fgcontrol.flightgear.Property;

public class SetPropertyCommandTest {
	@Test
	public void test() {
		Property property = new Property("/property/name", 12.3);

		SetPropertyCommand command = new SetPropertyCommand(property);

		String commandString = command.asCommandString();

		assertTrue(commandString.equals("set /property/name 12.3\r\n"));
	}
}
