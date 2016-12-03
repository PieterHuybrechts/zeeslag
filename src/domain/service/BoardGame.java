package domain.service;

import common.Subject;
import domain.model.Board;
import domain.model.Ship;
import domain.model.lib.BoardDimension;

public interface BoardGame extends Subject{

	public void Start();
	public BoardDimension getBoardSize();
	public void addPion(Ship ship);
	public Board getBoard();
}
