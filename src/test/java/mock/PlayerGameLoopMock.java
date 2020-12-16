package mock;

import BattelshipTesting.Player;
import interfaces.IManagerIO;
import interfaces.IPlayer;
import utils.Constants;

public class PlayerGameLoopMock extends Player {
	
	public PlayerGameLoopMock(String name, IManagerIO managerIO) {
		super(name, managerIO);
	}
	
	@Override
	public void locateBoat() {

		if (this.type == 1) {
			System.out.println("Player: " + this.name + "\nPosition your boats!");

			for (int i = 0; i < Constants.BOAT_LIST.length; i++) {
				own.insertPosicionRandom(Constants.BOAT_LIST[i]);
				own.showBoard();

			}
		} else {

			System.out.println("Machine: " + this.name + "\nRandomly positioning your boats!");
			for (int i = 0; i < Constants.BOAT_LIST.length; i++) {

				own.insertPosicionRandom(Constants.BOAT_LIST[i]);

			}
		}

	}
	
	@Override
	public void attack(IPlayer player) {
		
		if (this.type == 1) {
			System.out.println("Player => " + this.name + " ATTACK!!!");
			System.out.println("What position do you want to attack?");

			enemy.attackRandom(player);
			enemy.showBoard();

		} else {
			System.out.println("Machine => " + this.name + " ATTACK RANDOM!");
			enemy.attackRandom(player);
			enemy.showBoard();

		}
		
	}
}