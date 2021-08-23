package battleship;

public class MoveExecutor {

	private MissileAttackChecker missileAttackChecker;

	public MoveExecutor(MissileAttackChecker missileAttackChecker) {
		this.missileAttackChecker = missileAttackChecker;
	}

	public void executeMove(Game game, Move nextMove) {
		int currentPlayerId = nextMove.getCurrentPlayerId();

		PlayerGrid currentPlayerGrid = game.getPlayerGrids().get(currentPlayerId);
		PlayerGrid enemyPlayerGrid = game.getPlayerGrids().get(nextMove.getEnemyPlayerId());

		PlayerStatus currentPlayerStatus = game.getPlayerStatus().get(currentPlayerId);

		Position missilePosition = nextMove.getMissilePosition();
		MissileAttackResult missileAttackResult = missileAttackChecker.checkMissileAttackResult();
		if (missileAttackResult.equals(MissileAttackResult.DAMAGE)) {
			int noOfEnemyShipsDestroyed = currentPlayerStatus.getNoOfEnemyShipsDestroyed();
			noOfEnemyShipsDestroyed++;
			currentPlayerStatus.setNoOfEnemyShipsDestroyed(noOfEnemyShipsDestroyed);
		}

	}

}
