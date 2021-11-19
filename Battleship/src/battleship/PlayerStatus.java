package battleship;

public class PlayerStatus {

	private int playerId;

	private int noOfEnemyShipsDestroyed;

	private int noOfOwnShipsLeft;

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public int getNoOfEnemyShipsDestroyed() {
		return noOfEnemyShipsDestroyed;
	}

	public void setNoOfEnemyShipsDestroyed(int noOfEnemyShipsDestroyed) {
		this.noOfEnemyShipsDestroyed = noOfEnemyShipsDestroyed;
	}

	public int getNoOfOwnShipsLeft() {
		return noOfOwnShipsLeft;
	}

	public void setNoOfOwnShipsLeft(int noOfOwnShipsLeft) {
		this.noOfOwnShipsLeft = noOfOwnShipsLeft;
	}

}
