package battleship;

public class EnemyShipDestroyedHandler {

	public void destroyEnemyShip(PlayerGrid playerGrid, Position destroyPosition) {
		Ship[][] enemyShipGrid = playerGrid.getPlayerShipGrid();
		int rowDestroyed = destroyPosition.getRow();
		int colDestroyed = destroyPosition.getCol();
		enemyShipGrid[rowDestroyed][colDestroyed] = Ship.NO_SHIP;
	}

}
