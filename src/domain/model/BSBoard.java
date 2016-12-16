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
	private static final int  MAX_AANTAL_VLIEGDEKSCHIP=1;
	private static final int  MAX_AANTAL_SLAGSCHIP=2;
	private static final int  MAX_AANTAL_ONDERZEEËR=3;
	private static final int  MAX_AANTAL_TORPEDOBOOTJAGER=3;
	private static final int  MAX_AANTAL_PATROUILLESCHIP=4;
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

	public void addShip(Ship ship){
		if(this.isValidMove(ship)){
			this.schepen.add(ship);
			for(int i=0;i<ship.getLength();i++){
				switch(ship.getOrientation()){
				case VERTICAL:
					if(ship.getPos().getY()+i<getSize().getWidth())
						getField()[ship.getPos().getX()][ship.getPos().getY()+i] = true;
					break;
				case HORIZONTAL:
					if(ship.getPos().getX()+i<getSize().getHeight())
						getField()[ship.getPos().getX()+i][ship.getPos().getY()] = true;
					break;
				}
			}
		}
	}
	
	@Override
	public boolean isValidMove(ShipEnum type, ShipOrientationEnum orientation, Position pos) {
		boolean valid = false;
		
		try {
			valid = isValidMove(new Ship(type, pos, orientation));
		} catch (DomainException e) {}
		
		return valid;
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
		return true && this.checkOverlap(ship) && this.checkTouch(ship) && this.checkAmount(ship);
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
			switch(s.getOrientation()){
			case VERTICAL:
				for(int i=0;i< s.getLength();i++){
					Position p = new Position(s.getPos().getX(),s.getPos().getY()+i);
	
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
				break;
			case HORIZONTAL:
				for(int i=0;i< s.getLength();i++){
					Position p = new Position(s.getPos().getX()+i,s.getPos().getY());
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
				break;
			}
		}
			

				
	
		return true;
		
	}
	private boolean checkAmount(Ship ship){
		int count = 0;
		for(Ship s : this.schepen){
			
			if(ship.getName().equals(s.getName())){
				count++;
			}
		}
		String name = ship.getName();
		if(name.equals(ShipEnum.VLIEGDEKSCHIP.getName())){
			if(count == MAX_AANTAL_VLIEGDEKSCHIP){
				return false;
			}
		}else if(name.equals(ShipEnum.SLAGSCHIP.getName())){
			if(count == MAX_AANTAL_SLAGSCHIP){
				return false;
			}
		} else if(name.equals(ShipEnum.ONDERZEEER.getName())){
			if(count == MAX_AANTAL_ONDERZEEËR){
				return false;
			}
		}else if(name.equals(ShipEnum.TORPEDOBOOTJAGER.getName())){
			if(count == MAX_AANTAL_TORPEDOBOOTJAGER){
				return false;
			}
		} else {
			if(count == MAX_AANTAL_PATROUILLESCHIP){
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
	
	public List<Ship> getShips(){
		return this.schepen;
	}

}
