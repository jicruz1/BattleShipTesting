package BattelshipTesting;

import interfaces.IManagerIO;

/**
 * Class that manages the match
 * 
 * @author Cristian Vega
 *
 */
public class Match {

	Player randomIA;
	Player user;

	boolean endGame = false;
	boolean playerTurn = true;

	/**
	 * Default constructor
	 * 
	 * @param managerIO
	 */
	public Match() {

		this.user = new Player("Player");
		this.randomIA = new Player("RandomIA");
		this.startMatch();
	}

	/**
	 * Tells us who wins the game
	 */
	public String showWinner() {

		return "Player";
	}

	/**
	 * Main match/game loop
	 */
	public String startMatch() {

		return "Match started!";
	}

	public Player getRandomIA() {
		// TODO Auto-generated method stub
		return randomIA;
	}

	public Player getUserPlayer() {
		// TODO Auto-generated method stub
		return user;
	}

}
