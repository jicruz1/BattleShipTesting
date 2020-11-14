package interfaces;

import BattelshipTesting.Board;

/**
 * Inteface for Players
 * @author Cristian Vega
 *
 */
public interface IPlayer {
	
	public Board getOwn();
	public void locateBoat();
	public boolean  isWinning();
	public void attack(IPlayer jugador);
}
