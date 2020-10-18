package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import BattelshipTesting.Menu;

public class MenuTest {

	/*
	 * Test que devuelve el menu
	 */
	@Test
	public void testEmpezarJuego() {

		Menu testMenu = new Menu();
		assertEquals(testMenu.mostrarMenu(), "------Menu Principal------");
	}

	/*
	 * Test que devuelve la opcion del menu
	 */
	@Test
	public void testGetOpcionJugar() {

		Menu testMenu = new Menu();
		assertEquals(testMenu.getOpcion(), 1);

	}
	
	/*
	 * Test que devuelve la opcion del menu
	 */
	@Test
	public void testGetOpcionSalir() {

		Menu testMenu = new Menu();
		assertEquals(testMenu.getOpcion(), 1);

	}
	
}


