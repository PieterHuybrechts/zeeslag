package domain.model;

import domain.model.lib.BoardDimension;

public interface Board {

	public BoardDimension getSize();
	public boolean isValidMove(Ship ship);
	public int getMaxAmountOfPieces();
}
