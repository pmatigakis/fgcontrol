package com.matigakis.fgcontrol.tests.console.commands;

import static org.junit.Assert.*;

import org.junit.Test;

import com.matigakis.fgcontrol.console.commands.Reset;

public class ResetTest {
	@Test
	public void test() {
		Reset reset = new Reset();

		String commandString = reset.asCommandString();

		assertTrue(commandString.equals("run reset\r\n"));
	}
}
