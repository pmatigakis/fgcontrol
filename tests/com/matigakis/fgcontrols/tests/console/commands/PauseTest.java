package com.matigakis.fgcontrols.tests.console.commands;

import static org.junit.Assert.*;

import org.junit.Test;

import com.matigakis.fgcontrol.console.commands.Pause;

public class PauseTest {
	@Test
	public void test() {
		Pause pause = new Pause();
		
		String commandString = pause.asCommandString();
		
		assertTrue(commandString.equals("run pause\r\n"));
	}
}
