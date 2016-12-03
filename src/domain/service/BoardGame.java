package domain.service;

import domain.model.Board;
import domain.model.Ship;
import domain.model.lib.BoardDimension;

public interface BoardGame {

	public void Start();
	public BoardDimension getBoardSize();
	public void addPion(Ship ship);
	public Board getBoard();
}
