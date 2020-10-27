package BattelshipTesting;

public class Position {

	int x;
	int y; 
	
	
	public Position(int x, int y) {
		// TODO Auto-generated constructor stub+
		this.x = x;
		this.y = y;
	}


	
	@Override
	public String toString() {
		return "Position [x=" + x + ", y=" + y + "]";
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}


}
