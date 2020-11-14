package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import BattelshipTesting.Menu;
import mock.ManagerIOMock;
import utils.Constants;

/**
 * This test class takes care of the unit tests of the Menu class
 * 
 * @author Cristia Vega
 *
 */
public class MenuTest {

	public ByteArrayOutputStream result;

	/**
	 * Function that is executed before each @Test initializes and sets an
	 * outputstream to collect the data printed in the console
	 */
	@Before
	public void beforeAll() {

		result = new ByteArrayOutputStream();
		System.setOut(new PrintStream(result));
	}


	/**
	 * Test that tests that the menu options are correctly printed
	 */
	@Test
	public void testMenuOptions() {
		int[] input = new int[] { 2, 3 };
		new Menu(new ManagerIOMock(input));
		String expected = "------Main Menu------\n" + "1- Play\n" + "2- Exit\n"
				+ "Exiting Game";
		assertEquals(expected, result.toString());
	}

	/**
	 * Test that executes a sequence of actions with a mock that makes the player
	 * win
	 */
	@Test
	public void testMenuRunning() {

		new Menu(new ManagerIOMock(Constants.WINNER_PLAYER_SEQUENCE, Constants.WINNER_IA_SEQUENCE));
		assertTrue(result.toString().contains("------Starting Game------"));
	}

	/**
	 * Test that verifies that the game is correctly exited
	 */
	@Test
	public void testMenuExit() {
		int[] input = new int[] { 2 };
		new Menu(new ManagerIOMock(input));
		String expected = "------Main Menu------\n" + "1- Play\n" + "2- Exit\n"
				+ "Exiting Game";
		assertEquals(expected, result.toString());
	}

	/*
	 * Test de caja negra del metodo selecionarOpcion particiones equivalentes
	 * (-inf, 0), [0, 3], [4, inf) frontera 1, 3 limites: 0, 4, -1, 4
	 */
	@Test
	public void testMenuBadOption() {

		int[] input = new int[] { 0, 4, -1, 4, 2, 3 };
		new Menu(new ManagerIOMock(input));
		assertTrue(result.toString().contains("Invalid Option!"));
	}

}
