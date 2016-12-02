package domain.model;

import domain.DomainException;
import domain.model.lib.Position;

public class Human extends Player{

	public Human(String name) throws DomainException{
		super(name,new BSBoard());
	}

	@Override
	public void addShip(Ship ship, Position position, ShipOrientationEnum orientation) throws Exception {
		// TODO addShip op zijn boardip
		
		this.getBSBoard().addShip(ship, position, orientation);
	}
}
