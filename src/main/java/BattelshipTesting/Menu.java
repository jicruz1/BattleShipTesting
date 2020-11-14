package BattelshipTesting;

import java.io.IOException;

import interfaces.IManagerIO;

/**
 * Menu class - Print and choose diferent game options
 * 
 * @author Cristian Vega
 *
 */
public class Menu {

	public Menu() {

		this.showMenu();

	}

	/**
	 * Displays the main menu of the game
	 */
	public String showMenu() {

		return "------Main Menu------\n1- Play \n2- Exit";
	}

	/**
	 * The user selects the option
	 * 
	 * @param managerIO
	 * @throws IOException
	 */
	public String getOption(int opction) {

		switch (opction) {

		case 1:
			return "------Starting Game------";

		case 2:
			return "Exiting Game";

		default:
			break;
		}
		return null;

	}

}
