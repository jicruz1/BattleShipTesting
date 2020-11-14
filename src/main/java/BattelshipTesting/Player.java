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
	 * @param managerIO
	 */
	public Player(String string, IManagerIO managerIO) {

		this.name = string;
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
			System.out.println("Jugador: " + this.name + "\nPosiciona tus barcos!");

			for (int i = 0; i < Constants.BOAT_LIST.length; i++) {
				System.out.println(
						"Posicion (X,Y) cabeza del barco que ocupa " + Constants.BOAT_LIST[i] + " cuadrados (1/1)");

				own.insertPosicion(Constants.BOAT_LIST[i]);
				own.showBoard();

			}
		} else {

			System.out.println("Maquina: " + this.name + "\nPosicionando sus barcos de manera aleatoria!");
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
			System.out.println("Jugador => " + this.name + " ATACANTE!!!");
			System.out.println("Que posicion quieres atacar?");

			enemy.atacar(player);
			enemy.showBoard();

		} else {
			System.out.println("Maquina => " + this.name + " ATACA ALEATORIAMENTE!");
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

}
