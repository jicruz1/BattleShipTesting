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

	public ByteArrayOutputStream resultado;

	/*
	 * Function that runs before each @Test initializes and sets an outputstream to collect the printed data in the console
	 */
	@Before
	public void beforeAll() {

		resultado = new ByteArrayOutputStream();
		System.setOut(new PrintStream(resultado));
	}

	
	/*
	 * Test to verify console menu is show
	 */
	@Test
	
	public void testStartGame() {
		
		int[] input = new int[] { 1 };
		Menu testMenu = new Menu(new ManagerIOMock(input));
		assertTrue(resultado.toString().contains("------Main Menu------"));

	}

	/*
	 * Test to get Player option selected
	 */
	@Test
	public void testGetPlayOption() {
		
		int[] input = new int[] { 1 };
		Menu testMenu = new Menu(new ManagerIOMock(input));
		assertTrue(resultado.toString().contains("Starting Game"));

	}

	/*
	 * Test return the value of the 
	 */
	@Test
	public void testGetExitOption() {
		
		int[] input = new int[] { 2 };
		Menu testMenu = new Menu(new ManagerIOMock(input));
		assertTrue(resultado.toString().contains("Exiting Game"));

	}

}
