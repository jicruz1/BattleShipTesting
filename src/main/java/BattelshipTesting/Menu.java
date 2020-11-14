package BattelshipTesting;

import interfaces.IManagerIO;

/**
 * Menu class - Print and choose diferent game options
 * 
 * @author Cristian Vega
 *
 */
public class Menu {

	IManagerIO managerIO;

	public Menu(IManagerIO managerIO) {
		this.managerIO = managerIO;
		this.showMenu();
		getOption(managerIO);

	}

	/**
	 * Displays the main menu of the game
	 */
	public void showMenu() {

		System.out.println("------Main Menu------");
		System.out.println("1- Play ");
		System.out.println("2- Exit ");
	}

	/**
	 * The user selects the option
	 * 
	 * @param managerIO
	 */
	public void getOption(IManagerIO managerIO) {

		int option = managerIO.inInt();
		switch (option) {
		case 1:
			System.out.println("------Starting Game------");
			new Match(this.managerIO);
			break;
		case 2:
			System.out.println("Exiting Game");
			break;
		default:
			break;
		}

	}

}
