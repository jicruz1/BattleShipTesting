package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import BattelshipTesting.Menu;

public class MenuTest {

	/*
	 * Test que devuelve el menu
	 */
	@Test
	public void testStartGame() {

		Menu testMenu = new Menu();
		assertEquals(testMenu.mostrarMenu(), "------Main Menu------");
	}

	/*
	 * Test que devuelve la opcion del menu
	 */
	@Test
	public void testGetPlayOption() {

		Menu testMenu = new Menu();
		assertEquals(testMenu.getOption(), 1);

	}
	
	/*
	 * Test que devuelve la opcion del menu
	 */
	@Test
	public void testGetExitOption() {

		Menu testMenu = new Menu();
		assertEquals(testMenu.getOption(), 1);

	}
	
}


