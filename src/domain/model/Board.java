package domain.model;

import domain.model.lib.BoardDimension;
import domain.model.lib.Position;

public interface Board {

	public BoardDimension getSize();
	public boolean isValidMove(Ship ship);
	public int getMaxAmountOfPieces();
	public boolean isValidMove(ShipEnum type, ShipOrientationEnum orientation, Position pos);
}
