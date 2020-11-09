package BattelshipTesting;

import interfaces.IManagerIO;

/**
 * Main Game Class
 * @author Cristian Vega
 *
 */
public class Game {

	static IManagerIO managerIO = new ManagerIO();
	
	public static void main(String[] args) {
		
		new Menu(managerIO);

	}

}
