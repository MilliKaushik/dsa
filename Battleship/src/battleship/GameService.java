package battleship;

import java.util.Date;

public class GameService {

	private MoveValidator moveValidator;

	private MoveExecutor moveExecutor;

	private PlayerInputManager playerInputManager;

	public GameService(PlayerInputManager playerInputManager) {
		this.playerInputManager = playerInputManager;
	}

	public Game createGame(GameRequest gameRequest) {
		return null;
	}

	public void playGame(Game game) {

		game.setGameStatus(GameStatus.IN_PROGRESS);

		boolean turn = true;

		while (game.getGameStatus().equals(GameStatus.IN_PROGRESS)) {
			Move move = playerInputManager.getNextMove(game, turn);
			moveValidator.validate(game, move);
			moveExecutor.executeMove(game, move);
			turn = changeTurn(game, turn);
		}

		endGame(game);
	}

	private boolean changeTurn(Game game, boolean turn) {
		if (!turn)
			incrementNoOfMissiledFired(game);
		turn = !turn;
		return turn;
	}

	private void incrementNoOfMissiledFired(Game game) {
		int currentNoOfMissilesFired = game.getCurrentNoOfMissilesFired();
		currentNoOfMissilesFired++;
		game.setCurrentNoOfMissilesFired(currentNoOfMissilesFired);

	}

	public void endGame(Game game) {
		game.setEndTime(new Date());
	}

}
