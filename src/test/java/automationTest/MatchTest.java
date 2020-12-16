package automationTest;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import BattelshipTesting.ManagerIO;
import interfaces.IManagerIO;
import mock.MatchMock;

public class MatchTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		
		PrintStream systemOutOriginal = System.out;
		ByteArrayOutputStream result = new ByteArrayOutputStream();
		System.setOut(new PrintStream(result));
		
		IManagerIO managerIO = new ManagerIO();
		
		MatchMock m = new MatchMock(managerIO);
		
		assertTrue(result.toString().contains("Game winner: "));
		
		System.setOut(systemOutOriginal);
	}

}
