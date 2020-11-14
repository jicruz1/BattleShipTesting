package BattelshipTesting;

import interfaces.IManagerIO;

/**
 * Main Game Class ( Void main / Entry point)
 * 
 * @author Cristian Vega
 *
 */
public class Game {

	static IManagerIO managerIO = new ManagerIO();

	public static void main(String[] args) {

		new Menu(managerIO);

	}

	public static void setManager(IManagerIO manager) {
		Game.managerIO = manager;
	}

}
