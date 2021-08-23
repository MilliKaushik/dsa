package battleship;

public class Move {

	private int currentPlayerId;

	private Position missilePosition;

	private int enemyPlayerId;

	public int getCurrentPlayerId() {
		return currentPlayerId;
	}

	public void setCurrentPlayerId(int currentPlayerId) {
		this.currentPlayerId = currentPlayerId;
	}

	public Position getMissilePosition() {
		return missilePosition;
	}

	public void setMissilePosition(Position missilePosition) {
		this.missilePosition = missilePosition;
	}

	public int getEnemyPlayerId() {
		return enemyPlayerId;
	}

	public void setEnemyPlayerId(int enemyPlayerId) {
		this.enemyPlayerId = enemyPlayerId;
	}

}
