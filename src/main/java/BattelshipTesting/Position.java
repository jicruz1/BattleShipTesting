package BattelshipTesting;

/**
 * Position class entity (X, Y, Orientation, Size)
 * 
 * @author Cristian Vega
 *
 */
public class Position {

	int x;
	int y;
	int orientation;
	int size;

	public Position() {
	}

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Converts the orientation code to natural language
	 * @return
	 */
	public String getOrientacionString() {
		switch (this.orientation) {
		case 0:
			return "Right";
		case 1:
			return "Down";
		case 2:
			return "Up";
		case 3:
			return "Left";
		default:
			return "No orientation";
		}
	}

	public String toString() {
		return "Position [x=" + (x + 1) + ", y=" + (y + 1) + ", orientation=" + getOrientacionString() + "]";
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

	public void setOrientation(int readOrientation) {
		this.orientation = readOrientation;

	}

	public void setSize(int actualBoatSize) {
		this.size = actualBoatSize;

	}

	public int getSize() {

		return this.size;
	}

	public int getOrientation() {
		return this.orientation;
	}

}
