package BattelshipTesting;

import interfaces.IManagerIO;

public class Menu {

	IManagerIO managerIO;
	
	public Menu(IManagerIO managerIO){
		this.managerIO = managerIO;
		this.showMenu();
		getOption(managerIO);

	}
	public String showMenu() {
		// TODO Auto-generated method stub
		return "------Main Menu------";
	}

	public String getOption(IManagerIO managerIO) {
		
		int option = managerIO.inInt();
		switch (option) {
		// TODO Auto-generated method stub
		case 1:
			return "Starting Game";
		case 2:
			return "Exiting Game";
		default:
			break;
		}
		return "";

	}

}
