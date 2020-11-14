package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;

import BattelshipTesting.Board;
import BattelshipTesting.ManagerIO;
import BattelshipTesting.Position;
import interfaces.IManagerIO;

/*
 * This test class takes care of the unit tests of the Board class
 */
public class BoardTest {

	IManagerIO managerIO;
	/*
	 * Test checks that a Dashboard is created correctly
	 */
	@Test
	public void testCreateTablero() {

		Board boardTest = new Board();
		assertEquals(boardTest.iniBoard(), "Board Started!");

	}

	/*
	 * Test checks that a Dashboard is displayed correctly
	 */
	@Test
	public void testShowBoard() {

		Board boardTest = new Board();
		assertEquals(boardTest.showBoard(), "Show Board!");

	}

	

	

	

}
