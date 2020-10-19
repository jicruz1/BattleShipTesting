package com.battelship.TDD;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.battelship.main.Position;

/*
 * This class of test is in charge of the unit tests of the class Position
 */
public class PositionTest {

	/*
	 
		*Black box test to ensure that the builder sets correctly the
		*parameters
	 */
	@Test
	public void testConstructor() {
		Position position = new Position(0, 0);
		assertEquals(position.getX(), 0);
		assertEquals(position.getY(), 0);
	}

	/*
	 * getOrientationString method black box test equivalent partitions
	 * (-inf, 0), [0, 3], [4, inf) frontera 0, 3 limit: -1, 1, 3, 4
	 */
	@Test
	public void testOrientation() {
		Position position = new Position(0, 0);
		position.setOrientacion(0);
		assertEquals(position.getOrientationString(), "Right");
		position.setOrientacion(1);
		assertEquals(position.getOrientationString(), "Down");
		position.setOrientacion(2);
		assertEquals(position.getOrientationString(), "Up");
		position.setOrientacion(3);
		assertEquals(position.getOrientationString(), "Left");
		position.setOrientacion(-1);
		assertEquals(position.getOrientationString(), "No orientation");
		position.setOrientacion(4);
		assertEquals(position.getOrientationString(), "No orientation");
	}

	/*
		* Black box test of method position.toString () displayed by terminal
		* the Position values. Equivalent partitions: (-inf, 0), [0, 3], [4,
		* inf) boundary 0, 3 limits: -1, 1, 3, 4
	 */
	@Test
	public void testPrintPosition() {

		Position position = new Position(0, 0);
		position.setOrientacion(0);
		assertEquals(position.toString(), "Position [x=1, y=1, orientation=Right]");

		position.setOrientacion(1);
		assertEquals(position.toString(), "Position [x=1, y=1, orientation=Down]");
		position.setOrientacion(2);

		assertEquals(position.toString(), "Position [x=1, y=1, orientation=Up]");
		position.setOrientacion(3);

		assertEquals(position.toString(), "Position [x=1, y=1, orientation=Left]");
		position.setOrientacion(-1);

		assertEquals(position.toString(), "Position [x=1, y=1, orientation=No orientation]");
		position.setOrientacion(4);
		assertEquals(position.toString(), "Position [x=1, y=1, orientation=No orientation]");
	}


}
