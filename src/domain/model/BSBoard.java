package domain.model;

import domain.model.lib.BoardDimension;
import domain.model.lib.Position;

public class BSBoard implements Board{
	
	private int[][] field;
	private BoardDimension dimension;
	
	public BSBoard(){
		setField(new int[10][10]);
		dimension = new BoardDimension(10, 10);
	}

	@Override
	public BoardDimension getSize() {
		return dimension;
	}

	public int[][] getField() {
		return field;
	}

	private void setField(int[][] field) {
		this.field = field;
	}
	public void addShip(Ship ship, Position position, ShipOrientationEnum orientation){
		//TODO must be implmented
		
	}
}
