package battleship;

public class PlayerGrid {

	private int playerId;

	private Ship[][] playerShipGrid;

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public Ship[][] getPlayerShipGrid() {
		return playerShipGrid;
	}

	public void setPlayerShipGrid(Ship[][] playerShipGrid) {
		this.playerShipGrid = playerShipGrid;
	}

}
