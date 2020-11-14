package test;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import BattelshipTesting.Menu;
import mock.ManagerIOMock;

/**
 * This test class takes care of the unit tests of the Match class
 * 
 * @author Cristian Vega
 *
 */
public class MatchTest {

	private PrintStream systemOutOriginal;
	public ByteArrayOutputStream result;

	/**
	 * Function that is executed before each @Test initializes and sets an
	 * outputstream to collect the data printed in the console
	 */
	@Before
	public void beforeAll() {
		systemOutOriginal = System.out;
		result = new ByteArrayOutputStream();
		System.setOut(new PrintStream(result));
	}

	/**
	 * Function that returns the system output to its original state after
	 * each @Test
	 */
	@After
	public void restoreSystemOutStream() {
		System.setOut(systemOutOriginal);
	}

	/**
	 * Test that executes a sequence of actions with a mock that makes the Human
	 * player win
	 */
	@Test
	public void testWinnerPlayer() {

		int[] arrayInputPlayer = new int[] { 1, 1, 1, 1, 1, 3, 1, 1, 5, 1, 1, 7, 1, 1, 9, 1, 6, 1, 0, 8, 1, 0, 10, 1, 0,
				8, 8, 0, 10, 8, 0, 1, 1, 2, 1, 3, 1, 4, 1, 1, 3, 2, 3, 3, 3, 1, 5, 2, 5, 3, 5, 1, 7, 2, 7, 1, 9, 2, 9,
				6, 1, 6, 2, 8, 1, 8, 8, 10, 1, 10, 8 };
		int[] arrayInputRandom = new int[] { 1, 1, 1, 1, 3, 1, 1, 5, 1, 1, 7, 1, 1, 9, 1, 6, 1, 0, 8, 1, 0, 10, 1, 0, 8,
				8, 0, 10, 8, 0, 1, 1, 1, 3, 1, 5, 1, 7, 1, 9, 6, 1, 8, 1, 10, 1, 8, 8, 10, 8 };

		new Menu(new ManagerIOMock(arrayInputPlayer, arrayInputRandom));

		assertTrue(result.toString().contains("Game winner: HumanPlayer!!!"));
	}

	/**
	 * Test that executes a sequence of actions with a mock that makes the IA player
	 * win
	 */
	@Test
	public void testWinnerRandom() {

		result = new ByteArrayOutputStream();
		System.setOut(new PrintStream(result));

		int[] arrayInputRandom = new int[] { 1, 1, 1, 1, 3, 1, 1, 5, 1, 1, 7, 1, 1, 9, 1, 6, 1, 0, 8, 1, 0, 10, 1, 0, 8,
				8, 0, 10, 8, 0, 1, 1, 2, 1, 3, 1, 4, 1, 1, 3, 2, 3, 3, 3, 1, 5, 2, 5, 3, 5, 1, 7, 2, 7, 1, 9, 2, 9, 6,
				1, 6, 2, 8, 1, 8, 8, 10, 1, 10, 8 };

		int[] arrayInputPlayer = new int[] { 1, 1, 1, 1, 1, 3, 1, 1, 5, 1, 1, 7, 1, 1, 9, 1, 6, 1, 0, 8, 1, 0, 10, 1, 0,
				8, 8, 0, 10, 8, 0 };

		new Menu(new ManagerIOMock(arrayInputPlayer, arrayInputRandom));
		assertTrue(result.toString().contains("Game winner: RandomIA!!!"));
	}

}