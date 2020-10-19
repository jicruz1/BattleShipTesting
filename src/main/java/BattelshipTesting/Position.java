package BattelshipTesting;

public class Position {

	int x;

	int y;
	
	public Position(int x, int y) {
		// TODO Auto-generated constructor stub+
		this.x = x;
		this.y = y;
	}

	public Object getOrientationString() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setOrientacion(int i) {
		// TODO Auto-generated method stub

	}



	public void setOrientation(int i) {
		// TODO Auto-generated method stub

	}

	public void setSize(int i) {
		// TODO Auto-generated method stub

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
