package domain.model;

import domain.DomainException;
import domain.PlaceShipFactory;
import domain.model.lib.Position;

public class Computer extends Player{

	PlaceShipStrategy strat;
	
	public Computer(String name) throws DomainException{
		super(name,new BSBoard());
		strat = new PlaceShipFactory().getPlaceShipStrategy();
	}
	
	private void createShips(){
		
	}

	@Override
	public void addShip(Ship ship, Position position, ShipOrientationEnum orientation) {
		// TODO Auto-generated method stub
		
	}
	
}
