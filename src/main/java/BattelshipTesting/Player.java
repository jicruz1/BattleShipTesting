package BattelshipTesting;

import interfaces.IManagerIO;

public class Player {

	String name;
	Board own;
	Board enemy;

	public Player(String string, IManagerIO managerIO) {
		// TODO Auto-generated constructor stub
		this.name = string;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	public String attack(Player attack) {
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

	public boolean isWinning() {
		// TODO Auto-generated method stub
		return true;
	}

}
