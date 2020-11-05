package BattelshipTesting;

import interfaces.IManagerIO;

public class Game {

	static IManagerIO managerIO = new ManagerIO();
	
	public static void main(String[] args) {
		
		new Menu(managerIO);

	}

}
