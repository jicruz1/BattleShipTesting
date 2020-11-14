package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;



import BattelshipTesting.Menu;
import mock.ManagerIOMock;

public class MenuTest {



	
	/*
	 * Test to verify console menu is show
	 */
	@Test
	public void testStartGame() {

		Menu testMenu = new Menu();
		assertEquals(testMenu.showMenu(),  "------Main Menu------\n1- Play \n2- Exit");

	}

	/*
	 * Test to get Player option selected
	 */
	@Test
	public void testGetPlayOption() {

		Menu testMenu = new Menu();
		assertEquals(testMenu.getOption(1), "------Starting Game------");

	}

	/*
	 * Test return the value of the 
	 */
	@Test
	public void testGetExitOption() {

		Menu testMenu = new Menu();
		assertEquals(testMenu.getOption(2), "Exiting Game");

	}

}
