package automationTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import BattelshipTesting.ManagerIO;
import BattelshipTesting.Match;
import BattelshipTesting.Player;
import interfaces.IManagerIO;
import mock.ManagerIOMock;

public class MatchTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		IManagerIO managerIO = new ManagerIO();
		
		Match m = new Match();
		Player customPlayer = new Player("playerIA", managerIO);
		Player customIA = new Player("customIA", managerIO);
		m.setUser(customPlayer);
		m.setRandomIA(customIA);
		m.startMatch();
		assertTrue(m.getEndGame());
	}

}
