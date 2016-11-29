package domain.model;

import domain.DomainException;
import domain.model.lib.Position;

public class Computer extends Player{

	public Computer(String name) throws DomainException{
		super(name,new BSBoard());
	}

	@Override
	public void addShip(Ship ship, Position position, ShipOrientationEnum orientation) {
		// TODO Auto-generated method stub
		
	}
	
}
