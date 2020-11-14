package BattelshipTesting;

import interfaces.IManagerIO;

/**
 * Class that manages the game board
 * 
 * @author Cristian Vega
 *
 */
public class Board {

	IManagerIO managerIO;
	int numberBoats;


	/**
	 * Default Constructor
	 * 
	 * @param managerIO
	 */
	public Board() {

		iniBoard();
	}

	/**
	 * Initialize the board with all the squares as water(0)
	 */
	public String iniBoard() {
		return "Board Started!";
	}

	/**
	 * Display the board by console A to K horizontal and 1 to 10 vertical
	 */
	public String showBoard() {
		return "Show Board!";
	}

	/**
	 * Inserts a size N ship at a user-provided position on the board
	 * 
	 * @param actualBoatSize
	 */
	public void insertPosition(int actualBoatSize) {

		

	}

	

}
