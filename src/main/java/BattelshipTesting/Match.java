package BattelshipTesting;

import interfaces.IManagerIO;
import utils.Constants;

/**
 * Class that manages the match
 * 
 * @author Cristian Vega
 *
 */
public class Match {

	IManagerIO managerIO;

	Player randomIA;
	Player user;

	boolean endGame = false;
	boolean playerTurn = true;

	/**
	 * Default constructor
	 * 
	 * @param managerIO
	 */
	public Match(IManagerIO managerIO) {

		this.user = new Player(Constants.NAME_PLAYER, managerIO);
		this.randomIA = new Player(Constants.RANDOM_PLAYER_IA, managerIO);
		this.startMatch();
	}



	/**
	 * Main match/game loop
	 */
	public void startMatch() {

		while (!this.endGame) {

			if (this.playerTurn) {
				user.attack(randomIA);
				playerTurn = false;
			} else {
				randomIA.attack(user);
				playerTurn = true;
			}

			if (user.isWinning() || randomIA.isWinning()) {
				endGame = true;
			}
		}
		showWinner();
	}
	
	/**
	 * Tells us who wins the game
	 */
	public void showWinner() {

		if (this.user.isWinning()) {
			System.out.println("Game winner: " + this.user.getName() + "!!!");
		} else {
			System.out.println("Game winner: " + this.randomIA.getName() + "!!!");
		}
	}

}
