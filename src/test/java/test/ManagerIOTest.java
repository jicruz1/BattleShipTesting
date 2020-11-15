package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import BattelshipTesting.ManagerIO;

/**
 * This test class takes care of the unit tests of the ManagerIOTest class
 * 
 * @author Cristian Vega
 *
 */
public class ManagerIOTest {
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
	 * Test Function that prints an Integer in the output buffer
	 */
	@Test
	public void testManagerIOOutInteger() {
		ManagerIO manager = new ManagerIO();
		manager.out(1);
		assertEquals(Integer.valueOf(result.toString()), Integer.valueOf(1));
	}

	/**
	 * Test Function that prints a String in the output buffer
	 */
	@Test
	public void testManagerIOOutString() {
		ManagerIO manager = new ManagerIO();
		manager.out("testOutput");
		assertEquals(result.toString(), "testOutput");
	}

	/**
	 * Test Function that generates a random number between 0-10
	 */
	@Test
	public void testManagerIOGetRandomInt() {
		ManagerIO manager = new ManagerIO();

		for (int i = 0; i < 100; i++) {
			int random = manager.getRandomInt();
			assertTrue(random >= 0 && random <= 10);
		}

	}

	/**
	 * Test Function that generates random orientation between 0-4
	 */
	@Test
	public void testManagerIOGetRandomOrientacion() {
		ManagerIO manager = new ManagerIO();

		for (int i = 0; i < 100; i++) {
			int random = manager.getRandomOrientacion();
			assertTrue(random >= 0 && random <= 4);
		}

	}

	/**
	 * Test Function reads keyboard input from an Integer value
	 */
	@Test
	public void testManagerIOinInt() {

		ManagerIO manager = new ManagerIO();
		String value = "1";
		ByteArrayInputStream in = new ByteArrayInputStream(value.getBytes());
		manager.setScanner(new Scanner(in));
		assertEquals(manager.inInt(), 1);

	}

}