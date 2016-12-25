package domain.service;

import domain.model.Board;
import domain.model.Player;
import domain.model.Ship;
import domain.model.lib.BoardDimension;
import domain.model.lib.Position;
import domain.model.observer.Subject;
import domain.model.state.GameState;

public interface BoardGame extends Subject{

	public void start();
	public BoardDimension getBoardSize();
	public void addPion(Ship ship);
	public Board getBoard(Boolean isHuman);
	public void setState(GameState state);
	public void newGame();
	public GameState getStartedState();
	public GameState getNewSate();
	public GameState getEndedState();
	public void endGame();
	public boolean isStarted();
	public void hit(Position pos);
	public int getComputerScore();
	public int getHumanScore();
	public GameState getCurrentState();
	public Player getWinner();
	
}
