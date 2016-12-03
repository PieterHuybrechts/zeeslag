package domain.model;

import domain.DomainException;
import domain.PlaceShipFactory;

public class Computer extends Player{

	PlaceShipStrategy strat;
	
	public Computer(String name) throws DomainException{
		super(name,new BSBoard());
		strat = new PlaceShipFactory().getPlaceShipStrategy();
		createShips();
	}
	
	private void createShips(){
		for(int i=0;i<5;i++){
			Ship ship= strat.createShip(getBoard());
			addShip(ship);
		}
	}
}
