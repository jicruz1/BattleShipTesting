package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import BattelshipTesting.Position;

/*
 * This class of test is in charge of the unit tests of the class Position
 */
public class PositionTest {

	/*
	 * 
	 * Black box test to ensure that the builder sets correctly the parameters
	 */
	@Test
	public void testConstructor() {
		// Contrustor inputs
		Position posicion = new Position(0, 0);
		assertEquals(posicion.getX(), 0);
		assertEquals(posicion.getY(), 0);

		// Construsctor empty
		Position posicionTest = new Position();
		posicionTest.setX(0);
		posicionTest.setY(0);
		posicionTest.setSize(2);
		assertEquals(posicionTest.getX(), 0);
		assertEquals(posicionTest.getY(), 0);
		assertEquals(posicionTest.getSize(), 2);
		assertEquals(posicionTest.toString(), "Position [x=1, y=1, orientation=Right]");
	}

	/*
	 * Test print position toString()
	 */

	@Test
	public void testPrintPosition() {

		Position posicion = new Position(0, 0);
		posicion.setOrientation(0);
		assertEquals(posicion.getOrientacionString(), "Right");
		assertEquals(posicion.getOrientation(), 0);
		posicion.setOrientation(1);
		assertEquals(posicion.getOrientacionString(), "Down");
		assertEquals(posicion.getOrientation(), 1);
		posicion.setOrientation(2);
		assertEquals(posicion.getOrientacionString(), "Up");
		assertEquals(posicion.getOrientation(), 2);
		posicion.setOrientation(3);
		assertEquals(posicion.getOrientacionString(), "Left");
		assertEquals(posicion.getOrientation(), 3);
		posicion.setOrientation(-1);
		assertEquals(posicion.getOrientacionString(), "No orientation");
		posicion.setOrientation(4);
		assertEquals(posicion.getOrientacionString(), "No orientation");
	}

}
