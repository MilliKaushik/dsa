package battleship;

import java.util.List;
import java.util.Map;

public class Game {

	private int id;

	private GameStatus gameStatus;

	private List<Move> moves;

	private Map<Integer, PlayerGrid> playerGrids;

	private Map<Integer, PlayerStatus> playerStatus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public GameStatus getGameStatus() {
		return gameStatus;
	}

	public void setGameStatus(GameStatus gameStatus) {
		this.gameStatus = gameStatus;
	}

	public List<Move> getMoves() {
		return moves;
	}

	public void setMoves(List<Move> moves) {
		this.moves = moves;
	}

	public Map<Integer, PlayerGrid> getPlayerGrids() {
		return playerGrids;
	}

	public void setPlayerGrids(Map<Integer, PlayerGrid> playerGrids) {
		this.playerGrids = playerGrids;
	}

	public Map<Integer, PlayerStatus> getPlayerStatus() {
		return playerStatus;
	}

	public void setPlayerStatus(Map<Integer, PlayerStatus> playerStatus) {
		this.playerStatus = playerStatus;
	}

}
