package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import BattelshipTesting.Menu;
import BattelshipTesting.Player;
import mock.ManagerIOMock;
import utils.Constants;

/**
 * This class of test is in charge of the unit tests of the Partida class
 * 
 * @author Budy
 *
 */
public class PlayerTest {

	public ByteArrayOutputStream result;

	/**
	 * Function that is executed before each @Test initializes and sets an
	 * outputstream to collect the data printed in the console
	 */
	@Before
	public void beforeAll() {

		result = new ByteArrayOutputStream();
		System.setOut(new PrintStream(result));
	}

	/**
	 * Test to check the creation of Player objects
	 */
	@Test
	public void testCreatePlayer() {

		Player jugadorTest = new Player(Constants.NAME_PLAYER,
				new ManagerIOMock(Constants.WINNER_PLAYER_SEQUENCE, Constants.WINNER_IA_SEQUENCE));
		Player randomTest = new Player(Constants.RANDOM_PLAYER_IA,
				new ManagerIOMock(Constants.WINNER_PLAYER_SEQUENCE, Constants.WINNER_IA_SEQUENCE));

		assertEquals(Constants.NAME_PLAYER, jugadorTest.getName());
		assertEquals(1, jugadorTest.getType());
		assertEquals(Constants.RANDOM_PLAYER_IA, randomTest.getName());
		assertEquals(0, randomTest.getType());
	}

	/*
	 * Test para comprobar que los jugadores atacan correctamente
	 */
	@Test
	public void testPlayerAttack() {

		Player jugadorTest = new Player(Constants.NAME_PLAYER,
				new ManagerIOMock(Constants.WINNER_PLAYER_SEQUENCE, Constants.WINNER_IA_SEQUENCE));
		Player randomTest = new Player(Constants.RANDOM_PLAYER_IA,
				new ManagerIOMock(Constants.WINNER_PLAYER_SEQUENCE, Constants.WINNER_IA_SEQUENCE));

		jugadorTest.attack(randomTest);
		assertTrue(result.toString().contains("Player => " + Constants.NAME_PLAYER + " ATTACK!!!"));

		randomTest.attack(jugadorTest);
		assertTrue(result.toString().contains("Machine => " + Constants.RANDOM_PLAYER_IA + " ATTACK RANDOM!"));

	}

	/*
	 * Test para comprobar comprueba correctamente cuando un Jugador/Random gana la
	 * partida (todos los barcos enemigos hundidos)
	 */
	@Test
	public void testJugadorGana() {

		new Menu(new ManagerIOMock(Constants.WINNER_PLAYER_SEQUENCE, Constants.WINNER_IA_SEQUENCE));
		assertTrue(result.toString().contains("Game winner: HumanPlayer!!!"));

	}

}
