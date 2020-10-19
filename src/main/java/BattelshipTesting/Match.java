package BattelshipTesting;

public class Match {
	
	Player randomIA;
	Player user;

	public Match(){
		
		this.randomIA = new Player("RandomIA");
		this.user = new Player("Player");
	}
	public Player getRandomIA() {
		// TODO Auto-generated method stub
		return this.randomIA;
	}

	public Player getUserPlayer() {
		// TODO Auto-generated method stub
		return this.user;
	}

	public boolean isFinalGame() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isTurnPlayer() {
		// TODO Auto-generated method stub
		return false;
	}

	public Object showWinner() {
		// TODO Auto-generated method stub
		return "Player";
	}

	public String startMatch() {
		// TODO Auto-generated method stub
		return "Match started!";
	}

}
