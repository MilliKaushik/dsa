package battleship;

public class GameRequest {

	private int gridSize;

	private int noOfShips;

	private int[][] playerGrid1;

	private int[][] playerGrid2;

	public int getGridSize() {
		return gridSize;
	}

	public void setGridSize(int gridSize) {
		this.gridSize = gridSize;
	}

	public int getNoOfShips() {
		return noOfShips;
	}

	public void setNoOfShips(int noOfShips) {
		this.noOfShips = noOfShips;
	}

	public int[][] getPlayerGrid1() {
		return playerGrid1;
	}

	public void setPlayerGrid1(int[][] playerGrid1) {
		this.playerGrid1 = playerGrid1;
	}

	public int[][] getPlayerGrid2() {
		return playerGrid2;
	}

	public void setPlayerGrid2(int[][] playerGrid2) {
		this.playerGrid2 = playerGrid2;
	}

}
