package BattelshipTesting;

import interfaces.IManagerIO;

/**
 * Class to manager player entity
 * 
 * @author Cristian
 *
 */
public class Player {

	String name;
	Board own;
	Board enemy;
	int type;

	/**
	 * Player default constructor
	 * 
	 * @param string
	 * @param managerIO
	 */
	public Player(String string) {

		this.name = string;

		if (name.contains("IA")) {
			this.type = 0;
		} else {
			this.type = 1;
		}

	}

	/**
	 * Tells us if the current player has won
	 */
	public boolean isWinning() {
		if (enemy.numberBoats == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Get Atribute Name
	 * 
	 * @return
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Get Own Board
	 */
	public Board getOwn() {

		return this.own;
	}

	public String attackRandom() {
		// TODO Auto-generated method stub
		return "Random Attack!";
	}

	public String attack() {
		// TODO Auto-generated method stub
		return "Attack!";
	}

	public String positionBoat() {
		// TODO Auto-generated method stub
		return "Postion boat!";
	}

}
