package domain.service;

import domain.model.lib.BoardDimension;
import domain.model.lib.Position;

public interface BoardGame {

	public void Start();
	public BoardDimension getBoardSize();
	public void addPion(Object pion, Position position);
}
