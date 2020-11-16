package test;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import BattelshipTesting.Game;
import mock.ManagerIOMock;
import utils.Constants;

/**
 * This test class takes care of the unit tests of the Game class
 * 
 * @author Cristia Vega
 *
 */
public class GameTest {

	public ByteArrayOutputStream resultado;

	/**
	 * Function that is executed before each @Test initializes and sets an
	 * outputstream to collect the data printed in the console
	 */
	@Before
	public void beforeAll() {

		resultado = new ByteArrayOutputStream();
		System.setOut(new PrintStream(resultado));
	}

	/**
	 * Test that calls the Main Game function that initializes the Menu
	 */
	@Test
	public void testGame() {

		int[] input = new int[] { 2 };
		Game.setManager(new ManagerIOMock(input));
		Game.main(null);
		new Game();
		assertTrue(resultado.toString().contains("------Main Menu------"));

	}

}
