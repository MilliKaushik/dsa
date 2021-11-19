package battleship;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Game {

	private Date startTime;

	private Date endTime;

	private int currentNoOfMissilesFired;

	private int id;

	private GameStatus gameStatus;

	private List<Move> moveHistory;

	private int maxNoOfMissiles;

	private int winnerPlayerId;

	private Map<Integer, PlayerGrid> playerGrids;

	private Map<Integer, PlayerStatus> playerStatus;

	private Map<Integer, List<Position>> playerDestroyedShipPositions;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public int getCurrentNoOfMissilesFired() {
		return currentNoOfMissilesFired;
	}

	public void setCurrentNoOfMissilesFired(int currentNoOfMissilesFired) {
		this.currentNoOfMissilesFired = currentNoOfMissilesFired;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public int getWinnerPlayerId() {
		return winnerPlayerId;
	}

	public void setWinnerPlayerId(int winnerPlayerId) {
		this.winnerPlayerId = winnerPlayerId;
	}

	public int getMaxNoOfMissiles() {
		return maxNoOfMissiles;
	}

	public void setMaxNoOfMissiles(int maxNoOfMissiles) {
		this.maxNoOfMissiles = maxNoOfMissiles;
	}

	public GameStatus getGameStatus() {
		return gameStatus;
	}

	public void setGameStatus(GameStatus gameStatus) {
		this.gameStatus = gameStatus;
	}

	public List<Move> getMoves() {
		return moveHistory;
	}

	public void setMoves(List<Move> moves) {
		this.moveHistory = moves;
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
