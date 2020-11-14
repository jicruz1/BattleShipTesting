//package TDD;
//import static org.junit.Assert.assertEquals;
//
//import org.junit.Test;
//
//import BattelshipTesting.Player;
//import BattelshipTesting.Position;
//
//public class PlayerTest {
//
//	/*
//	 * Test para comprobar la creacion de los objetos Jugador
//	 */
//	@Test
//	public void testCreatePlayer() {
//
//		Player playerTest = new Player("Cristian");
//		Player randomTest = new Player("Random");
//
//		assertEquals("Cristian", playerTest.getName());
//		assertEquals("Random", randomTest.getName());
//
//	}
//
//	
//	/*
//	 * Test para comprobar que los jugadores atacan correctamente
//	 */
//	@Test
//	public void testPlayerAttack() {
//
//
//		Player playerTest = new Player("Cristian");
//		Player randomTest = new Player("Random");
//		
//		assertEquals(playerTest.attack(),"Attack!");
//		assertEquals(playerTest.attackRandom(),"Random Attack!");
//		
//
//	}
//	
//	/*
//	 * Test position boat on board
//	 */
//	
//	@Test
//	public void testPrintPosition() {
//
//		Player playerTest = new Player("Cristian");
//		assertEquals(playerTest.positionBoat(),"Postion boat!");
//		
//
//	}
//
//	
//}
