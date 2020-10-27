package BattelshipTesting;

public class Player {

	String name;
	Board own;
	Board enemy;
	
	public Player(String string) {
		// TODO Auto-generated constructor stub
		this.name= string;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	
	public String attack() {
		// TODO Auto-generated method stub
		return "Attack!";
	}

	public String attackRandom() {
		// TODO Auto-generated method stub
		return "Random Attack!";
	}
	
	public String positionBoat() {
		// TODO Auto-generated method stub
		return "Postion boat!";
	}
	
}
