package domain.service;

import common.Subject;
import domain.model.Board;
import domain.model.GameState;
import domain.model.Ship;
import domain.model.lib.BoardDimension;
import domain.model.lib.Position;

public interface BoardGame extends Subject{

	public void start();
	public BoardDimension getBoardSize();
	public void addPion(Ship ship);
	public Board getBoard();
	public void setState(GameState state);
	public void newGame();
	public GameState getStartedState();
	public GameState getNewSate();
	public boolean isStarted();
	public void hit(Position pos);
	public int getComputerScore();
	public int getHumanScore();
	
}
