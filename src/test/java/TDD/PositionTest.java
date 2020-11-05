//package TDD;
//
//import static org.junit.Assert.assertEquals;
//
//import org.junit.Test;
//
//import BattelshipTesting.Position;
//
///*
// * This class of test is in charge of the unit tests of the class Position
// */
//public class PositionTest {
//
//	/*
//	 * 
//	 * Black box test to ensure that the builder sets correctly the parameters
//	 */
//	@Test
//	public void testConstructor() {
//		Position position = new Position(0, 0);
//		assertEquals(position.getX(), 0);
//		assertEquals(position.getY(), 0);
//	}
//
//	/*
//	 * Test print position toString()
//	 */
//	
//	@Test
//	public void testPrintPosition() {
//
//		Position position = new Position(1, 1);
//
//		assertEquals(position.toString(), "Position [x=1, y=1]");
//
//	}
//
//}
