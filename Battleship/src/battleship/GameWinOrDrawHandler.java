package battleship;

public class GameWinOrDrawHandler {

	public void checkIfWinOrDraw(Game game, Move move) {
		int currentPlayerId = move.getCurrentPlayerId();
		PlayerStatus enemyPlayerStatus = game.getPlayerStatus().get(move.getEnemyPlayerId());
		if (!hasEnemyAnyShipsLeft(enemyPlayerStatus)) {
			game.setWinnerPlayerId(currentPlayerId);
			game.setGameStatus(GameStatus.WON);
			return;
		}

		if (noMissileLeft(game, move)) {
			game.setGameStatus(GameStatus.DRAW);
		}
	}

	private boolean noMissileLeft(Game game, Move move) {
		return game.getMaxNoOfMissiles() == game.getCurrentNoOfMissilesFired();
	}

	private boolean hasEnemyAnyShipsLeft(PlayerStatus enemyPlayerStatus) {
		if (enemyPlayerStatus.getNoOfOwnShipsLeft() == 0)
			return false;
		return true;
	}
}
