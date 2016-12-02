package domain.model;

import domain.DomainException;
import domain.model.lib.Position;

public class Ship {

	private String name;
	private int length;
	private Position pos;
	private ShipOrientationEnum orientation;
	
	public Ship() throws DomainException {
		this("",0);
	}

	public Ship(ShipEnum type) throws DomainException {
		this(type.getName(),type.getLength());
	}
	public Ship(ShipEnum type,Position pos, ShipOrientationEnum or) throws DomainException {
		this(type.getName(),type.getLength());
		this.setPos(pos);
		this.setOrientation(or);
	}
	public Ship(String name,int length) throws DomainException{
		setName(name);
		setLength(length);
	}
	public Ship(String name,int length,Position pos, ShipOrientationEnum or) throws DomainException{
		setName(name);
		setLength(length);
		this.setPos(pos);
		this.setOrientation(or);
	}
	
	private void setName(String name) throws DomainException{
		if(name == null || name.isEmpty()){
			throw new DomainException("A shipname can't be empty");
		}
		
		this.name = name;
	}
	
	private void setLength(int length) throws DomainException{
		if(length<1){
			throw new DomainException("A ship can't be smaller than 1");
		}
		
		this.length = length;
	}
	
	public String getName(){
		return name;
	}
	
	public int getLength(){
		return length;
	}

	public ShipOrientationEnum getOrientation() {
		return orientation;
	}

	public void setOrientation(ShipOrientationEnum orientation) {
		this.orientation = orientation;
	}

	public Position getPos() {
		return pos;
	}

	public void setPos(Position pos) {
		this.pos = pos;
	}

}
