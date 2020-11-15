package mock;

import BattelshipTesting.Board;
import interfaces.IPlayer;

public class PlayerMock implements IPlayer {

	String name;
	int type;
	private Board own;
	private Board enemy;

	public PlayerMock(int i, String name) {

		this.type = i;
		this.name = name;

		locateBoat();

	}

	@Override
	public Board getOwn() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void locateBoat() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isWinning() {
		return true;
	}

	@Override
	public void attack(IPlayer jugador) {

		if (type == 1) {

			System.out.println("Player Attack!");

		} else {
			System.out.println("Random Attack!");

		}

	}

	public String getNombre() {
		// TODO Auto-generated method stub
		return this.name;
	}

	public int getTipo() {
		// TODO Auto-generated method stub
		return this.type;
	}
}
