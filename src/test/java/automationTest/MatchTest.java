package automationTest;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import BattelshipTesting.ManagerIO;
import interfaces.IManagerIO;
import mock.MatchMock;


//This automation test uses a Player mock class that inputs random boat positions and attacks random places. 
//This way we can simulate how a game would play out without having to manually input anything.
//We execute the test 3 times since it uses random values.
public class MatchTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test1() {
		
		PrintStream systemOutOriginal = System.out;
		ByteArrayOutputStream result = new ByteArrayOutputStream();
		System.setOut(new PrintStream(result));
		
		IManagerIO managerIO = new ManagerIO();
		
		MatchMock m = new MatchMock(managerIO);
		assertFalse(m.hasWon());
		m.startGame();
		assertTrue(m.hasWon());
		assertTrue(result.toString().contains("Game winner: "));

		System.setOut(systemOutOriginal);
	}
	
	@Test
	public void test2() {
		
		PrintStream systemOutOriginal = System.out;
		ByteArrayOutputStream result = new ByteArrayOutputStream();
		System.setOut(new PrintStream(result));
		
		IManagerIO managerIO = new ManagerIO();
		
		MatchMock m = new MatchMock(managerIO);
		assertFalse(m.hasWon());
		m.startGame();
		assertTrue(m.hasWon());
		assertTrue(result.toString().contains("Game winner: "));

		System.setOut(systemOutOriginal);
	}
	
	@Test
	public void test3() {
		
		PrintStream systemOutOriginal = System.out;
		ByteArrayOutputStream result = new ByteArrayOutputStream();
		System.setOut(new PrintStream(result));
		
		IManagerIO managerIO = new ManagerIO();
		
		MatchMock m = new MatchMock(managerIO);
		assertFalse(m.hasWon());
		m.startGame();
		assertTrue(m.hasWon());
		assertTrue(result.toString().contains("Game winner: "));

		System.setOut(systemOutOriginal);
	}
	
	public void nTests() {
		
		
		
		
	}
}
