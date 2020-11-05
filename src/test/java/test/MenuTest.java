package test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;



import BattelshipTesting.Menu;
import mock.ManagerIOMock;

public class MenuTest {

	public ByteArrayOutputStream resultado;

	/*
	 * Función que se ejecuta antes de cada @Test inicializa y setea un outputstream
	 * para recoger los datos printados en consola
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
		
		int[] input = new int[] { 2,3 };
		Menu testMenu = new Menu(new ManagerIOMock(input));
		assertEquals(testMenu.showMenu(), "------Main Menu------");

	}

	/*
	 * Test to get Player option selected
	 */
	@Test
	public void testGetPlayOption() {
		
		int[] input = new int[] { 1 };
		Menu testMenu = new Menu(new ManagerIOMock(input));
		assertEquals(testMenu.getOption(new ManagerIOMock(input)), "Starting Game");

	}

	/*
	 * Test return the value of the 
	 */
	@Test
	public void testGetExitOption() {
		
		int[] input = new int[] { 2 };
		Menu testMenu = new Menu(new ManagerIOMock(input));
		assertEquals(testMenu.getOption(new ManagerIOMock(input)), "Exiting Game");

	}

}
