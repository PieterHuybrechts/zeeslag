package domain.model;

import domain.DomainException;
import domain.model.lib.Position;

public class Human extends Player{

	public Human(String name) throws DomainException{
		super(name,new BSBoard());
	}

	@Override
	public void addShip(Ship ship, Position position, ShipOrientationEnum orientation) {
		// TODO addShip op zijn board
		this.getBSBoard().addShip(ship, position, orientation);
	}
}
