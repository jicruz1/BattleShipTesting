package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;

import BattelshipTesting.Board;
import BattelshipTesting.Position;

/*
 * This test class takes care of the unit tests of the Board class
 */
public class BoardTest {

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

	/*
	 * Test checks that a position is correctly inserted in the Board
	 * 
	 */
	@Test
	public void testInsertPosition() {

		Position positionTest = new Position(0, 0);


		Board boardTest = new Board();
		boardTest.insertPosition(positionTest);
		int[][] board = boardTest.createBoard();

		assertTrue(board[0][0] == 1);
		assertFalse(board[0][1] == 1);
		assertFalse(board[1][0] == 1);
	}

	/*
	 * Test that checks the insertion of a random position
	 * 
	 */
	@Test
	public void testInsertPositionRandom() {

		Random rn = new Random();
		Board boardTest = new Board();
		int x = rn.nextInt(1) + 1;
		int y = rn.nextInt(1) + 1;
		Position testPosition = new Position(x, y);
		boardTest.insertPositionRandom(testPosition);

	}

	

	/*
	 * Test Put margin of protection to the boat (1 Square)
	 * 
	 */
	@Test
	public void testProtectionBoat() {

		Board boardTest = new Board();
		assertEquals(boardTest.protectionBoat(), "Protection Activated");

	}

	/*
	 * Test insert a boat with its corresponding size. To simplify no We will find
	 * the orientation (Temporary) and we do not check the margins
	 */
	@Test
	public void testInsertBoat() {

		Board boardTest = new Board();
		assertEquals(boardTest.insertBoat(), "Boat Inserted!");

	}
	

	/*
	 * Test get 
	 */
	@Test
	public void testInsertRandomBoat() {

		Board boardTest = new Board();
		assertEquals(boardTest.insertRandomBoat(), "Radom Boat Inserted!");

	}
	
	/*
	 * Test get 
	 */
	
	@Test
	public void testReadPosition() {

		Board boardTest = new Board();
		assertEquals(boardTest.readPosition(), "Insert Postion:");

	}
	

	

	

}
