package BattelshipTesting;

public class Menu {

	public String showMenu() {
		// TODO Auto-generated method stub
		return "------Main Menu------";
	}

	public String getOption(int option) {

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
