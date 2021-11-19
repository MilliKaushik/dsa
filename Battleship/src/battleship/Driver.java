package battleship;

public class Driver {

	public static void main(String[] args) {

		testDestroyEnemyShip();

	}

	private static void testDestroyEnemyShip() {
		EnemyShipDestroyedHandler handler = new EnemyShipDestroyedHandler();

		Position destroyPosition = new Position();
		destroyPosition.setCol(0);
		destroyPosition.setRow(0);

		PlayerGrid playerGrid = new PlayerGrid();
		playerGrid.setPlayerId(1);

		int n = 2;
		Ship[][] shipGrid = new Ship[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				shipGrid[i][j] = Ship.NO_SHIP;
				// if (i == 0 && j == 0)
				// shipGrid[i][j] = Ship.SHIP;
			}
		}

		playerGrid.setPlayerShipGrid(shipGrid);
		handler.destroyEnemyShip(playerGrid, destroyPosition);

		if (shipGrid[0][0].equals(Ship.NO_SHIP))
			System.out.println("Correct");
		else
			System.out.println("Incorrect");
	}

}
