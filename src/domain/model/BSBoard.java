package domain.model;

import domain.model.lib.BoardDimension;
import domain.model.lib.Position;

public class BSBoard implements Board{
	
	private boolean[][] field;
	private BoardDimension dimension;
	
	public BSBoard(){
		setField(new boolean[10][10]);
		dimension = new BoardDimension(10, 10);
	}

	@Override
	public BoardDimension getSize() {
		return dimension;
	}

	public boolean[][] getField() {
		return field;
	}

	private void setField(boolean[][] field) {
		this.field = field;
	}
	public void addShip(Ship ship, Position pos, ShipOrientationEnum orientation){
		for(int i=0;i<ship.getLength();i++){
			switch(orientation){
			case VERTICAL:
				if(pos.getY()+i<getSize().getWidth())
					getField()[pos.getX()][pos.getY()+i] = true;
				break;
			case HORIZONTAL:
				if(pos.getX()+i<getSize().getHeight())
					getField()[pos.getX()+i][pos.getY()] = true;
				break;
			}
		}
	}
}
