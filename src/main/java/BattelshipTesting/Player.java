package BattelshipTesting;

import interfaces.IManagerIO;
import interfaces.IPlayer;

import utils.Constants;

/**
 * Class to manager player entity
 * 
 * @author Budy
 *
 */
public class Player implements IPlayer {

	String name;
	Board own;
	Board enemy;
	int type;

	/**
	 * Player default constructor
	 * 
	 * @param string
	 * @param managerIOMock
	 */
	public Player(String name, IManagerIO managerIO) {

		this.name = name;
		this.own = new Board(managerIO);
		this.enemy = new Board(managerIO);
		if (name.contains("IA")) {
			this.type = 0;
		} else {
			this.type = 1;
		}
		this.locateBoat();
	}



	/**
	 * Position ships on the board
	 */
	public void locateBoat() {

		if (this.type == 1) {
			System.out.println("Player: " + this.name + "\nPosition your boats!");

			for (int i = 0; i < Constants.BOAT_LIST.length; i++) {
				System.out.println(
						"Position (X, Y) head of the ship it occupies " + Constants.BOAT_LIST[i] + " squares (1/1)");

				own.insertPosicion(Constants.BOAT_LIST[i]);
				own.showBoard();

			}
		} else {

			System.out.println("Machine: " + this.name + "\nRandomly positioning your boats!");
			for (int i = 0; i < Constants.BOAT_LIST.length; i++) {

				own.insertPosicionRandom(Constants.BOAT_LIST[i]);

			}
		}

	}

	/**
	 * Allows you to attack the player
	 */
	public void attack(IPlayer player) {

		if (this.type == 1) {
			System.out.println("Player => " + this.name + " ATTACK!!!");
			System.out.println("What position do you want to attack?");

			enemy.atacar(player);
			enemy.showBoard();

		} else {
			System.out.println("Machine => " + this.name + " ATTACK RANDOM!");
			enemy.atacarRandom(player);
			enemy.showBoard();

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

	/**
	 * Get Player type
	 */
	public int getType() {

		return this.type;
	}

}
