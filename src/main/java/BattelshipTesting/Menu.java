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

		System.out.print("------Main Menu------\n");
		System.out.print("1- Play\n");
		System.out.print("2- Configuration(TODO)\n");
		System.out.print("3- Exit\n");
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
			System.out.print("------Starting Game------");
			new Match(this.managerIO);
			break;
		case 2:
			System.out.print("Exiting Game");
			break;
		default:
			System.out.print("Invalid Option!");
			this.showMenu();
			this.getOption(managerIO);
			break;

		}

	}

}
