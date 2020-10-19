package BattelshipTesting;

public class Board {

	public String iniBoard() {
		// TODO Auto-generated method stub
		return "Board Started!";
	}

	public String showBoard() {
		// TODO Auto-generated method stub
		return "Show Board!";
	}

	public int[][] createBoard() {
		// TODO Auto-generated method stub
		int[][] board = new int[2][2];
	
		board[0][0] = 1;
		board[0][1] = 0;
		board[1][0] = 0;

		return board;
	}

	public void insertPosition(Position positionTest) {
		// TODO Auto-generated method stub

	}

	public void insertPositionRandom(Position testPosition) {
		// TODO Auto-generated method stub

	}

	public int[][] crearBoard() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean insertOrientation(Position positionTest) {
		// TODO Auto-generated method stub
		return true;
	}

	public String protectionBoat() {
		// TODO Auto-generated method stub
		return "Protection Activated";
	}

	public Object generateOrientation() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object genOrientation() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object genPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	public String insertBoat() {
		// TODO Auto-generated method stub
		return "Boat Inserted!";
	}

}
