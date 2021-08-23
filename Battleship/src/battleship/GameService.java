package battleship;

public class GameService {

	private GameValidator gameValidator;

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

			turn = !turn;
		}

		endGame(game.getId());
	}

	public void endGame(int gameId) {

	}
}
