package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import BattelshipTesting.Board;
import BattelshipTesting.Player;
import BattelshipTesting.Position;
import mock.ManagerIOMock;
import utils.Constants;

/**
 * This test class takes care of the unit tests of the Board class
 * 
 * @author Cristian Vega
 *
 */
public class BoardTest {

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
	 * White box test to verify that the Board initializes correctly Loop Testing
	 * (All = 0)
	 */
	@Test
	public void testInitBoard() {
		Board board = new Board(new ManagerIOMock());

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				assertEquals(board.getBoard()[i][j], 0);
			}
		}

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				assertEquals(board.getBoard()[j][i], 0);
			}
		}

	}

	/**
	 * White box test to verify that the Board is displayed correctly at startup
	 */
	/*
	 * @Test public void testShowBoard() { Board board = new Board(new
	 * ManagerIOMock()); board.showBoard(); String expected =
	 * "     _______________________________________\r\n" +
	 * "    | A | B | C | D | F | G | H | I | J | K |\r\n" +
	 * "+---+---+---+---+---+---+---+---+---+---+---+\r\n" +
	 * "| 1 |   |   |   |   |   |   |   |   |   |   |\r\n" +
	 * "+---+---+---+---+---+---+---+---+---+---+---+\r\n" +
	 * "| 2 |   |   |   |   |   |   |   |   |   |   |\r\n" +
	 * "+---+---+---+---+---+---+---+---+---+---+---+\r\n" +
	 * "| 3 |   |   |   |   |   |   |   |   |   |   |\r\n" +
	 * "+---+---+---+---+---+---+---+---+---+---+---+\r\n" +
	 * "| 4 |   |   |   |   |   |   |   |   |   |   |\r\n" +
	 * "+---+---+---+---+---+---+---+---+---+---+---+\r\n" +
	 * "| 5 |   |   |   |   |   |   |   |   |   |   |\r\n" +
	 * "+---+---+---+---+---+---+---+---+---+---+---+\r\n" +
	 * "| 6 |   |   |   |   |   |   |   |   |   |   |\r\n" +
	 * "+---+---+---+---+---+---+---+---+---+---+---+\r\n" +
	 * "| 7 |   |   |   |   |   |   |   |   |   |   |\r\n" +
	 * "+---+---+---+---+---+---+---+---+---+---+---+\r\n" +
	 * "| 8 |   |   |   |   |   |   |   |   |   |   |\r\n" +
	 * "+---+---+---+---+---+---+---+---+---+---+---+\r\n" +
	 * "| 9 |   |   |   |   |   |   |   |   |   |   |\r\n" +
	 * "+---+---+---+---+---+---+---+---+---+---+---+\r\n" +
	 * "| 10|   |   |   |   |   |   |   |   |   |   |\r\n" +
	 * "+---+---+---+---+---+---+---+---+---+---+---+\r\n"; assertEquals(expected,
	 * result.toString());
	 * 
	 * }
	 */

	/**
	 * White box test to verify that a boat is inserted correctly Black box test of
	 * the insertBoat method equivalent partitions (-inf, 0), [0, 3], [4, inf)
	 * border 0, 3 limit:: -1, 1, 3, 4
	 */
	@Test
	public void testInsertBoat() {

		int[] input = new int[] {};
		Board testBoard = new Board(new ManagerIOMock(input));

		Position pos = new Position(0, 0);
		pos.setSize(1);
		pos.setOrientation(0);
		testBoard.insertBoat(pos);

		pos = new Position(2, 2);
		pos.setSize(1);
		pos.setOrientation(1);
		testBoard.insertBoat(pos);

		pos = new Position(4, 4);
		pos.setSize(1);
		pos.setOrientation(2);
		testBoard.insertBoat(pos);

		pos = new Position(6, 6);
		pos.setSize(1);
		pos.setOrientation(3);
		testBoard.insertBoat(pos);

		// FUERA DEL SWITCH

		pos = new Position(6, 6);
		pos.setSize(1);
		pos.setOrientation(4);
		testBoard.insertBoat(pos);

	}

	/**
	 * Loop testing White box
	 */
	@Test
	public void testLoopInsertBoat() {

		int[] input = new int[] {};
		Board testBoard = new Board(new ManagerIOMock(input));

		// Loop with 0 iteractions
		Position pos = new Position(1, 1);
		pos.setSize(0);
		pos.setOrientation(0);
		testBoard.insertBoat(pos);

		// Loop with 1 iteractions
		pos = new Position(2, 2);
		pos.setSize(1);
		pos.setOrientation(1);
		testBoard.insertBoat(pos);

		// Loop with 2
		pos = new Position(4, 4);
		pos.setSize(2);
		pos.setOrientation(2);
		testBoard.insertBoat(pos);

		// Loop with 3 iteractions (m<n) N= 4 boat biggest size
		pos = new Position(6, 6);
		pos.setSize(3);
		pos.setOrientation(2);
		testBoard.insertBoat(pos);

	}

	/**
	 * White box test to verify that a Position is inserted correctly
	 */
	@Test
	public void testInsertPosition() {

		int[] input = new int[] {};

		Board testBoard = new Board(new ManagerIOMock(input));
		testBoard.insertPosition(1);

		assertEquals(testBoard.getBoard()[0][0], 1);
		assertEquals(testBoard.getBoard()[0][1], 4);
		assertEquals(testBoard.getBoard()[1][1], 4);
		assertEquals(testBoard.getBoard()[1][0], 4);
		assertEquals(testBoard.getBoard()[1][1], 4);
	}

	/**
	 * White box test to verify that an incorrect Position is inserted!
	 */
	@Test
	public void testInsertPositionKO() {

		// Incorrect and then correct positions
		int[] input = new int[] { 1, 1, 2, 1 };

		Board testBoard = new Board(new ManagerIOMock(input));
		testBoard.insertPosition(4);

		assertEquals(testBoard.getBoard()[0][0], 1);
		assertEquals(testBoard.getBoard()[1][0], 1);
		assertEquals(testBoard.getBoard()[2][0], 1);
		assertEquals(testBoard.getBoard()[3][0], 1);

		assertEquals(testBoard.getBoard()[0][1], 4);
		assertEquals(testBoard.getBoard()[1][1], 4);
		assertEquals(testBoard.getBoard()[1][1], 4);
		assertTrue(result.toString().contains(("\nIt is not correct!\nEnter one again!")));

	}

	/**
	 * White box test to verify that a correct Position is generated
	 */
	@Test
	public void testInsertPositionRandom() {

		int[] input = new int[] { 1, 1 };
		int[] empty = new int[] {};

		Board testBoard = new Board(new ManagerIOMock(empty, input));
		testBoard.insertPosicionRandom(1);

		assertEquals(testBoard.getBoard()[0][0], 1);
		assertEquals(testBoard.getBoard()[0][1], 4);
		assertEquals(testBoard.getBoard()[1][1], 4);
		assertEquals(testBoard.getBoard()[1][0], 4);
		assertEquals(testBoard.getBoard()[1][1], 4);
	}

	/**
	 * White box test to verify that protection is created around the ship Black box
	 * test of the ship protection method equivalent partitions (-inf, 0), [0, 3],
	 * [4, inf) border 0, 3 limit: -1, 1, 3, 4
	 */
	@Test
	public void testBoatProtection() {

		int[] input = new int[] {};
		Board testBoard = new Board(new ManagerIOMock(input));
		Position pos = new Position(2, 2);
		pos.setSize(1);
		testBoard.boatProtection(pos);

		assertEquals(testBoard.getBoard()[3][3], 4);
		assertEquals(testBoard.getBoard()[3][1], 4);
		assertEquals(testBoard.getBoard()[3][2], 4);
		assertEquals(testBoard.getBoard()[2][3], 4);
		assertEquals(testBoard.getBoard()[2][1], 4);
		assertEquals(testBoard.getBoard()[1][1], 4);
		assertEquals(testBoard.getBoard()[1][2], 4);
		assertEquals(testBoard.getBoard()[1][3], 4);

		// Positiones diferente de 0 alrededor
		testBoard.boatProtection(pos);

		// Limites Board
		pos = new Position(9, 0);
		pos.setSize(1);
		testBoard.boatProtection(pos);

		// Limites Board
		pos = new Position(0, 9);
		pos.setSize(1);
		testBoard.boatProtection(pos);

		// Limites Board
		pos = new Position(9, 9);
		pos.setSize(1);
		testBoard.boatProtection(pos);

		// Limites Board
		pos = new Position(0, 0);
		pos.setSize(1);
		testBoard.boatProtection(pos);

	}

	/**
	 * White box test to verify that an orientation is inserted correctly * Black
	 * box test of the isValidOrientation method equivalent partitions (-inf, 0),
	 * [0, 3], [4, inf) frontera 0, 3 limites: -1, 1, 3, 4
	 */
	@Test
	public void testIsValidOrientation() {

		int[] input = new int[] {};
		Board testBoard = new Board(new ManagerIOMock(input));

		// FUERA DE RANGO
		Position pos = new Position(0, 0);
		pos.setSize(11);
		pos.setOrientation(0);
		assertFalse(testBoard.isValidOrientation(pos));

		pos.setOrientation(1);
		assertFalse(testBoard.isValidOrientation(pos));

		pos.setOrientation(2);
		assertFalse(testBoard.isValidOrientation(pos));

		pos.setOrientation(3);
		assertFalse(testBoard.isValidOrientation(pos));

		pos.setOrientation(4);
		assertFalse(testBoard.isValidOrientation(pos));

		// INSERTAMOS 2,2 Position CORRECTA
		pos = new Position(2, 2);
		pos.setSize(1);
		pos.setOrientation(1);
		testBoard.isValidOrientation(pos);
		testBoard.insertBoat(pos);

		// VALORES DIFERENTES A 0 (CHOCA CON OTRO BARCOS)
		pos = new Position(2, 2);
		pos.setSize(2);
		pos.setOrientation(0);
		assertFalse(testBoard.isValidOrientation(pos));

		pos.setOrientation(1);
		assertFalse(testBoard.isValidOrientation(pos));

		pos.setOrientation(2);
		assertFalse(testBoard.isValidOrientation(pos));

		pos.setOrientation(3);
		assertFalse(testBoard.isValidOrientation(pos));

	}

	/**
	 * White box test to verify that an orientation is read correctly
	 */
	@Test
	public void testReadOrientation() {

		int[] input = new int[] { -1, 4, 1 };
		Board testBoard = new Board(new ManagerIOMock(input));
		assertEquals(testBoard.readOrientation(), 1);

	}

	/**
	 * Black box test to verify that an orientation is generated correctly (-inf,
	 * 0), [0, 3], [4, inf) frontera 0, 3 limites: -1, 1, 3, 4
	 */
	@Test
	public void testGenerarOrientacion() {

		int[] empty = new int[] {};
		int[] input = new int[] { -1, 4, 1, 3 };
		Board testBoard = new Board(new ManagerIOMock(empty, input));
		assertEquals(testBoard.generateOrientation(), 1);
		assertEquals(testBoard.generateOrientation(), 3);
	}

	/**
	 * Black box test to verify that a Position (x, y) is read correctly Black box
	 * test of the readPosition method and equivalent partitions (-inf, 1), [1, 10],
	 * [10, inf) frontera 1, 10 limites: 0, 11, -1, 11
	 */
	@Test
	public void testReadPosition() {

		int[] input = new int[] { -1, 11, 10, -1, 11, 10 };
		Board testBoard = new Board(new ManagerIOMock(input));
		Position testPosition = new Position(9, 9);

		Position expectedPosition = testBoard.readPosition();
		assertEquals(expectedPosition.getX(), testPosition.getX());
		assertEquals(expectedPosition.getY(), testPosition.getY());

	}

	/**
	 * Black box test to verify that a Position (x, y) is read correctly Black box
	 * test of the generatePosition (Random) method and equivalent partitions (-inf,
	 * 1), [1, 10], [10, inf) frontera 1, 10 limites: 0, 11, -1, 11
	 */
	@Test
	public void testGeneratePosition() {

		int[] empty = new int[] {};
		int[] input = new int[] { -1, 11, 10, -1, 11, 10 };
		Board testBoard = new Board(new ManagerIOMock(empty, input));
		Position testPosition = new Position(9, 9);

		Position expectedPosition = testBoard.generatePosition();
		assertEquals(expectedPosition.getX(), testPosition.getX());
		assertEquals(expectedPosition.getY(), testPosition.getY());

	}

	/**
	 * White box test to verify that it is attacked correctly
	 */
	@Test
	public void testAttack() {

		// CONDITION COVERAGE
		// 2,1 TOCADO TRUE TRUE
		// 2,1,2,1 TOCADO TRUE False
		// 1,2 AGUA FALSE TRUE
		// 6, 8 FALSE TRUE
		// 1,2,1,2 FALSE FALSE

		int[] input = new int[] { 2, 1, 2, 1, 1, 2, 6, 8, 1, 2, 1, 2 };

		Player testJugador = new Player(Constants.NAME_PLAYER, new ManagerIOMock(Constants.POSITION_BOATS));
		Board testBoard = new Board(new ManagerIOMock(input));

		// 2,1 TOCADO TRUE TRUE
		testBoard.attack(testJugador);
		// 2,1,2,1 TOCADO TRUE False
		testBoard.attack(testJugador);
		// 1,2 AGUA FALSE TRUE
		testBoard.attack(testJugador);
		// 6, 8 FALSE TRUE
		testBoard.attack(testJugador);
		// 1,2,1,2 FALSE FALSE
		testBoard.attack(testJugador);
		testBoard.showBoard();
	}

	/**
	 * White box test to verify that it is randomly attacked Correctly!
	 */
	@Test
	public void testAtacarRandom() {

		int[] empty = new int[] {};
		// CONDITION COVERAGE
		// 2,1 TOCADO TRUE TRUE
		// 2,1,2,1 TOCADO TRUE False
		// 1,2 AGUA FALSE TRUE
		// 6, 8 FALSE TRUE
		// 1,2,1,2 FALSE FALSE

		int[] input = new int[] { 2, 1, 2, 1, 1, 2, 6, 8, 1, 2, 1, 2 };

		Player testJugador = new Player(Constants.RANDOM_PLAYER_IA, new ManagerIOMock(empty, Constants.POSITION_BOATS));
		Board testBoard = new Board(new ManagerIOMock(empty, input));

		// 2,1 TOCADO TRUE TRUE
		testBoard.attackRandom(testJugador);
		// 2,1,2,1 TOCADO TRUE False
		testBoard.attackRandom(testJugador);
		// 1,2 AGUA FALSE TRUE
		testBoard.attackRandom(testJugador);
		// 6, 8 FALSE TRUE
		testBoard.attackRandom(testJugador);
		// 1,2,1,2 FALSE FALSE
		testBoard.attackRandom(testJugador);
		testBoard.showBoard();
	}

}
