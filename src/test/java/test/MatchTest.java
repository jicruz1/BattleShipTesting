import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import BattelshipTesting.Match;



/*
 * Esta clase de test se encarga de las pruebas unitarias de la clase Partida
 */

public class MatchTest {

	/*
	 * Test comprueba que se crea una Partida correctamente
	 */
	@Test
	public void testCreateMatch() {

		Match matchTest = new Match();
		assertEquals("RandomIA", matchTest.getRandomIA().getNombre());
		assertEquals("Player", matchTest.getUserPlayer().getNombre());
		assertFalse(matchTest.isFinalGame());
		assertTrue(matchTest.isTurnPlayer());
	}

	/*
	 * Test comprueba que se empieza la partida
	 */
	@Test
	public void testStartMatch() {

		Match matchTest = new Match();
		assertEquals(matchTest.startMatch(), "Match started!");

	}

	/*
	 * Test comprueba quien es el ganador
	 */
	@Test
	public void testShowMatch() {

		Match matchTest = new Match();
		assertEquals("Player", matchTest.showWinner());

	}

}