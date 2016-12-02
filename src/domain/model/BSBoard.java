package domain.model;

import java.util.ArrayList;
import java.util.List;

import domain.DomainException;
import domain.model.lib.BoardDimension;
import domain.model.lib.Position;

public class BSBoard implements Board{
	
	private boolean[][] field;
	private BoardDimension dimension;
	private List<Ship> schepen = new ArrayList<Ship>();
	
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
		if(this.isValidMove(ship)){
		this.schepen.add(ship);
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
	
	public boolean isValidMove(Ship ship){
		if(this.schepen.size()== 5){
			return false;
		}
		Position pos = ship.getPos();
		ShipOrientationEnum orientation = ship.getOrientation();
		if(orientation.equals(ShipOrientationEnum.VERTICAL)){
			int max = pos.getY() + ship.getLength();
			if(max >10){
				return false;
			}
		} else{
			int max = pos.getX() + ship.getLength();
			if(max >10){
				return false;
			}
		}
		return true && this.checkOverlap(ship) && this.checkTouch(ship);
	}
	private boolean checkOverlap(Ship ship){
		Position pos = ship.getPos();
		ShipOrientationEnum orientation = ship.getOrientation();
	for(int i=0;i<ship.getLength();i++){
		switch(orientation){
		case VERTICAL:
			if(getField()[pos.getX()][pos.getY()+i] == true)
				return false;
			break;
		case HORIZONTAL:
			if(	getField()[pos.getX()+i][pos.getY()] == true)
			return false;
			break;
		}
	}
	
	return true;
}
	private boolean checkTouch(Ship ship){
		List<Position> newShipPos = new ArrayList<Position>();
		Position pos = ship.getPos();
		ShipOrientationEnum orientation = ship.getOrientation();
		for(int i=0; i<ship.getLength();i++){
			switch(orientation){
			case VERTICAL:
				if(pos.getY()+i<getSize().getWidth()){
					Position p = new Position(pos.getX(),pos.getY()+i);
				
					newShipPos.add(p);}
				break;
			case HORIZONTAL:
				if(pos.getX()+i<getSize().getHeight()){
					Position p = new Position(pos.getX()+i,pos.getY());
			
					newShipPos.add(p);}
				break;
			}
		}
		for(Ship s: this.schepen){
			Position p = s.getPos();
			Position up = new Position(p.getX(),p.getY()-1);
			Position down =new Position(p.getX(), p.getY()+1);
			Position left =new Position(p.getX()-1, p.getY());
			Position right =new Position(p.getX()+1, p.getY());
			Position leftup = new Position(p.getX()-1, p.getY()-1);
			Position leftdown= new Position(p.getX()-1, p.getY()+1);
			Position rightup= new Position(p.getX()+1,p.getY()-1);
			Position rightdown= new Position(p.getX()+1, p.getY()+1);
			
	if(newShipPos.contains(up)|| newShipPos.contains(down)|| newShipPos.contains(left)|| newShipPos.contains(right)||newShipPos.contains(leftdown)|| newShipPos.contains(leftup)|| newShipPos.contains(rightdown)|| newShipPos.contains(rightup)){
	 return false;	
	}
				
		}
		return true;
		
	}

	@Override
	public int getMaxAmountOfPieces() {
		// TODO Auto-generated method stub
		return 5;
	}
}
