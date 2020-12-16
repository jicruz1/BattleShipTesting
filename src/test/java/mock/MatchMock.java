package mock;

import BattelshipTesting.Match;
import BattelshipTesting.Player;
import interfaces.IManagerIO;
import utils.Constants;

public class MatchMock extends Match {
	
	public MatchMock(IManagerIO managerIO) {
		
		this.user = new PlayerGameLoopMock(Constants.NAME_PLAYER, managerIO);
		this.randomIA = new Player(Constants.RANDOM_PLAYER_IA, managerIO);
	}
	
	public void startGame()
	{
		this.startMatch();
	}
	
	public boolean hasWon()
	{
		return this.endGame;
	}
}