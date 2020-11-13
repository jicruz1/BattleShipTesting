package BattelshipTesting;

import interfaces.IManagerIO;

public class Match {

	IManagerIO managerIO;

	Player randomIA;
	Player user;

	boolean endGame = false;
	boolean playerTurn = true;

	public Match() {

		this.randomIA = new Player("RandomIA", managerIO);
		this.user = new Player("Player", managerIO);
		this.startMatch();
	}

	public boolean isFinalGame() {

		return endGame;
	}

	public boolean isTurnPlayer() {

		return playerTurn;
	}

	public Object showWinner() {

		return "Player";
	}

	public void startMatch() {

		while (!isFinalGame()) {

			if (isTurnPlayer()) {
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

}
