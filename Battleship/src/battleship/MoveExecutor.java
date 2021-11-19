package battleship;

public class MoveExecutor {

	private MissileAttackChecker missileAttackChecker;

	private EnemyShipDestroyedHandler enemyShipDestroyedHandler;

	private GameWinOrDrawHandler gameWinOrDrawHandler;

	public MoveExecutor(MissileAttackChecker missileAttackChecker) {
		this.missileAttackChecker = missileAttackChecker;
	}

	public void executeMove(Game game, Move nextMove) {
		game.getMoves().add(nextMove);
		int currentPlayerId = nextMove.getCurrentPlayerId();

		int enemyPlayerId = nextMove.getEnemyPlayerId();
		PlayerGrid enemyPlayerGrid = game.getPlayerGrids().get(enemyPlayerId);

		PlayerStatus currentPlayerStatus = game.getPlayerStatus().get(currentPlayerId);

		Position missilePosition = nextMove.getMissilePosition();

		MissileAttackResult missileAttackResult = missileAttackChecker.checkMissileAttackResult(enemyPlayerGrid, nextMove.getMissilePosition());

		if (missileAttackResult.equals(MissileAttackResult.DAMAGE)) {

			int noOfEnemyShipsDestroyed = currentPlayerStatus.getNoOfEnemyShipsDestroyed();
			noOfEnemyShipsDestroyed++;
			currentPlayerStatus.setNoOfEnemyShipsDestroyed(noOfEnemyShipsDestroyed);

			enemyShipDestroyedHandler.destroyEnemyShip(enemyPlayerGrid, missilePosition);

			gameWinOrDrawHandler.checkIfWinOrDraw(game, nextMove);
		}

	}

}
