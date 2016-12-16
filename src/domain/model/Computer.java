package domain.model;

import domain.DomainException;
import domain.HitShipFactory;
import domain.PlaceShipFactory;
import domain.model.lib.Position;

public class Computer extends Player{
	
	PlaceShipStrategy strat;
	HitShipStrategy hitStrat;
	public Computer(String name) throws DomainException{
		super(name,new BSBoard());
		strat = new PlaceShipFactory().getPlaceShipStrategy();
		hitStrat = new HitShipFactory().getHitShipStrategy();
		createShips();
	}
	
	private void createShips(){
		for(int i=0;i<5;i++){
			Ship ship= strat.createShip(getBoard());
			addShip(ship);
		}
	}
	public void hit(Board b){
		Position pos = hitStrat.hitShip();
		b.hit(pos);
	}
}
